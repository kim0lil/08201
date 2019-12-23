# 스프링 코어

이장에서는 스프링에서 사용하는 기본 코어 모듈과 연관 되는 기본 모듈에 관하여 다루어 보도록 하겠습니다.

## 스프링 부팅 방법

스프링은 기본적으로 xml 파일(dispatcher-servlet.xml)을 사용하여 부팅하는 방법과 sevlet 3.0 이상에서 자바를 사용하여 부팅하는 두가지 방법이 있습니다.  
( AbstractAnnotationConfigDispatcherServletInitializer 을 상속)

좀 더 자세한 설명은 아래와 같이 설정 할 수 있습니다.

1. web.xml 파일에 root.xml 파일과 dispatcher-servler.xml 파일을 등록하여 부팅하는 방법 [예제 : SpringCore-Boot-1]
2. web.xml 파일에 root.xml 파일을 등록하고 자바 설정 파일로 dispatcher의 설정 파라미터로 등록 하는 방법 [예제 : SpringCore-Boot-2]
3. web.xml 파일을 사용하지 않고 스프링 초기화 클래스인 AbstractAnnotationConfigDispatcherServletInitializer를 사용하여 부팅하는 방법 [예제 : SpringCore-Boot-3]

위와 같이 스프링을 설정 하는 방법을 알아 보았습니다.

이번에는 스프링에서 사용하는 에너테이션에 관하여 다루어 보도록 하겠습니다.

## 스프링 코어의 기본 에너테이션

스프링에서 사용하는 기본 에너테이션에 관하여 하나씩 다루어 보도록 하겠습니다.

( 각 에너테이션의 관한 설명은 package-info.java 파일에서 확인할 수 있으며 boot 클래스를 사용하여 테스트 할 수 있습니다. )

### autowired

[설명](./src/annotations/autowired/package-info.java)

### bean

[설명](./src/annotations/bean/package-info.java)

### component

[설명](./src/annotations/component/package-info.java)

### componentScan

[설명](./src/annotations/componentScan/package-info.java)

### configuration

[설명](./src/annotations/configuration/package-info.java)

### dependsOn

[설명](./src/annotations/dependsOn/package-info.java)

### Import

[설명](./src/annotations/Import/package-info.java)

### lazy

[설명](./src/annotations/lazy/package-info.java)

### postConstruct

[설명](./src/annotations/postConstruct/package-info.java)

### preDestroy

[설명](./src/annotations/preDestroy/package-info.java)

### primary

[설명](./src/annotations/primary/package-info.java)

### profile

[설명](./src/annotations/profile/package-info.java)

### propertySource

[설명](./src/annotations/propertySource/package-info.java)

### qualifier

[설명](./src/annotations/qualifier/package-info.java)

### resource

[설명](./src/annotations/resource/package-info.java)

### scope

[설명](./src/annotations/scope/package-info.java)

### value

[설명](./src/annotations/value/package-info.java)

## ApplicationContext

ApplicationContext는 등록 된 빈(bean)을 관리 하는 역활을 하며 정교하게 AOP를 적용할 수 있도록 돕고 있습니다.

|구현체|기본위치|타입|
|:--|:--|:--|
|ClassPathXmlApplicationContext|classpath|XML|
|FileSystemXmlApplicationContext|file|XML|
|AnnotationConfigApplicationContext|classpath|JAVA|
|XmlWebApplicationContext|web application root path|XML|
|AnnotationConfigWebApplicationContext|web application classpath|JAVA|

## Enable Annotations

스프링의 설정에서 사용 되는 활성화 기능에 관하여 하나씩 풀어 보도록 하겠습니다.

좀더 자세한 기능을 각 기능에 관하여 다루어 볼 예정입니다.

### EnableAspectJAutoProxy

@Aspect을 처리 하는 기능을 활성화

### EnableAsync

@Asynchronous을 처리하는 기능을 활성화

### EnableCaching

@Cacheable을 처리하는 기능을 활성화

### EnableLoadTimeWeaving

로드타임 위빙 기능을 활성화

### EnableScheduling

@Scheduled을 처리하는 기능을 활성화

### EnableSpringConfigured

@Configurable을 처리하는 기능을 활성화

### EnableTransactionManagement

@Transact1onal이나 @TransactionAttribute을 처리하는 기능을 활성화

### EnableWebMvc

스프링 웹 MVC와 관련 된 기능을 활성화

## DispatcherServlet이 사용하는 기본 컴포넌트

### MultipartResolver

멀티파트 파일 업로드를 관리 처리하는 컴포넌트

(기본값은 존재 하지 않음)

### LocaleResolver

로케일을 결정하고 처리하는 컴포넌트

(AcceptHeaderLocaleResolver)

### ThemeResolver

테마를 결정하고 변경하는 컴포넌트

(FixedThemeResolver)

### HandlerMapping

사용자의 요청을 핸들러와 매핑하는 컴포넌트

(BeanNameUrlHandlerMapping, RequestMappingHandlerMapping)

### HandlerAdaptor

핸들러 객체가 요청을 처리할수 있도록 돕는 컴포넌트

(HttpRequestHandlerAdapter, SimpleControllerHandlerAdapter, AnnotationMethodHandlerAdapter)

### HandlerExceptionResolver

핸들러를 실행하는 동안 오류가 발생할 경우 처리하는 컴포넌트

(AnnotationMethodHandlerExceptionResolver, ResponseStatusExceptionResolver , DefaultHandlerExceptionResolver)

### RequestToViewNameTranslator

핸들러가 아무것도 반환하지 않을 경우 뷰 이름을 결정하는 컴포넌트

(DefaultRequestToViewNameTranslator)

### ViewResolver

뷰 명칭으로 뷰 구현체를 찾는 컴포넌트

(lnternalResourceViewResolver)

### FlashMapManager

컴포넌트간에 공유를 위하여 세션단위로 저장소를 관리하는 컴포넌트

(SessionFlashMapManager)

