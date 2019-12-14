/**
 * 
 * 사용자의 요청이 들어 오게 되면 기본적으로 서블릿 디스패처에서 처리 가능한 컨트롤러를 찾아 해당 요청을 컨트롤러와 연결합니다.
 * 
 * 이 부분을 JAVA EE 레이어링 아키텍처로 분리 하자면 웹 레이어가 하는 역활입니다
 * 
 * 스프링에서 기본 구성 동작의 기본 구성요소는
 * 
 * 사용자 요청 
 * -> HandlerMapping (request를 사용하여 핸들러를 선택)  
 * -> handler execute
 * -> ViewResolving 
 * -> view rendering
 * -> 요청 반납
 */
package web;