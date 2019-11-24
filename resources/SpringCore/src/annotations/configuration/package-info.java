/**
 * configuration 에너테이션은 componentScan시에 검색 되며 스프링 설정에 참여 합니다.
 * 
 * [attributes]
 *      |
 *      +-- value : name과 등일
 *      |     |
 *      |     \-- String[,String] : 빈의 명칭을 등록 
 *      |
 *      \-- name : 빈의 명칭
 *            |
 *            \-- String[,String] : 빈의 명칭을 등록 
 *
 */
package annotations.configuration;