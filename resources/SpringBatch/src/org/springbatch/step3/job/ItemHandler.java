package org.springbatch.step3.job;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ItemHandler {
	
	@Value("classpath:org/springbatch/step3/input.txt")
	private Resource input;
	
	@Value("classpath:org/springbatch/step3/output.txt")
	private Resource output;
	
	@Autowired
	private DataSource dataSource;

	@Bean
	public ItemReader<List<String>> flatfileItemReader() {
		
		FlatFileItemReader<List<String>> flatfileItemReader = new FlatFileItemReader<List<String>>();

		flatfileItemReader.setResource(input);
		
		flatfileItemReader.setLineMapper((s, i)->{
			String[] splitList = s.split(",");
			return Arrays.asList(splitList);
		});
		
		return flatfileItemReader;
	}
	
	@Bean
	public ItemReader<List<String>> jdbcCursorItemReader() {
		JdbcCursorItemReader<List<String>> cursorItemReader = new JdbcCursorItemReader<List<String>>();
		
		cursorItemReader.setDataSource(dataSource);
		cursorItemReader.setIgnoreWarnings(true);
		
		cursorItemReader.setRowMapper((r,i)->{
			return Arrays.asList(r.getString(1),r.getString(2),r.getString(3),r.getString(4));
		});
		
		cursorItemReader.setSql("SELECT NAME, AGE, ADDRESS, TEL FROM TM_USER");
		
		return cursorItemReader;
	}
	

	@Bean
	public ItemProcessor<List<String>, List<String>> nonProcessingItemProcessor() {
		return (item->item);
	}
	
	@Bean
	public ItemProcessor<List<String>, List<String>> firstUpdateProcessingItemProcessor() {
		return (item->{
			item.set(1, "30");
			return item;
		});
	}
	
	
	@Bean
	public ItemProcessor<List<String>,List<String>> logProcessingItemProcessor() {
		return (item->{
			System.out.println(item.toString());
			return item;
		});
	}
	
	@Bean
	public ItemProcessor<List<String>,List<String>> compositItemProcessor() {
		return new CompositeItemProcessorBuilder<List<String>, List<String>>()
				  .delegates(Arrays.asList(firstUpdateProcessingItemProcessor(),logProcessingItemProcessor()))
				  .build();
	}
	
	@Bean
	public ItemWriter<List<String>> flatfileItemWriter() {
		FlatFileItemWriter<List<String>> flatfileItemWriter= new FlatFileItemWriter<List<String>>();
		
		flatfileItemWriter.setEncoding("UTF-8");
		flatfileItemWriter.setAppendAllowed(true);
		flatfileItemWriter.setResource(output);
		flatfileItemWriter.setForceSync(true);

		flatfileItemWriter.setLineAggregator((item->String.join(",", item)));

		return flatfileItemWriter;
	}
	
	@Bean
	public ItemWriter<List<String>> jdbcItemWriter() {

		JdbcBatchItemWriter<List<String>> batchItemWriter = new JdbcBatchItemWriter<List<String>>();

		batchItemWriter.setDataSource(dataSource);
		batchItemWriter.setSql("INSERT INTO TM_USER (NAME, AGE, ADDRESS, TEL) VALUES(?,?,?,?)");
		batchItemWriter.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<List<String>>() {
			
			@Override
			public void setValues(List<String> item, PreparedStatement ps) throws SQLException {
				
				ps.setString(1, item.get(0));	
				ps.setString(2, item.get(1));	
				ps.setString(3, item.get(2));	
				ps.setString(4, item.get(3));	
			}
		});

		return batchItemWriter;
	}
}
