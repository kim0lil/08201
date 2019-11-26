package aop.expression;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aop.expression")
@EnableAspectJAutoProxy
public class boot {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		MatchingMethod method = context.getBean(MatchingMethod.class);
		method.method_1_run(new ParamsObject());
		method.method_2_run();
		
		MatchingType type = context.getBean(MatchingType.class);
		type.method_1_run(new ParamsObject());
		type.method_2_run();
	}
}
