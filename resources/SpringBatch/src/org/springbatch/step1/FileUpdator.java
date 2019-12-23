package org.springbatch.step1;

import org.springframework.batch.core.StepExecution;

public class FileUpdator{
	
	private StepExecution stepExecution;
	
	public FileUpdator(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}

	public void update(){

		String item = stepExecution.getExecutionContext().getString("item");
		String[] spliteItems = item.split(",");
		
		spliteItems[1] = "updated";
		
		stepExecution.getExecutionContext().putString("item", String.join(",", spliteItems));
	}
}
