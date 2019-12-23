package org.springbatch.step1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class boot {
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {

		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(BatchConfiguration.class);

		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		
		SimpleLogJob job = new SimpleLogJob("SimpleLogJob");
		
		job.add(new SimpleStep("FileUpdateStep"));
		
		Map<String, JobParameter> jobParameter = new HashMap<String, JobParameter>();
		jobParameter.put("in_file", new JobParameter("src/org/springbatch/step1/Hello.txt"));
		jobParameter.put("out_file", new JobParameter("src/org/springbatch/step1/Hello2.txt"));

		jobLauncher.run(job, new JobParameters(jobParameter));
	}
}
