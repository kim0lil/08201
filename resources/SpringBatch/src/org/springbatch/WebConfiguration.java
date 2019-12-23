package org.springbatch;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("org.springbatch.web")
public class WebConfiguration {

	public WebConfiguration() {
		System.out.println("---------------------");
	}
	
}
