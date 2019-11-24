package annotations.preDestroy;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class PreDestroyAnnotations {

	@PreDestroy
	public void destroyMethod() {
		boot.stdinout.append("<<destroy>>");
	}

}
