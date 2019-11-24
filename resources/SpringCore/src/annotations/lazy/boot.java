package annotations.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("annotations.lazy")
public class boot {
	
	public static StringBuffer stdinout = new StringBuffer();
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		String item1 = stdinout.toString();
		
		if(item1.equals("<<init>>")) {

			System.out.println("test expire");
			return;
		}
		
		context.getBean(LazyAnnotations.class);
		
		String item2 = stdinout.toString();
		
		if(!item2.equals("<<init>>")) {

			System.out.println("test expire");
			return;
		}
	}
}
