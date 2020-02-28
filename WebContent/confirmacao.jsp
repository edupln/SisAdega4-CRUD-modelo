<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="_header.jsp"%>
</head>
<body>
	<%@include file="_cabecalho.jsp"%>
	
	<!--  CONTAINER PRINCIPAL -->
	<div class="container">	
	
		<div class="alert alert-danger">
			
			<c:if test= "${operacao eq 'popularBD'}">
				<strong>Esta operação é irreversível e populará a base de dados. Tem certeza que deseja prosseguir?</strong><br></br>
				<a href="PopularBD" class="btn btn-primary">Sim</a>
			</c:if>
		
		</div>
	</div>
	<!--  fim .container da pagina -->
</body>
</html>