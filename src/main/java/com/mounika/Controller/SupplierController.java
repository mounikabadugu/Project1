package com.mounika.Controller;



import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mounika.DaoImpl.SupplierDaoimpl;
import com.mounika.DaoImpl.TestSessFact;
import com.mounika.model.SupplierPOJO;

@Controller
public class SupplierController
{
	
	@Autowired
	TestSessFact t;
	
	@Autowired
	SupplierDaoimpl sd;
	
	public SupplierController()
	{
		System.out.print("control is loading");
	}
	
	@RequestMapping("/supplier")
	   // @RequestMapping(value="/supplier", method=RequestMethod.GET)
	    public ModelAndView goToSupplierForm()
	    {
	        ModelAndView  mv=new ModelAndView("Supplier");//jsp
	        
	        mv.addObject("sat",new SupplierPOJO());
	        mv.addObject("buttonName", "AddSupplier");
	        return  mv;
	    }
	    
	    @RequestMapping(value="/addSat",method=RequestMethod.POST)
	    public String recieveSupplierFormData(@ModelAttribute ("sat") SupplierPOJO sa)//sa is SupplierPOJO type
	    {
	    	
	    	t.Test();//to print sessionfactory adress
	        System.out.println(sa.getSupplierId());//to print in console
	        System.out.println(sa.getSupplierName());//to print in console
	        System.out.println(sa.getSupplierSalary());
	        System.out.println(sa.getSupplierAddress());
	       sd.saveSupplier(sa);//values goto database
	                
	        return "UserHome";//return jsp
	    }
	    @RequestMapping("/showsupplier")
		public ModelAndView m2()
		{
	    	List list	= sd.getData();
		   ModelAndView model=new ModelAndView("ShowSupplier");
		 model.addObject("SupData",list );
		  return model;
		   }
	    @RequestMapping("/del")
	    public String deleterecord(@RequestParam("satid") int supplierId)
	    {
	    	System.out.println(supplierId);
	    	ModelAndView model=new ModelAndView("ShowSupplier");
	    	
	    sd.deleteSupplier(supplierId);
	   
	    	List lis=sd.getData();
	    		
	    	 model.addObject("SupData",lis);
	    	return "redirect:showsupplier";
	    }
	   @RequestMapping("/edit")
	    public ModelAndView editRecord(@RequestParam("satid")int supplierId ) 
	    {
	    	SupplierPOJO supplier=sd.editRecord(supplierId);
	    	ModelAndView model=new ModelAndView("Supplier");
	    	model.addObject("sat",supplier );
	    	 model.addObject("buttonName","UpdateSupplier");
			return model;
		}
	   	

}
