<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/styles/styles.css">
<title>Puun tiheyslaskuri</title>
</head>
<body>


	<form method="get">
	<fieldset><legend>Puun Tiheyslaskuri</legend>

			<label for="paksuus">Paksuus(mm):</label>
			<input type="text" name="paksuus" value="${paksuus}" required><br>
		
			<label for="pituus">Pituus(mm):</label> 
			<input type="text" name="pituus" value="${pituus}" required><br>
		
			<label for="leveys">Leveys(mm):</label>
			<input type="text" name="leveys" value="${leveys}" required><br>
		
			 <label for="paino">Paino(g):</label>
		 	<input type="text" name="paino" value="${paino}" required><br>
		 	<label for="tulos">Tulos: </label>
		 	${tulos }
		 	<input type="submit" value="Laske" id="laskubtn">
		 	
		</fieldset>
				 	</form>
		
		<input type="submit" value="Premium version">
		
		
		
</body>
</html>