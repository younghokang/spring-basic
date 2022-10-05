package hello.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LogDemoController {
	
	private final LogDemoService logDemoService;
	private final MyLogger myLogger;
	
	@GetMapping("log-demo")
	public ResponseEntity<String> logDemo(HttpServletRequest request) {
		String requestURL = request.getRequestURL().toString();
		
		log.debug("myLogger = {}", myLogger.getClass());
		myLogger.setRequestURL(requestURL);
		
		myLogger.log("controller test");
		logDemoService.logic("testId");
		return ResponseEntity.ok("OK");
	}

}
