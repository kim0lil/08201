package annotations.autowired;

import org.springframework.stereotype.Component;

/**
 * 스프링 4.3이상의 버전에서는 단일 생성자의 경우 자동으로 의존성으 주입 됩니다. 
 */
@Component
public class AutowiredAnnotation_constructor {

	private String name;
	
	
	public AutowiredAnnotation_constructor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
