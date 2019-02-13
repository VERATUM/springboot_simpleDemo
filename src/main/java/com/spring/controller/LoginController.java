package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//	@PutMapping
//	@DeleteMapping
//	@GetMapping
//	@RequestMapping(value = "/user/login",method = RequestMethod.POST)
	@PostMapping(value = "/user/login")
	public String login(@RequestParam("username") String username,
	                    @RequestParam("password") String password,
	                    Map<String,Object> map, HttpSession session){
		System.out.println(username+"\t"+password);
		if (!StringUtils.isEmpty(username) && "12345".equals(password)) {
			// 登录成功
			// 防止表单重复提交
			// 重定向
			session.setAttribute("loginUser",username);
			session.setMaxInactiveInterval(5*60);
			return "redirect:/main.html";
		} else {
			// 登录失败
			map.put("msg","用户名或密码有误");
			return "login";
		}
	}

}
