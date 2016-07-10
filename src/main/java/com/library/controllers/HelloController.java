package com.library.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tomasz Dębski
 *
 */
@RestController
public class HelloController {
	
	@RequestMapping("/findUser")
	@ResponseBody
	public Principal getUser(Principal user){
		if (user == null){
			System.out.println("Jestem w IndexController.class user is null");
			return null;
		}
		System.out.println("Jestem w IndexController.class + user: " + user.toString());
		return user;
	}
	
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World")	;
		return model;
	}

}
