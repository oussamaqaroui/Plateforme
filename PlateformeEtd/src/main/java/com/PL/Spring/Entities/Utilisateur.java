package com.PL.Spring.Entities;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long ID;
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
	@NotEmpty
	private int active;//Pour savoir si le compte est activé ou pas
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
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
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	
	public Utilisateur(long iD, String login, String password, String nom,
			String prenom, String email, byte[] photo, int active) {
		super();
		ID = iD;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.photo = photo;
		this.active = active;
	}
	@Override
	public String toString() {
		return "Utilisateur [ID=" + ID + ", login=" + login + ", password="
				+ password + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", photo=" + Arrays.toString(photo) + ", active="
				+ active + "]";
	}
	

}
