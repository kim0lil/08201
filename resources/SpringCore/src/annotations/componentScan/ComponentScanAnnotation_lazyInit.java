package annotations.componentScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

// 스프링 초기화 시에 빈 초기화를 할지 여부를 등록 합니다. default = true
@ComponentScan(
		basePackages = {"annotaions.componentScan"}
	  , lazyInit = true // 빈 초기화를 실행할 때 합니다. false로 변경 시 실행과 동시에 <<init>>이 출력 될 것입니다.
	  , includeFilters = {
			  @ComponentScan.Filter(
			      type = FilterType.ASSIGNABLE_TYPE,
			      classes = {LazyBean.class}
			  )
	  }
)
public class ComponentScanAnnotation_lazyInit {
	
}
