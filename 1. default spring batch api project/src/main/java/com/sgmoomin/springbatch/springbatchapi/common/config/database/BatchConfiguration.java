package com.sgmoomin.springbatch.springbatchapi.common.config.database;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.sgmoomin.springbatch.springbatchapi.repository",
    entityManagerFactoryRef = "batchAutoEntityManager",
    transactionManagerRef = "batchAutoTransactionManager" 
)

public class BatchConfiguration {
    private static String scanPackage = "com.sgmoomin.springbatch.springbatchapi.entity";

    @Primary
    @Bean
    public PlatformTransactionManager batchAutoTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(batchAutoEntityManager().getObject());
        
        return transactionManager;
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean batchAutoEntityManager(){
        LocalContainerEntityManagerFactoryBean localEntityManager = new LocalContainerEntityManagerFactoryBean();
        localEntityManager.setDataSource(batchAutoDataSource());
        localEntityManager.setPackagesToScan(scanPackage);
        localEntityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return localEntityManager;
    }  
    
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari.batchauto")
    public DataSource batchAutoDataSource(){
        return DataSourceBuilder.create().build();
    }
}
