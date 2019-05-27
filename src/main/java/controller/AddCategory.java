package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddCategory {
public AddCategory() {
	
	System.out.println("AddCatogry is loading");
}
@RequestMapping("/abc")
public String m1()
{
	return "Category";
}
}
