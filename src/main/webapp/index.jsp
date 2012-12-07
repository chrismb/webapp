<html>
<head>
	<link type="text/css" href="static/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<script src="static/js/bootstrap.js">
	</script>

<%@ page import="fr.adhoc.leboncoin.service.UtilisateurService" %>
<%@ page import="fr.adhoc.leboncoin.model.Utilisateur" %>
<%@ page import="fr.adhoc.leboncoin.service.impl.UtilisateurServiceImpl" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>


    <% int userID = 0;
        if (request.getParameter("userID") != null) {
        userID = Integer.parseInt( request.getParameter("userID") ); 
        }%>
    <% UtilisateurService myUtService=null; %> 
    <% try{
        myUtService = new UtilisateurServiceImpl();
    }catch (Exception e) {
            out.println(e) ;
    } %>
        <table>
        <tr>
            <td>
                <FORM ACTION="/myWebApp/" METHOD="POST">
                <H1>Utilisateurs : </H1>
                <SELECT NAME="userID">
                <% for(Utilisateur ut: myUtService.findAllUtilisateurs()){
                    out.println("<OPTION VALUE=\""+ut.getID()+"\">");
                    out.print(ut.getNom());
                } %>
                </SELECT> 
                <BUTTON type="submit" class="btn btn-primary">Infos utilisateur</BUTTON>
                </FORM>
            </td>
        


            <% if (userID != 0){ 
                 Utilisateur user = myUtService.findUtilisateurById(userID); %>
            <td>
                <table>
                    <tr>
                        <td>
                            <H2>
                            Name : 
                            </H2>
                        </td>
                        <td>
                            <% out.println( user.getNom() ); %>
                        </td>
                    </tr>    
                    <tr>
                        <td>
                            <H2>
                            Mail :
                            </H2>
                        </td>
                        <td>
                            <% out.println( user.getMail() );%>
                        </td>
                    </tr>
               <table>
            </td>      
            <% } %>

        </tr> 
        </table>   

        <% out.flush();
        out.close(); %>

</body>
</html>
