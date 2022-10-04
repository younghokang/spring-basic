package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationContextSameBeanFindTest {
	
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SameBeanConfig.class);
	
	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
	void findBeanByTypeDuplicate() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> ctx.getBean(MemberRepository.class));
	}
	
	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
	void findBeanByName() {
		MemberRepository memberRepository1 = ctx.getBean("memberRepository1", MemberRepository.class);
		assertThat(memberRepository1).isInstanceOf(MemberRepository.class);
	}
	
	@Test
	@DisplayName("특정 타입을 모두 조회하기")
	void findAllBeanByType() {
		Map<String, MemberRepository> beansOfType = ctx.getBeansOfType(MemberRepository.class);
		for (String key : beansOfType.keySet()) {
			log.debug("key = {}, value = {}", key, beansOfType.get(key));
		}
		
		log.debug("beansOfType: {}", beansOfType);
		assertThat(beansOfType.size()).isEqualTo(2);
	}
	
	@Configuration
	static class SameBeanConfig {
		
		@Bean
		public MemberRepository memberRepository1() {
			return new MemoryMemberRepository();
		}
		
		@Bean
		public MemberRepository memberRepository2() {
			return new MemoryMemberRepository();
		}
		
	}

}
