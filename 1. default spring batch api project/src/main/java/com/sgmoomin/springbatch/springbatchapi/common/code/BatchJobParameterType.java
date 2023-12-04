package com.sgmoomin.springbatch.springbatchapi.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BatchJobParameterType {
    JOBPARAMETER_START_DAY("JP0001", "startDay"),
    JOBPARAMETER_JOB_NAME("JP0002", "jobName"),
    JOBPARAMETER_SCHEDULER_NAME("JP0003", "schedulerName"),
    JOBPARAMETER_ETC("JP0009", "etc");

    private String code;
    private String value;
}
