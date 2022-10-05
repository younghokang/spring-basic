package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NetworkClient // implements InitializingBean, DisposableBean 
{
	
	private String url;
	
	public NetworkClient() {
		log.debug("생성자 호출, url = {}", url);
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	// 서비스 시작시 호출
	public void connect() {
		log.debug("connect: {}", url);
	}
	
	public void call(String message) {
		log.debug("call: {}, message: {}", url, message);
	}
	
	// 서비스 종료시 호출
	public void disconnect() {
		log.debug("close: {}", url);
	}

	/*
	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("NeworkClient.afterPropertiesSet");
		connect();
		call("초기화 연결 메시지");
	}

	@Override
	public void destroy() throws Exception {
		log.debug("NeworkClient.destroy");
		disconnect();
	}
	*/
	
	@PostConstruct
	public void init() {
		log.debug("NeworkClient.init");
		connect();
		call("초기화 연결 메시지");
	}

	@PreDestroy
	public void close() {
		log.debug("NeworkClient.close");
		disconnect();
	}

}
