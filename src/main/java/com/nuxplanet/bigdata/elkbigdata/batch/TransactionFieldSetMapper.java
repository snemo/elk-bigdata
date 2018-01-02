package com.nuxplanet.bigdata.elkbigdata.batch;

import com.nuxplanet.bigdata.elkbigdata.domain.Transaction;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class TransactionFieldSetMapper implements FieldSetMapper<Transaction> {
    @Override
    public Transaction mapFieldSet(FieldSet fieldSet) throws BindException {
        Transaction transaction = new Transaction();

        transaction.transactionDate(getDate(fieldSet, 0));
        transaction.product(fieldSet.readString(1));
        transaction.price(fieldSet.readBigDecimal(2));
        transaction.paymentType(fieldSet.readString(3));
        transaction.customerName(fieldSet.readString(4));
        transaction.city(fieldSet.readString(5));
        transaction.state(fieldSet.readString(6));
        transaction.country(fieldSet.readString(7));
        transaction.accountCreationDate(getDate(fieldSet, 8));
        transaction.lastLogin(getDate(fieldSet, 9));
        transaction.latitude(fieldSet.readDouble(10));
        transaction.longitude(fieldSet.readDouble(11));

        return transaction;
    }

    private Date getDate(FieldSet fieldSet, int index) {
        return fieldSet.readDate(index, "MM/dd/YY HH:mm");
    }
}
