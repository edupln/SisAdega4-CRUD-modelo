<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ page import="java.util.*"%>
<head>
	<%@include file="_header.jsp"%>
</head>
<body>
	<%@include file="_cabecalho.jsp"%>
	
	<div class="container">
	
		<c:if test= "${empty vinhos}">			
	        <div class="alert alert-danger">
	        	<strong>Não há vinhos cadastrados</strong>
	        </div>	    
		</c:if>
					
		<c:if test= "${not empty vinhos}">
			<div class= table-responsive>
				<table class="table table-striped table-hover">
					<thead class="thead-dark">
						<tr>
							<th></th>
							<th>Id</th>
							<th>Nome</th>
							<th>Ano</th>
							<th>Tipo</th>
							<th>QtdEstoque</th>
							<th>Uva</th>					
						</tr>
					</thead>
					<c:forEach items="${vinhos}" var="vinho">
						<tr>
							<td>
							</td>
							<td><strong>${vinho.idVinho}</strong></td>
							<td>${vinho.nomeVinho}</td>
							<td>${vinho.ano}</td>
							<td>${vinho.tipo}</td>
							<td>${vinho.qtdEstoque}</td>
							<td>${vinho.uva.nomeUva}</td>
						</tr>
					</c:forEach>
				</table>
			</div>			
		</c:if>		
	</div>
</body>
</html>