package annotations.autowired;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"annotations.autowired"})
public class boot {

	
	@Bean
	public String getName() {
		return "Justin";
	}
	
	@Bean
	public AutowiredObject getOwner1() {
		return new AutowiredObject("Justin", "Limmer", "Ken");
	}
	
	@Bean
	public AutowiredObject getOwner2() {
		return new AutowiredObject("Mina", "Luice", "Killan");
	}
	
	@Bean
	public AutowiredObject getOwner3() {
		return new AutowiredObject("Homi", "Lus", "issac");
	}
	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context
			=	new AnnotationConfigApplicationContext(boot.class);
		
		// 의존성 주입
		AutowiredAnnotation autowired 
			= context.getBean(AutowiredAnnotation.class);

		// 메소드 단위 의존성 주입
		AutowiredAnnotation_method method
			= context.getBean(AutowiredAnnotation_method.class);

		// 단일 생성자 의존성 자동 주입
		AutowiredAnnotation_constructor constructor
		= context.getBean(AutowiredAnnotation_constructor.class);

		// 의존성 필수 여부
		AutowiredAnnotation_required required
			= context.getBean(AutowiredAnnotation_required.class);
		
		// 맵 객체를 통한 의존성 주입
		AutowiredAnnotation_map map
			= context.getBean(AutowiredAnnotation_map.class);
		
		// 리스트 객체를 통한 의존성 주입
		AutowiredAnnotation_list list
		= context.getBean(AutowiredAnnotation_list.class);
		
		
		String item1 = autowired.getName();

		if(!"Justin".equals(item1)) {
			System.out.println("test expire");
			return;
		}
		
		String item2 = method.getName();
		
		if(!"Justin".equals(item2)) {
			System.out.println("test expire");
			return;
		}
		
		String item3 = constructor.getName();
		
		if(!"Justin".equals(item3)) {
			System.out.println("test expire");
			return;
		}
		
		int item4 = required.getAge();
		
		if(!(0 == item4)) {
			System.out.println("test expire");
			return;
		}

		Map<String, AutowiredObject> item5 = map.getOwners();

		if(item5.size() != 3) {
			System.out.println("test expire");
			return;
		}
		
		List<AutowiredObject> item6 = list.getOwners();
		
		if(item6.size() != 3) {
			System.out.println("test expire");
			return;
		}
		
		
	}
}
