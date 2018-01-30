package com.nuxplanet.bigdata.elkbigdata.batch.transaction;

import com.nuxplanet.bigdata.elkbigdata.batch.JobCompletionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class TransactionChunkListener implements ChunkListener {
    private static final Logger log = LoggerFactory.getLogger(TransactionChunkListener.class);

    @Override
    public void beforeChunk(ChunkContext context) {

    }

    @Override
    public void afterChunk(ChunkContext context) {
        int readCount = context.getStepContext().getStepExecution().getReadCount();
        int writeCount = context.getStepContext().getStepExecution().getWriteCount();
        int commitCount = context.getStepContext().getStepExecution().getCommitCount();

        log.info("Job name: {} - Chunk status: read {}; write {}; commit {};", context.getStepContext().getJobName(), readCount, writeCount, commitCount);
    }

    @Override
    public void afterChunkError(ChunkContext context) {

    }
}
