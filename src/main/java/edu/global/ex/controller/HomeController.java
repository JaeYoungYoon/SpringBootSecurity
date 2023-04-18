package edu.global.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/user/userHome")
	public void user_home() {
		log.info("userHome ...");
	}
	
	@GetMapping("/admin/adminHome")
	public void admin_home() {
		log.info("adminHome ... ");
	}

}
