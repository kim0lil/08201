package aware.beanFactoryAware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("aware.beanFactoryAware")
public class boot {
	
	@Bean
	public String name() {
		return "Justin";
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		BeanFactoryAwareInterface beanFactoryAware = context.getBean(BeanFactoryAwareInterface.class);
		
		String item1 = beanFactoryAware.getMessage();
		
		if(!item1.equals("Justin")) {
			System.out.println("test expire");
		}
	}
}
