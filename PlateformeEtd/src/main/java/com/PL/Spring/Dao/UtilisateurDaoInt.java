package com.PL.Spring.Dao;

import java.util.List;
import java.util.Map;

import com.PL.Spring.Entities.Utilisateur;

public interface UtilisateurDaoInt {
	
	public List<Utilisateur> getAllUsers();
	public List<Utilisateur> getUsersByProperties(Map<String,Object> Props);
	public boolean supprimerUtilisateur(Utilisateur user);
	public boolean modifierUtilisateur(Utilisateur user);
	public Long ajouterUtilisateur(Utilisateur user);
	public Utilisateur getUser(long ID);
	
	
}
