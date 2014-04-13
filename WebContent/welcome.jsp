<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="cart" class="model.Cart" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COMP9321 Music Store</title>
</head>
<body></body>

<h1 align="center">COMP9321 Music Store</h1>

<form action="search" align="center">
	<input type="text" name="query"> <select name="type">
		<option value="album">album</option>
		<option value="song">song</option>
	</select> <input type="submit" value="search">
</form>
</html>