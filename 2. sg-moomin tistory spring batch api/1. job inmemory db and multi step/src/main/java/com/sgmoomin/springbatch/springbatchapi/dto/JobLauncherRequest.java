package com.sgmoomin.springbatch.springbatchapi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobLauncherRequest {
    
    private String JobName;
    private String JobCron;

}
