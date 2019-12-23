package com.education;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class boot {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(BatchConfiguration.class);
		
		JobRepository jr = context.getBean(JobRepository.class);
		JobLauncher jl   = context.getBean(JobLauncher.class);
		System.out.println(jr);
		System.out.println(jl);
	}
}