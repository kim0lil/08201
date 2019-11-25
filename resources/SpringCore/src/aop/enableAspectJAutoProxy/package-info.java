/**
 * Aspect의 에너테이션을 활성화 하기 위하여서는 설정 파일에 @EnableAspectJAutoProxy를 등록 하여야 합니다.
 * 
 * [attributes]
 *      |
 *      \-- proxyTargetClass : 에스팩트는 기본적을로 자바의 동적 프록시를 사용하지만 이 값을 true로 할 경우 CGLIB로 프록싱 처리 합니다.
 *      
 *      
 *      CGLIB : 바이트 코드로 클래스를 직접 생성하며 인터페이스를 구현할 필요가 없습니다.
 *      
 */
package aop.enableAspectJAutoProxy;