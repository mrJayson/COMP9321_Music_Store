
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Search results for "${query}"</h1>
	<c:choose>
		<c:when test="${type == 'empty'}">
			Search returned nothing
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${type == 'album'}">
					<table align="center">
						<tr>
							<th>Title</th>
							<th>Artist</th>
							<th>Genre</th>
							<th>Publisher</th>
							<th>Year</th>
						</tr>
						<c:forEach items="${albumList}" var="album">
							<tr>
								<td>${album.title}</td>
								<td>${album.artist}</td>
								<td>${album.genre}</td>
								<td>${album.publisher}</td>
								<td>${album.year}</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>

				<c:when test="${type == 'song'}">
					<table align="center">
					<tr>
						<th>Title</th>
						<th>Artist</th>
					</tr>
						<c:forEach items="${songList}" var="song">
							<tr>
								<td>${song.title}</td>
								<td>${song.artist}</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
			</c:choose>

		</c:otherwise>
	</c:choose>

</body>
</html>