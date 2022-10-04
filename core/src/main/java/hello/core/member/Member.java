package hello.core.member;

import lombok.Data;

@Data
public class Member {

	private Long id;
	private String name;
	private Grade grade;
	
	public Member(Long id, String name, Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
}
