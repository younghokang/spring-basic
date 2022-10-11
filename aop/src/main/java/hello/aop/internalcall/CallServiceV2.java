package hello.aop.internalcall;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * ObjectProvider(Provider), ApplicationContext를 사용해서 지연(Lazy) 조회
 * */
@Slf4j
@Component
public class CallServiceV2 {
	
	//private final ApplicationContext applicationContext;
	private final ObjectProvider<CallServiceV2> callServiceProvider;
	
	public CallServiceV2(ObjectProvider<CallServiceV2> callServiceProvider) {
		super();
		this.callServiceProvider = callServiceProvider;
	}

	public void external() {
		log.info("call external");
		//CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
		CallServiceV2 callServiceV2 = callServiceProvider.getObject();
		callServiceV2.internal(); // 외부 메서드 호출
	}
	
	public void internal() {
		log.info("call internal");
	}

}
