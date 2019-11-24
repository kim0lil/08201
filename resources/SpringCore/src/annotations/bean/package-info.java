/**
 * bean 에노테이션은 스프링 설정 시에 반환 되는 객체를 빈으로 등록 될수 있도록 합니다.
 * 
 * [attributes]
 *      |
 *      +-- value : name과 동일
 *      |     |
 *      |     \-- String[,String] : 빈의 명칭을 등록 
 *      |
 *      +-- name : 등록 된 빈의 명칭
 *      |     |
 *      |     \-- String[,String] : 빈의 명칭을 등록 
 *      |
 *      +-- initMethod : 빈이 생성 후 초기화할 메소드명을 등록 합니다.
 *      |     |
 *      |     \-- String : 메소드 명을 등록
 *      |
 *      +-- destroyMethod : 빈이 삭제 되기 전 실행할 메소드명을 등록 합니다.
 *      |     |
 *      |     \-- String : 메소드 명을 등록
 *      |
 *      \-- autowireCandidate : 이 외의 빈에서 이 빈을 autowire로 의존성을 불러 올수 있는지 여부
 *            |
 *            \-- Boolean : 기본은 true로 되어 있으며 false로 변경 시 의존성을 자동 주입하지 않습니다.
 *
 *
 *
 * @see annotations.component
 */

package annotations.bean;