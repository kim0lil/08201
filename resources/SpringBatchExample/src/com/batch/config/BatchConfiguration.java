package com.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableScheduling
@EnableBatchProcessing
@ComponentScan("com.batch.batch")
public class BatchConfiguration {
	
	@Value("classpath:org/springframework/batch/core/schema-h2.sql")
	private Resource batch_table;

	@Bean
	public JobRepository jobRepository(
		@Qualifier("batchDataSource") DataSource dataSource ,
		@Qualifier("batchTransactionManager") PlatformTransactionManager transactionManager
	) throws Exception {
		JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
		
		jobRepositoryFactoryBean.setDataSource(dataSource);
		jobRepositoryFactoryBean.setTransactionManager(transactionManager);
		
		return jobRepositoryFactoryBean.getObject();
	}
	
	@Bean
	public JobLauncher jobLauncher(TaskExecutor taskExecutor, JobRepository jobRepository) {
		SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
		simpleJobLauncher.setJobRepository(jobRepository);
		simpleJobLauncher.setTaskExecutor(taskExecutor);
		return simpleJobLauncher;
	}
	
	@Bean
	public DataSourceInitializer dataSourceInitializer(
		@Qualifier("batchDataSource") DataSource dataSource	
	) {
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setDatabasePopulator(databasePopulator());

		return dataSourceInitializer;
	}
	
	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		
		databasePopulator.addScript(this.batch_table);
		databasePopulator.setContinueOnError(true);
		
		return databasePopulator;
	}
	
	@Bean
	public JobBuilderFactory jobBuilderFactory(JobRepository jobRepository) {
		return new JobBuilderFactory(jobRepository);
	}
	
	@Bean
	public StepBuilderFactory stepBuilderFactory(
			JobRepository jobRepository
		,@Qualifier("batchTransactionManager") PlatformTransactionManager transactionManager) {
		return new StepBuilderFactory(jobRepository, transactionManager);
	}
	
	@Bean
	public JobRegistry jobRegistry() {

		return new MapJobRegistry();
	}

	@Bean
	public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
		JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
		
		jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);

		return jobRegistryBeanPostProcessor;
	}
}
