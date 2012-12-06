package fr.adhoc.leboncoin.service;

import java.util.List;
import java.util.List;
import java.util.ArrayList;

import fr.adhoc.leboncoin.model.Utilisateur;

public interface UtilisateurService {
	Utilisateur createUtilisateur(String nom, String mail);
	List<Utilisateur> findAllUtilisateurs();
	List<Utilisateur> findUtilisateurByName(String nom);
	Utilisateur findUtilisateurById(int id);
	Utilisateur findUtilisateurByNameAndMail(String nom, String mail);
	boolean deleteUtilisateur(int id);
}