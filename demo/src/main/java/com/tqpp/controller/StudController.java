package com.tqpp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class StudController {

	@GetMapping(value="/home")
	public String home()
	{
		return "home";
	}
}

