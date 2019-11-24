package annotations.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileAnnotation_method {
	
	@Bean
	@Profile("method")
	public String method() {
		return "method-이진혁";
	}

	@Bean
	@Profile("none")
	public String none() {
		return "none-이진혁";
	}
}
