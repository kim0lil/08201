package aware.beanNameAware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanNameAwareInterface implements BeanNameAware {
	
	@Autowired
	private String message;

	public static String beanName;

	@Override
	public void setBeanName(String name) {
		beanName = name;
	}

	public static String getBeanName() {
		return beanName;
	}

	public String getMessage() {
		return message;
	}
	
	
}
