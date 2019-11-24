package annotations.componentScan;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(
//기준이 되는 패키지를 지정 - basePackages = String[,String[]]
//기준이 되는 클래스를 지정 - basePackageClasses = Class[,Class[]]
//컴포넌트 스캔시에 배제할 필터 지정 - excludeFilters = ComponentnScan.Filter
//컴포넌트 스캔시에 등록할 필터 지정 - includeFilters = ComponentnScan.Filter
//빈 설정 시에 초기화 시기 설정 - lazyInit = Boolean
//기본 필터 적용 여부 - useDefaultFilters = Boolean 
//빈 스코프를 처리할 리졸버 - scopeResolver = implements org.springframework.context.annotation.ScopeMetadataResolver
//빈 명칭을 처리할 리졸버  - nameGenerator = implements org.springframework.beans.factory.support.BeanNameGenerator
)
public class ComponentScanAnnotation {
	
}
