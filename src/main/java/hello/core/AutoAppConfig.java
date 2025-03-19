package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// 컴포넌트 스캔을 사용하면 @Configuration이 붙은 설정 정보도 자동으로 등록되기 떄문에 AppConfig, TestConfig 등 앞서 만들어두었던 설정 정보도 함께 등록되고 실행되어 버린다.
// excludeFilters를 이용해서 설정정보는 컴포넌트 스캔 대상에서 제외함.
public class AutoAppConfig {
}