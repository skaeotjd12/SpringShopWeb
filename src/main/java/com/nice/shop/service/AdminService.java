package com.nice.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nice.shop.model.Product;
import com.nice.shop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class AdminService {
	
	private final ProductRepository productRepository;
	
	//상품 등록
	@Transactional
	public int 상품등록(Product product) {
		try{
			productRepository.findByprdNum(product.getPrdNum()).get(); //같은 prdNum이 있으면 에러
			return -1;
		}
		catch (Exception e) {
			productRepository.save(product);
			return 1; //성공
		}
}
	
	
	//상품 수정
	@Transactional
	public int updatePrd(Product product) {
		try{
			Product productEntity = productRepository.findByprdNum(product.getPrdNum()).get();
			productEntity.setPrdCtg(product.getPrdCtg());
			productEntity.setPrdDetail(product.getPrdDetail());
			productEntity.setPrdFilename(product.getPrdFilename());
			productEntity.setPrdName(product.getPrdName());
			productEntity.setPrdPrice(product.getPrdPrice());
			productEntity.setPrdStatuts(product.getPrdStatuts());
			return 1;
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1; 
		}
	}
	//상품삭제
	@Transactional
	public int deletePrd(int prdNum) {
		try {
			productRepository.deleteById(prdNum);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
}