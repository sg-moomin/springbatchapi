package com.sgmoomin.springbatch.springbatchapi.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.stereotype.Component;

import com.sgmoomin.springbatch.springbatchapi.common.code.BatchJobParameterType;

import antlr.StringUtils;

@Component
public class BatchRunIdIncrementerUtils implements JobParametersIncrementer{

    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");

    /**
     * 해당 프로젝트에서는 미사용
     * - 파라미터에 date값으로 중복이 없기 때문
     */
    @Override
    public JobParameters getNext(JobParameters parameters) {
        String startDate = dateFormat.format(new Date());

        return new JobParametersBuilder()
                    .addString("run.id", startDate)
                    .toJobParameters();
    
    }

    public JobParameters basicJobParameterStructure(String jobName, String schedulerName, String etc) {
        String date = dateFormat.format(new Date());

        if(etc == null){
            return new JobParametersBuilder()
                .addString(BatchJobParameterType.JOBPARAMETER_START_DAY.getValue(), date)
                .addString(BatchJobParameterType.JOBPARAMETER_JOB_NAME.getValue(), jobName)
                .addString(BatchJobParameterType.JOBPARAMETER_SCHEDULER_NAME.getValue(), schedulerName)
                .toJobParameters();
        } else {
            return new JobParametersBuilder()
                .addString(BatchJobParameterType.JOBPARAMETER_START_DAY.getValue(), date)
                .addString(BatchJobParameterType.JOBPARAMETER_JOB_NAME.getValue(), jobName)
                .addString(BatchJobParameterType.JOBPARAMETER_SCHEDULER_NAME.getValue(), schedulerName)
                .addString(BatchJobParameterType.JOBPARAMETER_ETC.getValue(), etc)
                .toJobParameters();
        }
    }

}
