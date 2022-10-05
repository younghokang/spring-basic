package hello.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Slf4j
public class HelloLombok {
	
	private String name;
	private int age;
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok();
		helloLombok.setName("asdf");
		
		String name = helloLombok.getName();
		log.debug("name = {}", name);
	}

}
