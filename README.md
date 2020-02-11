# 스프링 프레임워크 5

스프링 5을 기반으로 스프링에서 제공하는 기본 기능을 익히고 구현해 보도록 하겠습니다.

## 스프링 빈 컴포넌트

스프링에서는 객체의 생명 주기 및 의존성 등을 관리하기 위하여 빈이라는 컴포넌트를 사용합니다.

이 스프링빈은 일반적인 클래스에 등록하여 사용할 수 있으며 이 클래스를 POJO(Plain Old Java Object)라고 합니다.

스프링의 빈 컴포넌트를 등록하는 방법은 간단합니다.

Component라는 에너테이션을 붙여 주기만 하면 됩니다.

먼저 계산기능을 하는 클래스를 만들어 보도록 하겠습니다.

[소스보기](./resources/SpringBeanComponents/src/org/springCore/components/step1/Calculation.java)

소스를 보게 되면 이 클래스는 add, subtract, divide, multiply 기능을 가지고 있습니다.

이번에는 이 계산기능을 사용하여 간단하게 계산기를 구현해 볼 수 있습니다.

[소스보기](./resources/SpringBeanComponents/src/org/springCore/components/step1/Calculator.java)

이 클래스를 보면 Calculation 클래스를 사용한다는 것을 볼수 있으며

따라서 의존성관계를 보면 Calculator -> Calculation (```Calculator가 Calculation를 의존한다``` 라고 합니다.) 관계가 된다는 것을 알 수 있습니다.

아직까지는 이 의존성을 스프링을 배우면서 까지 해결해야 되나 싶을 것입니다.

이제부터 알아 보도록 하겠습니다.

### 스프링 빈 컴포넌트 - 추가 된 클래스 (히스토리 작성 클래스)

이번에는 계산기능에 로그 기능을 추가해 보도록 하겠습니다.

기존의 Calculation은 그대로 놔두고 HistoryCalculation을 새로 생성해 보도록 하겠습니다.

[소스보기](./resources/SpringBeanComponents/src/org/springCore/components/step2/HistoryCalculation.java)

log 함수와 중간 로그를 찍는 기능이 추가 되었습니다.

이제 계산기 클래스를 살펴 보도록 하겠습니다.

[소스보기](./resources/SpringBeanComponents/src/org/springCore/components/step2/Calculator.java)

기존의 Calculation클래스를 의존하던 것이 HistoryCalculation을 의존하도록 변경 된 것을 알 수 있습니다.

하지만 만일 아래와 같은 운영 계획이라면 어떻게 해야 될지 생각해 보세요

- - -

1. 개발 도중에는 로그를 남기는 HistoryCalculation를 사용하여 개발
2. 개발이 완료 될 경우 운영시에는 기존의 Calculation를 사용하여 배포

- - -

이와 같은 경우는 인터페이스를 사용하여 구조와 기능을 분리 함으로써 객체에 관한 의존성을 느슨하게 할 수 있습니다.  
(<strong>타입</strong>에 관한 의존성을 느슨하게 한다는 것이지 객체간 의존성을 말하는 것은 아닙니다. 객체간 의존성은 다음장에 나옵니다.)

[소스보기 : 계산기능 구조 인터페이스](./resources/SpringBeanComponents/src/org/springCore/components/step3/Calculation.java)  
[소스보기 : 계산기능 기본 기능](./resources/SpringBeanComponents/src/org/springCore/components/step3/SimpleCalculation.java)  
[소스보기 : 계산기능 기본기능 + 로그 기능](./resources/SpringBeanComponents/src/org/springCore/components/step3/HistoryCalculation.java)  
[소스보기 : 계산기](./resources/SpringBeanComponents/src/org/springCore/components/step3/Calculator.java)

계산기 클래스에서는 두 클래스를 모두 수용할 수 있도록 인터페이스를 사용하여 확장성을 쥐어 주었습니다.

따라서 의존성은 아래와 같이 변경 되었습니다.

- - -

Calculator -> Calculation <- SimpleCalculation

Calculator -> Calculation <- HistoryCalculation

- - -

따라서 `Calculator`는 `Calculation`의 구현체와는 분리되어 개발할 수 있게 되었습니다.

이번에는 객체간 의존성에 말해 보도록 하겠습니다.

### 스프링 빈 컴포넌트 - 생성 관심의 분리

객체와 객체간에는 의존성이 존재 합니다.

Calculator에서 우리가 new SimpleCalculation()을 한 것과 같이 `Calculator`객체와 `SimpleCalculation`객체간에는 의존성이 존재 합니다.

이전장에서는 Calculator와 Calculation의 타입 의존성을 줄이기 위하여 인터페이스를 사용하였습니다.

하지만 아직까지 Calculator는 SimpleCalculation 또는 HistoryCalculation를 선택 해야 하는 의존성(객체 선택에 관한 의존성)이 존재 합니다.

이 의존성은 팩토리 클래스를 사용하여 분리 할 수 있습니다.

팩토리 클래스는 객체간 의존성 관계를 대신 설정해 주는 관계설정 클래스 입니다.

