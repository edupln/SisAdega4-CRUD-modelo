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


@WebServlet("/CadastrarCliente")
public class CadastrarClienteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nomeCliente = request.getParameter("nomeCliente").trim();
		String idadeCliente = request.getParameter("idadeCliente").trim();		

		//Encaminha para a classe especialista
		String result = UvaVinhoManager.cadastrarCliente(nomeCliente, idadeCliente);
		request.setAttribute("mensagem", result);
		RequestDispatcher view = request.getRequestDispatcher("GerenciarVinhos");//modifiquei era vinhos
	
		if( result.contains("Nao foi possivel cadastrar")) {
			request.setAttribute("nomeCliente", nomeCliente);
			request.setAttribute("idadeCliente", idadeCliente);			
			view = request.getRequestDispatcher("cadastrarCliente.jsp");
		}
		
		view.forward(request, response);
	}
}