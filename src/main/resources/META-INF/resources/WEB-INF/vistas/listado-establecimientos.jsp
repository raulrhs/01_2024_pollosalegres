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
	
	<h2>Listado de establecimientos</h2>
	<table>
		<thead>
			<tr>
				<th>Código</th>
				<th>Nombre Comercial</th>
				<th>Direccion</th>
				<th>Datos de Contacto</th>
				<th>Fecha de Inauguracion</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="establecimiento" items="${establecimientos}">
			<tr>
				<td>${establecimiento.codigo}</td>
				<td>${establecimiento.nombreComercial}</td>
				<td>${establecimiento.direccion.direccion}</td>
				<td>${establecimiento.datosContacto.telefono}</td>
				<td>${establecimiento.fechaInauguracion}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>