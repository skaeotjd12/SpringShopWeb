package com.nice.shop.controller.api;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


import com.nice.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nice.shop.dto.ResponseDto;
import com.nice.shop.model.Product;
import com.nice.shop.service.AdminService;
import com.nice.shop.service.ProductService;


@RestController
public class ProductApiController {


	@Value("${file.path}")
	private String uploadFolder;


	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductService productService;
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/admin/addPrd")
	public ResponseDto<Integer> addPrd(@RequestPart(value = "key" ) Product product,
																		@RequestPart(value= "prdFile") MultipartFile prdFile,
																		Model model) {
		String fileResult =  saveFile(prdFile);
		 if(fileResult !=null){ // 파일 저장 성공
		        model.addAttribute("result", fileResult);
		    } else { // 파일 저장 실패
		    	return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), -1);
		    }
				product.setPrdFilename(fileResult);

			int result = adminService.addPrd(product);
			if(result==-1) {
				return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), -1);
			}
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	//추후 삭제
	@RequestMapping(value="/admin/testaddPrd")
	public int testAddPrd(Product product) {
		product.setPrdName("sdsdds");
		product.setPrdDetail("aaaa");
		product.setPrdCtg("asdsd");
		product.setPrdStatuts("sdsd");
		product.setPrdPrice(123123);
		product.setPrdFilename("wdwdwd");

		adminService.testAddPrd(product);

		return 1;
	}

	
	
	
	@PutMapping("/api/updatePrd")
	public ResponseDto<Integer> updatePrd(@RequestPart(value = "key" ) Product product,
																		@RequestPart(value= "prdFile") MultipartFile prdFile,
																		Model model) {
		String fileResult =  saveFile(prdFile);
		 if(fileResult !=null){ // 파일 저장 성공
		        model.addAttribute("result", fileResult);
		    } else { // 파일 저장 실패
		        model.addAttribute("result","fail");
		    }
		product.setPrdFilename(fileResult);
		int result = adminService.updatePrd(product);
		if(result==-1) {
			return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), -1); 
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@DeleteMapping("/api/{prdNum}/deletePrd")
	public ResponseDto<Integer> deletePrd(@PathVariable int prdNum) {
		adminService.deletePrd(prdNum);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	
	private String saveFile(MultipartFile file) {

		 // 파일 이름 변경
	    UUID uuid = UUID.randomUUID();
		String whitespace = file.getOriginalFilename().replaceAll("\\s", ""); //파일 공백없애기
	    String saveName = uuid + "_" + whitespace;

	    // 저장할 File 객체를 생성(껍데기 파일)
	    File saveFile = new File(uploadFolder,saveName); // 저장할 폴더 이름, 저장할 파일 이름
	    try {
	        file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	    return saveName;
	}


}


