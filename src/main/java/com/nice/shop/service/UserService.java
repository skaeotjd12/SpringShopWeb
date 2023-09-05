package com.nice.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nice.shop.dto.ResponseDto;
import com.nice.shop.dto.UserUpdateDto;
import com.nice.shop.model.RoleType;
import com.nice.shop.model.User;
import com.nice.shop.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public int 회원가입(User user) {
		try{
			userRepository.findByUserId(user.getUserId()).get();
			return -1;
		}
		catch (Exception e) {
			String rawPassword = user.getUserPwd(); //원문
			String encPassword = encoder.encode(rawPassword); //해쉬
			user.setUserPwd(encPassword);
			user.setRole(RoleType.USER);
			userRepository.save(user);
			return 1; //성공
		}
}
	@Transactional
	public User 회원수정(String userId, User user) {
		try{
			User userEntity =  userRepository.findByUserId(userId).get();
				String rawPassword = user.getUserPwd(); //원문
				String encPassword = encoder.encode(rawPassword); //해쉬
				//userRepository.mUpdate(userUpdateDto.getUserName(), userUpdateDto.getUserEmail(), userUpdateDto.getUserAddr(), userUpdateDto.getUserZipcode(),  encPassword, userUpdateDto.getUserId());
				userEntity.setUserPwd(encPassword);
				userEntity.setUserEmail(user.getUserEmail());
				userEntity.setUserAddr(user.getUserAddr());
				userEntity.setUserZipcode(user.getUserZipcode());
				userEntity.setUserName(user.getUserName());
			return userEntity;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
	}
}
