package org.springbatch.step1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.launch.support.RunIdIncrementer;

public class SimpleLogJob extends ArrayList<Step> implements Job{

	private String name;
	
	public SimpleLogJob(String name) {
		this.name = name == null ? "-" : name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isRestartable() {
		return false;
	}

	@Override
	public void execute(JobExecution execution) {
		try {
			for(Step step : this) {
				StepExecution stepExecution = new StepExecution(step.getName(), execution);

				step.execute(stepExecution);
				
				System.out.println("걸린시간 : "+(stepExecution.getEndTime().getTime() - stepExecution.getStartTime().getTime())+"/ms");
				System.out.println(stepExecution.getReadCount()+"건 읽었습니다.");
				System.out.println(stepExecution.getWriteCount()+"건 작성하였습니다.");
			}
		} catch (JobInterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public JobParametersIncrementer getJobParametersIncrementer() {
		return new RunIdIncrementer();
	}

	@Override
	public JobParametersValidator getJobParametersValidator() {
		return new DefaultJobParametersValidator();
	}
}
