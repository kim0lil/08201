package annotations.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QualifierAnnotation {

	@Autowired
	@Qualifier("eng")
	private String name;

	public String getName() {
		return name;
	}
}
