package fr.adhoc.myWebbApp.web;

import fr.adhoc.leboncoin.service.UtilisateurService;
import fr.adhoc.leboncoin.model.Utilisateur;
import fr.adhoc.leboncoin.service.impl.UtilisateurServiceImpl;
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
    try{
        myUtService = new UtilisateurServiceImpl();
    }catch (Exception e) {
            //out.println(e);
    }

    int myId = Integer.parseInt( request.getParameter("userID") );
    mySession.setAttribute("listeUtilisateurs", myUtService.findAllUtilisateurs());
    mySession.setAttribute( "infosutilisateursnom", myUtService.findUtilisateurById( myId ).getNom() );
    mySession.setAttribute("infosutilisateursmail", myUtService.findUtilisateurById( myId ).getMail());
    RequestDispatcher view = request.getRequestDispatcher("/infos.jsp");
    view.forward(request, response);   
    }
}