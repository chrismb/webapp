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
                <FORM ACTION="/myWebApp/infosUt" METHOD="POST">
                <H1>Utilisateurs : </H1>
                <SELECT NAME="userID">
                <c:forEach items="${listeUtilisateurs}" var="user">
                    <OPTION VALUE="${user.id}">
                        ${user.nom}
                    </OPTION>
                </c:forEach>
                </SELECT> 
                <BUTTON type="submit" class="btn btn-primary">Infos utilisateur</BUTTON>
                </FORM>
            </td>
            <td>
                <table>
                    <tr>
                        <td>
                            <b>Nom : </b>${infosutilisateursnom}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Mail : </b>${infosutilisateursmail}
                        </td>
                    </tr>
                </table>
            </td>
            <c:if test="${listeProduitsnotnull == 1}">
                <td>
                    <table>
                        <c:forEach items="${listeProduits}" var="prod">
                       <tr>
                        <td>
                            <b>Nom : </b>${prod.nom}
                        </td>
                        <td>
                            <b>Description : </b>${prod.description}
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
