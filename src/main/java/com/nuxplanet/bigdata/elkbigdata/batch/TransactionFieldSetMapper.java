package com.nuxplanet.bigdata.elkbigdata.batch;

import com.nuxplanet.bigdata.elkbigdata.domain.Transaction;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TransactionFieldSetMapper implements FieldSetMapper<Transaction> {
    @Override
    public Transaction mapFieldSet(FieldSet fieldSet) throws BindException {
        Transaction transaction = new Transaction();

        transaction.transactionDate(getZonedDateTime(fieldSet, 0));
        transaction.product(fieldSet.readString(1));
        transaction.price(fieldSet.readBigDecimal(2));
        transaction.paymentType(fieldSet.readString(3));
        transaction.customerName(fieldSet.readString(4));
        transaction.city(fieldSet.readString(5));
        transaction.state(fieldSet.readString(6));
        transaction.country(fieldSet.readString(7));
        transaction.accountCreationDate(getZonedDateTime(fieldSet, 8));
        transaction.lastLogin(getZonedDateTime(fieldSet, 9));
        transaction.latitude(fieldSet.readDouble(10));
        transaction.longitude(fieldSet.readDouble(11));

        return transaction;
    }

    private ZonedDateTime getZonedDateTime(FieldSet fieldSet, int index) {
        return ZonedDateTime.ofInstant(
                fieldSet.readDate(index, "MM/dd/YY HH:mm").toInstant(),
                ZoneId.systemDefault());
    }
}
