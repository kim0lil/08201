/**
 * 관점 지향 프로그래밍은 프로그래밍 방법을 소스의 관점에서 바라보면 프로그밍 할 수 있습니다.
 * 
 * 가령 해당 상황에 필요 없는 로그나 전체적으로 전처리가 필요한 상황일 경우 에스팩트를 사용하여 두 소스를 구분할 수 있습니다.
 * 
 * 먼저 Aspect에노테이션을 활성화 하기 위하여 @EnableAspectJAutoProxy를 사용하여 에너테이션을 활성화 할 수 있습니다.
 * 
 * [Annotation]
 *      |
 *      +-- Configuration
 *      |         |
 *      |         \-- @EnableAspectJAutoProxy : AOP 에너테이션 활성화
 *      |
 *      +-- Advice
 *      |     |
 *      |     +-- @Before : 메서드가 실행 되기 전 처리
 *      |     |       |
 *      |     |       \-- JoinPoint : 조인포인트 정보      
 *      |     |
 *      |     +-- @After : 메서드가 실행 된 다음 처리
 *      |     |       |
 *      |     |       \-- JoinPoint : 조인포인트 정보
 *      |     |
 *      |     +-- @AfterReturning : 메서드 결과값이 반환 된 다음 처리
 *      |     |       |
 *      |     |       \-- JoinPoint : 조인포인트 정보
 *      |     |
 *      |     +-- @AfterThrowing : 메서드가 에러가 발생한 다음 처리
 *      |     |       |
 *      |     |       \-- JoinPoint : 조인포인트 정보
 *      |     |
 *      |     \-- @Around : 메서드의 실행을 메서드에게 위임
 *      |             |
 *      |             \-- PreceedingJoinPoint : 조인포인트 정보
 *      |
 *      +-- Pointcut
 *      |     |
 *      |     \-- @Pointcut : 조인 포인트의 포인트컷을 정의하는 에너테이션
 *      |             |
 *      |             \-- String : Expression을 등록하여 외부에서도 참조 가능
 *      |
 *      +-- Expression
 *      |     |
 *      |     +-- MethodSigniture : 메소드의 반환타입, (타입 + 메소드명), 파라미터 정보로 매칭
 *      |     |        |
 *      |     |        \-- String : [ execution(반환값 타입.메소드명(인자타입)) ]
 *      |     |
 *      |     \-- TypeSigniture : 타입명으로 매칭
 *      |              |
 *      |              \-- String : [ within(타입) ]
 *      |
 *      \-- Introduction
 *            |
 *            \-- @DeclareParents
 *                    |
 *                    +--value
 *                    |    |
 *                    |    \-- String : 끌어들일 객체이 타입
 *                    |
 *                    \-- defaultImpl
 *                         |
 *                         \-- Class : 상속받을 클래스
 */
package aop;

import org.aspectj.lang.annotation.DeclareParents;