먼저 Calculator의 Calculation 의존성을 외부로 맡기는 것부터 시작합니다.

[소스보기 : 계산기](./resources/SpringBeanComponents/src/org/springCore/components/step4/Calculator.java)

이번에는 의존성을 관리할 팩토릴 객체를 만들어 보겠습니다.

팩토리 객체라고 해도 크게 어렵지는 않습니다.

일반적으로 의존성을 연결해 주는 기능만 있으면 되니까요.

[소스보기 : 애플리케이션 팩토리](./resources/SpringBeanComponents/src/org/springCore/components/step4/ApplicationFactory.java)

이제 Calculator와 SimpleCalculation는 전혀 상관없는 관계가 되었습니다.

Calculator가 SimpleCalculation 타입을 의존하지 않으며  
(심할 경우 SimpleCalculation 삭제 되어도 우리의 Calculator는 문제 없습니다.)

Calculator가 SimpleCalculation 객체를 의존하지도 않습니다.  
(문제점이 되었던 SimpleCalculation를 HistoryCalculation로 변경하여도 Calculator는 아무런 문제가 없습니다.)

### 스프링 빈 컴포넌트 - 스프링의 등장

이번에는 지겨웠던 의존성을 끝내고 스프링의 기본 기능을 들어가 보도록 하겠습니다.

우리의 문제점이 되었던 이 의존성 관계를 스프링에서는 스프링 빈이라는 컴포넌트를 사용하여 관리하고 있습니다.

- - -

(5.0 기준으로 @annotation을 기반으로하여 설명 하도록 하겠습니다.)

- - -

각 컴포넌트(클래스)를 컨텍스트에 등록하여 `beanDefinition`을 생성한 다음

각 컴포넌트 끼리의 의존성을 `타입 또는 명칭` 을 사용하여 연결하여 줍니다.

이 기능은 스프링의 기본 기능이며 스프링 DI(Dependency Injection)의 핵심 기능이기도 합니다.

먼저 스프링빈의 의존성 설정을 등록해 보도록 하겠습니다.

의존성 설정은 기존 팩토리 클래스를 사용합니다.

[소스보기 : 애플리케이션 설정 파일](./resources/SpringBeanComponents/src/org/springCore/components/step5/ApplicationFactory.java)

`@Bean`을 붙여 스프링이 관리하는 빈이라는 객체를 생성합니다.

[소스보기 : 계산기](./resources/SpringBeanComponents/src/org/springCore/components/step5/Calculator.java)

실행 구문에서 컨텍스트에 등록 되어 의존성이 등록 된 빈을 불러와 사용하는 것을 알 수 있습니다.

이제 여러분은 스프링의 기본 의존성 설정 방법을 배웠습니다.

다음은 좀 더 새분화 된 의존성 설정 방법에 대하여 다루어 보도록 하겠습니다.

- - -

스프링의 빈은 기본적으로 메소드명 또는 등록한 빈의 `name` 설정값에 따라 명칭으로 불러 올 수 있습니다.


[소스보기 : 계산기](./resources/SpringBeanComponents/src/org/springCore/components/step6/Calculator.java)

> 2번의 빈을 불러 오는 항목이 변경 되었습니다.


@Bean 에너테이션의 자세한 설명 및 예제는 `resources/SpringCore/src/annotations/bean` 을 참조 하세요

[요약 : @Bean](./resources/SpringCore/src/annotations/bean/package-info.java)

- - -

### 컴포넌트 자동 검색

이번에 해 볼 것은 컴포넌트의 자동 검색 기능입니다.

기존의 ApplicationFactory에서는 의존성을 직접적으로 등록하여 주는 것이었습니다.  
(new SimpleCalculation()와 같이 주입해 주는 것을 직접 등록이라고 합니다.)

하지만 이번에는 의존성을 직접 주입해 주지 않고 타입 또는 명칭에 따라서 자동 등록 되도록 처리해 보도록 하겠습니다.

따라서 구조는 아래와 같이 변경 됩니다.

기존 구조

1. SimpleCalculation를 생성 `(직접 생성)`
2. Calculator를 생성 `(직접 생성)`
3. Calculator의 생성자를 사용하여 생성 된 SimpleCalculation 를 등록 `(직접 등록)`
4. 스프링 컨텍스트의 Calculator 등록 `(직접 생성)`
5. 필요시 스프링 컨텍스트에서 Calculator를 불러와 사용

변경 된 구조

1. SimpleCalculation를 생성 `(자동 검색)`
2. Calculator를 생성 `(자동 검색)`
3. Calculator의 생성자를 사용하여 생성 된 SimpleCalculation 를 등록 `(자동 검색)`
4. 스프링 컨텍스트의 Calculator 등록 `(자동 검색)`
5. 필요시 스프링 컨텍스트에서 Calculator를 불러와 사용

먼저 기존 설정 클래스를 수정하도록 하겠습니다.

[소스보기 : 애플리케이션 설정 파일](./resources/SpringBeanComponents/src/org/springCore/components/step7/ApplicationFactory.java)  
(경로는 패키지 경로를 기반으로 등록합니다.)

