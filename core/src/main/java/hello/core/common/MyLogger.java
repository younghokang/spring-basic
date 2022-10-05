package hello.core.common;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Slf4j
public class MyLogger {
	private String uuid;
	private String requestURL;
	
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}
	
	public void log(String message) {
		log.debug("[{}] [{}] [{}] ", uuid, requestURL, message);
	}
	
	@PostConstruct
	public void init() {
		uuid = UUID.randomUUID().toString();
		log.debug("[{}] request scope bean create: {} ", uuid, this);
	}
	
	@PreDestroy
	public void close() {
		log.debug("[{}] request scope bean close: {} ", uuid, this);
	}

}
