package com.nuxplanet.bigdata.elkbigdata.batch.airpollution;

import com.nuxplanet.bigdata.elkbigdata.domain.AirPollution;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class AirPollutionFieldSetMapper implements FieldSetMapper<AirPollution> {
    @Override
    public AirPollution mapFieldSet(FieldSet fieldSet) throws BindException {
        AirPollution airPollution = new AirPollution();

        airPollution.setStateCode(fieldSet.readInt(0));
        airPollution.setCountryCode(fieldSet.readInt(1));
        airPollution.setParameterCode(fieldSet.readInt(2));
        airPollution.setPoc(fieldSet.readInt(3));
        airPollution.setLatitude(fieldSet.readDouble(4));
        airPollution.setLongitude(fieldSet.readDouble(5));
        airPollution.setDatum(fieldSet.readString(6));
        airPollution.setParameterName(fieldSet.readString(7));
        airPollution.setSampleDuration(fieldSet.readString(8));
        airPollution.setPollutantStandard(fieldSet.readString(9));

        return airPollution;
    }
}
