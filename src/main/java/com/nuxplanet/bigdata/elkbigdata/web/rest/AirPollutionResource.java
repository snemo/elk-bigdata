package com.nuxplanet.bigdata.elkbigdata.web.rest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class AirPollutionResource {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("airPollutionImportJob")
    Job importJob;

    @GetMapping("/import")
    public void runImport() throws Exception {
        jobLauncher.run(importJob, new JobParameters());
    }
}
