/**
 * 객체지향은 객체의 관계설정이 중요하며 이 관계설정을 스프링에서는 스프링이 관리하는 빈 객체로 등록 하여 줍니다.
 * 이떄 사용하는 에너테이션이 @Autowired 입니다.
 * 또한 Autowired는 기본적으로 빈의 타입을 사용하여 연결하므로 동일한 타입이 있을 경우 에러를 발생합니다. 
 * 
 * [attributes]
 *      |
 *      \-- required : 빈의 의존성 필수 여부를 등록
 *             |
 *             \-- Boolean : 기본은 true이며 빈의 의존성이 없을 경우 에러를 발생
 *             
 *             
 * @see annotations.primary
 * @see annotations.qualifier
 */

package annotations.autowired;