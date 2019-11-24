package annotations.lazy;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(true)
public class LazyAnnotations {

	@PostConstruct
	public void destroyMethod() {
		boot.stdinout.append("<<init>>");
	}

}
