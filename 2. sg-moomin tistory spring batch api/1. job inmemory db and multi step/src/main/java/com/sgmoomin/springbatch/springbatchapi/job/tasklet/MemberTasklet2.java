package com.sgmoomin.springbatch.springbatchapi.job.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * MemberTaskLet 2
 */
@Slf4j
@Configuration
public class MemberTasklet2 implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("Start GetMember TaskLet 2");
        log.info("End GetMember TaskLet 2");
        return RepeatStatus.FINISHED;
    }
}
