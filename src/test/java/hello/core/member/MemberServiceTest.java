package hello.core.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {
    //TODO: DIP 원칙(구현체 까지 의존) 위배 수정
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join () {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        // then
        assertThat(member).isEqualTo(findMember);
    }
}
