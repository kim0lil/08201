/**
 * @PropertySource는 스프링에서 설정값을 불러 올 경우 사용합니다.
 * 
 * [attributes]
 *      |
 *      +--name : 
 *      |    |
 *      |    \-- String : 리로스의 명칭을 등록
 *      |
 *      +-- values : 리소스 경로를 등록
 *      |    |
 *      |    \-- String[,String] : 리소스의 경로 (file,classpath와 같은 리소스 명칭 사용)
 *      |
 *      +-- encoding : 리소스 파일의 케릭터셋 등록
 *      |    |
 *      |    \-- String : 케릭터셋 명칭(utf-8, enc-kr, iso)
 *      |
 *      +-- factory : 리소스를 처리하는 팩토리 객체를 등록
 *      |    |
 *      |    \-- PropertySourceFactory : 리소스를 처리하는 팩토리 객체 
 *      |
 *      \-- ignoreResourceNotFound : 리소스를 찾을 수 없을 경우 에러처리 유무
 *           |
 *           \-- Boolean : 기본은 false이며 true로 변경시 Info를 출력하며 에러는 발생시키지 않음
 */
package annotations.propertySource;