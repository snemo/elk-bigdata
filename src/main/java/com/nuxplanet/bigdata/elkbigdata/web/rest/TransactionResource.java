package com.nuxplanet.bigdata.elkbigdata.web.rest;

import com.nuxplanet.bigdata.elkbigdata.domain.Transaction;
import com.nuxplanet.bigdata.elkbigdata.repository.TransactionRepository;
import com.nuxplanet.bigdata.elkbigdata.repository.search.TransactionSearchRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionResource {

    @Autowired
    TransactionSearchRepository searchRepository;

    @Autowired
    TransactionRepository repository;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("importJob")
    Job importJob;

    @Autowired
    @Qualifier("indexJob")
    Job indexJob;

    @Autowired
    JobOperator jobOperator;

    @GetMapping("/import")
    public void runImport() throws Exception {
        jobLauncher.run(importJob, new JobParameters());
    }

    @GetMapping("/index")
    public void runIndex() throws Exception {
        jobOperator.start(indexJob.getName(), "");
    }

    @GetMapping("/all-elasticsearch")
    public Iterable<Transaction> findAllElasticsearch() {
        return searchRepository.findAll();
    }

    @GetMapping("/all-mongodb")
    public List<Transaction> findAllMongodb() {
        return repository.findAll();
    }
}
