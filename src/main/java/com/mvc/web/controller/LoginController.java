package com.mvc.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.web.model.User;

//get the username n password to detect 
@Controller
public class LoginController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String displayLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String displayPostLoginPage(@Valid User user, BindingResult result, Model model) {
		System.out.println("User name:" + user.getUsername());
		System.out.println("password:" + user.getPassword());
		System.out.println("result.hasErrors()="+result.hasErrors());
		if(result.hasErrors()){
			return "login";
		}
		return "redirect:greeting.html";
	}
	
	
}
