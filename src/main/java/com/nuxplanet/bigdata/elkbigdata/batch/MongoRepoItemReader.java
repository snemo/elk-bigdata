package com.nuxplanet.bigdata.elkbigdata.batch;

import org.springframework.batch.item.data.AbstractPaginatedDataItemReader;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.util.ClassUtils;

import java.util.Iterator;

public class MongoRepoItemReader<T> extends AbstractPaginatedDataItemReader<T> {

    private final MongoRepository repository;

    public MongoRepoItemReader(MongoRepository repository) {
        this.repository = repository;
        setName(ClassUtils.getShortName(MongoRepoItemReader.class));
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Iterator<T> doPageRead() {
        return (Iterator<T>) repository.findAll(PageRequest.of(page, pageSize)).iterator();
    }
}
