package annotations.qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"annotations.qualifier"})
public class boot {
	
	@Bean("eng")
	public String engName() {
		return "Justin";
	}
	
	@Bean("kor")
	public String korName() {
		return "LeeJinHyeok";
	}
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context
			= new AnnotationConfigApplicationContext(boot.class);
	
		QualifierAnnotation qualifier = context.getBean(QualifierAnnotation.class);
		QualifierAnnotation_method method = context.getBean(QualifierAnnotation_method.class);
		QualifierAnnotation_constructor constructor = context.getBean(QualifierAnnotation_constructor.class);
		
		if(!"Justin".equals(qualifier.getName())) {
			System.out.println("test expire");
		}

		if(!"Justin".equals(method.getName())) {
			System.out.println("test expire");
		}
		
		if(!"Justin".equals(constructor.getName())) {
			System.out.println("test expire");
		}
	}
}
