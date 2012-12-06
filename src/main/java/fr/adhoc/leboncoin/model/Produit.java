package fr.adhoc.leboncoin.model;
import java.util.Set;


public class Produit {

	private int P_ID;
	private String nom;
	private double prixDepart;
	private String description;
	private Set<Offre> listeOffres;
	private Utilisateur vendeur;
	
	//------------------------------------------------------
	//	Constructeurs
	//------------------------------------------------------
	public Produit() {
		// TODO Auto-generated constructor stub
	}
	
	public Produit(Utilisateur vendeur) {
		super();
		this.vendeur = vendeur;
	}
	public Produit(String nom, double prixDepart, String description, Utilisateur vendeur) {
		super();
		this.nom = nom;
		this.prixDepart = prixDepart;
		this.description = description;
		this.vendeur = vendeur;
	}
	


	//------------------------------------------------------
	//	Get/Set
	//------------------------------------------------------
	
	





	public int getID() {
		return P_ID;
	}

	public void setID(int iD) {
		P_ID = iD;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrixDepart() {
		return prixDepart;
	}

	public void setPrixDepart(double prixDepart) {
		this.prixDepart = prixDepart;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Offre> getListeOffres() {
		return listeOffres;
	}

	public void setListeOffres(Set<Offre> listeOffres) {
		this.listeOffres = listeOffres;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}


}