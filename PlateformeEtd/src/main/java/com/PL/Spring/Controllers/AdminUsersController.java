package com.PL.Spring.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.PL.Spring.Entities.Utilisateur;
import com.PL.Spring.Metier.UtilisateurServiceInt;

@Controller
@RequestMapping(value="adminUsers")
public class AdminUsersController implements HandlerExceptionResolver{

	@Autowired
	private UtilisateurServiceInt metier;
	


	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("user", new Utilisateur());
		model.addAttribute("users",metier.getAllUsers());
		return "users";
	}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// TODO Auto-generated method stub
		return null;
	}

}
