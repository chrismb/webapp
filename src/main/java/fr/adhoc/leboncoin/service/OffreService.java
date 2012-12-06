package fr.adhoc.leboncoin.service;

import java.util.List;

import fr.adhoc.leboncoin.model.Produit;
import fr.adhoc.leboncoin.model.Offre;
import fr.adhoc.leboncoin.model.Utilisateur;
import java.util.List;
import java.util.ArrayList;

public interface OffreService {
	Offre createOffre(Double montant, Utilisateur acheteur,Produit produit);
	List<Offre> findAllOffres();
	boolean deleteOffre(int id);
	Offre findOffreById(int id);

}