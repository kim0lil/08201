package annotations.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotation_method {

	private String name;

	@Value("Justin")
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
