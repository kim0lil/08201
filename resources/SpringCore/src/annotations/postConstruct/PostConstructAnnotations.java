package annotations.postConstruct;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PostConstructAnnotations {

	private String name;
	
	@PostConstruct
	public void initMethod() {
		this.name = "<<init>>";
	}

	public String getName() {
		return name;
	}
}
