package locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class LocaleConfiguration {

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource
			= new ReloadableResourceBundleMessageSource();
		
		messageSource.setDefaultEncoding("utf-8");
		messageSource.setBasename("classpath:locale/message");
		
		messageSource.setCacheSeconds(1);

		return messageSource; 
	}
}
