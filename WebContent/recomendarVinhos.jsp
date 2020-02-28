<html>
<head>
	<%@include file="_header.jsp"%>
</head>
<body>
	<%@include file="_cabecalho.jsp"%>

	<div class="container">	
	
		<form method="post" action="RecomendarVinhos">
	
			<p>Selecione o tipo do vinho:</p>
			
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label for="tipo">Tipo:</label>
						<select class="form-control" id="tipo" name="tipo" size="1">
							<option value="Branco">Branco</option>
							<option value="Tinto">Tinto</option>
							<option value="Rose">Rose</option>
						</select> 
					</div>
				</div>
			</div>
			<br><br> 
			<button type="submit" class="btn btn-primary">Consultar</button>
		</form>
		
	</div> <!-- Fim container -->
	
</body>
</html>

