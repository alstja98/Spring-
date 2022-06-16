package com.boot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class StartBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(StartBoot2Application.class, args);
	}

	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	
}
