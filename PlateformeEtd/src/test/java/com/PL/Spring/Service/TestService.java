package com.PL.Spring.Service;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.PL.Spring.Metier.UtilisateurServiceImp;
import com.PL.Spring.Metier.UtilisateurServiceInt;

public class TestService {

	@Autowired
	
	private static UtilisateurServiceInt metier;
	/*
	private static ClassPathXmlApplicationContext context;
	private static UtilisateurServiceInt metier;
	*/
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		//context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		//metier=(UtilisateurServiceInt) context.getBean("metier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	//	context.close();
	}


	@Test
	public void testGetUsersByProperties() {
		
		Map<String,Object>props=new TreeMap();
		props.put("nom","amnay");
		System.out.println(metier.getUsersByProperties(props) );
	}

	@Test
	public void testGetAllUsers() {
		System.out.println(metier.getAllUsers());
	}

}
