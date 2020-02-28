<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ page import="java.util.*"%>
<head>
	<%@include file="_header.jsp"%>
</head>
<body>
	<%@include file="_cabecalho.jsp"%>
	
	<div class="container"> 		
		<c:if test = "${not empty mensagem}">
			<div class="alert alert-danger">
				<strong>"${mensagem}"</strong>
			</div>
		</c:if>
		
			<form action="CadastrarCliente" method="post">
				
				<p>Preencha os dados do novo Cliente:</p>
				
				<div class="row">
					<div class="col-sm-8">					
						<label for="nomeCliente">Nome: </label>
						<input class="form-control" type="text" id="nomeCliente" name="nomeCliente" maxlength="150" value="${nomeCliente}" required>
						<label for="idadeCliente">Idade: </label>
						<input class="form-control" type="text" id="idadeCliente" name="idadeCliente" maxlength="150" value="${idadeCliente}" required>
					</div>
				</div>	
				
				<br><br>
				<button type="submit" class="btn btn-primary">Cadastrar Cliente</button>
			</form>
	</div>
</body>
</html>