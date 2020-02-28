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
		
		<c:if test= "${empty uvas}">
			<div class="alert alert-danger">
				<strong>Não há uvas cadastradas.</strong>
				<br></br>
				<a href="confirmacao.jsp?operacao=popularBD" class="btn btn-primary">Popular Banco de Dados</a>
			</div>
		</c:if>
		
		<c:if test= "${not empty uvas}">
				
			<form action="CadastrarVinho" method="post">
				
				<p>Preencha os dados do novo vinho:</p>
				
				<div class="row">
					<div class="col-sm-8">					
						<label for="nomeVinho">Nome: </label>
						<input class="form-control" type="text" id="nomeVinho" name="nomeVinho" maxlength="150" value="${nomeVinho}" required>
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-4">					
						<label for="tipoVinho">Tipo: </label>
						<select class="form-control" id="tipoVinho" name="tipoVinho" required>					
							<option value="Branco" ${tipoVinho == 'Branco' ? 'selected="true"' : ''}>Branco</option>
							<option value="Tinto" ${tipoVinho == 'Tinto' ? 'selected="true"' : ''}>Tinto</option>
							<option value="Rose" ${tipovinho == 'Rose' ? 'selected="true"' : ''}>Rose</option>					
						</select>
					</div>
					
					<div class="col-sm-4">
						<label for= idUva>Uva:</label>
						<select class="form-control" id="idUva" name="idUva" required>					
							<c:forEach items="${uvas}" var="uva">					
								<option value="${uva.idUva}">${uva.nomeUva}</option>
								<option value="${uva.idUva}" ${idUva == uva.idUva ? 'selected="true"' : ''}>${uva.nomeUva}</option>					
							</c:forEach>
						</select>
					</div>
				</div>
	
				<div class="row">
					<div class="col-sm-2">
						<label for="anoVinho">Ano: </label>
						<input class="form-control" type="number" min="1980" max="2020" id="anoVinho" name="anoVinho" maxlength="4" value="${anoVinho}" required/>
					</div>
					<div class="col-sm-2">
						<label for="qtdEstoque">Quantidade: </label>
						<input class="form-control" type="number" min="0" id="qtdEstoque" name="qtdEstoque" value="${qtdEstoque}" required>
					</div>
					<div class="col-sm-2">
						<label for="precoVinho">Preço: </label>
						<input class="form-control" type="text" id="precoVinho" name="precoVinho" required/>
					</div> 
				</div>
				<br><br>
				<button type="submit" class="btn btn-primary">Cadastrar Vinho</button>
			</form>	
		</c:if>	
	</div>
</body>
</html>