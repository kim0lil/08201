package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
	//WebConfiguration.class,
	InterceptorConfiguration.class
})
public class SpringConfiguration {
	
}
