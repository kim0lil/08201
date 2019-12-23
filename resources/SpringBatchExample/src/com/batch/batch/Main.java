package com.batch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.batch.config.ApplicationConfiguration;
import com.batch.config.BatchConfiguration;

public class Main {
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext();
		
		context.register(ApplicationConfiguration.class, BatchConfiguration.class);
		context.refresh();
		
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		jobLauncher.run(job, new JobParametersBuilder().addParameter("a",new JobParameter(args[0])).toJobParameters());
		
	}
}
