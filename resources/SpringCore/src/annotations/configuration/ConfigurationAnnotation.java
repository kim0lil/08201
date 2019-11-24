package annotations.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationAnnotation {
	
	public static String bootYn = "N";
	
	public ConfigurationAnnotation() {
		this.bootYn = "Y";
	}

	
}
