package hello.core.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import hello.core.member.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutowiredTest {
	
	@Test
	void autowiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
	}
	
	static class TestBean {
		
		@Autowired(required = false)
		public void setNoBean1(Member member) {
			log.debug("member = {}", member);
		}
		
		@Autowired
		public void setNoBean2(@Nullable Member member) {
			log.debug("member = {}", member);
		}
		
		@Autowired
		public void setNoBean3(Optional<Member> member) {
			log.debug("member = {}", member);
		}
		
	}

}
