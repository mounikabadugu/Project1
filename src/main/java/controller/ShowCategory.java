package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowCategory 
{
		public ShowCategory() 
		{
		
		   System.out.println("ShowCategory is loading");
	    }
	@RequestMapping("/bbc")
	public ModelAndView m2()
	{
		ModelAndView model=new ModelAndView("ShowCategory");
		model.addObject("nm",20);
		
		
		return model;
	}

}
