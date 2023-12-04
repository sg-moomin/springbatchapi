package com.sgmoomin.springbatch.springbatchapi.common.util;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.stereotype.Component;

import com.sgmoomin.springbatch.springbatchapi.common.code.BatchJobParameterType;

import io.micrometer.core.instrument.util.StringUtils;

/**
 * jobParameter vaildation check 
 */
@Component
public class BatchJobParameterVaildationUtils implements JobParametersValidator{

    @Override
    public void validate(JobParameters parameters) throws JobParametersInvalidException {
        if(parameters.isEmpty() || parameters == null){
            throw new JobParametersInvalidException("parameter is empty");
        } else {
            if(StringUtils.isEmpty(parameters.getString(BatchJobParameterType.JOBPARAMETER_START_DAY.getValue()))
            || StringUtils.isEmpty(parameters.getString(BatchJobParameterType.JOBPARAMETER_JOB_NAME.getValue()))
            || StringUtils.isEmpty(parameters.getString(BatchJobParameterType.JOBPARAMETER_SCHEDULER_NAME.getValue()))
            ){
                throw new JobParametersInvalidException("parameter is invalid");
            }
        }  
    }
}
