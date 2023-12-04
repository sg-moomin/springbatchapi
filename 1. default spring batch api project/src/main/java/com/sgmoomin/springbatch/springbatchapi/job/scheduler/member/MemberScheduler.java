package com.sgmoomin.springbatch.springbatchapi.job.scheduler.member;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sgmoomin.springbatch.springbatchapi.common.code.BatchJobNameType;
import com.sgmoomin.springbatch.springbatchapi.common.code.BatchSchedulerNameType;
import com.sgmoomin.springbatch.springbatchapi.common.util.BatchRunIdIncrementerUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MemberScheduler {
    
    @Autowired
    private JobRegistry jobRegistry;
    // private Job getMemberJob;

    // @Autowired
    // @Lazy
    // @Qualifier(value = BatchJobNameType.JOB_ANNOTATAION.GET_ACCOUNT_JOB)
    // private Job job;

    @Autowired
    private BatchRunIdIncrementerUtils batchRunIdIncrementerUtils;

    @Autowired
    private JobLauncher jobLauncher;

    @Scheduled(cron = "0/10 * * * * ?")
     public void runJob() {
        //job parameter 
        log.info("JobLauncher Start!");
        JobParameters jobParameters = batchRunIdIncrementerUtils.basicJobParameterStructure(BatchJobNameType.GET_MEMBER_JOB_NAME.getValue(),
             BatchSchedulerNameType.GET_MEMBER_SCHEDULER_NAME.getValue(), null);

        try {
           jobLauncher.run(jobRegistry.getJob(BatchJobNameType.JOB_ANNOTATAION.GET_MEMBER_JOB), jobParameters);
            // jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


}
