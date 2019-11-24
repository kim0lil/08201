package annotations.primary;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"annotations.primary"})
public class boot {

	@Bean
	@Primary
	public String engName() {
		return "Justin";
	}
	
	@Bean
	public String korName() {
		return "LeeJinHyeok";
	}
	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context
			= new AnnotationConfigApplicationContext(boot.class);
		
		PrimaryAnnotation primary = context.getBean(PrimaryAnnotation.class);
		
		if(!"Justin".equals(primary.getName())) {
			System.out.println("test expire");
		}
		
	}
}
