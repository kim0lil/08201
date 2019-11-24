package annotations.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanAutowired {
	
	@Autowired(required = false)
	private BeanObject beanObject;

	public BeanObject getBeanObject() {
		return beanObject;
	}

}
