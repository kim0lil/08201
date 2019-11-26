package aop.introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan("aop.i*")
public class boot {
	
	@Bean
	public String name() {
		return "Justin";
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		Logger logger = context.getBean(Logger.class);
		
		LogTransaction txLog = ((LogTransaction) logger); 
		LogDatabase    dbLog = ((LogDatabase) logger); 

		txLog.logTx("<< Lransaction Log >>");
		dbLog.logDB("<< Database Log >>");
	}
}
