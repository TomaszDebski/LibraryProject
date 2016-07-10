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
			return null;
		}
		return user;
	}
}
