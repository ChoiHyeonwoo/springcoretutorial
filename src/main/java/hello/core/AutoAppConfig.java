package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        /*basePackages = "hello.core",*/ // 기본값 @ComponentScan가 붙은 class의 패키지
        /*basePackageClasses = AutoAppConfig.class,*/
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// 기존 AppConfig.java, TestConfig.java 등 예외처리.
public class AutoAppConfig {
}
