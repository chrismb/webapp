package fr.adhoc.leboncoin.service.impl;

import java.sql.*;


import fr.adhoc.leboncoin.model.Produit;
import fr.adhoc.leboncoin.utils.DbUtils;
import fr.adhoc.leboncoin.dao.ProduitDao;
import fr.adhoc.leboncoin.dao.impl.ProduitDaoImpl;
import fr.adhoc.leboncoin.service.ProduitService;
import fr.adhoc.leboncoin.model.Utilisateur;
import java.util.List;
import java.util.ArrayList;




public class ProduitServiceImpl implements ProduitService {
	private ProduitDao myDao;
	
	public ProduitServiceImpl() throws SQLException, Exception {
		 this.myDao = new ProduitDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Produit createProduit(String nom, double prixDepart, String description, Utilisateur vendeur){

			//Creation de l'objet Produit
			Produit myPro = new Produit(nom,prixDepart,description, vendeur);
			
			//Stockage de myUt dans la base de donnees
			myDao.create(myPro);
	     
	     return myPro;
	        
	    
		
		
	}
	public List<Produit> findProduitByName(String nom){
		return myDao.findByName(nom);
	}
	public List<Produit> findAllProduits(){
		return myDao.findAll();
	}
		public boolean deleteProduit(int id){
		Produit myProd = new Produit("",0,"",new Utilisateur());
		myProd.setID(id);
		return myDao.delete(myProd);
	}

}
