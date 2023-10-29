package com.sgmoomin.springbatch.springbatchapi.job.tasklet.member;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MemberSelectTasklet implements Tasklet{

    @Override
    @Nullable
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("Start SelectMember TaskLet");

        log.info("End SelectMember TaskLet");
        return RepeatStatus.FINISHED;
    
    }
    
}
