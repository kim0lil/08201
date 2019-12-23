package com.batch.batch;

import java.util.Date;
import java.util.HashMap;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

@Component
public class SimpleScheduling {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	@Scheduled(fixedRate = 1000*60)
	public void SecondaryBatch() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		HashMap<String, JobParameter> jobparams = new HashMap<String, JobParameter>();
		jobparams.put("dateTime", new JobParameter(new Date()));
		jobLauncher.run(job, new JobParameters(jobparams));
	}
	
	//@Schedules(value = {@Scheduled(cron = "")})
	public void SecondaryBatch2() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		HashMap<String, JobParameter> jobparams = new HashMap<String, JobParameter>();
		jobparams.put("dateTime", new JobParameter(new Date()));
		jobLauncher.run(job, new JobParameters(jobparams));
	}
	
}
