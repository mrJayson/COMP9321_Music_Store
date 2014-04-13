
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
			<h1 align="center">${type}search results for "${query}"</h1>
			<c:choose>
				<c:when test="${type == 'song'}">
					<form action="cart" method="post">
						<table align="center" border="1">
							<tr>
								<th>Title</th>
								<th>Artist</th>
								<th>Album</th>
								<th>Genre</th>
								<th>Publisher</th>
								<th>Year</th>
								<th>Price</th>
								<th>Select</th>
							</tr>
							<c:forEach items="${songList}" var="song">
								<tr>
									<td>${song.title}</td>
									<td><a href="/COMP9321_Music_Store/search?query=${song.artist}&type=album">${song.artist}</a></td>
									<td><a href="/COMP9321_Music_Store/search?query=${song.albumTitle}&type=song">${song.albumTitle}</a></td>
									<td>${song.genre}</td>
									<td>${song.publisher}</td>
									<td>${song.year}</td>
									<td>${song.price}</td>
									<td><input type="checkbox" name="song"
										value="${song.songID}"></td>
								</tr>
							</c:forEach>
							<tr>
								<td></td>
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