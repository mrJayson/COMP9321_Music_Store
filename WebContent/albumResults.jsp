
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="cart" class="model.Cart" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COMP9321 Music Store</title>
</head>
<body>
	<c:choose>
		<c:when test="${type == 'empty'}">
			<h1 align="center">search results for "${query}" returned
				nothing</h1>
		</c:when>
		<c:when test="${type == 'album' || type == 'song'}">
			<h1 align="center">search results for "${query}"</h1>
			<c:choose>

				<c:when test="${type == 'album'}">
					<form action="cart" method="post">
						<table align="center" border="1">
							<tr>
								<th>Title</th>
								<th>Artist</th>
								<th>Genre</th>
								<th>Publisher</th>
								<th>Year</th>
								<th>Price</th>
								<th>Select</th>
							</tr>
							<c:forEach items="${albumList}" var="album">
								<tr>
									<td><a href="/COMP9321_Music_Store/search?query=${album.title}&type=song">${album.title}</a></td>
									<td><a href="/COMP9321_Music_Store/search?query=${album.artist}&type=album">${album.artist}</a></td>
									<td align="right">${album.genre}</td>
									<td align="right">${album.publisher}</td>
									<td align="right">${album.year}</td>
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
								<td></td>
								<td><input type="submit" name="action" value="add"></td>
							</tr>
						</table>
					</form>
				</c:when>

			</c:choose>
		</c:when>

	</c:choose>
	<a href="welcome.jsp">Back to Search</a>
</body>
</html>