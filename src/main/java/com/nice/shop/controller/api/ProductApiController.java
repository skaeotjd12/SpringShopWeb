package com.nice.shop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nice.shop.dto.ReplySaveRequestDto;
import com.nice.shop.dto.ResponseDto;
import com.nice.shop.service.ReplyService;


@RestController
public class ProductApiController {
	

	@Autowired
	private ReplyService ReplyService;
	
	//댓글 쓰기
		@PostMapping("/api/board/{userId}/addReply")
		public ResponseDto<Integer> addReply(@RequestBody ReplySaveRequestDto replySaveRequestDto) {
			
			
			ReplyService.댓글쓰기(replySaveRequestDto);
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바 오브젝트를 JSON으로 변환해서 리턴
		}
		//댓글 삭제
		@DeleteMapping("/api/{replyId}/deleteReply")
		public ResponseDto<Integer> deleteReply(@PathVariable int replyId) {
			ReplyService.deleteReply(replyId);
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바 오브젝트를 JSON으로 변환해서 리턴
		}
}
	
		

