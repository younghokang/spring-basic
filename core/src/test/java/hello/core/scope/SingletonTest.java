package hello.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonTest {
	
	@Test
	void singletonBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
		
		SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
		SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
		log.debug("singletonBean1 = {}, singletonBean2 = {}", singletonBean1, singletonBean2);
		assertThat(singletonBean1).isSameAs(singletonBean2);
		
		ac.close();
	}
	
	@Scope("singleton")
	static class SingletonBean {
		@PostConstruct
		public void init() {
			log.debug("SingletonBean.init");
		}
		
		@PreDestroy
		public void destroy() {
			log.debug("SingletonBean.destroy");
		}
	}
	
}
