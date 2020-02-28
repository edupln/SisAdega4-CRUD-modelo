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

/* É provável ter de criar a tabela no banco antes, vou testar primeiro com o cadastrar vinho
@WebServlet("/FormCadastrarCliente")
public class FormCadastrarClienteServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//Lista de uvas		
		List<?> clientes = ClienteManager.consultarTodosClientes(); 
		request.setAttribute("clientes", clientes);
		
		RequestDispatcher view = request.getRequestDispatcher("cadastrarCliente.jsp");		
		view.forward(request, response);
	}
}
*/