package com.nice.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nice.shop.model.Product;
import com.nice.shop.repository.ProductRepository;


@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepository;

		
	//전체 상품 목록
	@Transactional
	public List<Product> findListProduct() {
		return productRepository.findAll();
		}
	
	//베스트 상품목록
	@Transactional
	public List<Product> findListBestProduct(String prdStatuts ) {
		return productRepository.findByprdStatuts(prdStatuts);
		}
	
	
	//상품 상세보기 및 좋아요 상태 저장
	@Transactional(readOnly = true)
	public Product 상품상세(int prdNum, String principalId) {
		
		Product product = productRepository.findByprdNum(prdNum)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패 : 글 번호를 찾을 수 없습니다.");
				});
			 product.getLikes().forEach((like)->{
				 if(like.getUser().getUserId().equals(principalId)) {
					 product.setLikeState(true);
				 }
			 });
		return product;
		}
	}
	

