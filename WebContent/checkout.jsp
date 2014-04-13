<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="cart" class="model.Cart" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Checkout</h1>
	<h2 align="center">Please confirm these are the items you are
		purchasing</h2>
	<form action="confirmation" method=post>
		<table align="center">
			<tr>
				<th>Title</th>
				<th>Artist</th>
				<th>Type</th>
				<th>Publisher</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${cart.songList}" var="song">
				<tr>
					<td>${song.title}</td>
					<td>${song.artist}</td>
					<td>Song</td>
					<td align="right">${song.publisher}</td>
					<td align="right">${song.price}</td>
				</tr>
			</c:forEach>
			<c:forEach items="${cart.albumList}" var="album">
				<tr>
					<td>${album.title}</td>
					<td>${album.artist}</td>
					<td>Album</td>
					<td align="right">${album.publisher}</td>
					<td align="right">${album.price}</td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td align="right">Total Price</td>
				<td align="right">${cart.totalPrice}</td>
			</tr>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td align="center"><input type="submit" name="action" value="cancel"></td>
				<td align="center"><input type="submit" name="action" value="confirm"></td>
			</tr>


		</table>
	</form>
<a href="welcome.jsp">Back to Search</a>

</body>
</html>