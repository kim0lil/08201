package org.springbatch.step1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import org.springframework.batch.core.StepExecution;

public class FileReader {
	
	private BufferedReader br;
	private String nexLine;
	private StepExecution stepExecution;
	
	public FileReader(StepExecution stepExecution) {
		this.stepExecution = stepExecution; 
	}

	public boolean readable() {
		try {
			nexLine = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		if(nexLine != null) {
			this.stepExecution.setReadCount(this.stepExecution.getReadCount()+1);
			this.stepExecution.getExecutionContext().putString(SimpleStep.ITEM, nexLine);
			
			return true;
		}else {
			return false;
		}
	}

	public void openStream()  {
		
		String filePath = stepExecution.getJobParameters().getString("in_file");
		
		try {
			File file = new File(filePath);
			java.io.FileReader reader = new java.io.FileReader(file);
			this.br = new BufferedReader(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeStream() {
		try {
			this.br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
