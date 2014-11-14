package com.PL.Spring.Service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.PL.Spring.Metier.UtilisateurServiceImp;
import com.PL.Spring.Metier.UtilisateurServiceInt;

public class TestService {

	private static ClassPathXmlApplicationContext context;
	private static UtilisateurServiceInt userService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		userService=(UtilisateurServiceInt) context.getBean("userService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}


	@Test
	public void testGetUsersByProperties() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllUsers() {
		fail("Not yet implemented");
	}

}
