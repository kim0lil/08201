/**
 * 빈의 생성 범위를 지정할 떄 @Scope를 사용할 수 있습니다.
 * 
 * [attributes]
 *      |
 *      +-- ScopeName : 빈의 생성 범위를 지정
 *      |      |
 *      |      \-- String : 빈의 생성 범위(ConfigurableBeanFactory.[SCOPE_PROTOTYPE, SCOPE_SINGLETON]
 *      |      
 *      +-- proxyMode : AOP를 사용할 경우 프록시를 관련 여부를 등록(AOP에서 다룰 예정)
 */
package annotations.scope;