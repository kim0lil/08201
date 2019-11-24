package annotations.propertySource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource(
	name = "ignoreResourceNotFound"
  , value = {"classpath:notFound.properties"}
  , ignoreResourceNotFound = true // false로 변경시 에러 발생
)
@ComponentScan // PropertySource를 사용하 ComponentScan을 필수로 등록 하여야 한다
public class PropertySourceAnnotation_ignoreResourceNotFound {
	
}
