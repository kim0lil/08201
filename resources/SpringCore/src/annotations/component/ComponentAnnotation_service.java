package annotations.component;

import org.springframework.stereotype.Service;

@Service
public class ComponentAnnotation_service {

	@Override
	public String toString() {
		return "i'm component annotation";
	}
	
}
