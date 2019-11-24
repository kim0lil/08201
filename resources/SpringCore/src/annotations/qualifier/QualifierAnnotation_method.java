package annotations.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 메서드를 사용하여 의존성을 주입 할 때 빈 명칭을 선택 할 수 있습니다.
@Component
public class QualifierAnnotation_method {
	
	private String name;
	
	@Autowired
	public void setName(@Qualifier("eng") String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
