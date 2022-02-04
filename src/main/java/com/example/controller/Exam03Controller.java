package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

	@Autowired
	public ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/totalprice")
	public String totalPrice(int item1, int item2, int item3){
		application.setAttribute("addprice", String.format("%,d", item1 + item2 + item3));
		application.setAttribute("totalprice", String.format("%,d", (int)((item1 + item2 + item3) * 1.1)));
		
		return "exam03-result";
		
	}
}
