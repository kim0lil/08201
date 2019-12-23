package org.springbatch.step1;

import java.util.Date;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;

public class SimpleStep implements Step{
	
	private String name;
	
	public final static String ITEM = "item";
	
	public SimpleStep(String name) {
		this.name = name == null ? "-" : name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isAllowStartIfComplete() {
		return false;
	}

	@Override
	public int getStartLimit() {
		return 0;
	}

	@Override
	public void execute(StepExecution stepExecution) {
		
		
		FileReader  reader  = new FileReader(stepExecution);     
		FileUpdator updater = new FileUpdator(stepExecution);    
		FileWritor  writer  = new FileWritor(stepExecution);     

		stepExecution.setStartTime(new Date());
		
		reader.openStream();
		writer.openStream();
		
		while(reader.readable()) {
			updater.update();
			writer.write();
		}

		reader.closeStream();
		writer.closeStream();
		
		stepExecution.setEndTime(new Date());
	}
}
