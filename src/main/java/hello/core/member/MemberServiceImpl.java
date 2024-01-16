package hello.core.member;

public class MemberServiceImpl implements MemberService{

<<<<<<< HEAD
    private final MemberRepository memberRepository = new MemoryMemberRepository();
=======
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
>>>>>>> 7c7239e (240116_spring)

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
