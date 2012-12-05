package fr.adhoc.myWebbApp.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("Votre nom est : " + request.getParameter("nom"));
        out.flush();
        out.close();
    }
}