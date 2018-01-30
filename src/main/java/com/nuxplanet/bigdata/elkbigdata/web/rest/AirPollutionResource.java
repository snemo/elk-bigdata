package com.nuxplanet.bigdata.elkbigdata.web.rest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airpollution")
public class AirPollutionResource {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("airPollutionImportJob")
    Job importJob;

    @Autowired
    @Qualifier("airPollutionIndexJob")
    Job indexJob;

    @Autowired
    JobOperator jobOperator;

    @GetMapping("/import")
    public void runImport() throws Exception {
        jobLauncher.run(importJob, new JobParameters());
    }

    @GetMapping("/index")
    public Long runIndex() throws Exception {
        return jobOperator.start(indexJob.getName(), null);
    }

    @GetMapping("/job/status/{jobId}")
    public String getJobStatus(@PathVariable("jobId") Long jobId) throws Exception {
        return jobOperator.getSummary(jobId);
    }

    
}
