package annotations.primary;

import org.springframework.stereotype.Component;

@Component
public class PrimaryAnnotation {

	private String name;
	
	public PrimaryAnnotation(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
