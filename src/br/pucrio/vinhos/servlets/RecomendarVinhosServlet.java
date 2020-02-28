package br.pucrio.vinhos.servlets;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.pucrio.vinhos.model.UvaVinhoManager;

@WebServlet("/RecomendarVinhos")
public class RecomendarVinhosServlet extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String tipo = request.getParameter("tipo");
		request.setAttribute("tipo", tipo);

		List<?> resultado = UvaVinhoManager.consultarVinhosPorTipo(tipo);
		request.setAttribute("vinhos", resultado);
		
		RequestDispatcher view = request.getRequestDispatcher("resultadoRecomendacao.jsp");
		view.forward(request, response);
	}
	
}