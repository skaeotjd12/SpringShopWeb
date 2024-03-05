package com.nice.shop.service;

import java.util.List;

import com.nice.shop.dto.ReplySaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


	@Transactional
	public Page<Product> getAllproduct(Pageable pageable) {
		int page = pageable.getPageNumber() -1;
		int pageLimit = 3;
		return productRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.DEFAULT_DIRECTION.ASC, "prdNum")));
	}
	//베스트 상품목록
	@Transactional(readOnly = true)
	public List<Product> findListBestProduct(String prdStatuts) {
		return productRepository.findByprdStatuts(prdStatuts);
	}

	//신상 상품목록
	@Transactional(readOnly = true)
	public List<Product> findListNewProduct(String prdStatuts) {
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
		
	//검색 페이지
	@Transactional(readOnly = true)
	public Page<Product> searchPrd(String keyword, Pageable pageable) {
		int page = pageable.getPageNumber() -1;
		int pageLimit = 4;
		return productRepository.findByprdNameContaining(keyword,
				PageRequest.of(page, pageLimit, Sort.by(Sort.DEFAULT_DIRECTION.ASC, "prdNum")));
	}



}
	

