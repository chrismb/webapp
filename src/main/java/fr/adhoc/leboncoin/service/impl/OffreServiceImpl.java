package fr.adhoc.leboncoin.service.impl;

import java.sql.*;


import fr.adhoc.leboncoin.model.Produit;
import fr.adhoc.leboncoin.model.Offre;
import fr.adhoc.leboncoin.model.Utilisateur;
import fr.adhoc.leboncoin.utils.DbUtils;
import fr.adhoc.leboncoin.dao.ProduitDao;
import fr.adhoc.leboncoin.dao.impl.ProduitDaoImpl;
import fr.adhoc.leboncoin.dao.OffreDao;
import fr.adhoc.leboncoin.dao.impl.OffreDaoImpl;
import fr.adhoc.leboncoin.dao.UtilisateurDao;
import fr.adhoc.leboncoin.dao.impl.UtilisateurDaoImpl;
import fr.adhoc.leboncoin.service.OffreService;

import java.util.List;
import java.util.ArrayList;




public class OffreServiceImpl implements OffreService {
	private OffreDao myDao;
	private UtilisateurDao utDao;
	private ProduitDao prodDao;
	
	public OffreServiceImpl() throws SQLException, Exception {
		 this.myDao = new OffreDaoImpl();
		 this.utDao = new UtilisateurDaoImpl();
		 this.prodDao = new ProduitDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Offre createOffre(Double montant, Utilisateur acheteur,Produit produit){

		//Business rules
		/*
		*	montant>0 montant peut etre inferieur au prix de depart

		*	L'acheteur ne peux pas etre le proprietaire du produit
		*	L'acheteur est bien dans la base de données
		*	Le produit est bien dans la base de données
		*/
		boolean busrulesOK = true;


		//	montant>0 ,montant peut etre inferieur au prix de depart
			if(montant <= 0){
				busrulesOK = false;
				System.out.println("Montant invalide");
			}
		//	L'acheteur ne peux pas etre le proprietaire du produit
			if(acheteur.getID() == produit.getVendeur().getID()){
				busrulesOK = false;
				System.out.println("Proprietaire = Acheteur");
			}
		//	L'acheteur est bien dans la base de données
			 
			if(acheteur.getID() == 0 || utDao.findById(acheteur.getID()) == null){
				busrulesOK = false;
				System.out.println("Acheteur inconnu");
			}
		//	Le produit est bien dans la base de données
			
			if(produit.getID() == 0 || prodDao.findById(produit.getID()) == null){
				busrulesOK = false;
				System.out.println("Produit inconnu");
			}


		if (busrulesOK){
			//Creation de l'objet Offre
			Offre myOffre = new Offre(montant,acheteur,produit);
			
			//Stockage de myUt dans la base de donnees
			myDao.create(myOffre);
	     
	     	return myOffre;
	     }
	     else{
	     	System.out.println("Probleme rencontre");
	     	return null;
	     }	
	}

	public List<Offre> findAllOffres(){
		return myDao.findAll();
	}

	public boolean deleteOffre(int id){
		return myDao.delete(new Offre(id));
	}

	public Offre findOffreById(int id){
		return myDao.findById(id);
	}

}
