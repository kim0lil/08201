package annotations.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanAnnotation {

	@Bean(
	//다른 빈에서 이 빈을 autowire 에너테이션으로 의존할 수 있는지 여부 - autowireCandidate = Boolean
	//빈이 생성 된 다음 초기화 하는 메소드 - initMethod = String
	//빈이 삭제 되기전 실행되는 메소드 - destroyMethod = String
	//빈의 가칭을 등록 = name = String[,String[]]
	)
	public BeanObject getBeanObject() {
		return new BeanObject();
	}
}
