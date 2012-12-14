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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 

public class UtilisateurInfos extends HttpServlet {

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {


    HttpSession mySession = request.getSession();

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
    UtilisateurService myUtService=null; 
    ProduitService myPrService=null;
       
        myUtService = (UtilisateurService)context.getBean("utilisateurService");
        myPrService = (ProduitService)context.getBean("produitService");


    int myId = Integer.parseInt( request.getParameter("userID") );
    
    List<Produit> listeproduits = myPrService.findProduitsByUtilisateur(myId);
   
    
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