package annotations.component;

import org.springframework.stereotype.Component;

@Component

//실제 비즈니스 로직을 처리하는 비즈니스 레이어에 사용 - @Service
//웹서비스와 같은 웹 레이어에 사용 - @Controller
//데이터베이스 접근 같은 영속성이 필요한 퍼시스턴스 레이어에 사용 - @Repository
public class ComponentAnnotation {

	@Override
	public String toString() {
		return "i'm component annotation";
	}
	
}
