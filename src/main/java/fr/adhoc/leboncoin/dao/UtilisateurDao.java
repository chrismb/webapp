package fr.adhoc.leboncoin.dao;

import java.util.List;

import fr.adhoc.leboncoin.model.Utilisateur;

public interface UtilisateurDao {
	Utilisateur create(Utilisateur utilisateur);
	Utilisateur findById(int U_ID);
	List<Utilisateur> findByName(String nom);
	Utilisateur findByMail(String mail);
	List<Utilisateur> findAll();
	Utilisateur findByNameAndMail(String nom,String mail);
	boolean delete(Utilisateur utilisateur);
}