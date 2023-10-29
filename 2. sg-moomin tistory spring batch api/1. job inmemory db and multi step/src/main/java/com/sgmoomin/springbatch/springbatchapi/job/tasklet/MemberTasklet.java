package com.sgmoomin.springbatch.springbatchapi.job.tasklet;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * MemberTaskLet 1
 */
@Slf4j
@Configuration
public class MemberTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("Start GetMember TaskLet");
        contribution.setExitStatus(ExitStatus.COMPLETED);
        log.info("End GetMember TaskLet");
        return RepeatStatus.FINISHED;
    }
}
