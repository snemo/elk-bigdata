package com.nuxplanet.bigdata.elkbigdata.repository;

import com.nuxplanet.bigdata.elkbigdata.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

}