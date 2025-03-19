package hello.core.member;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// Repository
@Component
@Qualifier("memberRepository")
public class MemoryMemberRepository implements MemberRepository {

    private final static Map<Long, Member> store = new HashMap<>();
    // 동시성 이슈 막기에는 ConcurrentHashMap이 좋음.
//    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
