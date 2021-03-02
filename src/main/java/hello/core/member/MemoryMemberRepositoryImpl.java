package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepositoryImpl implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();   // 동시성 때문에 concurrent HashMap을 사용해야함.
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
