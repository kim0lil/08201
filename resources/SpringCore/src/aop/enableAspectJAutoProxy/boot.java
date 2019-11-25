package aop.enableAspectJAutoProxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class boot {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext();

	}
}
