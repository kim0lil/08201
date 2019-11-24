package annotations.autowired;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Autowired는 List을 사용하여 해당하는 빈 객체를 주입받을 수 있습니다.
@Component
public class AutowiredAnnotation_list {
	
	@Autowired
	public List<AutowiredObject> owners;

	public List<AutowiredObject> getOwners() {

		return owners;
	}
}
