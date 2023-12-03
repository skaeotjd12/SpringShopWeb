package com.nice.shop.controller;

import com.nice.shop.model.Product;
import com.nice.shop.repository.ProductRepository;
import com.nice.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
public class testController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping("/auth/page")
    public String testPage(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "3") int size,
                           Model model){

    Page<Product> PagePrd = productService.getAllproduct(page, size);
    model.addAttribute("page", PagePrd);
        System.out.println("@@@@@@@@@@@@@@@@@ size : " + PagePrd.getSize());

    return  "test";
    }


    @GetMapping("/auth/pa")
    public Page<Product> testPageable(@PageableDefault(size=5, direction = Sort.Direction.DESC) Pageable pageable){
        Page<Product> PagePageable = productRepository.findAll(pageable);

        return  PagePageable;
    }
}
