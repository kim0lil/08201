package annotations.resource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("annotations.resource")
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
		
		ResourceAnnotation resource = context.getBean(ResourceAnnotation.class);
		
		if(!"Justin".equals(resource.getName())) {
			System.out.println("test expire");
		}
	}
}
