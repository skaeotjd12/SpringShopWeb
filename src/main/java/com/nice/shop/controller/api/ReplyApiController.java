package com.nice.shop.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.nice.shop.dto.ReplySaveRequestDto;
import com.nice.shop.dto.ResponseDto;
import com.nice.shop.service.ReplyService;

@RequiredArgsConstructor
@RestController
public class ReplyApiController {
	


	private final ReplyService ReplyService;


	
		//댓글 쓰기
		@PostMapping("/api/board/{userId}/addReply")
		public ResponseDto<Integer> addReply(@RequestBody ReplySaveRequestDto replySaveRequestDto) {
			
			
			ReplyService.댓글쓰기(replySaveRequestDto);
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		}
		//댓글 삭제
		@DeleteMapping("/api/{replyId}/deleteReply")
		public ResponseDto<Integer> deleteReply(@PathVariable int replyId) {
			ReplyService.댓글삭제(replyId);
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		}



}
	
		

