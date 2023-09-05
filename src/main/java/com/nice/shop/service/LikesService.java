package com.nice.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nice.shop.repository.LikesRepository;
import com.nice.shop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LikesService {

private final ProductRepository productRepository;
private final LikesRepository likesRepository;
	
	//좋아요
	@Transactional
	public void like(String userId, int prdNum) {
		
		likesRepository.mLikes(userId, prdNum);
		productRepository.mlikeCount(prdNum);
	}
	
	//좋아요 취소
	@Transactional
	public void unlike(String userId, int prdNum) {
		
		likesRepository.munLikes(userId, prdNum);
		productRepository.munlikeCount(prdNum);
	}
}
