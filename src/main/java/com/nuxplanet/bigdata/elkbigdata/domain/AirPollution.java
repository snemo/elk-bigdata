package com.nuxplanet.bigdata.elkbigdata.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "air_pollution")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "air_pollution")
public class AirPollution {

    @Id
    private String id;

    @Field("state_code")
    private Integer stateCode;

    @Field("country_code")
    private Integer countryCode;

    @Field("site_num")
    private Integer siteNum;

    @Field("parameter_code")
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

    @Field("date_local")
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Date)
    private Date dateLocal;

    @Field("units_of_measure")
    private String unitsOfMeasure;

    @Field("event_type")
    private String eventType;

    @Field("observation_count")
    private Integer observationCount;

    @Field("observation_percent")
    private Float observationPercent;

    @Field("arithmetic_mean")
    private Double arithmeticMean;

    @Field("first_max_value")
    private Double firstMaxValue;

    @Field("first_max_hour")
    private Float firstMaxHour;

    @Field("aqi")
    private String aqi;

    @Field("method_code")
    private Integer methodCode;

    @Field("method_name")
    private String methodName;

    @Field("local_site_name")
    private String localSiteName;

    @Field("address")
    private String address;

    @Field("state_name")
    private String stateName;

    @Field("country_name")
    private String countryName;

    @Field("city_name")
    private String cityName;

    @Field("cbsa_name")
    private String cbsaName;

    @Field("date_of_last_change")
    @org.springframework.data.elasticsearch.annotations.Field(type = FieldType.Date)
    private Date dateOfLastChange;
}
