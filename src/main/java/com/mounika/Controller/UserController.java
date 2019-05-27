package com.mounika.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mounika.DaoImpl.UserDaolmpl;
import com.mounika.model.Category;
import com.mounika.model.User;

@Controller
public class UserController {
	@Autowired
	UserDaolmpl userDaolmpl;
	public UserController()
	{
		System.out.println("UserController");
	}
@RequestMapping("/register")	
public ModelAndView goToRegisterForm() {
	ModelAndView model=new ModelAndView("register");
	model.addObject("user",new User());
	return model;
}
@RequestMapping(value="/addUser",method=RequestMethod.POST)
public String setUserFormData(@ModelAttribute ("user") User user)//ca is categorytype of pojo
{
    System.out.println(user.getEmail());
    System.out.println(user.getPassword());
    System.out.println(user.getPassword());
    System.out.println(user.getUserName());
    System.out.println(user.getRole());
    System.out.println(user.getAddress());
    System.out.println(user.isEnabled());
    userDaolmpl.addUser(user);
   
            
    return "Home";//returning category.jsp
}
@RequestMapping(value="/login",method=RequestMethod.GET)
public ModelAndView goToLoginForm()
{
     ModelAndView model=new ModelAndView("LoginSucess");
     model.addObject("Login",new User());
    return model;//
}
@RequestMapping(value="/login",method=RequestMethod.POST)
public ModelAndView retriveUserData(@ModelAttribute("Login") User user)
{
	boolean result=userDaolmpl.checkLoginSucess(user);
	if(result==true)
	{
	 
		ModelAndView model=new ModelAndView("Login");
		return model;
	
	}
	else
	{
		ModelAndView model=new ModelAndView("LoginSucess");
		model.addObject("Login","loginfailed");
		return model;
	}
}


}
