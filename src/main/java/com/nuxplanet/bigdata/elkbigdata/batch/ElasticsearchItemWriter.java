package com.nuxplanet.bigdata.elkbigdata.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.util.Assert;

import java.util.List;

public class ElasticsearchItemWriter<T> implements ItemWriter<T>, InitializingBean {

    private ElasticsearchRepository repository;

    public ElasticsearchItemWriter(ElasticsearchRepository repository) {
        this.repository = repository;
    }

    @Override
    public void write(List<? extends T> items) throws Exception {
        repository.saveAll(items);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.state(repository != null, "A ElasticsearchRepository implementation is required.");
    }
}
