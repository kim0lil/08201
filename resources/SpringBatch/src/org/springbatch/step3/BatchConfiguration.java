package org.springbatch.step3;

import javax.sql.DataSource;

import org.springbatch.step3.job.SimpleJob;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@Import({
	SimpleJob.class
	})
public class BatchConfiguration {
	
	@Value("org/springframework/batch/core/schema-drop-h2.sql")
	private Resource dropTables;

	@Value("org/springframework/batch/core/schema-h2.sql")
	private Resource createTable;

	@Bean
	public DataSource batchDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		return new DataSourceTransactionManager(batchDatasource());
	}
	
	@Bean
	public DataSourceInitializer dataSourceInitializer() {
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(batchDatasource());
		
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(dropTables);
		databasePopulator.addScript(createTable);
		
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		return dataSourceInitializer;		
	}
	
	@Bean
	public TaskExecutor teskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(3);
        taskExecutor.setMaxPoolSize(30);
        taskExecutor.setQueueCapacity(10);
        taskExecutor.setThreadNamePrefix("Executor-");
        taskExecutor.initialize();
        return taskExecutor; 
	}
	
	@Bean
	public JobLauncher jobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository());
		jobLauncher.setTaskExecutor(teskExecutor());
		return jobLauncher;
	}
	
	@Bean
	public JobRepository jobRepository() throws Exception {
		JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
		factoryBean.setDataSource(batchDatasource());
		factoryBean.setTransactionManager(dataSourceTransactionManager());
		factoryBean.setDatabaseType("H2");
		factoryBean.setTablePrefix("BATCH_");
		return factoryBean.getObject();
	}
	
	@Bean
	public JobRegistryBeanPostProcessor beanPostProcessor() {

		JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor
			=	new JobRegistryBeanPostProcessor();
		
		jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry());
		
		return jobRegistryBeanPostProcessor;
	}
	
	@Bean
	public JobRegistry jobRegistry() {
		
		return new MapJobRegistry();
	}
	
	@Bean
	public JobBuilderFactory jobBuilderFactory() throws Exception {
		return new JobBuilderFactory(jobRepository());
	}
	
	@Bean
	public StepBuilderFactory stepBuilderFactory() throws Exception {
		return new StepBuilderFactory(jobRepository(), dataSourceTransactionManager());
	}
	
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, InterruptedException {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(BatchConfiguration.class);
		
		
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		JobRepository jobRepository = context.getBean(JobRepository.class);
		JobRegistry jobRegistry = context.getBean(JobRegistry.class);
		JobBuilderFactory jobBuilderFactory = context.getBean(JobBuilderFactory.class);
		StepBuilderFactory stepBuilderFactory = context.getBean(StepBuilderFactory.class);
		Job job = context.getBean("fileReadFileWriteJob", Job.class);
		
		System.out.println(jobBuilderFactory);
		System.out.println(stepBuilderFactory);
		System.out.println(jobLauncher);
		System.out.println(jobRepository);
		System.out.println(jobRegistry.getJobNames());
	
		JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
		
		int i = 1;
		while(jobExecution.getExitStatus().isRunning()) {
			Thread.sleep(1000);
			System.out.println("작업 시간 "+(i++));
		}
		
	}
}
