package com.nice.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nice.shop.model.Product;
import com.nice.shop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminController {
	
	private final ProductService productService;
	
	@GetMapping("/admin/managerPage")
	public String managerpage() {
		return "admin/managerPage";
	}
	
	@GetMapping("/admin/addProductForm")
	public String addProductform() {
		return "admin/addProductForm";
	}
	
	@GetMapping("/admin/updateProductList")
	public String updateProductList(Model model) {
		List<Product> products = productService.findListProduct();
		model.addAttribute("prds", products);
		return "admin/updatePrdList";
	}
	
	@GetMapping("/admin/{prdNum}/updateProductForm")
	public String updateProductForm(@PathVariable int prdNum, Model model) {
		
		model.addAttribute("prdNum",prdNum );
		return "admin/updateProductForm";
	}
	
	
}
