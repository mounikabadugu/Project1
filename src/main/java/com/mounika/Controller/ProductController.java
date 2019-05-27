package com.mounika.Controller;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mounika.DaoImpl.CategoryDaolmpl;
import com.mounika.DaoImpl.ProductDaoImpl;
import com.mounika.DaoImpl.SupplierDaoimpl;
import com.mounika.DaoImpl.TestingSessionFactory;
import com.mounika.model.Cart;
import com.mounika.model.Category;
import com.mounika.model.Product;
import com.mounika.model.SupplierPOJO;

import controller.AddCategory;

@Controller
public class ProductController {
	
	@Autowired
	TestingSessionFactory test;
	
	@Autowired
	ProductDaoImpl proD;
	@Autowired
	CategoryDaolmpl category;
	@Autowired
	SupplierDaoimpl supplier;
	 
    public ProductController() {
	System.out.println("loading");
	}
    
    @RequestMapping("/Product")
    public ModelAndView goToProductForm() 
    {
    ModelAndView model=new ModelAndView("Product");
    Product product=new Product();
    model.addObject("pro",product);
     product.setProductId((int)(Math.random()*10000));
     List<Category> catlist=category.getData();
     model.addObject("CatList", catlist);
     List<SupplierPOJO> suplist=supplier.getData();
    model.addObject("SupList", suplist);
    
       model.addObject("buttonName","AddProduct");
    return model;
    }
    
    @RequestMapping(value="/addPro",method=RequestMethod.POST)
    public String recieveSupplierFormData(@ModelAttribute ("pro") Product pr)//sa is SupplierPOJO type
    {
    	MultipartFile image=pr.getProductImage();
        System.out.println("image="+image);
        try {
        	 byte bytearray[]=image.getBytes();
			FileOutputStream fos=new FileOutputStream("D:/Users/Administrator/eclipse-workspace/eshop4/src/main/webapp/resources/ProductImages/"+pr.getProductId()+".jpg");
			 BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(bytearray);
		       bos.close();
		} 
        catch (FileNotFoundException e) 
        {
			e.printStackTrace();
		}
        catch (IOException e)
        {
			e.printStackTrace();
		}
        
    	test.TestingSessionFactory();;//to print sessionfactory adress
    	System.out.println(pr.getProductId());
        System.out.println(pr.getProductName());//to print in console
        System.out.println(pr.getProductDiscription());
        System.out.println(pr.getProductPrice());//to print in console
        System.out.println(pr.getProductCategory());
        System.out.println(pr.getProductSupplier());
        System.out.println(pr.getSupplierAddress());
        
       proD.saveProduct(pr);//values goto database*/
                
        return "Home";//return jsp
    }
    @RequestMapping("/showProduct")
   public ModelAndView RetriveProductData() 
   {
    	List list=proD.RetriveDataFromProduct();	
     ModelAndView model=new ModelAndView("ShowProduct");
     model.addObject("ProData", list);
	return model;
    }
    @RequestMapping("/delpro")
    public String deleteProduct(@RequestParam("proid") int productId) 
    {
    	System.out.println("ProductID..."+productId);
    	proD.deleteProduct(productId);
    	 File file=new File("D:/Users/Administrator/eclipse-workspace/eshop4/src/main/webapp/resources/ProductImages/"+productId+".jpg");
    	file.delete();
    	return "redirect:showProduct";
	}
    @RequestMapping("/editpro")
	 public ModelAndView editRecord(@RequestParam("proid") int productId)
	 {
		 Product product=proD.getProduct(productId);
		 
		ModelAndView model=new ModelAndView("Product");
		model.addObject("pro",product);
		 List<Category> catlist=category.getData();
	     model.addObject("CatList", catlist);
	     List<SupplierPOJO> suplist=supplier.getData();
	    model.addObject("SupList", suplist);
	     model.addObject("buttonName","UpdateProduct");
		return model; 
	 }
    ///.............user module.......................
   @RequestMapping("/showpro") 
     public ModelAndView displaying() 
      {
	   List list=proD.RetriveDataFromProduct();	
	    ModelAndView model=new ModelAndView("userProducts");	
	    model.addObject("UserPro", list);
		return model;
       	
       }
   @RequestMapping("/view")
   public ModelAndView viewdetails(@RequestParam("proid") int productId) 
   {
   	
   	Product product=proD.view(productId);
     ModelAndView model=new ModelAndView("productsdetails");	
    model.addObject("Prodetails", product);
	return model;
    
  }
   @RequestMapping("/addtocart")
   public ModelAndView addCart() 
   {
	   Cart cart=new Cart();
   ModelAndView model=new ModelAndView("productsdetails");
   model.addObject("Cart", cart);
	return model;
    
  }
   @RequestMapping("/savecartdata")
	public String saveCartData(HttpServletRequest request)
	{
	  int productId=Integer.parseInt(request.getParameter("cartid"));
	  System.out.println("...."+productId);
	  Product product=proD.getProduct(productId);
	  int Quantity=Integer.parseInt(request.getParameter("quantity"));
	  System.out.println("quantity"+Quantity);
	  Cart cart= proD.setCart(product,Quantity);
	 // cart.setQuantity(Quantity);
	  proD.saveCart(cart);
	   return "UserHeader";
	}
  @RequestMapping("/showcart")
   public ModelAndView DisplayCart()
   {
	  List list=proD.RetriveDataFromCart();
	  ModelAndView model=new ModelAndView("ShowCart");
	  model.addObject("cartdata", list);
	  return model;
   }
   }
