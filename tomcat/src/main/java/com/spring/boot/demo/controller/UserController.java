package com.spring.boot.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.demo.vo.User;

@RestController  
public class UserController {

	@RequestMapping("/")  
    String home() {  
        return "Hello World!";  
    }  
	
	@RequestMapping("/user/{id}")  
    public User view(@PathVariable("id") Long id) {  
        User user = new User();  
        user.setId(id);  
        user.setName("Niekq");  
        return user;  
    }  
}
