package annotations.autowired;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Component;

// Autowired는 Map을 사용하여 bean ID와 해당하는 빈 객체를 주입받을 수 있습니다.
@Component
public class AutowiredAnnotation_map {

	@Autowired
	public Map<String, AutowiredObject> owners;

	public Map<String, AutowiredObject> getOwners() {

		return owners;
	}
}
