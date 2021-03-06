package com.PL.Spring.Entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="utilisateurs")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long ID;
	@NotEmpty
	private String login;
	@NotEmpty
	private String password;//Penser a une fonction de hachage par la suite
	@NotEmpty
	private String nom;
	@NotEmpty
	private String prenom;
	@NotEmpty
	private String email;
	@Lob
	private byte[] photo;
	
	private boolean active;//Pour savoir si le compte est activ� ou pas
	
	private Date dateNaissance;
	
	private String adresse;
	
	private Date dateCreation;
	
	private Date dateModification;
	
	
	
	
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 


	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	 
	public Utilisateur(String login, String password, String nom,
			String prenom, String email, byte[] photo, boolean active,
			Date dateNaissance, String adresse, Date dateCreation,
			Date dateModification) {
		super();
		
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.photo = photo;
		this.active = active;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
	}
	@Override
	public String toString() {
		return "Utilisateur [ID=" + ID + ", login=" + login + ", password="
				+ password + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", photo=" + photo + ", active="
				+ active + "]";
	}
	
	public Utilisateur(){
		super(); 
		//ID=-1;//Pour diff�rencier les instances r�cup�r�es de la base et celles cr��es
		}
	

}
