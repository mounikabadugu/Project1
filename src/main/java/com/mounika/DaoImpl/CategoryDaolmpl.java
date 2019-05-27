package com.mounika.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.sql.ordering.antlr.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mounika.model.Category;



@Component 
public class CategoryDaolmpl {
	
@Autowired

SessionFactory sf;
public void saveCategory(Category category)
{
	Session s=sf.openSession();
	if(category.getCategoryId()==0)
	{
		System.out.println(".....Working");
	int id=(int)(Math.random()*10000);
    category.setCategoryId(id);
	}
	s.saveOrUpdate(category);
	Transaction t=s.beginTransaction();
	t.commit();	
	s.close();
}

 public List<Category> getData()
 {
	 Session s=sf.openSession();
	Query  query=s.createQuery("from Category");
	List<Category> list=query.list();
	/*for( Category category:list)
	{
	 
	 System.out.println(category.getCategoryId());
	 System.out.print(category.getCategoryDiscription());
	}*/
	s.close();
	return list;
	
 }

 public void getCategoryObject(int categoryId)
 {
  Session session=sf.openSession();
  Category cat=session.get(Category.class,categoryId);
 
  System.out.println(cat);
  session.delete(cat);
 session.close();
  
 }
 public Category getCategory(int categoryId)
 {
	 Session sess=sf.openSession();
	 Category cat=sess.get(Category.class,categoryId);
	 
	  System.out.println("cat...."+cat);
	 
	  Transaction trans=sess.beginTransaction();
	  trans.commit();
	  sess.close();
	 	 return cat;
	 	
 }

}
