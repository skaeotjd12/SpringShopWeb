package com.nice.shop.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	
	
	
	@GetMapping("/auth/joinForm")
	public String join() {
		return "user/joinForm";
	}
	
	@GetMapping("/auth/howJoin")
	public String join(@RequestParam String join) {
		System.out.println("id "+join);
		if (join.equals("normal")) {
			return "user/normalJoinForm";
		}
		return "index";
	}
	
	@GetMapping("/auth/loginForm")
	public String login(@RequestParam(value = "error", required = false)String error,
									 @RequestParam(value = "exception", required = false) String exception,
									 Model model) {
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		return "user/loginForm";
	}
	
	@GetMapping("/{userId}/update")
	public String userUpdateForm() {
		return "user/userUpdateForm";
	}	


}
