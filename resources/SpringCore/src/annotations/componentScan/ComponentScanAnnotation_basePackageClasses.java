package annotations.componentScan;

import org.springframework.context.annotation.ComponentScan;

//클래스를 기준으로 정해 주어 해당 클래스 이하를 검색 범위를 한정합니다.
@ComponentScan(basePackageClasses = {ComponentScanAnnotation_basePackageClasses.class})
public class ComponentScanAnnotation_basePackageClasses {
	
}
