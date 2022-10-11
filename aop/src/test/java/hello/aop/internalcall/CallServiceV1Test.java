package hello.aop.internalcall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import hello.aop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
public class CallServiceV1Test {
	
	@Autowired
	CallServiceV1 callServiceV1;
	
	@Test
	void external() {
		log.info("target={}", callServiceV1.getClass());
		callServiceV1.external();
	}
	
	@Test
	void internal() {
		callServiceV1.internal();
	}

}
