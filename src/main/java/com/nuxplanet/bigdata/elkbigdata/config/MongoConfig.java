package com.nuxplanet.bigdata.elkbigdata.config;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.nuxplanet.bigdata.elkbigdata.repository")
@Import(value = MongoAutoConfiguration.class)
public class MongoConfig {
}
