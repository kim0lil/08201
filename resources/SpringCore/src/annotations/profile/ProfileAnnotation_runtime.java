package annotations.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileAnnotation_runtime {
	
	@Bean
	@Profile("run")
	public String method() {
		return "run-이진혁";
	}

	@Bean
	@Profile("dev")
	public String none() {
		return "dev-이진혁";
	}
}
