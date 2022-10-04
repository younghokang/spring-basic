package hello.core.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceTest {
	
	private MemberService memberService;
	private OrderService orderService;
	
	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		this.memberService = appConfig.memberService();
		this.orderService = appConfig.orderService();
	}
	
	@Test
	void orderTest() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		assertThat(order.getMemberId()).isEqualTo(memberId);
		assertThat(order.calculatePrice()).isEqualTo(9000);
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
		log.debug("order: {}", order);
	}

}
