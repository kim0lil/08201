package com.batch.batch;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.RowMapper;

@Batch
public class SimpleBatch {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Value("com/batch/out.txt")
	private Resource out;
	
	@Autowired
	@Qualifier("batchDataSource")
	private DataSource dataSource;
	
	@Bean("job")
	public Job simpleJob() {
		return jobBuilderFactory.get("simpleJob")
				                .start(simpleStep(null))
				                .build();
	}
	
	@Bean
	@JobScope
	public Step simpleStep(@Value("#{jobParameters[dateTime]}") Date dateTime) {
		System.out.println(">>"+dateTime.toString());
		return stepBuilderFactory.get("simpleStep")
				                 .<Map<String,Object>,Map<String,Object>>chunk(10)
				                 .reader(jdbcItemReader())
				                 .writer(itemWriter())
				                 .build();
	}
	
	public ItemReader<Map<String,Object>> jdbcItemReader() {
		return new JdbcCursorItemReaderBuilder<Map<String,Object>>()
			   .sql("SELECT * FROM TM_USER")
			   .rowMapper(new RowMapper<Map<String,Object>>() {
				
				@Override
				public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
					Map<String, Object> map = new HashMap<String, Object>();
					ResultSetMetaData mataData = rs.getMetaData();
					
					for(int col = 1 ; col <= mataData.getColumnCount() ; col++) {
						String colName  = mataData.getColumnName(col);
						Object colValue = rs.getObject(colName);

						map.put(colName, colValue);
					}
					System.out.println(map);
					
					return map;
				}
			})
		   .name("jdbcItemReader")
		   .dataSource(dataSource)
		   .build();
	}
	
	
	public ItemWriter<Map<String,Object>> itemWriter() {
		return new FlatFileItemWriterBuilder<Map<String,Object>>()
				.lineAggregator(e->{
					System.out.println(e.toString());
					return e.toString();
				})
				.name("itemWriter")
				.resource(out)
				.build();
				
	}
}
