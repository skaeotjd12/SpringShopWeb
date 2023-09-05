package com.nice.shop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nice.shop.config.auth.PrincipalDetail;
import com.nice.shop.dto.ResponseDto;
import com.nice.shop.service.LikesService;

@RestController
public class LikesApiController {
	
	@Autowired
	private LikesService likesService;
	
	//좋아요
			@PostMapping("api/board/{prdNum}/likes")
				public ResponseDto<Integer> likes(@PathVariable int prdNum, @AuthenticationPrincipal PrincipalDetail principalDetail){
				likesService.like(principalDetail.getUsername(),prdNum);
				return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
			}
			
			//좋아요 취소
			@DeleteMapping("api/board/{prdNum}/likes")
				public ResponseDto<Integer> unlikes(@PathVariable int prdNum, @AuthenticationPrincipal PrincipalDetail principalDetail){
				likesService.unlike(principalDetail.getUsername(),prdNum);
				return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
			}
}
