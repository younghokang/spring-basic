package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		log.debug("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		log.debug("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}

	@Bean
	public OrderService orderService() {
		log.debug("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		log.debug("call AppConfig.discountPolicy");
		return new FixDiscountPolicy();
	}

}
