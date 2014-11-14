package com.PL.Spring.Controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	


	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("user", new Utilisateur());
		model.addAttribute("users",metier.getAllUsers());
		return "users";
	}
	
	@RequestMapping(value="/saveUser")
	public String saveUser(@Valid Utilisateur user,BindingResult bindingResult,Model model,MultipartFile file) throws IOException{
		if(bindingResult.hasErrors()){
			model.addAttribute("users",metier.getAllUsers());
			return("users");
		}
		
		if(!file.isEmpty())
		{
			//String path=System.getProperty("java.io.tmpdir");
			//user.setPhoto(file.getOriginalFilename());
			
			BufferedImage originalImage = ImageIO.read(new File(file.getOriginalFilename()));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( originalImage, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			
			user.setPhoto(imageInByte);

		}
		
		if(user.getID()==-1)metier.ajouterUtilisateur(user);
		else  metier.modifierUtilisateur(user);
		
	
		
		model.addAttribute("user", new Utilisateur());	
		model.addAttribute("users",metier.getAllUsers());
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