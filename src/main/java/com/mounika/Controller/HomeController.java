package com.mounika.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	public HomeController()
	{
		System.out.println("Home is loading");
	}
	@RequestMapping("/home")
	public String goToHome()
	{
		
	return "UserHome";	
		
	}
	
	@RequestMapping("/contact")
	public String gotoContact()
	{
		
	return "ContactUs";	
		
	}
	@RequestMapping("/about")
	public String gotoAboutUs()
	{
		
	return "AboutUs";	
		
	}
	
}
