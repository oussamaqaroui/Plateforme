package com.PL.Spring.Controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.PL.Spring.Entities.Utilisateur;
import com.PL.Spring.Metier.UtilisateurServiceInt;

@Controller
@RequestMapping(value="adminUsers")
public class AdminUsersController {

	@Autowired
	private UtilisateurServiceInt metier;
	


	@InitBinder
	public void initBinder(WebDataBinder binder) {

	   SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	   dateFormat.setLenient(false);
	   binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("user", new Utilisateur());
		model.addAttribute("users",metier.getAllUsers());
		return "users";
	}
	
	@RequestMapping(value="/saveUser",params="save")
	public String saveUser(Utilisateur u,BindingResult bindingResult,Model model,MultipartFile file) throws IOException{
		/*
		if(bindingResult.hasErrors()){
			model.addAttribute("user", new Utilisateur());
			model.addAttribute("users",metier.getAllUsers());
			
			return("users");
		}
		
		*/
		
		
		if(!file.isEmpty()){
			String path=System.getProperty("java.io.tmpdir");
			u.setPhoto(file.getOriginalFilename());
			Long idP=null;
			if(u.getID() == null){
			  idP = metier.ajouterUtilisateur(u);
			}
			else{
			  metier.modifierUtilisateur(u);
			  idP=u.getID();
			}
			file.transferTo(new File(path+"/"+"PROD_"+idP+"_"+file.getOriginalFilename()));
		}
		else{
			if(u.getID()==null)
			  metier.ajouterUtilisateur(u);
			else metier.modifierUtilisateur(u);
		}
		
		
	
		
		/*if(u.getID()==-1)metier.ajouterUtilisateur(u);
		else  metier.modifierUtilisateur(u);*/
		
	
		
		model.addAttribute("user", new Utilisateur());	
		model.addAttribute("users",metier.getAllUsers());
		return "users";
	}
	
	@RequestMapping(value="/saveUser",params="find")
	public String findUsers(Utilisateur u,BindingResult bindingResult,Model model,MultipartFile file) throws IOException{
		/*
		if(bindingResult.hasErrors()){
			model.addAttribute("user", new Utilisateur());
			model.addAttribute("users",metier.getAllUsers());
			
			return("users");
		}
		
		*/
		Map<String,Object> props=new TreeMap<String,Object>();
		
		if(u.getID()!=null) props.put("ID", u.getID());
		else
		{
			if(u.getLogin()!=null && !u.getLogin().equals(""))props.put("login",u.getLogin());
			if(u.getNom()!=null && !u.getNom().equals(""))props.put("nom", u.getNom());
			if(u.getPrenom()!=null && !u.getPrenom().equals(""))props.put("prenom",u.getPrenom());
			if(u.getEmail()!=null && !u.getEmail().equals(""))props.put("email",u.getEmail());
			if(u.getDateNaissance()!=null && !u.getDateNaissance().equals("")) 
				props.put("dateNaissance", u.getDateNaissance());
			if(u.getAdresse()!=null && !u.getAdresse().equals("")) props.put("adresse", u.getAdresse());
			//if(u.getActive()==true)props.put("active", 1);
			props.put("active",u.getActive());
			
			
			
		}
		
		model.addAttribute("user", new Utilisateur());	
		model.addAttribute("users",metier.getUsersByProperties(props));
		return "users";
	}
	@RequestMapping(value="photoUser",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public  byte[] photoUser(Long userID) throws IOException{
		//Comment afficher une image
		return null;
	}
	
	
	@RequestMapping(value="/suppUser")
	public String supp(long userID,Model model){
		Utilisateur u=metier.getUser(userID);
		metier.supprimerUtilisateur(u);
		model.addAttribute("user", new Utilisateur());	
		model.addAttribute("users",metier.getAllUsers());
		return "users";
	}
	@RequestMapping(value="/editUser")
	public String edit(long userID,Model model){
		Utilisateur u=metier.getUser(userID);
		model.addAttribute("user", u);	
		model.addAttribute("users",metier.getAllUsers());
		return "users";
	}
	

}
