package com.PL.String.Metier;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.PL.Spring.Dao.UtilisateurDaoImp;
import com.PL.Spring.Entities.Utilisateur;

@Transactional
public class UtilisateurServiceImp implements UtilisateurServiceInt{
	
	private UtilisateurDaoImp utilisateurDaoImp;
	
	@SuppressWarnings("rawtypes")
	public List<Utilisateur>getUsersByProperties(Map<String,Object> Props)
	{
		return this.utilisateurDaoImp.getUsersByProperties(Props);
	}
	
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAllUsers()
	{
		return this.utilisateurDaoImp.getAllUsers();
	}

}
