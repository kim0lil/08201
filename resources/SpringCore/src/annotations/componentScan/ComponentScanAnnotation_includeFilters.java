package annotations.componentScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//includeFilters를 사용하여 빈으로 등록해야 할 대상을 필터링합니다.
@ComponentScan(basePackages = {"annotations.componentScan"}
	, useDefaultFilters = false    // 기본 필터를 사용하지 않습니다.
	, includeFilters = {
			   // 컴포넌트 스캔의 필터를 사용 합니다.
			   @ComponentScan.Filter(
					   // 정규 표현식을 사용하여 클래스 명과 풀 매칭 합니다.
					   type = FilterType.REGEX
					  ,pattern = { "annotations.componentScan.Scan*" } 
					   // componentScan패키지 아래 Scan으로 시작하는 클래스는 빈으로 등록합니다.
			   ),
			   // 또는 원하는 에노테이션을 필터링 할수 있습니다. 
			   @ComponentScan.Filter(
					   type = FilterType.ANNOTATION 
					  ,classes = { CustomAnnotation.class } 
					   // @CustomAnnotation이 붙은 클래스는 빈으로 등록합니다.
			   ),
			   // 또는 원하는 타입을 지정할 수 있습니다.
			   @ComponentScan.Filter(
					   type = FilterType.ASSIGNABLE_TYPE
					  ,value = { Scan.class } 
					   // Scan클래스를 빈으로 등록합니다.
			   )
	}
)
public class ComponentScanAnnotation_includeFilters {
	
}
