package com.nuxplanet.bigdata.elkbigdata.config;

import com.nuxplanet.bigdata.elkbigdata.batch.*;
import com.nuxplanet.bigdata.elkbigdata.domain.Transaction;
import com.nuxplanet.bigdata.elkbigdata.repository.TransactionRepository;
import com.nuxplanet.bigdata.elkbigdata.repository.search.TransactionSearchRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableBatchProcessing
@PropertySource("classpath:batch.properties")
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private TransactionSearchRepository searchRepository;

    @Autowired
    private TransactionRepository repository;


    @Bean
    public TransactionProcessor transactionProcessor() {
        return new TransactionProcessor();
    }

    @Bean
    public FlatFileItemReader<Transaction> reader() {
        FlatFileItemReader<Transaction> reader = new FlatFileItemReader<Transaction>();
        reader.setResource(new ClassPathResource("SalesJan2009.csv"));
        reader.setLineMapper(new DefaultLineMapper<Transaction>(){{
            setFieldSetMapper(new TransactionFieldSetMapper());
            setLineTokenizer(new DelimitedLineTokenizer());
        }});

        return reader;
    }

    @Bean
    public TransactionProcessor processor() {
        return new TransactionProcessor();
    }

    @Bean
    public ItemWriter<Transaction> writer() {
        MongoItemWriter<Transaction> writer = new MongoItemWriter<Transaction>();
        writer.setTemplate(mongoTemplate);
        writer.setCollection("transaction");
        return writer;
    }

    @Bean
    public ItemWriter<Transaction> elasticSearchWriter() {
        return new ElasticsearchItemWriter<>(searchRepository);
    }

    @Bean
    public ItemReader<Transaction> mongoDBReader() {
        return new MongoRepoItemReader<Transaction>(repository);
    }

    @Bean
    public Step importStep() {
        return stepBuilderFactory.get("transactionStep")
                .<Transaction, Transaction>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job importJob(JobCompletionListener listener) {
        return jobBuilderFactory.get("transactionJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(importStep())
                .end()
                .build();
    }

    @Bean
    public Step indexStep() {
        return stepBuilderFactory.get("indexStep")
                .<Transaction, Transaction>chunk(50)
                .reader(mongoDBReader())
                .writer(elasticSearchWriter())
                .build();
    }

    @Bean
    public Job indexJob(JobCompletionListener listener) {
        return jobBuilderFactory.get("indexJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(indexStep())
                .end()
                .build();
    }






}
