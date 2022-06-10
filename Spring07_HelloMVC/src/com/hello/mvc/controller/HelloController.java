package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloService;

@Controller
public class HelloController {

	@Autowired
	private HelloService service;

	@RequestMapping("/hello.do")
	public String getHello(Model model) {
		String value = service.getHello();
		model.addAttribute("message",value);
		
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/bye.do")
	public ModelAndView getBye(@RequestParam("name") String name) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message", "Bye"+name);
		
		return mav;
		
	}
}