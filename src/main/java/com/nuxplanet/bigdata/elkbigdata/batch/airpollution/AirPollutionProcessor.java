package com.nuxplanet.bigdata.elkbigdata.batch.airpollution;

import com.nuxplanet.bigdata.elkbigdata.domain.AirPollution;
import org.springframework.batch.item.ItemProcessor;

public class AirPollutionProcessor implements ItemProcessor<AirPollution, AirPollution> {
    @Override
    public AirPollution process(AirPollution item) throws Exception {
        return item;
    }
}
