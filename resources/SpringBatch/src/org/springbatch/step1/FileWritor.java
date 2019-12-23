package org.springbatch.step1;

import java.io.File;
import java.io.IOException;

import org.springframework.batch.core.StepExecution;

public class FileWritor{
	
	private java.io.FileWriter fw = null;
	private StepExecution stepExecution;
	private int iCount = 0;
	
	
	public FileWritor(StepExecution stepExecution) {
		this.stepExecution = stepExecution; 
	}
	
	public boolean writable() {
		return fw != null;
	}
	
	public void openStream() {
		String filePath = stepExecution.getJobParameters().getString("out_file");
		
		File file = new File(filePath);
		try {
			fw = new java.io.FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void closeStream() {
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(){

		String item = stepExecution.getExecutionContext().getString("item");
		
		if((iCount % 5) == 0) {
			iCount++;
			return;
		} else {

			iCount++;
		}
		try {
			fw.write(item+"\n");
			this.stepExecution.setWriteCount(this.stepExecution.getWriteCount()+1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
