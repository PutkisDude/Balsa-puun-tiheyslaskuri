<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 	http://softwareservice.fi:8080/lauripuuntiheys/ -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./styles/styles.css">
<title>Puun tiheyslaskuri</title>
</head>
<body>


	<form method="get" action="laske">
	<fieldset><legend>Puun Tiheyslaskuri</legend>

			<label for="paksuus">Paksuus(mm):</label>
			<input type="text" name="paksuus" value="${paksuus}" placeholder="0.00"><br>
		
			<label for="pituus">Pituus(mm):</label> 
			<input type="text" name="pituus" value="${pituus}" placeholder="0.00"><br>
		
			<label for="leveys">Leveys(mm):</label>
			<input type="text" name="leveys" value="${leveys}" placeholder="0.00"><br>
		
			 <label for="paino">Paino(g):</label>
		 	<input type="text" name="paino" value="${paino}" placeholder="0.00"><br>
		 	<label for="tulos">Tulos: </label>
		 	${tulos }
		 	<br><br>
		 	<input type="submit" value="Laske" name="laske" id="laskubtn">
		 			<input type="submit" name="premium" value="Premium version">
		 	
		 	
		</fieldset>
				 	</form>
		
		
		
		
</body>
</html>