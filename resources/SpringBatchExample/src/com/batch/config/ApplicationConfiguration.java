package com.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ApplicationConfiguration {
	
	@Bean("poolTaskExecutor")
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setMaxPoolSize(10);
		return taskExecutor;
	}
	
	@Bean("batchDataSource")
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

		driverManagerDataSource.setDriverClassName("org.h2.Driver");
		driverManagerDataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		driverManagerDataSource.setUsername("sa");
		driverManagerDataSource.setPassword("");
		
		return driverManagerDataSource;
	}
	
	@Bean("batchTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("batchDataSource") DataSource dataSource) {
		
		return new DataSourceTransactionManager(dataSource);
	}

}
