package annotations.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredAnnotation {
	
	
	@Autowired(
    // 의존성필수 여부 - required = Boolean
    )
	private String name;

	public String getName() {
		return name;
	}
}
