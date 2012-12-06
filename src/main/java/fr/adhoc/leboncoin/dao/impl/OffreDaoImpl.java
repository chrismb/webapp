package fr.adhoc.leboncoin.dao.impl;

import java.sql.*;
import java.util.List;

import java.util.ArrayList;
import java.text.SimpleDateFormat;

import fr.adhoc.leboncoin.model.Offre;
import fr.adhoc.leboncoin.model.Produit;
import fr.adhoc.leboncoin.model.Utilisateur;
import fr.adhoc.leboncoin.utils.DbUtils;
import fr.adhoc.leboncoin.dao.OffreDao;
import fr.adhoc.leboncoin.dao.UtilisateurDao;
import fr.adhoc.leboncoin.dao.ProduitDao;




public class OffreDaoImpl implements OffreDao {
	private DbUtils myDbUtils;
	
	
	public OffreDaoImpl() throws SQLException, Exception {
		 this.myDbUtils = new DbUtils();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Offre create(Offre offre){
		
        try{		
		//Stockage dans la basede donnees
        Statement stmt = myDbUtils.getStatement();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        

        String str = "INSERT INTO Offre (MONTANT,DATE,STATUT,A_ID,P_ID) VALUES (" + 
        								offre.getMontant() + ",'" + 
        								ft.format(offre.getDate()) + "','" + 
        								offre.getStatut() + "'," +
        								offre.getAcheteur().getID() + "," +
        								offre.getProduit().getID() + ")";

        stmt.execute(str);
        ResultSet rslt = stmt.executeQuery("SELECT * FROM Offre WHERE MONTANT="+ offre.getMontant() + " AND A_ID=" + offre.getAcheteur().getID() + " AND P_ID=" + offre.getProduit().getID());
        	if (rslt.next()){
        		offre.setID(rslt.getInt("O_ID"));
        		rslt.close();
				stmt.close();
        		return offre;
	        }else{
	        	rslt.close();
				stmt.close();
	        	return null;
	        }
        }
        catch (SQLException e) {
        	System.out.println(e);
        	return null;
        }
	}

		public Offre findById(int O_ID) {
	        try {	
		//Recherche dans la basede donnees
        Statement stmt = myDbUtils.getStatement();
        
        ResultSet rslt = stmt.executeQuery("SELECT * FROM Offre WHERE O_ID="+ O_ID );
        
        //Instantiation d'une offre
        
        //Instantiation du acheteur

        UtilisateurDao acht = new UtilisateurDaoImpl();
		ProduitDao prod = new ProduitDaoImpl();
        Offre myOffre = new Offre();
			if  (rslt.next()){
				myOffre.setID(rslt.getInt("O_ID"));
				myOffre.setMontant(rslt.getDouble("MONTANT"));
				myOffre.setDate(rslt.getDate("DATE"));
				myOffre.setStatut(rslt.getString("STATUT"));
				myOffre.setAcheteur( acht.findById( rslt.getInt("A_ID") ) );
				myOffre.setProduit( prod.findById( rslt.getInt("P_ID") ) );
			rslt.close();
			stmt.close();
			return myOffre;
			}else{
				rslt.close();
				stmt.close();
        		return null;
        	}
			
		} catch (SQLException e) {
				System.out.println(e);
				return null;

		} catch (Exception e) {
				System.out.println(e);
				return null;
		}
        
	}

	public List<Offre> findAll(){
		List<Offre> liste = new ArrayList<Offre>();
		try{
			Statement stmt = myDbUtils.getStatement();
			ResultSet rslt = stmt.executeQuery("SELECT * FROM OFFRE");
			while(rslt.next()){
				Offre of = new Offre();
				UtilisateurDao acht = new UtilisateurDaoImpl();
				ProduitDao prod = new ProduitDaoImpl();
				of.setID(rslt.getInt("O_ID"));
				of.setMontant(rslt.getDouble("MONTANT"));
				of.setDate(rslt.getDate("DATE"));
				of.setStatut(rslt.getString("STATUT"));
				of.setAcheteur( acht.findById( rslt.getInt("A_ID") ) );
				of.setProduit( prod.findById( rslt.getInt("P_ID") ) );

				liste.add(of);
			}
			rslt.close();
			stmt.close();
		}catch(SQLException e){
			System.out.println(e);
			return null;	
		}catch (Exception e) {
        	System.out.println(e);
        	return null;
        }
		return liste;
	}

		public boolean delete(Offre offre){
		try{
			String str = "DELETE FROM Offre WHERE O_ID=" + offre.getID();
			Statement stmt = myDbUtils.getStatement();
       		stmt.execute(str);
       		stmt.close();
        	return true;
        } catch (SQLException e) {
			System.out.println("Offre n°" + offre.getID() + " non efface.");
				return false;
		}
	}

}