- - -

`ComponentScan` 에노테이션은 빈 검색 시 필요한 클래스를 추가 하거나 제외 할 수 있는 필터 기능이 존재 합니다.

좀 더 자세한 설명 및 예제는 `resources/SpringCore/src/annotations/componentScan` 을 참조 하세요  

[요약 : @ComponentScan](./resources/SpringCore/src/annotations/componentScan/package-info.java)  

- - -

다음으로 컴포넌트를 등록해 보도록 하겠습니다.

[소스보기 : 계산기능 기본 기능](./resources/SpringBeanComponents/src/org/springCore/components/step7/SimpleCalculation.java)  
[소스보기 : 계산기능 기본기능 + 로그 기능](./resources/SpringBeanComponents/src/org/springCore/components/step7/HistoryCalculation.java)

이번에는 컴포넌트를 주입하는 구문을 살펴 보겠습니다.

[소스보기 : 계산기](./resources/SpringBeanComponents/src/org/springCore/components/step7/Calculator.java)

계산기를 살펴 보면 `@Resource` 구문이 눈에 들어 올 것입니다.

@Resourced 에너테이션은 등록한 컴포넌트를 명칭으로 검색하겠다는 의미이며 등록 된 빈 명칭으로 매칭 되어 등록 됩니다.

- - -

의존성 설정 구문

|구문|의존성관계|설명|
|:--|:--:|:--|
|@Autowired|type|타입에 기반으로 의존성을 등록 하며 두가지 이상의 타입이 있을 경우 @qualifier를 추가로 사용|
|@Resource|name|빈 명칭 기반으로 의존성을 등록합니다.|
|@Inject|@annotation|고유한 annotation을 기반으로 의존성을 등록합니다.

더 자세한 설명 및 예제는 `resources/SpringCore/src/annotations` 을 참조 하세요  
(&issue Inject는 작성하지 않음)

[요약 : @Resource](./resources/SpringCore/src/annotations/resource/package-info.java)  
[요약 : @Autowired](./resources/SpringCore/src/annotations/autowired/package-info.java)  
[요약 : @Qualifier](./resources/SpringCore/src/annotations/qualifier/package-info.java)  
[요약 : @Primary](./resources/SpringCore/src/annotations/primary/package-info.java)  

- - -

### 부가적인 에너테이션

그 외의 부가 에너테이션은 설명과 함께 예제파일을 제공합니다.

#### Import

개발 도중에 운영시 또는 개발시와 같이 설정을 분리 하는 일은 흔합니다.

스프링에서 설정을 분리 하는 일은 `@import` 에너테이션을 붙여 가능합니다.

- - -

더 자세한 설명 및 예제는 `resources/SpringCore/src/annotations/import` 을 참조 하세요

[요약 : @Import](./resources/SpringCore/src/annotations/import/package-info.java)

- - -

#### Scope

빈을 생성할 때에 해당 빈을 최초 한번 생성할지 아니면 매번 생성할지와 같이 빈의 생성 범위를 선택하여야 합니다.

이러한 생성 범위를 스프링에서는 `@Scope`를 등록 함으로써 관리합니다.

기본(default)는 `Singleton(단일)`입니다.

- - -

더 자세한 설명 및 예제는 `resources/SpringCore/src/annotations/scope` 을 참조 하세요

[요약 : @Import](./resources/SpringCore/src/annotations/scope/package-info.java)

- - -

## 외부 리소스 사용하기

이번에는 외부의 리소스를 불러오고 사용하는 방법에 관하여 다루어 보도록 하겠습니다.

스프링에서는 Resource라는 단일 인터페이스를 제공함으로써 간략화된 리소스 인터페이스를 사용합니다.

가령 설정값을 불러 오는 일부터 해보겠습니다.

### 설정파일(.priperties) 불러오기

스프링에서 설정파일을 불러 오는 일은 간단합니다.

`@PropertySource` 에너테이션을 등록하여 간단히 설정값을 불러올 수 있습니다.

- - -

더 자세한 설명 및 예제는 `resources/SpringCore/src/annotations/propertySource` 을 참조 하세요

[요약 : @Import](./resources/SpringCore/src/annotations/propertySource/package-info.java)

- - -

















































## 스프링 소셜

스프링 소셜은 소셜 네트워크의 인가 및 접속 흐름을 관리하는 커넥션 프레임워크(connection framework)와 서비스 공급자, 소비기(application), 사용자 간의 oAuth를 주고 받는 접속 관리(Connection Controller), 사용자가 자신의 소셜 네트워크 계정에 로그인할 수 있도록 스프링 소셜을 스프링 시큐리티와 연동하는 소셜 인증 필터(SocialAuthenticationFilter) 세부분으로 구분 됩니다.

**스프링 소셜**
1. Connection Framework
2. Connection Controller
3. SocialAuthenticationFielter






## JMX Mbean

스프링은 IoC 컨테이너의 모든 빈을 MBean으로 익스포트하는 식으로 JMX를 지원합니다.

따라서 스프링에서는 MBeanExporter 인스턴스를 선언하기만 하면 됩니다.

