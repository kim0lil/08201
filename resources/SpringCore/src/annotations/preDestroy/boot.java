package annotations.preDestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("annotations.preDestroy")
public class boot {
	
	public static StringBuffer stdinout = new StringBuffer();
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		context.destroy();
		
		String item1 = stdinout.toString();
		
		if(!item1.equals("<<destroy>>")) {
			
			System.out.println("test expire");
		}
	}
}
