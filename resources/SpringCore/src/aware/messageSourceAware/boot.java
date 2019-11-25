package aware.messageSourceAware;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ComponentScan("aware.messageSourceAware")
public class boot {
	
	@Bean
	public Locale getLocale() {
		return new Locale("en_US");
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		
		messageSource.setDefaultEncoding("utf-8");
		
		messageSource.setBasename("classpath:aware/messageSourceAware/message");
		
		return messageSource;
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		MessageSourceAwareInterface messageSource = context.getBean(MessageSourceAwareInterface.class);
		
		String item1 = messageSource.getMessage();
		
		if(!item1.equals("Justin")) {
			System.out.println("test expire");
		}
		
	}
}
