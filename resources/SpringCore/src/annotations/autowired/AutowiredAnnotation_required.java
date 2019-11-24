package annotations.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredAnnotation_required {
	
	
	@Autowired(
			required = false
			)
	private int age;

	public int getAge() {
		return age;
	}
}
