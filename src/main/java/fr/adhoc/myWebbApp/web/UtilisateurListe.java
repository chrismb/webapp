package fr.adhoc.myWebbApp.web;

import fr.adhoc.leboncoin.service.UtilisateurService;
import fr.adhoc.leboncoin.model.Utilisateur;
import fr.adhoc.leboncoin.service.impl.UtilisateurServiceImpl;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class UtilisateurListe extends HttpServlet {

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {


    HttpSession mySession = request.getSession();
     ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
     //ApplicationContext context = new FileSystemXmlApplicationContext("/Users/marshall/code/leboncoin/src/main/resources/applicationContext.xml");
    UtilisateurService myUtService=null; 
    
       System.out.println(context);
        myUtService = (UtilisateurService)context.getBean("utilisateurService");
        


    mySession.setAttribute("listeUtilisateurs", myUtService.findAllUtilisateurs());
    RequestDispatcher view = request.getRequestDispatcher("/liste.jsp");
    view.forward(request, response);   

    }
}