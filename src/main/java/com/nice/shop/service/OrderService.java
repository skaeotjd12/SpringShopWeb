package com.nice.shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nice.shop.dto.OrderInfoDto;
import com.nice.shop.model.OrderPage;
import com.nice.shop.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	@Transactional(readOnly = true)
	public Page<OrderPage> orderList(String userId,Pageable pageable) {
			return  orderRepository.mOrderpage(userId, pageable);
	}
	
	
	//상품구매
		@Transactional
		public void orderPrd(OrderInfoDto buyPrdINfoDto) {
			 orderRepository.mOrderPrd(buyPrdINfoDto.getPrdNum(),buyPrdINfoDto.getUserId(),buyPrdINfoDto.getOrderCount(),buyPrdINfoDto.getOrderPrice());	
			}
}
