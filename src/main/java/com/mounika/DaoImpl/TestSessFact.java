package com.mounika.DaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestSessFact {
	
	@Autowired
	
	SessionFactory s;
	public void Test()
	{
		System.out.print(s);	
	}

}
