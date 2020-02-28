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

@WebServlet("/GerenciarVinhos")
public class GerenciarVinhosServlet extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		List<?> resultado = UvaVinhoManager.consultarTodosVinhos();
		request.setAttribute("vinhos", resultado);
		
		RequestDispatcher view = request.getRequestDispatcher("gerenciarVinhos.jsp");
		view.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
				doPost(request, response);
			}
}