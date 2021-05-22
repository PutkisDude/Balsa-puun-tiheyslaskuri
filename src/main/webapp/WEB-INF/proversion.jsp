<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/styles/styles.css">
<title>Premium puun tiheyslaskuri</title>
</head>
<body>


	<form method="get" action="premium">
	<fieldset><legend>Premium Puun Tiheyslaskuri</legend>

			<label for="paksuus">Paksuus(mm):</label>
			<input type="text" name="paksuus" value="${paksuus}"><br>
		
			<label for="pituus">Pituus(mm):</label> 
			<input type="text" name="pituus" value="${pituus}"><br>
		
			<label for="leveys">Leveys(mm):</label>
			<input type="text" name="leveys" value="${leveys}"><br>
		
			 <label for="paino">Paino(g):</label>
		 	<input type="text" name="paino" value="${paino}"><br>
		 	<label for="tulos">Tulos: </label>
		 	${tulos }
		 	<input type="submit" value="Laske" name="laske" id="laskubtn">		 	
		 	
		</fieldset>
				 	</form>
				 	
		<table>
		<tr>
			<th>id</th>
			<th>Tiheys</th>
			<th>Paksuus</th>
			<th>Leveys</th>
			<th>Pituus</th>
			<th>Poista</th>
		</tr>
		<c:forEach var="bal" items="${lista}">
		<tr>
			<td>${bal.getId()}</td>
			<td><fmt:formatNumber value="${bal.getTiheys()}" type="number" maxFractionDigits="2" /></td>
			<td>${bal.getKorkeus()}</td>
			<td>${bal.getLeveys()}</td>
			<td>${bal.getPituus()}</td>
			<td><a href="remove?item${bal.getId()}">Poista</a></td>
		</tr>
		</c:forEach>
		</table>
		
		
		
		
</body>
</html>