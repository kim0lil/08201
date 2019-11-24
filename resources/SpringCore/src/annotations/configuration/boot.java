package annotations.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"annotations.configuration"})
public class boot {
	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context
			= new AnnotationConfigApplicationContext(boot.class);
		
		if(ConfigurationAnnotation.bootYn.equals("N")) {
			System.out.println("test expire");
		}
	}
}
