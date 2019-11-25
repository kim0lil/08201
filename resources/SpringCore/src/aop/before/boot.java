package aop.before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aop.before")
@EnableAspectJAutoProxy
public class boot {

	@Bean
	public StringBuilder builder() {
		return new StringBuilder();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		PointCut cutting = context.getBean(PointCut.class);
		BeforeAdvice advice = context.getBean(BeforeAdvice.class);
		
		cutting.add(10, 15);
		cutting.sub(5, 10);
		
		String item1 = advice.getMessage();
		
		if(!item1.equals("10,15")) {
			System.out.println("test expire");
		}
	}
}
