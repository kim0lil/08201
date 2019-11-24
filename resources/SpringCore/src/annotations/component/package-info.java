/**
 * Component 에노테이션은 스프링 설정 중 ComponentScan시에 빈으로 등록 됩니다.
 * 
 * [attributes]
 *      | 
 *      \-- value : 등록 된 빈의 명칭
 * 
 * [extends]
 *      |
 *      +-- controller : 웹 관련 레이어를 처리할 어노테이션
 *      |
 *      +-- repository : 영속성을 지닌 레이어를 처리 할 어노테이션
 *      |
 *      \-- service : 비즈니스 레이어를 처리 할 어노테이션
 *      
 *      
 *      
 * @see annotations.bean
 */
package annotations.component;