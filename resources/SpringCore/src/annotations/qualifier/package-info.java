/**
 * 의존성을 자동 주입하는 autowired는 타입에 의한 주입으로 기능은 막강하지만
 * 의존성이하나 이상 발생하였을 경우 모호한 타입으로 인하여 에러를 발생시킵니다.
 * 그런 모호함을 처리 하고자 나온것이 @Qualifier입니다.
 * 
 * <p>Qualifier는 주입할 빈의 상세한 빈 명칭을 사용하여 등록 할 수 있습니다.</p>
 * 
 * 
 * 
 * @see annotations.autowired
 */
package annotations.qualifier;