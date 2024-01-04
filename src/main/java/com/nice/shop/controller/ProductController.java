package com.nice.shop.controller;


import com.nice.shop.config.Pagination;
import com.nice.shop.model.Product;
import com.nice.shop.model.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nice.shop.config.auth.PrincipalDetail;
import com.nice.shop.service.ProductService;
import com.nice.shop.service.ReplyService;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
public class ProductController {

	private final ProductService productService;
	private final ReplyService replyService;
	private final Pagination pagination;


	@GetMapping({"","/","/board/search"})
	public String index(Model model,
						String keyword,
						@PageableDefault(page = 1)Pageable pageable) {
		if (keyword != null) {
			Page<Product> searchList = productService.searchPrd(keyword,pageable);

			pagination.setBlockLimit(5);
			int startPage = pagination.getStartPage(pageable);
			int endPage = pagination.getEndPage(searchList,startPage);

			model.addAttribute("keyword", keyword);
			model.addAttribute("pages", searchList);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage" , endPage);
			return "index";
		}
		Page<Product> productList = productService.getAllproduct(pageable);
		pagination.setBlockLimit(10);
		int startPage = pagination.getStartPage(pageable);
		int endPage = pagination.getEndPage(productList,startPage);

		model.addAttribute("pages", productList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage" , endPage);
		return "index";
	}
		//베스트목록
		@GetMapping("/board/best")
		public String boardBest(Model model) {
			
			model.addAttribute("prds", productService.findListBestProduct("best"));
			return "board/best";
		}
		
		//상품 상세보기,댓글목록 페이징처리
		@GetMapping("/board/{prdNum}")
		public String prdDetail(@PathVariable int prdNum, Model model,
								@PageableDefault(page = 1) Pageable pageable,
								@RequestParam String page,
								@RequestParam String keyword,
			                	@AuthenticationPrincipal PrincipalDetail principalDetail) {

			Page<Reply> replyList = replyService.댓글목록(prdNum,  pageable);
			Product product = productService.상품상세(prdNum, principalDetail.getUsername());
			pagination.setBlockLimit(3);
			int startPage = pagination.getStartPage(pageable);
			int endPage = pagination.getEndPage(replyList, startPage);
			model.addAttribute("prd", product);
			model.addAttribute("page", page);
			model.addAttribute("keyword", keyword);
			model.addAttribute("pages", replyList);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage" , endPage);

			return "board/boardDetail";
		}
		
		//상세보기 -> 상품 구매페이지
		@GetMapping("/board/{prdNum}/{userId}/orderForm")
		public String orderForm(@PathVariable int prdNum, Model model,@AuthenticationPrincipal PrincipalDetail principalDetail) {
			model.addAttribute("prd", productService.상품상세(prdNum, principalDetail.getUsername()));
			return "board/orderForm";
		}


}