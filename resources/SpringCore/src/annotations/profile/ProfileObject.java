package annotations.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileObject {
	
	@Autowired(required = false)
	private String name;

	public String getName() {
		return name;
	}
}
