package com.mounika.DaoImpl;

import java.util.List;
import java.util.function.Supplier;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mounika.model.Cart;
import com.mounika.model.Category;
import com.mounika.model.Product;
import com.mounika.model.SupplierPOJO;

@Component
public class ProductDaoImpl {
	@Autowired
	SessionFactory sf;
	
	public void saveProduct(Product product)
	{
		Session sess=sf.openSession();
		sess.saveOrUpdate(product);
		Transaction transaction=sess.beginTransaction();
		transaction.commit();
		sess.close();
	}
	
public List<Product> RetriveDataFromProduct()
     {
	   Session session=sf.openSession();
	   Query query=session.createQuery("from Product");
	   List list=query.list();
	   session.close();
	   return list;
     }

public void deleteProduct(int productId)
{
 Session session=sf.openSession();
 Product pro=session.get(Product.class,productId);

 System.out.println(pro);
 session.delete(pro);
 Transaction trans=session.beginTransaction();
 trans.commit();
 session.close();
}
public Product getProduct(int productId)
{
	 Session sess=sf.openSession();
	  Product pro=sess.get(Product.class,productId);
	  System.out.println("pro...."+pro);
	   sess.close();
	 	 return pro;
	 	
}
public Product view(int productId)
{
	Session sess=sf.openSession();
	  Product pro=sess.get(Product.class,productId);
	  sess.close();
	 	 return pro;
}
public Cart setCart(Product product,int q)
{
	 Cart cart=new Cart();
	  cart.setCartId((int)(Math.random()*10000));
	  cart.setProductId(product.getProductId());
	  cart.setProductName(product.getProductName());
	  cart.setProductPrice(product.getProductPrice());
	 
	  cart.setSupplierName(product.getProductSupplier()); 
	  cart.setQuantity(q);
	 
	 cart.setTotalPrice(((product.getProductPrice()))*(cart.getQuantity()));
	return cart;
}

public void saveCart(Cart cart)
{
	Session session=sf.openSession();
	session.save(cart);
	Transaction trans=session.beginTransaction();
	trans.commit();
	session.close();
    
}
public List<Cart> RetriveDataFromCart()
{
  Session session=sf.openSession();
  Query query=session.createQuery("from Cart");
  List list=query.list();
  session.close();
  return list;
}

}
