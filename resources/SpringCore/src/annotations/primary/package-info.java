/**
 * 의존성을 자동 주입하는 autowired는 타입에 의한 주입으로 기능은 막강하지만
 * 의존성이하나 이상 발생하였을 경우 모호한 타입으로 인하여 에러를 발생시킵니다.
 * 그런 모호함을 처리 하고자 나온것이 @primary입니다.
 * 
 * <p>primary는 하나 이상의 타입이 있을 경우 기본적으로 적용할 타입에 등록하여 사용합니다.</p>
 * 
 * 
 * 
 * @see     annotations.autowired.AutowiredAnnotation
 */
package annotations.primary;