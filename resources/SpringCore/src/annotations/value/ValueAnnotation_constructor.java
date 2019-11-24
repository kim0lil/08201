package annotations.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotation_constructor {

	private String name;

	
	public ValueAnnotation_constructor(@Value("Justin") String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}
	
}
