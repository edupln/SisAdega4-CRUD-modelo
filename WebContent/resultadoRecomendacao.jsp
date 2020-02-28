<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ page import="java.util.*"%>
<head>
	<%@include file="_header.jsp"%>
</head>
<body>
	<%@include file="_cabecalho.jsp"%>
	<div class="container">	
	
		<p>Você escolheu o tipo ${tipo}</p>
			
		<c:if test= "${empty vinhos}">
			<p>Não há sugestão de vinhos para o tipo selecionado.
		</c:if>
		<c:if test= "${not empty vinhos}">
			<ul>
		        <c:forEach items="${vinhos}" var="vinho">
		            <li>${vinho.nomeVinho}</li>
		        </c:forEach>
		    </ul>
		</c:if>
		
	</div>
</body>
</html>

