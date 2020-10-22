package com.sumon.xyz.RestApi_Course.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class LoginController {
	
	@RequestMapping("/login")
	@ResponseBody
	public String ShowMessge()
	{
		
		return "Login";
		
	}

}
