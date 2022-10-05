package hello.core.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StatefulService {
	/*
	private int price; // 상태를 유지하는 필드
	
	public void order(String name, int price) {
		log.debug("name = {}, price = {}", name, price);
		this.price = price; //여기가 문제! 
	}
	
	public int getPrice() {
		return price;
	}
	*/
	
	public int order(String name, int price) {
		log.debug("name = {}, price = {}", name, price);
		return price; 
	}

}
