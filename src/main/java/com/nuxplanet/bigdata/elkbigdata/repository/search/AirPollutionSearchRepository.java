package com.nuxplanet.bigdata.elkbigdata.repository.search;

import com.nuxplanet.bigdata.elkbigdata.domain.AirPollution;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPollutionSearchRepository extends ElasticsearchRepository<AirPollution, String> {
}
