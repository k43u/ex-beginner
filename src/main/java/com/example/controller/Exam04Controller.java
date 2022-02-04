package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

	@RequestMapping("")
	public String index() {
		return "exam04";
	}
	
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	
	@RequestMapping("/register")
	public String register(
		@Validated UserForm form
		, BindingResult result
		, RedirectAttributes redirectAttributes
		, Model model
		){
		User user = new User();
		user.setName(form.getName());
		user.setAge(form.getAge());
		user.setComment(form.getComment());
		model.addAttribute("user", user);
		
		if(result.hasErrors()) {
			return index();
		}
		return "exam04-result";
	}
	
}
