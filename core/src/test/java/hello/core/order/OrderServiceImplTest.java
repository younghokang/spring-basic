package hello.core.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImplTest {
	
	@Test
	void createOrder() {
		MemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.save(new Member(1L, "name", Grade.VIP));
		
		DiscountPolicy discountPolicy = new FixDiscountPolicy();
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl(memberRepository, discountPolicy);
		Order order = orderServiceImpl.createOrder(1L, "name", 10000);
		assertThat(order.calculatePrice()).isEqualTo(9000);
	}

}
