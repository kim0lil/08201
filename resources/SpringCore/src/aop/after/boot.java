package aop.after;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan("aop.after")
public class boot {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		EmbeddedTransaction tx = context.getBean(EmbeddedTransaction.class);
		AfterAdvice afterAdvice = context.getBean(AfterAdvice.class);
		
		int $loop = 5;
		
		while($loop-->0)tx.connect();
		
		if(afterAdvice.getCount() != 5) {
			System.out.println("test expire");
		}
	}
}
