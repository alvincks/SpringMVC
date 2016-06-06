package com.mvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.repository.UserRepositoryInterface;
import com.mvc.web.model.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepositoryInterface<User, User> userRepository; 

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String displayLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
	
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String displayPostLoginPage(@ModelAttribute("user") User user) {
		System.out.println("User name:" + user.getUsername());
		System.out.println("password:" + user.getPassword());
		boolean isValidUser = userRepository.isValidUser(user,user);
		System.out.println("isValidUser : "+isValidUser);
		return "redirect:greeting.html";
	}

}
