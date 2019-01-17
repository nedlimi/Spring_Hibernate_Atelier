<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sw" uri="http://java.sun.com/jsp/jstl/core" %>    

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
    <table border="1" width="50%">
		<tr>
			<th>ID</th>
			<th>NOM</th>
			<th>DESCRIPTION</h>
			<th>PRIX</th>
			<th>Option</th>
		</tr>
		
		<!--  listeProduit  -->
		<sw:forEach items="${listeProduit}" var="o" >
			<tr>
				<td>${o.idEtudiant }</td>
				<td>${o.nom }</td>
				<td>${o.prenom }</td>
				<td>${o.filiere }</td>
				<td><a href="deleteProduit.aspx?id=${o.idEtudiant }">supprimer</a></td>
			</tr>
		</sw:forEach>
	</table>
    </body>
</html>
