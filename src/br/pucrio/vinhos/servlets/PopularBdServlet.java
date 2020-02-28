package br.pucrio.vinhos.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.pucrio.vinhos.model.UvaVinhoManager;

/**
 * Servlet implementation class ConfirmacaoServlet
 */

@WebServlet("/PopularBD")
public class PopularBdServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UvaVinhoManager.popularBD();		
		RequestDispatcher view = request.getRequestDispatcher("GerenciarVinhos");
		view.forward(request,response);
	}
}