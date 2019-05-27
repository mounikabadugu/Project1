package Pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class C2 {
	C2()
	{
		System.out.println("c2 is loading");
	}
	@RequestMapping("/abc")
	
	public ModelAndView m2()
	{
		ModelAndView model=new ModelAndView();
		model.addObject("nm",20);
		
		return model;
	}

}
