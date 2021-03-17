package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor// final이 붙은 멤버변수의 생성자를 만들어줌 , 생성자가 하나일 때는 생성자 주입(@Autowired)이 자동 적용된다.
public class OrderServiceImpl implements OrderService {

    // DIP OCP 원칙 준수
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 단일 책임의 원칙! (Order에서는 할인금액에 대한 책임을 DiscountPolicy에 넘김)
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    //테스트 용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
