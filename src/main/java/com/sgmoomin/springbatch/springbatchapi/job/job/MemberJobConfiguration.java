package com.sgmoomin.springbatch.springbatchapi.job.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sgmoomin.springbatch.springbatchapi.job.listener.JobCompletionListener;
import com.sgmoomin.springbatch.springbatchapi.job.step.MemberStep;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class MemberJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final JobCompletionListener jobCompletionListener;

    private final MemberStep memberStep;

    @Bean(name = "getMemberJob")
    public Job getMemberJob(){
        return jobBuilderFactory.get("getMemberJob")
            .incrementer(new RunIdIncrementer())
            // .listener(jobCompletionListener)
            .start(memberStep.getMemberStep())
            .build();
    }

    @Bean(name = "selectMemberJob")
    public Job selectMemberJob(){
        return jobBuilderFactory.get("selectMemberJob")
            .incrementer(new RunIdIncrementer())
            // .listener(jobCompletionListener)
            .start(memberStep.selectMemberStep())
            .build();
    }
}
