package annotations.component;

import org.springframework.stereotype.Component;

@Component("annotationValue")
public class ComponentAnnotation_value {

	@Override
	public String toString() {
		return "i'm component annotation value";
	}
	
}
