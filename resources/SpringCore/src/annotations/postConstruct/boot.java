package annotations.postConstruct;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("annotations.postConstruct")
public class boot {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		PostConstructAnnotations postCustruct = context.getBean(PostConstructAnnotations.class);
		
		String item1 = postCustruct.getName();
		
		if(!item1.equals("<<init>>")) {
			
			System.out.println("test expire");
		}
	}
}
