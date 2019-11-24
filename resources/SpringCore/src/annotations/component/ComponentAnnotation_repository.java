package annotations.component;

import org.springframework.stereotype.Repository;

@Repository
public class ComponentAnnotation_repository {

	@Override
	public String toString() {
		return "i'm repository annotation";
	}
	
}
