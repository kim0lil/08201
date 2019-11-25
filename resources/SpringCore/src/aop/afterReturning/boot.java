package aop.afterReturning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan
@Configuration
public class boot {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		Arithmetics arithmetics = context.getBean(Arithmetics.class);
		AfterReturningAdvice advice = context.getBean(AfterReturningAdvice.class);
		
		arithmetics.arithmetics(10, 20, 30);
		
		String item1 = advice.getMethodName();
		int item2        = advice.getResult();

		if(!item1.equals("arithmetics")) {
			System.out.println("test expire");
		}
		
		if(item2 != arithmetics.getResult()) {
			System.out.println("test expire");
		}
		
			
	}
}
