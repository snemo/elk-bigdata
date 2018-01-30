package com.nuxplanet.bigdata.elkbigdata.batch.transaction;


import com.nuxplanet.bigdata.elkbigdata.domain.Transaction;
import org.springframework.batch.core.ItemProcessListener;

public class TransactionItemProcessListener implements ItemProcessListener<Transaction, Transaction> {

    @Override
    public void beforeProcess(Transaction item) {

    }

    @Override
    public void afterProcess(Transaction item, Transaction result) {

    }

    @Override
    public void onProcessError(Transaction item, Exception e) {

    }
}
