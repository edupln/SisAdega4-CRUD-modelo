<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ page import="java.util.*"%>
<head>
	<%@include file="_header.jsp"%>
</head>
<body>
	<%@include file="_cabecalho.jsp"%>
	
	<div class="container">


		<c:if test= "${not empty clientes}">
			<div class= table-responsive>
				<table class="table table-striped table-hover">
					<thead class="thead-dark">
						<tr>
							<th></th>
							<th>Id</th>
							<th>Nome</th>
							<th>Idade</th>												
						</tr>
					</thead>
					<c:forEach items="${clientes}" var="cliente">
						<tr>
							<td>
							</td>
							<td><strong>${cliente.idCliente}</strong></td>
							<td>${cliente.nomeCliente}</td>
							<td>${cliente.idadeCliente}</td>							
						</tr>
					</c:forEach>
				</table>
			</div>	
		</c:if>
	</div>
</body>
</html>