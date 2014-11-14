package com.PL.Spring.Metier;

import java.util.List;
import java.util.Map;

import com.PL.Spring.Entities.Utilisateur;

public interface UtilisateurServiceInt {
	
	public List<Utilisateur> getAllUsers();
	public List<Utilisateur> getUsersByProperties(Map<String,Object> Props);
	public boolean supprimerUtilisateur(Utilisateur user);
	public boolean modifierUtilisateur(Utilisateur user);
	public void ajouterUtilisateur(Utilisateur user);
	public Utilisateur getUser(Long idUser);
}
