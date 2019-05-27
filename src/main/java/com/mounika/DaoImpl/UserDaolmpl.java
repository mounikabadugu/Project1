package com.mounika.DaoImpl;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mounika.model.Product;
import com.mounika.model.User;

@Component
public class UserDaolmpl {
    @Autowired
	SessionFactory sessionFactory;
    public void addUser(User user)
	{
		Session sess=sessionFactory.openSession();
		user.setRole("USER_NAME");;
		user.setEnabled(true);
		sess.save(user);
		Transaction transaction=sess.beginTransaction();
		transaction.commit();
		sess.close();
	}
	public boolean checkLoginSucess(User user)
	{
	
		Session sess=sessionFactory.openSession();
		 Query query=sess.createQuery("from User where email=:em and password=:pw");
		 query.setParameter("em",user.getEmail());
		 query.setParameter("pw",user.getMobileNo());
		Object object=query.uniqueResult();
		User user1=(User)object;
		if(user1==null)
		{
			return true;
		}
		else
		{
			return false;
		}
    }
}
