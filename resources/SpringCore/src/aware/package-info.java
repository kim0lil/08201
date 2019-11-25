/**
 * aware interface를 구현하면
 * 스프링에서 사용하는 리소스(beanFactory, ApplicationContext, MessageSource, Environment)들을
 * 런타임 시에 주입해 주고 있습니다.
 * 
 * 따라서 원하는 aware를 추가 하여 사용할 수 있습니다.
 * 
 * [Aware Interface]
 *        |
 *        +-- ApplicationContextAware : 런타임 시에 ApplicationContext를 주입
 *        |
 *        +-- BeanFactoryAware : 런타임 시에 BeanFactory를 주입
 *        |
 *        +-- BeanNameAware : 런타임 시에 BeanName을 주입
 *        |
 *        +-- MessageSourceAware : 런타임 시에 MessageSource를 주입
 *        |
 *        +-- ResourceLoaderAware : 런타임 시에 ResourceLoader를 주입
 *        |
 *        +-- ApplicationEventPublisherAware
 *        |
 *        +-- BeanClassLoaderAware
 *        |
 *        +-- BootstrapContextAware
 *        |
 *        +-- LoadTimeWeaverAware
 *        |
 *        +-- NotificationPublisherAware
 *        |
 *        +-- PortletConfigAware
 *        |
 *        +-- PortletContextAware
 *        |
 *        +-- ServletConfigAware
 *        |
 *        +-- ServletContextAware
 */
package aware;