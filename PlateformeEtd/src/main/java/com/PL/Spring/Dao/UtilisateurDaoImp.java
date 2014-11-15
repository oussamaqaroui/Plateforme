package com.PL.Spring.Dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.PL.Spring.Entities.Utilisateur;

public class UtilisateurDaoImp implements UtilisateurDaoInt{

	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	
	@SuppressWarnings("rawtypes")
	public List<Utilisateur>getUsersByProperties(Map<String,Object> Props)
	{
		/*Syntaxe :
		 * query = entityManager.createQuery("select o from MyTestObject o where o.income = :income and o.age = :age");
		   query.setParameter("income", 50507.0);
	       query.setParameter("age", 12);
		   List<MyTestObject> obs = query.getResultList();
		 */
		
		
		String req=new String("select o from Utilisateur o where ");
		
		//Construction de la requete
		
		Iterator it=Props.keySet().iterator();
		
		while(it.hasNext())
		{
			String aide =(String)it.next();
			req+="o."+aide+" = :"+aide;
			if(it.hasNext())req+=" and ";
		}
		
		//Creation de la requete 
		Query query=this.em.createQuery(req);
		
		//Affectation des parametre
		for(Entry<String,Object> e:Props.entrySet())
		{
			query.setParameter(e.getKey(), e.getValue());
		}
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAllUsers()
	{
		Query query=this.em.createQuery("SELECT o from Utilisateur o");
		return query.getResultList();
	}

	
	@Override
	public Utilisateur getUser(long ID) {
		
		return em.find(Utilisateur.class, ID);
	}

	@Override
	public boolean supprimerUtilisateur(Utilisateur user) {
		if(user==null) return false;
		Utilisateur u=em.getReference(Utilisateur.class, user.getID());
		em.remove(u);
		return true;
	}

	@Override
	public boolean modifierUtilisateur(Utilisateur user) {
		this.em.merge(user);
		return false;
	}

	@Override
	public Long ajouterUtilisateur(Utilisateur user) {
		em.persist(user);
		return user.getID();
	}

	
	
}
