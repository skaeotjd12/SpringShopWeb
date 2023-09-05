package com.nice.shop.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nice.shop.model.OrderPage;
import com.nice.shop.service.OrderService;
import com.nice.shop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OrderController {

	private final OrderService orderService;
	
	
	@GetMapping("/board/{userId}/orderPage")
		public String orderPage(@PathVariable String userId, Model model,@PageableDefault(size=5, sort = "id", direction = Direction.DESC) Pageable pageable) {
				Page<OrderPage> orderpages = orderService.orderList(userId, pageable);
				model.addAttribute("orders", orderpages);
		return "board/orderPage";
		
	}
	
	
}
