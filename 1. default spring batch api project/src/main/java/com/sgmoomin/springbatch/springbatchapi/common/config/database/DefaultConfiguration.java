package com.sgmoomin.springbatch.springbatchapi.common.config.database;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.sgmoomin.springbatch.springbatchapi.repository",
    entityManagerFactoryRef = "defaultEntityManager",
    transactionManagerRef = "defaultTransactionManager" 
)
public class DefaultConfiguration {
    
    private static String scanPackage = "com.sgmoomin.springbatch.springbatchapi.entity";

    @Bean
    public PlatformTransactionManager defaultTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(defaultEntityManager().getObject());
        
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean defaultEntityManager(){
        LocalContainerEntityManagerFactoryBean localEntityManager = new LocalContainerEntityManagerFactoryBean();
        localEntityManager.setDataSource(defaultDataSource());
        localEntityManager.setPackagesToScan(scanPackage);
        localEntityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return localEntityManager;
    }  
    
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari.default")
    public DataSource defaultDataSource(){
        return DataSourceBuilder.create().build();
    }
}
