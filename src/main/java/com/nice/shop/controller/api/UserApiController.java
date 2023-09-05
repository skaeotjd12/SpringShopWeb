package com.nice.shop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nice.shop.config.auth.PrincipalDetail;
import com.nice.shop.dto.ResponseDto;
import com.nice.shop.dto.UserUpdateDto;
import com.nice.shop.model.User;
import com.nice.shop.service.UserService;


@RestController
public class UserApiController {
	

	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		int result = userService.회원가입(user);
		
		if(result==-1) {
			return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), -1); 
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
		
	}	
	
	@PutMapping("/api/{userId}/update")
	public ResponseDto<?> userUpdate(@PathVariable String userId, @RequestBody UserUpdateDto userUpdateDto, 
			@AuthenticationPrincipal PrincipalDetail principalDetail) {
		
		//userService.회원수정(userUpdateDto);
		User userEntity = userService.회원수정(userId, userUpdateDto.toEntity());
//		principalDetail.setUser(userEntity);
		return new ResponseDto<User>(HttpStatus.OK.value(), userEntity); 
	}	
}

