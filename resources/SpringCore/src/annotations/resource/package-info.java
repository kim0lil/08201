/**
 * 통상적으로 의존성을 연결할 떄 타입에 의한 의존으로써 @Autowired를 사용하지만
 * 상세한 빈의 주입의 경우 빈명칭을 사용한 @Qualifier를 추가하여 두 에너테이션을 등록하여야 합니다.
 * 
 * 하지만 그렇데 되면 에너테이션이 많아 지게 되어 가독성이 떨어지게 될것입니다.
 * 
 * <p>
 * @Resource 를 사용하여 두 에너테이션을 사용한 것과 같은 효과를 지니게 할 수 있습니다.
 * 또한 Resource 역시 기본은 타입으로 조회를 하므로 Autowired와 같은 기능을 지니고 있습니다. 
 * </p>
 * 
 * [attributes]
 *      |
 *      +-- name : 빈명칭을 사용하여 빈을 주입
 *      |    |
 *      |    \-- String : 빈 명칭
 *      |
 *      \-- ... : 그 외 속성들이 존재 하지만 자바 확장(javax)문법이므로 스프링 관련 에너테이션에서는 다루지 않음
 * 
 * 
 * 
 * @see annotations.autowired
 * @see annotations.qualifier
 * @see annotations.inject
 */
package annotations.resource;