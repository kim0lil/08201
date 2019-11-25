package aop.afterThrowing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("aop.afterThrowing")
public class boot {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		ZeroDeviceSigniture device = context.getBean(ZeroDeviceSigniture.class);
		AfterThrowingAdvice advice = context.getBean(AfterThrowingAdvice.class);
		
		try {
			device.devide(1, 0);
		}catch(Exception e) {
			
		}

		String item1 = advice.getExceptionMessage();
		
		if(item1 == null) {
			System.out.println("test expire");
		}
	}
}
