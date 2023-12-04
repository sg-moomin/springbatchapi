package com.sgmoomin.springbatch.springbatchapi.job.tasklet.member;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
public class MemberTasklet implements Tasklet {

    @Override
    @StepScope
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("Start GetMember TaskLet");

        log.info("End GetMember TaskLet");
        return RepeatStatus.FINISHED;
    }
    

}
