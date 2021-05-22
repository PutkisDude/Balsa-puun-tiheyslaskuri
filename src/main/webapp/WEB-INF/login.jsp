<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form method="post">
<fieldset>
<legend>Login</legend>
<label for="password">Password: </label>
<input type="password" name="password">
<input type="submit" value="Login"><br><br>
<input type="submit" name="back" value="Back to normal">
${msg}
</fieldset>
</form>
</body>
</html>