package fr.adhoc.leboncoin.dao;

import java.util.List;

import fr.adhoc.leboncoin.model.Offre;

public interface OffreDao {
	Offre create(Offre offre);
	Offre findById(int O_ID);
	List<Offre> findAll();
	boolean delete(Offre offre);
}