package com.nuxplanet.bigdata.elkbigdata.config;

import com.nuxplanet.bigdata.elkbigdata.batch.JobCompletionListener;
import com.nuxplanet.bigdata.elkbigdata.batch.airpollution.AirPollutionFieldSetMapper;
import com.nuxplanet.bigdata.elkbigdata.batch.airpollution.AirPollutionProcessor;
import com.nuxplanet.bigdata.elkbigdata.domain.AirPollution;
import com.nuxplanet.bigdata.elkbigdata.domain.Transaction;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AirPollutionBatchConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<AirPollution> airPollutionCSVReader() {
        FlatFileItemReader<AirPollution> reader = new FlatFileItemReader<>();
        reader.setResource(new PathResource("/Users/oleciwoj/Downloads/epa_hap_daily_summary.csv"));
        reader.setLineMapper(new DefaultLineMapper<AirPollution>(){{
            setFieldSetMapper(new AirPollutionFieldSetMapper());
            setLineTokenizer(new DelimitedLineTokenizer());
        }});

        return reader;
    }

    @Bean
    public ItemWriter<AirPollution> airPollutionMongodbWriter() {
        MongoItemWriter<AirPollution> writer = new MongoItemWriter<>();
        writer.setTemplate(mongoTemplate);
        writer.setCollection("air_pollution");
        return writer;
    }

    @Bean
    public AirPollutionProcessor airPollutionProcessor() {
        return new AirPollutionProcessor();
    }

    @Bean
    public Step airPollutionImportStep() {
        return stepBuilderFactory.get("airPollutionStep")
                .<AirPollution, AirPollution>chunk(50)
                .reader(airPollutionCSVReader())
                .processor(airPollutionProcessor())
                .writer(airPollutionMongodbWriter())
                .build();
    }

    @Bean
    public Job airPollutionImportJob(JobCompletionListener listener) {
        return jobBuilderFactory.get("airPollutionJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(airPollutionImportStep())
                .end()
                .build();
    }
}
