package com.boot.leaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.leaf.dto.LeafDto;

@Controller
public class LeafController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "Thymeleaf");
		return "hello";
	}
	
	@GetMapping("/util")
	public String util() {
		return "utility";
	}
	
	@GetMapping("/expression")
	public String expression(Model model) {
		model.addAttribute("name","Thymeleaf");
		LeafDto dto = new LeafDto("Spring",1);
		model.addAttribute("dto",dto);
		
		List<LeafDto> list = new ArrayList<LeafDto>();
		list.add(new LeafDto("java",2));
		list.add(new LeafDto("css",3));
		list.add(new LeafDto("github",4));
		model.addAttribute("list",list);
		
		return "expression";
	}
	

}
