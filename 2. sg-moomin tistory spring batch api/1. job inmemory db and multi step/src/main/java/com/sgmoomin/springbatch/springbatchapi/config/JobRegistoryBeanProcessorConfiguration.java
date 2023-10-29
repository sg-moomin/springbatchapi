package com.sgmoomin.springbatch.springbatchapi.config;

import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobRegistoryBeanProcessorConfiguration {

    @Autowired
    private JobRegistry jobRegistry;
    
    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(){
        JobRegistryBeanPostProcessor postProcessor = new JobRegistryBeanPostProcessor();
        postProcessor.setJobRegistry(jobRegistry);
        return postProcessor;
    }

}