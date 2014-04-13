<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.*"%>
<jsp:useBean id="cart" class="model.Cart" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COMP9321 Music Store</title>
</head>
<body>
	<form action="cart" method="post">
		<table>
			<tr>
				<th>Title</th>
				<th>Artist</th>
				<th>Type</th>
				<th>Publisher</th>
				<th>Price</th>
				<th>Select</th>
				</tr>

				<c:forEach items="${cart.songList}" var="song">
					<tr>
						<td>${song.title}</td>
						<td>${song.artist}</td>
						<td>Song</td>
						<td>${song.publisher}</td>
						<td>${song.price}</td>
						<td><input type="checkbox" name="song" value="${song.songID}"></td>
					</tr>
				</c:forEach>
				<c:forEach items="${cart.albumList}" var="album">
					<tr>
						<td>${album.title}</td>
						<td>${album.artist}</td>
						<td>Album</td>
						<td>${album.publisher}</td>
						<td>${album.price}</td>
						<td><input type="checkbox" name="album"
							value="${album.albumID}"></td>
					</tr>
				</c:forEach>
				<tr><td></td><td></td><td></td><td></td><td></td><td><input type="submit" name="action" value="remove"></td></tr>
				

		</table>
	</form>

</body>
</html>