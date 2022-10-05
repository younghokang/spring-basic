package hello.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrototypeTest {
	
	@Test
	void prototypeBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
		log.debug("find prototypeBean1");
		PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
		log.debug("find prototypeBean2");
		PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
		log.debug("prototypeBean1 = {}, prototypeBean2 = {}", prototypeBean1, prototypeBean2);
		assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
		
		prototypeBean1.destroy();
		prototypeBean2.destroy();
		ac.close();
	}
	
	@Scope("prototype")
	static class PrototypeBean {
		@PostConstruct
		public void init() {
			log.debug("PrototypeBean.init");
		}
		
		@PreDestroy
		public void destroy() {
			log.debug("PrototypeBean.destroy");
		}	
	}

}
