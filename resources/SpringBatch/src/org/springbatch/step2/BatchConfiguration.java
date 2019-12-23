package org.springbatch.step2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class BatchConfiguration {

	@Value("org/springframework/batch/core/schema-drop-h2.sql")
	private Resource dropTables;

	@Value("org/springframework/batch/core/schema-h2.sql")
	private Resource createTable;
	
	@Value("org/springbatch/step2/Hello.txt")
	private Resource input;
	
	@Value("org/springbatch/step2/JDBC.txt")
	private Resource jdbc_input;
	
	@Value("org/springbatch/step2/Hello2.txt")
	private Resource output;

	@Bean
	public DataSource batchDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		
		return dataSource;
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
	public DataSourceTransactionManager dataSourceTransactionManager() {
		return new DataSourceTransactionManager(batchDatasource());
	}
	
	@Bean
	public JobRepository jobRepository() throws Exception {
		JobRepositoryFactoryBean jobRepositoryFactoryBean
			= new JobRepositoryFactoryBean();
		jobRepositoryFactoryBean.setDataSource(batchDatasource());
		jobRepositoryFactoryBean.setTransactionManager(dataSourceTransactionManager());
		return jobRepositoryFactoryBean.getObject();
	}
	
	
	@Bean
	public JobLauncher jobLauncher() throws Exception {
		SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
		simpleJobLauncher.setJobRepository(jobRepository());
		return simpleJobLauncher;
	}
	
	@Bean
	public Job job() throws Exception {
		
		return new JobBuilder("fileReadUpdateWriteJob").repository(jobRepository())
				                                       .start(step())
				                                       .next(step2())
				                                       .build();
	}

	@Bean
	public Step step() throws Exception {

		return new StepBuilder("flatFileBuilder").repository(jobRepository())
				                                 .transactionManager(dataSourceTransactionManager())
												 .<List<String>,List<String>>chunk(5)
				                                 .reader(fileItemReader()).readerIsTransactionalQueue()
				                                 .processor(new SimpleItemProcessors())
				                                 .writer(fileItemWriter())
				                                 .build();
	}
	
	@Bean
	public Step step2() throws Exception {
		
		return new StepBuilder("flatFileBuilder").repository(jobRepository())
												.transactionManager(dataSourceTransactionManager())
												.<TM_USER, TM_USER>chunk(500)
												.reader(jdbcBatchItemReader())
												.processor(new JdbcItemProcessors())
												
												.writer(jdbcBatchItemLog())
												.writer(jdbcBatchItemWriter())
				/*
												 .<List<String>,List<String>>chunk(5)
				                                 .reader(fileItemReader())
				                                 .processor(new SimpleItemProcessors())
				 */	
				//.writer(fileItemWriter())
				
				.build();
	}
	
	public FlatFileItemReader<List<String>> fileItemReader() {

		FlatFileItemReader<List<String>> flatFileItemReader = new FlatFileItemReader<List<String>>();
		
		//flatFileItemReader.setResource(input);
		flatFileItemReader.setResource(jdbc_input);
		
		flatFileItemReader.setLineMapper(new LineMapper<List<String>>() {

			@Override
			public List<String> mapLine(String line, int lineNumber) throws Exception {
				String[] splitedItem = line.split(",");
				List<String> items = new ArrayList<String>();
				for(String str : splitedItem) {
					items.add(str);
				}
				return items;
			}
		});
		
		return flatFileItemReader;
	}
	
	// flatfile Item writer
	public FlatFileItemWriter<List<String>> fileItemWriter() throws Exception {

		FlatFileItemWriter<List<String>> fileItemWriter = new FlatFileItemWriter<List<String>>();

		fileItemWriter.setResource(output);

		fileItemWriter.setLineAggregator(new LineAggregator<List<String>>() {
			
			@Override
			public String aggregate(List<String> item) {
				return String.join(",", item);
			}
		});
		
		return fileItemWriter;
	}
	
	public JdbcCursorItemReader<TM_USER> jdbcBatchItemReader() {

		JdbcCursorItemReader<TM_USER> itemReader = new JdbcCursorItemReader<TM_USER>();
		
		itemReader.setDataSource(batchDatasource());
		
		itemReader.setSql("SELECT NAME, AGE, ADDRESS, TEL FROM TM_USER");
		
		itemReader.setRowMapper(new RowMapper<TM_USER>() {
			
			@Override
			public TM_USER mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new TM_USER(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		});
		
		return itemReader;
	}
	
	
	public JdbcBatchItemWriter<TM_USER> jdbcBatchItemLog() {
		JdbcBatchItemWriter<TM_USER> itemWriter = new JdbcBatchItemWriter<TM_USER>();
		
		
		itemWriter.setSql("INSERT INTO LOGGER ( NAME, WORK_DATE) VALUES(?, CURRENT_DATE)");
		
		itemWriter.setDataSource(batchDatasource());
		itemWriter.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<TM_USER>() {
			
			@Override
			public void setValues(TM_USER item, PreparedStatement ps) throws SQLException {
				ps.setString(1, item.getNAME());
			}
		});
		
		return itemWriter;
	}
	
	public JdbcBatchItemWriter<TM_USER> jdbcBatchItemWriter() {
		JdbcBatchItemWriter<TM_USER> itemWriter = new JdbcBatchItemWriter<TM_USER>();
		

		itemWriter.setSql("INSERT INTO TM_USER  ( NAME, AGE, ADDRESS, TEL) VALUES(?, ?, ?, ?)");
		
		itemWriter.setDataSource(batchDatasource());
		itemWriter.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<TM_USER>() {
			
			@Override
			public void setValues(TM_USER item, PreparedStatement ps) throws SQLException {
				ps.setString(1, item.getNAME());
				ps.setString(2, item.getAGE());
				ps.setString(3, item.getADDRESS());
				ps.setString(4, item.getTEL());
			}
		});

		return itemWriter;
	}
	
	public JdbcBatchItemWriter<List<String>> batchItemWriter() {
		
		JdbcBatchItemWriter<List<String>> itemWriter = new JdbcBatchItemWriter<List<String>> ();
		
		itemWriter.setSql("INSERT INTO TM_USER  ( NAME, AGE, ADDRESS, TEL) VALUES(?, ?, ?, ?)");
		itemWriter.setDataSource(batchDatasource());
		itemWriter.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<List<String>>() {
			
			@Override
			public void setValues(List<String> item, PreparedStatement ps) throws SQLException {
				ps.setString(1, item.get(0));
				ps.setString(2, item.get(1));
				ps.setString(3, item.get(2));
				ps.setString(4, item.get(3));
			}
		});

		return itemWriter;
	}
	
	class SimpleItemProcessors implements ItemProcessor<List<String>,List<String>>{

		@Override
		public List<String> process(List<String> item) throws Exception {
			item.set(3, "updated");
			return item;
		}
		
	}
	
	class JdbcItemProcessors implements ItemProcessor<TM_USER,TM_USER>{
		
		@Override
		public TM_USER process(TM_USER item) throws Exception {
			item.setADDRESS("");
			item.setADDRESS("** ****");
			return item;
		}
		
	}
	
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(BatchConfiguration.class);
		
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		
		jobLauncher.run(job, new JobParameters());
	}
}
