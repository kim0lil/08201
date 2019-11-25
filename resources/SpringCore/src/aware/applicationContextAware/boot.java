package aware.applicationContextAware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("aware.applicationContextAware")
public class boot {
	
	@Bean
	public String name() {
		return "Justin";
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		ApplicationContextAwareInterface applicationContext
			=	context.getBean(ApplicationContextAwareInterface.class);
		
		String item1 = applicationContext.getBean();
		
		if(!item1.equals("Justin")) {
			System.out.println("test expire");
		}
	}
}
