<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Pollos Alegres</title>
</head>
<body>
	
	<h2>Listado de categorias</h2>
	<table>
		<thead>
			<tr>
				<th>Código</th>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="categoria" items="${categorias}">
			<tr>
				<td>${categoria.id}</td>
				<td>${categoria.nombre}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>