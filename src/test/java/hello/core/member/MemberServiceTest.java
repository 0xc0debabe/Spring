package hello.core.member;

<<<<<<< HEAD
import org.assertj.core.api.Assertions;
=======
import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
>>>>>>> 7c7239e (240116_spring)
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

<<<<<<< HEAD
    MemberService memberService = new MemberServiceImpl();
=======
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
>>>>>>> 7c7239e (240116_spring)

    @Test
    void join() {
        // given
        Member member = new Member(1l, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
