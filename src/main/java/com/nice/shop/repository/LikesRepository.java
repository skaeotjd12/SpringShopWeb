package com.nice.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nice.shop.model.Likes;

public interface LikesRepository extends JpaRepository<Likes, Integer> {
	
	//좋아요
	@Modifying
	@Query(value = "INSERT INTO likes(userId, prdNum, createDate) VALUES(:userId, :prdNum, now())", nativeQuery = true)
	int mLikes(String userId, int prdNum);
	
	
	//좋아요 취소
	@Modifying
	@Query(value = "DELETE FROM likes WHERE userId = :userId AND prdNum= :prdNum", nativeQuery = true)
	int munLikes(String userId, int prdNum);
}
