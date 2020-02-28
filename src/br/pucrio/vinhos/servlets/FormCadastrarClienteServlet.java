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

@WebServlet("/FormCadastrarCliente")
public class FormCadastrarClienteServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//Lista de uvas , Poderia converter para uma lista de clientes, mas só comentei por enquanto
		//List<?> uvas = UvaVinhoManager.consultarTodasUvas(); 
		//request.setAttribute("uvas", uvas);
		
		RequestDispatcher view = request.getRequestDispatcher("cadastrarCliente.jsp");		
		view.forward(request, response);
	}
}