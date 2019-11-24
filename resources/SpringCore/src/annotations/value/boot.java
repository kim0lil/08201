package annotations.value;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("annotations.value")
public class boot {
	

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		ValueAnnotation item1 = context.getBean(ValueAnnotation.class);
		
		if(!item1.getName().equals("Justin")) {
			System.out.println("test expire");
			return;
		}

		ValueAnnotation_method item2 = context.getBean(ValueAnnotation_method.class);
		
		if(!item2.getName().equals("Justin")) {
			System.out.println("test expire");
			return;
		}
		
		ValueAnnotation_constructor item3 = context.getBean(ValueAnnotation_constructor.class);
		
		if(!item3.getName().equals("Justin")) {
			System.out.println("test expire");
			return;
		}
		
		ValueAnnotation_external item4 = context.getBean(ValueAnnotation_external.class);

		if(!item4.getName().equals("Justin")
		|| !item4.getDefaultName().equals("이진혁")) {
			System.out.println("test expire");
			return;
		}
		
		ValueAnnotation_resources item5 = context.getBean(ValueAnnotation_resources.class);
		
		if(!item5.getName().equals("Justin")) {
			System.out.println("test expire");
			return;
		}
		
	}
}
