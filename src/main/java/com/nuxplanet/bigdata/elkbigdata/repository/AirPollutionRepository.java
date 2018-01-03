package com.nuxplanet.bigdata.elkbigdata.repository;

import com.nuxplanet.bigdata.elkbigdata.domain.AirPollution;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPollutionRepository extends MongoRepository<AirPollution, String> {
}
