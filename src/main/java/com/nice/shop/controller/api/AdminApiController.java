package com.nice.shop.controller.api;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nice.shop.dto.ResponseDto;
import com.nice.shop.model.Product;
import com.nice.shop.service.AdminService;
import com.nice.shop.service.ProductService;




@RestController
public class AdminApiController {
	
	private static final String UPLOAD_PATH ="C:\\git\\repository\\SpringBootWebProject\\src\\main\\resources\\static\\productImg" ;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/admin/addPrd")
	public ResponseDto<Integer> addPrdoduct(@RequestPart(value = "key" ) Product product,
																		@RequestPart(value= "prdFile") MultipartFile prdFile,
																		Model model) {
		String fileResult =  saveFile(prdFile);
		 if(fileResult !=null){ // 파일 저장 성공
		        model.addAttribute("result", fileResult);
		    } else { // 파일 저장 실패
		    	return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), -1);
		    }
		product.setPrdFilename(fileResult);
		int result = adminService.상품등록(product);
		if(result==-1) {
			return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), -1); 
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	
	}
	
	
	
	@PutMapping("/api/updatePrd")
	public ResponseDto<Integer> updatePrdoduct(@RequestPart(value = "key" ) Product product,
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
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바 오브젝트를 JSON으로 변환해서 리턴
	}
	
	
	private String saveFile(MultipartFile file) {
		 // 파일 이름 변경
	    UUID uuid = UUID.randomUUID();
	    String saveName = uuid + "_" + file.getOriginalFilename();

	    // 저장할 File 객체를 생성(껍데기 파일)
	    File saveFile = new File(UPLOAD_PATH,saveName); // 저장할 폴더 이름, 저장할 파일 이름

	    try {
	        file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	    return saveName;
	}
}


