package com.nuxplanet.bigdata.elkbigdata.config;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.nuxplanet.bigdata.elkbigdata.repository", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ElasticsearchRepository.class))
@Import(value = MongoAutoConfiguration.class)
public class MongoConfig {
}
