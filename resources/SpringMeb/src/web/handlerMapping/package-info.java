/**
 * handler는 사용자의 요청을 컨트롤러와 매핑해 주는 역활을 하고 있습니다.
 * 
 * [Type]
 *    |
 *    \-- HandlerMapping [i]
 *              |
 *              +-- BeanNameUrlHandlerMapping : 빈 명칭을 사용하여 핸들러를 매핑합니다.
 *              |
 *              +-- RequestMappingHandlerMapping : requestMapping 에너테이션을 사용하여 핸들러를 매핑합니다.
 *              |
 *              \-- SimpleUrlHandlerMapping : 컨트롤러 명과 url을 직접 매핑합니다.
 *              
 *              
 */
package web.handlerMapping;