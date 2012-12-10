package fr.adhoc.myWebbApp.web;

import fr.adhoc.leboncoin.service.UtilisateurService;
import fr.adhoc.leboncoin.model.Utilisateur;
import fr.adhoc.leboncoin.service.impl.UtilisateurServiceImpl;
import fr.adhoc.leboncoin.service.ProduitService;
import fr.adhoc.leboncoin.model.Produit;
import fr.adhoc.leboncoin.service.impl.ProduitServiceImpl;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Utilisateurinfos extends HttpServlet {

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {


    HttpSession mySession = request.getSession();

    UtilisateurService myUtService=null; 
    ProduitService myPrService=null; 
    try{
        myUtService = new UtilisateurServiceImpl();
    }catch (Exception e) {
            //out.println(e);
    }
    try{
        myPrService = new ProduitServiceImpl();
    }catch (Exception e) {
            //out.println(e);
    }

    int myId = Integer.parseInt( request.getParameter("userID") );
    List<Produit> listeproduits = new ArrayList<Produit>();
   for(Produit prod : myPrService.findAllProduits() ){

        if( prod.getVendeur().getId() == myId ){
            listeproduits.add(prod);
        }
    }
    
    int check = 0;
    if (listeproduits != null){
        mySession.setAttribute( "listeProduits", listeproduits );
        check=1;

    }
    mySession.setAttribute( "listeProduitsnotnull", check );
    
    mySession.setAttribute( "Utilisateur", myUtService.findUtilisateurById( myId ) );
    
    RequestDispatcher view = request.getRequestDispatcher("/infos.jsp");
    view.forward(request, response);   
    }
}