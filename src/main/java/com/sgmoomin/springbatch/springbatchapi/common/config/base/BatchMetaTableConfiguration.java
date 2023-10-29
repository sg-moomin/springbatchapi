package com.sgmoomin.springbatch.springbatchapi.common.config.base;

import javax.sql.DataSource;

import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BasicBatchConfigurer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;

import com.sgmoomin.springbatch.springbatchapi.common.code.BatchMetaTablePrefixType;

@Configuration
public class BatchMetaTableConfiguration extends BasicBatchConfigurer {

    @Qualifier("BatchConfiguration")
    private DataSource dataSource;

    protected BatchMetaTableConfiguration(BatchProperties properties, DataSource dataSource,
            TransactionManagerCustomizers transactionManagerCustomizers) {
        super(properties, dataSource, transactionManagerCustomizers);
        this.dataSource = dataSource;
        // TODO Auto-generated constructor stub
    }

    @Override
    protected JobRepository createJobRepository() throws Exception{
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(getTransactionManager());
        jobRepositoryFactoryBean.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED");
        jobRepositoryFactoryBean.setTablePrefix(BatchMetaTablePrefixType.DEFAULT_META_PREFIX_TYPE.getValue());
        jobRepositoryFactoryBean.afterPropertiesSet();
        
        return jobRepositoryFactoryBean.getObject();
    }

    @Override
    protected JobLauncher createJobLauncher() throws Exception{
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(createJobRepository());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }

    @Override
    protected JobExplorer createJobExplorer() throws Exception{
		JobExplorerFactoryBean jobExplorerFactoryBean = new JobExplorerFactoryBean();
		jobExplorerFactoryBean.setDataSource(dataSource);
		jobExplorerFactoryBean.setTablePrefix(BatchMetaTablePrefixType.DEFAULT_META_PREFIX_TYPE.getValue());
		jobExplorerFactoryBean.afterPropertiesSet();
		return jobExplorerFactoryBean.getObject();
	}
}
