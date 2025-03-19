package hello.core.member;

// Repository
public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
