package com.mounika.Controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mounika.DaoImpl.CategoryDaolmpl;
import com.mounika.DaoImpl.TestingSessionFactory;
import com.mounika.model.Category;





@Controller
public class CategoryController {
	@Autowired
	TestingSessionFactory ts;
	@Autowired
	CategoryDaolmpl c;
	
	public CategoryController()
	{
		
		System.out.println("controller is loading");
		
	}
	
	@RequestMapping("/category")
	    //@RequestMapping(value="/category", method=RequestMethod.GET)
	    public ModelAndView goToCategoryForm()
	    {
	        ModelAndView  mv=new ModelAndView("Category1");//jsp
	        
	        mv.addObject("cat",new Category());
	        mv.addObject("buttonName", "AddCategory");
	        return  mv;
	    }
	 @RequestMapping(value="/addCat",method=RequestMethod.POST)
	    public String setCategoryFormData(@ModelAttribute ("cat") Category ca)//ca is categorytype of pojo
	    {
		 
		 ts.TestingSessionFactory();
	        System.out.println(ca.getCategoryId());
	        System.out.println(ca.getCategoryName());
	        System.out.println(ca.getCategoryDiscription());
	        c.saveCategory(ca);
	       
	                
	        return "Home";//returning category.jsp
	    }
	 @RequestMapping("/showcategory")
		public ModelAndView RetriveCategoryData()
		{
		 
		 List list	= c.getData();
			ModelAndView model=new ModelAndView("ShowCategory1");
		    model.addObject("Catdata",list );
				return model;
		}
	 @RequestMapping("/sss")
	    public String deleterecord(@RequestParam("catid") int categoryId)
	    {
		 System.out.println(categoryId);
		 c.getCategoryObject(categoryId);	
		return "redirect:showcategory";
	    }
	 @RequestMapping("/mmm")
	 public ModelAndView editRecord(@RequestParam("catid") int categoryId )
	 {
		 Category ca=c.getCategory(categoryId);
		ModelAndView model=new ModelAndView("Category1");
		model.addObject("cat",ca);
		 model.addObject("buttonName","UpdateCategory");
		return model; 
	 }
    
	    
	
	   

}
