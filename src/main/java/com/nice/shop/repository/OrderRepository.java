package com.nice.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nice.shop.model.OrderPage;

public interface OrderRepository extends JpaRepository<OrderPage, Integer> {
	
	@Query(value = "SELECT * FROM OrderPage WHERE userId=:userId", nativeQuery = true)
	Page<OrderPage> mOrderpage(String userId, Pageable pageable);
	
	@Modifying
	@Query(value = "INSERT INTO orderPage(prdNum, userId, orderCount, orderPrice, createdate) VALUES(:prdNum, :userId, :orderCount, :orderPrice, now())", nativeQuery = true)
	int mOrderPrd(int prdNum, String userId, int orderCount, int orderPrice);
}
