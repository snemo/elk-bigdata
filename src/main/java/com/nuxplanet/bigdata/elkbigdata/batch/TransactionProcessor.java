package com.nuxplanet.bigdata.elkbigdata.batch;

import com.nuxplanet.bigdata.elkbigdata.domain.Transaction;
import org.springframework.batch.item.ItemProcessor;

public class TransactionProcessor implements ItemProcessor<Transaction, Transaction> {

    @Override
    public Transaction process(Transaction item) throws Exception {
        return item;
    }
}
