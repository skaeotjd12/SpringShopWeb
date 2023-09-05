package com.nice.shop.handler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.nice.shop.dto.ResponseDto;



@ControllerAdvice //어디서든 exception발생해도 이쪽으로 오게 만든다
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseDto<String>  handleArgumentException(Exception e){
		//500에러
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
	}
}

