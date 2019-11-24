package annotations.value;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotation_resources {

	@Value("classpath:annotations/value/Properties.properties")
	private Resource resource;
	
	@PostConstruct
	public void PostConstructEvent() {
		Properties prop = new Properties();
		try {
			prop.load(resource.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.name = prop.getProperty("name");
	}
	
	private String name;

	public String getName() {
		return name;
	}
	
}
