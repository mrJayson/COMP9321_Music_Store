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
	<c:choose>
		<c:when test="${cart.cartNotEmpty}">
		<h1 align="center">Cart</h1>
			<form action="cart" method="post">
				<table align="center">
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
							<td align="right">${song.publisher}</td>
							<td align="right">${song.price}</td>
							<td align="center"><input type="checkbox" name="song"
								value="${song.songID}"></td>
						</tr>
					</c:forEach>
					<c:forEach items="${cart.albumList}" var="album">
						<tr>
							<td>${album.title}</td>
							<td>${album.artist}</td>
							<td>Album</td>
							<td align="right">${album.publisher}</td>
							<td align="right">${album.price}</td>
							<td align="center"><input type="checkbox" name="album"
								value="${album.albumID}"></td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td align="center"><input type="submit" name="action"
							value="remove"></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td>Total Price</td>
						<td>${cart.totalPrice}</td>
						<td align="center"><input type="submit" name="action"
							value="checkout"></td>
					</tr>
				</table>
			</form>
			<c:if test="${cart.duplicated}">
				<h2 align="center">Duplicated Tracks</h2>
				<table align="center">
					<tr>
						<th>Title</th>
						<th>Artist</th>
						<th>Publisher</th>
					</tr>
					<c:forEach items="${cart.duplicatedTracks}" var="dup">
						<tr>
							<td>${dup.title}</td>
							<td>${dup.artist}</td>
							<td>${dup.publisher}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</c:when>
		<c:otherwise>
		<h1 align="center">Cart is Empty</h1>
		</c:otherwise>
	</c:choose>

	<a href="welcome.jsp">Back to Search</a>
</body>
</html>