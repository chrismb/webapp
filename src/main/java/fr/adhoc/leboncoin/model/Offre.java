package fr.adhoc.leboncoin.model;
import java.util.Date;
import java.util.Date;	



public class Offre {
	
	private int O_ID;
	private double montant;
	private Date date;
	//private enum Statut {Attente, Acceptee, Refusee};
	private String statut;
	private Utilisateur acheteur;
	private Produit produit;
	
	
	
	//------------------------------------------------------
	//	Constructeurs
	//------------------------------------------------------

	
	public Offre() {
		// TODO Auto-generated constructor stub
	}

	public Offre(int id) {
		this.O_ID = id;
	}

	public Offre(double montant, Utilisateur acheteur, Produit produit) {
		super();
		this.montant = montant;
		this.acheteur = acheteur;
		this.produit = produit;
		Date madate = new Date();
        this.date = madate;
        this.statut = "Attente";



	}


	//------------------------------------------------------
	//	Get/Set
	//------------------------------------------------------





	public int getID() {
		return O_ID;
	}



	public void setID(int iD) {
		O_ID = iD;
	}



	public double getMontant() {
		return montant;
	}



	public void setMontant(double montant) {
		this.montant = montant;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
	}



	public Utilisateur getAcheteur() {
		return acheteur;
	}



	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}



	public Produit getProduit() {
		return produit;
	}



	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	


	
	
	

}
