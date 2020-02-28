package br.pucrio.vinhos.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmacaoServlet
 */

@WebServlet("/ConfirmarOperacao")
public class ConfirmacaoServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao");
		String idVinho = request.getParameter("idVinho");
		
		request.setAttribute("idVinho", idVinho);
		request.setAttribute("operacao", operacao);
		
		RequestDispatcher view = request.getRequestDispatcher("confirmacao.jsp");
		view.forward(request,response);
	}
}
