package com.mounika.DaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestingSessionFactory {
	@Autowired
	SessionFactory session;
	public void TestingSessionFactory()
	{
		System.out.print(session);
		
	}

}
