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
	
	<h2>Listado de pedidos</h2>
	<table>
		<thead>
			<tr>
				<th>Código</th>
				<th>Fecha</th>
				<th>Cliente</th>
				<th>Camarero</th>
				<th>Establecimiento</th>
				<th>Estado</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pedido" items="${pedidos}">
			<tr>
				<td>${pedido.numero}</td>
				<td>${pedido.fecha}</td>
				<td>${pedido.cliente.id}</td>
				<td>${pedido.camarero.id}</td>
				<td>${pedido.establecimiento.codigo}</td>
				<td>${pedido.estado}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>