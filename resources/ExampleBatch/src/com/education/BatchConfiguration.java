package com.education;

import javax.sql.DataSource;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;

import com.education.batch.JobConfiguration;

@Configuration
@Import(JobConfiguration.class)
public class BatchConfiguration {

	@Value("classpath:org/springframework/batch/core/schema-h2.sql")
	private Resource h2Schema;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasource.setUsername("sa");
		datasource.setPassword("");

		return datasource;
	}
	
	@Bean
	public DataSourceInitializer dataSourceInitializer() {
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		
		dataSourceInitializer.setDataSource(dataSource());
		
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		
		databasePopulator.addScript(h2Schema);
		databasePopulator.setContinueOnError(true);
		databasePopulator.setIgnoreFailedDrops(true);

		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		
		return dataSourceInitializer;
	}
	
	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public JobRepository jobRepository() throws Exception {
		JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
		
		jobRepositoryFactoryBean.setDataSource(dataSource());
		jobRepositoryFactoryBean.setTransactionManager(platformTransactionManager());
		
		return jobRepositoryFactoryBean.getObject();
	}
	
	@Bean
	public JobLauncher jobLauncher() throws Exception {
		SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
		
		simpleJobLauncher.setJobRepository(jobRepository());
		
		return simpleJobLauncher;
	}
}
