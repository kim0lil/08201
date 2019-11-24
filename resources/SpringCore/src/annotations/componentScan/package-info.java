
/**
 * ComponentScan 에노테이션은 @Component와 같은 특별한 에노테이션이 붙은 클래스를 스프링이 관리하는 빈으로 등록 합니다.
 * 
 * [Attirbutes]
 *      |
 *      +-- value : basePackages 속성과 동일
 *      |
 *      +-- basePackages : 패키지명을 사용하여 컴포넌트를 검색합니다.
 *      |        |
 *      |        \-- String[,LString] : 검색시 사용할 패키지명
 *      |
 *      +-- basePackageClasses : 클래스를 사용하여 컴포넌트를 검색합니다.
 *      |        |
 *      |        \-- Class[,LCLass] : 검색시에 사용할 기준 클래스 (이 클래스 아래로 스캔 합니다)
 *      |
 *      +-- useDefaultFilters : 기본 필터를 적용할지 여부를 등록합니다.
 *      |        |
 *      |        \-- Boolean : 기본은 true이며 fasle로 변경시 @Component와 @Repository와 같은 @Component기반의 어노테이션빈을 등록하지 않습니다.
 *      |
 *      +-- excludeFilters : 컴포넌트 스캔 시에 등록하지 않을 빈을 필터링
 *      |        |
 *      |        \-- ComponentnScan.Filter : 컴포넌트 필터 함수를 실행하여 결과값을 등록
 *      |                 |
 *      |                 +-- type : 필터링 시에 사용할 타입
 *      |                 |    |
 *      |                 |    +-- FilterType.REGEX(정규식을 사용하여 필터링)
 *      |                 |    |
 *      |                 |    +-- FilterType.ANNOTATION(에노테이션을 사용하여 필터링)
 *      |                 |    |
 *      |                 |    \-- FilterType.ASSIGNABLE_TYPE(타입[클래스]를 사용하여 필터링)
 *      |                 |
 *      |                 +-- pattern : 정규식을 사용하여 필터링 할 때 등록하는 패턴
 *      |                 |
 *      |                 +-- classes : 에노테이션을 사용하여 필터링 할 때 등록하는 에노테이션 클래스
 *      |                 |
 *      |                 \-- value : 타입과 기타 방법을 사용하여 필터링할 때 등록하는 값
 *      |
 *      +-- includeFilters : 컴포넌트 스캔 시에 등록할 빈을 필터링
 *      |        |
 *      |        \-- ComponentnScan.Filter : 컴포넌트 필터 함수를 실행하여 결과값을 등록
 *      |                 |
 *      |                 +-- type : 필터링 시에 사용할 타입
 *      |                 |    |
 *      |                 |    +-- FilterType.REGEX(정규식을 사용하여 필터링)
 *      |                 |    |
 *      |                 |    +-- FilterType.ANNOTATION(에노테이션을 사용하여 필터링)
 *      |                 |    |
 *      |                 |    \-- FilterType.ASSIGNABLE_TYPE(타입[클래스]를 사용하여 필터링)
 *      |                 |
 *      |                 +-- pattern : 정규식을 사용하여 필터링 할 때 등록하는 패턴
 *      |                 |
 *      |                 +-- classes : 에노테이션을 사용하여 필터링 할 때 등록하는 에노테이션 클래스
 *      |                 |
 *      |                 \-- value : 타입과 기타 방법을 사용하여 필터링할 때 등록하는 값
 *      |        
 *      +-- lazyInit : 빈의 초기화 시기 생성시점과 동일하게 할 것인지 여부를 등록합니다.
 *      |        |
 *      |        \-- Boolean : 기본은 false이며 true로 변경시 빈 호출시 초기화 합니다.
 *      |
 *      +-- scopeResolver : 빈의 스코프를 처리하는 리졸버를 등록합니다
 *      |        |
 *      |        \-- org.springframework.context.annotation.ScopeMetadataResolver를 상속 받은 클래스를 등록합니다.
 *      |
 *      \-- nameGenerator : 빈의 명칭을 처리하는 제너레이터를 등록합니다.
 *               |
 *               \-- org.springframework.beans.factory.support.BeanNameGenerator를 상속 받은 클래스를 등록합니다.
 *
 */
package annotations.componentScan;