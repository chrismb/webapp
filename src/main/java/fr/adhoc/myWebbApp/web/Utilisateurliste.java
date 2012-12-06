package fr.adhoc.myWebbApp.web;

import fr.adhoc.leboncoin.service.UtilisateurService;
import fr.adhoc.leboncoin.model.Utilisateur;
import fr.adhoc.leboncoin.service.impl.UtilisateurServiceImpl;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Utilisateurliste extends HttpServlet {

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    UtilisateurService myUtService=null; 
    try{
        myUtService = new UtilisateurServiceImpl();
    }catch (Exception e) {
            out.println(e);
    }
        
        
        out.println("<H1>Liste des Utilisateurs : </H1>");
        out.println("<SELECT NAME=\"Utilisateur\">");
        for(Utilisateur ut: myUtService.findAllUtilisateurs()){
            out.println("<OPTION VALUE=\"Utilisateur\""+ut.getID());
            out.print(">");
            out.print(ut.getNom());
        } 
        out.println("</SELECT>");       

        out.flush();
        out.close();
    }
}