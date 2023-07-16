package com.sgmoomin.springbatch.springbatchapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class JobConfiguration implements SchedulingConfigurer {

    private final int POOL_SIZE = 5;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

		threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
		threadPoolTaskScheduler.setThreadNamePrefix("DevLog-Scheduler-");
		threadPoolTaskScheduler.initialize();

		taskRegistrar.setTaskScheduler(threadPoolTaskScheduler);

    }
    
}
