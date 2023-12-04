package com.sgmoomin.springbatch.springbatchapi.common.util;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

import com.sgmoomin.springbatch.springbatchapi.common.code.BatchJobParameterType;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class BatchJobListenerUtils {
    
    @JobScope
    public JobExecutionListener jobExecutionListener() {
        return new JobExecutionListener(){
            @Override
            public void beforeJob(JobExecution jobExecution) {
                log.info("[Before JobExecution] jobStatus : {}, startDay : {}, jobName : {}, schedulerName : {}",
                    jobExecution.getStatus(),
                    jobExecution.getJobParameters().getString(BatchJobParameterType.JOBPARAMETER_START_DAY.getValue()),
                    jobExecution.getJobParameters().getString(BatchJobParameterType.JOBPARAMETER_JOB_NAME.getValue()),
                    jobExecution.getJobParameters().getString(BatchJobParameterType.JOBPARAMETER_SCHEDULER_NAME.getValue()));
            }

            @Override
            public void afterJob(JobExecution jobExecution) {
                log.info("[After JobExecution] jobStatus : {}, startDay : {}, jobName : {}, schedulerName : {}",
                    jobExecution.getStatus(),
                    jobExecution.getJobParameters().getString(BatchJobParameterType.JOBPARAMETER_START_DAY.getValue()),
                    jobExecution.getJobParameters().getString(BatchJobParameterType.JOBPARAMETER_JOB_NAME.getValue()),
                    jobExecution.getJobParameters().getString(BatchJobParameterType.JOBPARAMETER_SCHEDULER_NAME.getValue()));
            }
        };
    }

    @StepScope
    public StepExecutionListener stepExecutionListener() {
        return new StepExecutionListener() {
            @Override
            public void beforeStep(StepExecution stepExecution) {
                log.info("[Before StepExecution] stepStatus : {}", stepExecution.getStatus());
            }

            @Override
            public ExitStatus afterStep(StepExecution stepExecution) {
                log.info("[After StepExecution] stepStatus : {}, exitStatus : {} ",
                            stepExecution.getStatus(),
                            stepExecution.getExitStatus());
                return stepExecution.getExitStatus();
            }
        };
    }
}
