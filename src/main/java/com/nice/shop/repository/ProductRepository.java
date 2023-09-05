package com.nice.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nice.shop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Optional<Product> findByprdNum(int prdNum);
	
	public Page<Product> findByprdNum(int prdNum, Pageable pageable);

	List<Product> findByprdStatuts(String prdStatuts);
	
	@Query(value =  "select * from product where prdNum= :prdNum", nativeQuery = true)
	int mProductDetail(int prdNum);
	
	//좋아요 카운트 증가
	@Modifying
	@Query(value =  "update product set likeCount = likeCount + 1 where prdNum = :prdNum", nativeQuery = true)
	int mlikeCount(int prdNum);
	
	
	//좋아요 카운트 감소
	@Modifying
	@Query(value =  "update product set likeCount = likeCount - 1 where prdNum = :prdNum", nativeQuery = true)
	int munlikeCount(int prdNum);
}
