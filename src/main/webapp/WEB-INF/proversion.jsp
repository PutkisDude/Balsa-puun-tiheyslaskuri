<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./styles/styles.css">
<title>Premium puun tiheyslaskuri</title>
</head>
<body>

	<form method="get" action="premium">
	<fieldset><legend>Puun Tiheyslaskuri - Database versio</legend>

			<label for="paksuus">Paksuus(mm):</label>
			<input type="text" name="paksuus" value="${paksuus}" placeholder="0.00"><br>
		
			<label for="pituus">Pituus(mm):</label> 
			<input type="text" name="pituus" value="${pituus}" placeholder="0.00"><br>
		
			<label for="leveys">Leveys(mm):</label>
			<input type="text" name="leveys" value="${leveys}" placeholder="0.00"><br>
		
			 <label for="paino">Paino(g):</label>
		 	<input type="text" name="paino" value="${paino}" placeholder="0.00"><br>
		 	
		 	<label for="grain">Grain(A-C)</label>
			<input type="text" pattern="[a-cA-C]" name="grain" value="${grain}" placeholder="A-C"><br><br>
		 	
		 	<input type="submit" value="laske" name="laske" id="laskubtn">		 	
		 	
		</fieldset>
				 	</form>				 	
				 	
		<table>
		<tr>
			<th>id</th>
			<th>Tiheys</th>
			<th>Grain</th>
			<th>Paksuus</th>
			<th>Leveys</th>
			<th>Pituus</th>
			<th>Poista</th>
		</tr>
		<c:forEach var="bal" items="${lista}">
		<tr>
			<td>${bal.getId()}</td>
			<td><fmt:formatNumber value="${bal.getTiheys()}" type="number" maxFractionDigits="2" /></td>
			<td>${bal.getGrain()}</td>
			<td>${bal.getKorkeus()}</td>
			<td>${bal.getLeveys()}</td>
			<td>${bal.getPituus()}</td>
			<td><a href="premium?remove=${bal.getId()}">Poista</a></td>
		</tr>
		</c:forEach>
		</table>
		
</body>
</html>