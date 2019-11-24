package annotations.resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class ResourceAnnotation {

	@Resource(name = "eng")
	private String name;

	public String getName() {
		return name;
	}
}
