package annotations.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("annotations.scope")
public class boot { 
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		ScopeAnnotation item1 = context.getBean(ScopeAnnotation.class);
		ScopeAnnotation item2 = context.getBean(ScopeAnnotation.class);

		if(item1 == item2) {
			System.out.println("test expire");
		}
	}
}
