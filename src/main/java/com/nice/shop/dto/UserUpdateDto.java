package com.nice.shop.dto;

import javax.persistence.Column;

import com.nice.shop.model.User;

import lombok.Data;

@Data
public class UserUpdateDto {
	
	
	
	@Column(nullable = false, length = 100) 
	private String userName; 

	@Column(nullable = false, length = 100) // 123456==>해쉬 (비밀번호암호화)
	private String userPwd;
	
	@Column(nullable = false, length = 50)
	private String userEmail;
	
	@Column(nullable = false, length = 200)
	private String userAddr;
	
	@Column(nullable = false, length = 50)
	private String userZipcode;
	
	//user 타입의 엔티티를 만들어 user 객체로 간단히 service 단에서 영속성컨텍스트 안에서 더티체킹 후 update 하기 위함 및 세션 저장 용이
	public User toEntity() {
		return User.builder()
				.userName(userName)  //이름을 기재안하면 문제! 벨리데이션 체크
				.userPwd(userPwd) // 마찬가지 벨리데이션 체크
				.userEmail(userEmail)
				.userAddr(userAddr)
				.userZipcode(userZipcode)
				.build();
	}
}
