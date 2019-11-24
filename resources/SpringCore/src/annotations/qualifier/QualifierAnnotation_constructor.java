package annotations.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 생성자를 사용하여 의존성을 주입 할 때 빈 명칭을 선택 할 수 있습니다.
@Component
public class QualifierAnnotation_constructor {
	
	private String name;
	
	public QualifierAnnotation_constructor(@Qualifier("eng") String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
