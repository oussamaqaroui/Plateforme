package com.PL.Spring.Service;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

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
		
		Map<String,Object>props=new TreeMap();
		props.put("nom","amnay");
		System.out.println(userService.getUsersByProperties(props) );
	}

	@Test
	public void testGetAllUsers() {
		System.out.println(userService.getAllUsers());
	}

}
