package annotations.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredAnnotation_method {

	private String name;
	
	@Autowired
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
