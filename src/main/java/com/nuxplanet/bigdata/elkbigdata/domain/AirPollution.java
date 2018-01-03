package com.nuxplanet.bigdata.elkbigdata.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "air_pollution")
public class AirPollution {

    @Id
    private String id;

    @Field("state_code")
    private Integer stateCode;

    @Field("country_code")
    private Integer countryCode;

    @Field("transaction_date")
    private Integer parameterCode;

    @Field("poc")
    private Integer poc;

    @Field("latitude")
    private Double latitude;

    @Field("longitude")
    private Double longitude;

    @Field("datum")
    private String datum;

    @Field("parameter_name")
    private String parameterName;

    @Field("sample_duration")
    private String sampleDuration;

    @Field("pollutant_standard")
    private String pollutantStandard;
}
