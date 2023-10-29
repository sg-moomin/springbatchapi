package com.sgmoomin.springbatch.springbatchapi.job.scheduler;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MemberScheduler {
    
    @Autowired
    private JobRegistry jobRegistry;
    // private Job getMemberJob;

    @Autowired
    private JobLauncher jobLauncher;

    public JobLauncher getJobLauncher() {
        return jobLauncher;
    }

    @Scheduled(cron = "0/10 * * * * ?")
     public void runJob() {
        //job parameter 
        log.info("JobLauncher Start!");
        Map<String, JobParameter> confMap = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        confMap.put("time", new JobParameter(date));
        
        JobParameters jobParameters = new JobParameters(confMap);

        try {
           jobLauncher.run(jobRegistry.getJob("getMemberJob"), jobParameters);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


}
