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

    int userID = Integer.parseInt( request.getParameter("userID") );
    PrintWriter out = response.getWriter();
    UtilisateurService myUtService=null; 
    try{
        myUtService = new UtilisateurServiceImpl();
    }catch (Exception e) {
            out.println(e);
    }
        out.println("<table>");
        out.println("<tr>");
            out.println("<td>");
                out.println("<FORM ACTION=\"/myWebApp/listeUt\" METHOD=\"POST\">");
                out.println("<H1>Utilisateurs : </H1>");
                out.println("<SELECT NAME=\"userID\">");
                for(Utilisateur ut: myUtService.findAllUtilisateurs()){
                    out.println("<OPTION VALUE=\""+ut.getID()+"\">");
                    out.print(ut.getNom());
                } 
                out.println("</SELECT>"); 
                out.println("<BUTTON type=\"submit\" class=\"btn btn-primary\">Infos utilisateur</BUTTON>");
                out.println("</FORM>");
            out.println("</td>");
        


            if (userID != 0){ 
                Utilisateur user = myUtService.findUtilisateurById(userID);
            out.println("<td>");
                out.println("<table>");
                    out.println("<tr>");
                        out.println("<td>");
                            out.println("<H2>");
                            out.print("Name : ");
                            out.println("</H2>");
                        out.println("</td>");
                        out.println("<td>");
                            out.println( user.getNom() );
                        out.println("</td>");
                    out.println("</tr>");    
                    out.println("<tr>");
                        out.println("<td>");
                            out.println("<H2>");
                            out.print("Mail : ");
                            out.println("</H2>");
                        out.println("</td>");
                        out.println("<td>");
                            out.println( user.getMail() );
                        out.println("</td>");
                    out.println("</tr>");
                out.println("<table>");
            out.println("</td>");      
            }

        out.println("</tr>"); 
        out.println("</table>");   

        out.flush();
        out.close();
    }
}