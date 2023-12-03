package com.nice.shop.controller;


import com.nice.shop.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
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

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {

	private final ProductService productService;
	private final ReplyService replyService;
	
		//메인페이지
//		@GetMapping({"","/"})
//		public String index(Model model) {
//
//			model.addAttribute("prds", productService.findListProduct());
//			return "index";
//		}


	@GetMapping({"","/"})
	public String index(Model model,
						@RequestParam(defaultValue = "0") int page,
						@RequestParam(defaultValue = "10") int size) {

		model.addAttribute("prds", productService.getAllproduct(page, size));
		return "index"; //=
	}
		//베스트목록
		@GetMapping("/board/best")
		public String boardBest(Model model) {
			
			model.addAttribute("prds", productService.findListBestProduct("best"));
			return "board/best";
		}
		
		//상품 상세보기,댓글목록 
		@GetMapping("/board/{prdNum}")
		public String prdDetail(@PathVariable int prdNum, Model model,
				@PageableDefault(size=5, sort = "replyId", direction = Direction.DESC) Pageable pageable,
				@AuthenticationPrincipal PrincipalDetail principalDetail) {
			model.addAttribute("prd", productService.상품상세(prdNum, principalDetail.getUsername()));
			model.addAttribute("replys", replyService.댓글목록(prdNum,pageable));
			return "board/boardDetail";
		}
		
		//상세보기 -> 상품 구매페이지
		@GetMapping("/board/{prdNum}/{userId}/orderForm")
		public String orderForm(@PathVariable int prdNum, Model model,@AuthenticationPrincipal PrincipalDetail principalDetail) {
			model.addAttribute("prd", productService.상품상세(prdNum, principalDetail.getUsername()));
			return "board/orderForm";
		}

		@GetMapping("/board/search")
		public String searchPrd(Model model, String keyword) {
			List<Product> searchList = productService.searchPrd(keyword);
			model.addAttribute("searchList", searchList);
			return "board/searchList";
		}
}
