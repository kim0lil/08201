package annotations.componentScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//useDefaultFilters는 기본 컴포넌트(@Component,@Service ..)의
//컴포넌트를 스캔하는 필터를 사용할지 하지 않을지를 등록 합니다.
@ComponentScan(basePackages = {"annotations.componentScan"}
, useDefaultFilters = false    // 기본 필터를 사용하지 않습니다.
		                          // default = true
)
public class ComponentScanAnnotation_useDefaultFilters {
	
}
