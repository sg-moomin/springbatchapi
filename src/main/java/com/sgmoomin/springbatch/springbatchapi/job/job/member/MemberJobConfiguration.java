package com.sgmoomin.springbatch.springbatchapi.job.job.member;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.sgmoomin.springbatch.springbatchapi.common.code.BatchJobNameType;
import com.sgmoomin.springbatch.springbatchapi.config.JobRegistoryBeanProcessorConfiguration;
import com.sgmoomin.springbatch.springbatchapi.job.step.member.MemberStep;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
@Import(JobRegistoryBeanProcessorConfiguration.class)
public class MemberJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    // private final JobCompletionListener jobCompletionListener;

    private final MemberStep memberStep;

    // @Bean(name = BatchJobNameType.JOB_ANNOTATAION.GET_MEMBER_JOB)
    @Bean(name = "getMemberJob")
    public Job getMemberJob(){
        return jobBuilderFactory.get(BatchJobNameType.GET_MEMBER_JOB_NAME.getValue())
            .incrementer(new RunIdIncrementer())
            // .listener(jobCompletionListener)
            .start(memberStep.getMemberStep())
            .build();
    }

    // @Bean(name = BatchJobNameType.JOB_ANNOTATAION.SELECT_MEMBER_JOB)
    @Bean(name = "selectMemberJob")
    public Job selectMemberJob(){
        return jobBuilderFactory.get(BatchJobNameType.SELECT_MEMBER_JOB_NAME.getValue())
            .incrementer(new RunIdIncrementer())
            // .listener(jobCompletionListener)
            .start(memberStep.selectMemberStep())
            .build();
    }
}
