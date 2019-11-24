package annotations.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotation {

	@Value("Justin")
	private String name;

	public String getName() {
		return name;
	}
	
}
