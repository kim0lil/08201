package org.springbatch.step3.job;

import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.TaskExecutor;
import org.springframework.retry.policy.TimeoutRetryPolicy;

@Configuration
@Import(ItemHandler.class)
public class SimpleJob {
	
	@Autowired
	private ItemHandler itemHandler;

	@Autowired
	private JobBuilderFactory jobs;
	
	@Autowired
	private StepBuilderFactory steps;
	
	@Autowired
	private TaskExecutor teskExecutor;
	
	
	@Bean("fileReadFileWriteJob")
	public Job fileReadFileWriteJob() {
		return jobs.get("fileReadFileWriteJob")
				   .start(fileReadFileWriteStep())
				   .next(fileReadJdbcWriterStep()) 
				   .next(jdbcReadJdbcWriteStep())
				   .build();
	}
	
	@Bean("statementJob")
	public Job statementJob() {
		return jobs.get("statementJob")
				.start(fileReadFileWriteStep())
				.on("COMPLETED").to(fileReadJdbcWriterStep())
				.on("*").to(fileReadJdbcWriterStep())
				.end()
				.build();
	}
	
	@Bean
	public Step fileReadFileWriteStep() {
		return steps.get("fileReadFileWriteStep")
				    .<List<String>, List<String>>chunk(500)
				    .faultTolerant()
				    .retryLimit(5)
				    .retryPolicy(new TimeoutRetryPolicy())
				    .reader(itemHandler.flatfileItemReader())
				    .processor(itemHandler.nonProcessingItemProcessor())
				    .writer(itemHandler.flatfileItemWriter())
				    .build();
	}
	
	@Bean
	public Step fileReadJdbcWriterStep() {
		return steps.get("fileReadJdbcWriterStep")
				.<List<String>, List<String>>chunk(500)
				.reader(itemHandler.flatfileItemReader())
				.processor(itemHandler.logProcessingItemProcessor())
				.writer(itemHandler.jdbcItemWriter())
				.build();
	}
	
	@Bean
	public Step jdbcReadJdbcWriteStep() {
		return steps.get("fileReadJdbcWriterStep")
				.<List<String>, List<String>>chunk(500)
				.reader(itemHandler.jdbcCursorItemReader())
				.processor(itemHandler.firstUpdateProcessingItemProcessor())
				.writer(itemHandler.jdbcItemWriter())
				.build();
	}
}
