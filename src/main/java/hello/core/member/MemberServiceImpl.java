package hello.core.member;

public class MemberServiceImpl implements MemberService {
    //TODO: DIP 원칙(구현체 까지 의존) 위배 수정
    private final MemberRepository memberRepository = new MemoryMemberRepositoryImpl();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
