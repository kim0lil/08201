package annotations.dependsOn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class boot {
	
	public static StringBuffer stdinout = new StringBuffer();
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(DependsOnAnnotations.class);
		
		String item1 = stdinout.toString();
		
		if(!item1.equals("first-second")) {
			System.out.println("test expire");
			return;
		}
	}
}
