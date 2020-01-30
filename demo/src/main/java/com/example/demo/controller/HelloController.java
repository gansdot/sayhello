package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@ResponseBody
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		return "Hello " + name;
	}

}
