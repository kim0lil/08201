package aop.order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("aop.order")
public class boot {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		Target t = context.getBean(Target.class);
		
		int result = t.result(10);
		//10 / 2 + 6 + 4 = 15 ? 
		//10 + 6 / 2 + 4 = 12 ?
		System.out.println("result : "+result);
	}
}
