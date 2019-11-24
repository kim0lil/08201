package beanPostProcess;

import org.springframework.stereotype.Component;

@Component
public class PostProcessingBean {

	private String name;
	
	public void init(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
