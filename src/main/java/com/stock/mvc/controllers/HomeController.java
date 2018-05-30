package com.stock.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	
	@RequestMapping(value="/blank")
	public String home(){
		return "blank/blank";
	}
}
