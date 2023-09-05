package com.nice.shop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nice.shop.dto.OrderInfoDto;
import com.nice.shop.dto.ResponseDto;
import com.nice.shop.service.OrderService;

@RestController
public class OrderApiController {
	
	@Autowired
	OrderService orderService;
	
	//상품 구매
			@PostMapping("/api/board/{prdNum}/orderPrd")
			public ResponseDto<Integer> orderPrd(@RequestBody OrderInfoDto orderInfoDto) {
				orderService.orderPrd(orderInfoDto);
				
				return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바 오브젝트를 JSON으로 변환해서 리턴
			}
			
}
