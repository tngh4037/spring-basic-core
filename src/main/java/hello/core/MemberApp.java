package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        // MemberService memberService = new MemberServiceImpl();

        /*
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        */

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}



// ApplicationContext : 스프링 컨테이너라고 보면된다. (객체들을 관리)
// AppConfig에 있는 환경설정 정보를 가지고, 스프링이 그 내부에 있는 @Bean으로 적용된 것들을 스프링 빈으로 등록한다.
// 첫 번쨰 매개변수인 name(이름)이 @Bean의 메소드명과 일치해야 함., 두번째 매개변수는 Type을 뜻함.
