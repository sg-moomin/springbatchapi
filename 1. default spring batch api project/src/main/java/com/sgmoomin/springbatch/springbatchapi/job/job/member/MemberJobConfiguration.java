package com.sgmoomin.springbatch.springbatchapi.job.job.member;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.sgmoomin.springbatch.springbatchapi.common.code.BatchJobNameType;
import com.sgmoomin.springbatch.springbatchapi.common.util.BatchJobListenerUtils;
import com.sgmoomin.springbatch.springbatchapi.common.util.BatchJobParameterVaildationUtils;
import com.sgmoomin.springbatch.springbatchapi.common.util.BatchRunIdIncrementerUtils;
import com.sgmoomin.springbatch.springbatchapi.config.JobRegistoryBeanProcessorConfiguration;
import com.sgmoomin.springbatch.springbatchapi.job.step.member.MemberStep;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
@Import(JobRegistoryBeanProcessorConfiguration.class)
public class MemberJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private BatchJobParameterVaildationUtils batchJobParameterVaildationUtils;

    @Autowired
    private BatchJobListenerUtils batchJobListenerUtils;

    @Autowired
    private MemberStep memberStep;

    // @Bean(name = BatchJobNameType.JOB_ANNOTATAION.GET_MEMBER_JOB)
    @Bean(name = "getMemberJob")
    public Job getMemberJob(){
        return jobBuilderFactory.get(BatchJobNameType.GET_MEMBER_JOB_NAME.getValue())
            .validator(batchJobParameterVaildationUtils)
            .listener(batchJobListenerUtils)
            .start(memberStep.getMemberStep())
            .build();
    }

    // @Bean(name = BatchJobNameType.JOB_ANNOTATAION.SELECT_MEMBER_JOB)
    @Bean(name = "selectMemberJob")
    public Job selectMemberJob(){
        return jobBuilderFactory.get(BatchJobNameType.SELECT_MEMBER_JOB_NAME.getValue())
            .validator(batchJobParameterVaildationUtils)
            .listener(batchJobListenerUtils)
            .start(memberStep.selectMemberStep())
            .build();
    }
}
