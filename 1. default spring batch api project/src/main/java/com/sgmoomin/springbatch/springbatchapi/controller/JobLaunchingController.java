package com.sgmoomin.springbatch.springbatchapi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgmoomin.springbatch.springbatchapi.dto.JobLauncherRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JobLaunchingController {

    @Autowired
    private JobRegistry jobRegistry;


    private final JobLauncher jobLauncher;

    private final ApplicationContext applicationContext;


    @PostMapping("/runJob")
    public ExitStatus runJob(@RequestBody JobLauncherRequest params) throws Exception{

        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
        String regDate = simpleDate.format(nowDate);

        Job job = applicationContext.getBean(params.getJobName(), Job.class);
        JobParameters jobParameter = new JobParametersBuilder()
            .addString("regDate", regDate)
            .addString("runJob", "start runJob")
            .toJobParameters();

        log.info("PostMapping memberJob");
        return jobLauncher.run(jobRegistry.getJob("getMemberJob"), jobParameter).getExitStatus();
    }
    
    @GetMapping("/memberJob")
    public ExitStatus runMemberJob() throws Exception{

        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
        String regDate = simpleDate.format(nowDate);

        Job job = applicationContext.getBean("selectMemberJob", Job.class);
        JobParameters jobParameter = new JobParametersBuilder()
            .addString("regDate", regDate)
            .addString("runJob", "start runJob")
            .addString("jobName", job.getName())
            .toJobParameters();

        log.info("Getmapping memberJob");
        return jobLauncher.run(jobRegistry.getJob("getMemberJob"), jobParameter).getExitStatus();
    }

    // @GetMapping
    // public ExitStatus stopMemberJob() throws Exception{

    //     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // }
    // @PostMapping("/nextRun")
    // public ExitStatus runJob(@RequestBody JobLauncherRequest params) throws Exception {
    //             Job job = context.getBean(request.getName(), Job.class);
    //     JobParameters jobParameters = new JobParametersBuilder(request.getJobParameters(), jobExplorer)
    //             .getNextJobParameters(job)
    //             .toJobParameters();

    //     return jobLauncher.run(job, jobParameters).getExitStatus();
    // }

}
