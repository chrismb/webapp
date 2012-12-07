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


    HttpSession mySession = request.getSession();
    PrintWriter out = response.getWriter();
    UtilisateurService myUtService=null; 
    try{
        myUtService = new UtilisateurServiceImpl();
    }catch (Exception e) {
            out.println(e);
    }

    

    mySession.setAttribute("listeUt", myUtService.findAllUtilisateurs());
    RequestDispatcher view = request.getRequestDispatcher("/liste.jsp");
    view.forward(request, response);   

        out.flush();
        out.close();
    }
}