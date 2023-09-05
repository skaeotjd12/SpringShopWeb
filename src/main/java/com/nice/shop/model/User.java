package com.nice.shop.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // 자동으로 User 클래스가 MySql에 테이블이 생성이 된다.
public class User {

	@Id // Primary key
	@Column(nullable = false, length = 100, unique = true)
	private String userId;

	@Column(nullable = false, length = 100) 
	private String userName; 

	@Column(nullable = false, length = 100) // 123456==>해쉬 (비밀번호암호화)
	private String userPwd;

	@Column(nullable = false, length = 50)
	private String userEmail;
	
	@Enumerated(EnumType.STRING)
	private RoleType role; 

	@Column(nullable = false, length = 200)
	private String userAddr;
	
	@Column(nullable = false, length = 50)
	private String userZipcode;
	
	@Column(nullable = false, length = 50)
	private String userBirth;
	
	
	@CreationTimestamp // 현재 시간이 자동 입력
	private Timestamp createDate;
	
	
}
