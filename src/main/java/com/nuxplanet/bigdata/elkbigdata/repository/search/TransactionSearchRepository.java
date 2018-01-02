package com.nuxplanet.bigdata.elkbigdata.repository.search;

import com.nuxplanet.bigdata.elkbigdata.domain.Transaction;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionSearchRepository extends ElasticsearchRepository<Transaction, String> {
}
