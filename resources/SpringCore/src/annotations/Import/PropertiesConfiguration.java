package annotations.Import;

import org.springframework.context.annotation.Bean;

public class PropertiesConfiguration {
	
	@Bean("user")
	public String user() {
		return "admin";
	}
	
	@Bean("url")
	public String baeUrl() {
		return "127.0.0.1:8080";
	}
	
}
