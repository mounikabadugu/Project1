package com.mounika.DaoImpl;
import java.util.List;
import java.util.Locale.Category;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mounika.model.SupplierPOJO;

@Component
public class SupplierDaoimpl {
	
	
    @Autowired
	SessionFactory sf;
	public void saveSupplier(SupplierPOJO s)
	{
		Session se=sf.openSession();
		if(s.getSupplierId()==0)
		{
		int id=(int)(Math.random()*10000);
		
	    s.setSupplierId(id);
		}
		se.saveOrUpdate(s);
		Transaction t=se.beginTransaction();
		t.commit();		
		se.close();
	}
	 public List<SupplierPOJO> getData()
	 {
		 Session s=sf.openSession();
		Query  query=s.createQuery("from SupplierPOJO");
		List<SupplierPOJO> list=query.list();
		/*for( SupplierPOJO sup:list)
		{
		 
		 System.out.print(sup.getSupplierId());
		 System.out.print(sup.getSupplierName());
		 System.out.print(sup.getSupplierSalary());
		 System.out.println();
		 
		}*/
		s.close();
		return list;
	 }
	 public void deleteSupplier(int supplierId )
	 {
	  Session session=sf.openSession();
	  SupplierPOJO sat=session.get(SupplierPOJO.class,supplierId);
	 
	  System.out.println(sat);
	  session.delete(sat);
	  Transaction trans=session.beginTransaction();
	  trans.commit();
	  session.close();
	 }
public SupplierPOJO editRecord(int supplierId) 
	 {
		 Session session=sf.openSession();
		 SupplierPOJO sat=session.get(SupplierPOJO.class,supplierId);
		 
		  System.out.println("sat...."+sat);
		 
		  Transaction trans=session.beginTransaction();
		  trans.commit();
		  session.close();
		 return sat;
	}
}
