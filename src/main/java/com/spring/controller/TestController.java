package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class TestController {
/*	@RequestMapping(value = {"/","/aa"})
	public String showPage(){
		return "show";
	}*/

	@ResponseBody
	@RequestMapping("/hello")
	public String showHello(String user){
		if ("aaa".equals(user))
			throw new RuntimeException("用户名为"+user);
		return "hello world";
	}

	@RequestMapping("/show")
	public String showThymeleaf(Map<String,Object> map){
		map.put("hello","你好啊……");
		map.put("arr", Arrays.asList(" <i>hello 01</i>"," hell 02 "," he 03" ));
		return "show";
	}
}
