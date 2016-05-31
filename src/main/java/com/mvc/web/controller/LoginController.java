package com.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.web.model.User;

//get the username n password to detect 
@Controller
public class LoginController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String displayLoginPage(Model model) {
		User user = new User();
		user.setUsername("Enter UserName");
		model.addAttribute("user", user);
	
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String displayPostLoginPage(@ModelAttribute("user222") User user) {
		System.out.println("User name:" + user.getUsername());
		System.out.println("password:" + user.getPassword());
		return "redirect:greeting.html";
	}
}
