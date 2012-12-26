<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link type="text/css" href="static/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<script src="static/js/bootstrap.js">
	</script>
        <table>
        <tr>
            <td>
                <FORM class="form-horizontal" ACTION="/myWebApp/listeUt" METHOD="POST" >
                 <CENTER>
                     <BUTTON type="submit" NAME="userID" VALUE="0" class="btn btn-primary">Liste des Utilisateurs</BUTTON>
                 </CENTER>
                </FORM>
            </td>
            <td>
                <H1>
                    <CENTER>
                        Infos:
                    </CENTER>   
                </H1>   
                <table>
                    <tr>
                        <td>
                            <CENTER>
                            <b>Nom : </b>${Utilisateur.nom}
                            </CENTER>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <CENTER>
                            <b>Mail : </b>${Utilisateur.mail}
                            </CENTER>
                        </td>
                    </tr>
                </table>
            </td>
            <c:if test="${listeProduitsnotnull == 1}">
                <td>
                    <H1>
                        <CENTER>
                            Produits:
                        </CENTER>   
                    </H1> 
                    <table>
                        <c:forEach items="${listeProduits}" var="prod">
                       <tr>
                        <td>
                            <CENTER>
                            <b>Nom : </b>${prod.nom}
                            </CENTER>
                        </td>
                        <td>
                            <CENTER>
                            <b>Description : </b>${prod.description}
                            </CENTER>
                        </td>
                       </tr>
                        </c:forEach>
                    </table>
                </td>
            </c:if>
        </tr>
    </table>

</body>
</html>
