package fr.adhoc.leboncoin.service;

import java.util.List;

import fr.adhoc.leboncoin.model.Produit;
import fr.adhoc.leboncoin.model.Utilisateur;
import java.util.List;
import java.util.ArrayList;

public interface ProduitService {
	Produit createProduit(String nom, double prixDepart, String description, Utilisateur vendeur);
	List<Produit> findAllProduits();
	List<Produit> findProduitByName(String nom);
	boolean deleteProduit(int id);
}