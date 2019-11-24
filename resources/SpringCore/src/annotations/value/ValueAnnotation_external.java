package annotations.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(name="external", value = "classpath:annotations/value/Properties.properties")
public class ValueAnnotation_external {

	// 외부의 값을 등록하고 싶을 경우 메타기호인 $와 {값}을 사용하여 입력합니다.
	@Value("${name}")
	private String name;
	
	// 기본값을 추가 하고 싶을 경우 값:기본값 형식으로 입력합니다.
	@Value("${defaultName:이진혁}")
	private String defaultName;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}
	
}
