package fr.adhoc.leboncoin.app;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import fr.adhoc.leboncoin.utils.DbUtils;




import fr.adhoc.leboncoin.service.impl.UtilisateurServiceImpl;
import fr.adhoc.leboncoin.service.UtilisateurService;
import fr.adhoc.leboncoin.model.Utilisateur;

import fr.adhoc.leboncoin.service.impl.ProduitServiceImpl;
import fr.adhoc.leboncoin.service.ProduitService;
import fr.adhoc.leboncoin.model.Produit;

import fr.adhoc.leboncoin.service.impl.OffreServiceImpl;
import fr.adhoc.leboncoin.service.OffreService;
import fr.adhoc.leboncoin.model.Offre;


public class LeboncoinTest {


    private static DbUtils myDbUtils;


	public LeboncoinTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Statement stmt;
		ResultSet rslt = null;
        myDbUtils = new DbUtils();
		
        stmt = myDbUtils.getStatement();//Cree un stmt pour la bd correspondant a la connexion conn

        
        String str="";
        Scanner user_input = new Scanner( System.in );
 /*
        //Ajout d'un nouvel utilisateur
        System.out.println("Ajout d'un utilisateur");
        //user_input = new Scanner( System.in );
        //Fixe le nom
        System.out.print("Votre nom : ");//Pour l'instant on ne teste pas si il appartient a la BD
        String U_nom = user_input.next( );
        
        //Fixe le mail
        System.out.print("Votre mail : ");//Pour l'instant on ne teste pas si il appartient a la BD
        String mail = user_input.next( );

        
        UtilisateurService myUtService = new UtilisateurServiceImpl();
        myUtService.createUtilisateur(U_nom,mail);
*/
        UtilisateurService myUtService = new UtilisateurServiceImpl();
        
        System.out.println("Liste des Utilisateurs");

        for(Utilisateur ut: myUtService.findAllUtilisateurs()){
            System.out.println(ut.getID() + "\t" + ut.getNom());
        }





/*
        
        //Ajout d'un nouveau produit

        System.out.println("Ajout d'un produit");
        //user_input = new Scanner( System.in );
        //Fixe le nom
        System.out.print("Votre nom : ");//Pour l'instant on ne teste pas si il appartient a la BD
        String V_nom = user_input.next( );
        //Fixe le nom du produit
        System.out.print("Nom du produit : ");//Pour l'instant on ne teste pas si il appartient a la BD
        String P_nom = user_input.next( );
        //Fixe la description
        System.out.print("Description du produit : ");
        user_input.nextLine( );
        String description = user_input.nextLine( );
        //Fixe le prix de depart
        System.out.print("A combien ? ");
        double prixDepart = user_input.nextDouble( );
 
        //recherche l'utilisateur au nom donne en supposant qu'il n'y en a qu'un
        ProduitService myProdService = new ProduitServiceImpl();
        Utilisateur vendeur = myUtService.findUtilisateurByName(V_nom).iterator().next();

        myProdService.createProduit(P_nom,prixDepart,description,vendeur);


*/

        ProduitService myProdService = new ProduitServiceImpl();




        System.out.println("Liste des Produits");

        for(Produit prod: myProdService.findAllProduits()){
            System.out.println(prod.getID() + "\t" + prod.getNom());
        }




/*

        //Ajout d'une nouvelle offre

        System.out.println("Ajout d'une offre");
        //user_input = new Scanner( System.in );
        //Fixe le nom
        System.out.print("Votre nom : ");
        String V_nom = user_input.next( );
        //Fixe le nom du produit
        System.out.print("Nom du produit : ");
        String P_nom = user_input.next( );
        //Fixe le montant
        System.out.print("montant : ");
        
        Double montant = user_input.nextDouble( );

 
        //recherche l'utilisateur au nom donne en supposant qu'il n'y en a qu'un
        Utilisateur acheteur = myUtService.findUtilisateurByName(V_nom).iterator().next();

        //recherche le produit au nom donne en supposant qu'il n'y en a qu'un
        
        Produit produit = myProdService.findProduitByName(P_nom).iterator().next();

        OffreService myOfService = new OffreServiceImpl();
        myOfService.createOffre(montant,acheteur,produit);




*/
        OffreService myOfService = new OffreServiceImpl();




        
        System.out.println("Liste des Offres");

        for(Offre offre: myOfService.findAllOffres()){
            System.out.println(offre.getID() + "\t" + offre.getMontant());
        }





        myDbUtils.getConnection().close();
	}

}
