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


@WebServlet("/CadastrarVinho")
public class CadastrarVinhoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nomeVinho = request.getParameter("nomeVinho").trim();
		String tipoVinho = request.getParameter("tipoVinho").trim();
		int anoVinho = Integer.parseInt(request.getParameter("anoVinho").trim());
		//double precoVinho = Utils.strMoedaParaDouble(request.getParameter("precoVinho").trim());
		double precoVinho = 10.0;
		int qtdEstoque = Integer.parseInt(request.getParameter("qtdEstoque").trim());
		int idUva = Integer.parseInt(request.getParameter("idUva"));

		//Encaminha para a classe especialista
		String result = UvaVinhoManager.cadastrarVinho(nomeVinho, anoVinho, tipoVinho, precoVinho, qtdEstoque, idUva);
		request.setAttribute("mensagem", result);
		RequestDispatcher view = request.getRequestDispatcher("GerenciarVinhos");
	
		if( result.contains("Nao foi possivel cadastrar")) {
			request.setAttribute("nomeVinho", nomeVinho);
			request.setAttribute("tipoVinho", tipoVinho);
			request.setAttribute("anoVinho", anoVinho);
			//request.setAttribute("precoVinho", precoVinho);
			request.setAttribute("qtdEstoque", qtdEstoque);
			request.setAttribute("idUva", idUva);
			request.setAttribute("uvas", UvaVinhoManager.consultarTodasUvas());
			view = request.getRequestDispatcher("cadastrarVinho.jsp");
		}
		
		view.forward(request, response);
	}
}