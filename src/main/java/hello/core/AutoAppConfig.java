package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    /*
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    */
}





/*
1) 여기서는 @Configuration을 붙여주지 않아도 싱글톤이 적용되는 것 같은데 왜 붙여주는건지 ?

AutoAppConfig에서는 @ComponentScan으로 빈들을 등록하기 때문에 @Configuration를 사용하지 않아도 됩니다.
다만 여기서 @Configuration을 사용한 이유는 스프링에서 설정 파일들은 관례상 @Configuration을 붙이기 때문입니다.
이 애노테이션을 통해서 사용자들은 아~ 이게 설정 파일이구나 하고 이해할 수 있는 것이지요.

2) excludeFilters릁 통해 @Configuration이 붙은 클래스는 스프링 빈 대상이 아닌데 왜 AutoAppConfig은 스프링 빈으로 등록될까 ?

ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

: 이 코드를 보시면 생성자에서 AutoAppConfig를 넘기고 있습니다.
이 설정 파일을 통해서 설정이 시작되는 것이지요.
따라서 이 부분은 이미 설정에 포함된 것이기 때문에 excludeFilters를 해도 적용되지 않습니다.

: ApplicationContext를 생성할 때 primary source로 AutoAppConfig.class를 넘겨줍니다.
내부적으로 primary source는 빈으로 등록되게 됩니다.
따라서 primary source로 넘겨진 AutoAppConfig는 excludeFilter와 무관하게 빈으로 등록되어 동작합니다.

[참고]
@Configuration 애노테이션과 싱글톤 방식은 무관합니다.
그리고 컴포넌트 스캔과 @Configuration 애노테이션도 서로 관계가 없습니다. (@Configuration이 컴포넌트 스캔의 대상이 되는 것만 의미가 있습니다.)

스프링은 컴포넌트 스캔시 기본으로 싱글톤으로 빈을 등록합니다.
그리고 @Configuration 없이 @Bean만 사용해서 스프링 빈을 등록해도 싱글톤으로 등록됩니다.

싱글톤이 안되고, 문제가 되는 부분은, @Bean으로 수동 등록할 때, 내부의 의존관계를 직접 메서드 호출로 주입할 때만 발생하고,
이때 문제를 해결해주는 것이 @Configuration 애노테이션입니다.
이 부분은 @Configuration과 싱글톤, 그리고 @Confiruation과 바이트코드 조작의 마법 부분을 다시 복습해보시길 바랍니다.

감사합니다.
 */