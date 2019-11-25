package aware.beanFactoryAware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryAwareInterface 
	implements BeanFactoryAware{
	
	private String message;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.message = beanFactory.getBean(String.class);
	}

	public String getMessage() {
		return message;
	}

}
