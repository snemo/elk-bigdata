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
        airPollution.setSiteNum(fieldSet.readInt(3));
        airPollution.setPoc(fieldSet.readInt(4));
        airPollution.setLatitude(fieldSet.readDouble(5));
        airPollution.setLongitude(fieldSet.readDouble(6));
        airPollution.setDatum(fieldSet.readString(7));
        airPollution.setParameterName(fieldSet.readString(8));
        airPollution.setSampleDuration(fieldSet.readString(9));
        airPollution.setPollutantStandard(fieldSet.readString(10));

        airPollution.setDateLocal(fieldSet.readDate(11, "yyyy-MM-dd"));
        airPollution.setUnitsOfMeasure(fieldSet.readString(12));
        airPollution.setEventType(fieldSet.readString(13));
        airPollution.setObservationCount(fieldSet.readInt(14));
        airPollution.setObservationPercent(fieldSet.readFloat(15));


        airPollution.setArithmeticMean(fieldSet.readDouble(16));
        airPollution.setFirstMaxValue(fieldSet.readDouble(17));
        airPollution.setFirstMaxHour(fieldSet.readFloat(18));
        airPollution.setAqi(fieldSet.readString(19));

        airPollution.setMethodCode(fieldSet.readInt(20));
        airPollution.setMethodName(fieldSet.readString(21));
        airPollution.setLocalSiteName(fieldSet.readString(22));
        airPollution.setAddress(fieldSet.readString(23));
        airPollution.setStateName(fieldSet.readString(24));
        airPollution.setCountryName(fieldSet.readString(25));
        airPollution.setCityName(fieldSet.readString(26));
        airPollution.setCbsaName(fieldSet.readString(27));
        airPollution.setDateOfLastChange(fieldSet.readDate(28, "yyyy-MM-dd"));

        return airPollution;
    }
}
