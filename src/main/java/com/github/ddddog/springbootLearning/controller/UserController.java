package com.github.ddddog.springbootLearning.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

    
    @RequestMapping("/login")
    public Map<String,Object> addStock() {
    	Map<String,Object> data = new HashMap<String,Object>();
    	data.put("token", "xiaoming_token");
    	return data;
    	
    }
}
