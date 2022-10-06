package hello.advanced.trace.threadlocal;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalServiceTest {
	
	private ThreadLocalService servic = new ThreadLocalService();
	
	@Test
	void field() {
		log.info("main start");
		Runnable userA = () -> {
			servic.logic("userA");
		};
		Runnable userB = () -> {
			servic.logic("userB");
		};
		
		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");
		Thread threadB = new Thread(userB);
		threadB.setName("thread-B");
		
		threadA.start();
		//sleep(2000); // 동시성 문제 발생X
		sleep(100); // 동시성 문제 발생O
		threadB.start();
		
		sleep(3000); // 메인 스레드 종료 대기
		log.info("main exit");
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
