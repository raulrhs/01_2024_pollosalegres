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
	
	<h2>Listado de productos</h2>
	<table>
		<thead>
			<tr>
				<th>Código</th>
				<th>Nombre</th>
				<th>Descripcion</th>
				<th>Fecha Alta</th>
				<th>Precio</th>
				<th>Categoria</th>
				<th>Descatalogado</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="producto" items="${productos}">
			<tr>
				<td>${producto.codigo}</td>
				<td>${producto.nombre}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.fechaAlta}</td>
				<td>${producto.precio}</td>
				<td>${producto.categoria.id}</td>
				<td>${producto.descatalogado}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>