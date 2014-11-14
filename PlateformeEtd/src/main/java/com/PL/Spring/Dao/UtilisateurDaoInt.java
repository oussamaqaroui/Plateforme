package com.PL.Spring.Dao;

import java.util.List;
import java.util.Map;

import com.PL.Spring.Entities.Utilisateur;

public interface UtilisateurDaoInt {
	
	public List<Utilisateur> getAllUsers();
	public List<Utilisateur> getUsersByProperties(Map<String,Object> Props);
	
	
}
