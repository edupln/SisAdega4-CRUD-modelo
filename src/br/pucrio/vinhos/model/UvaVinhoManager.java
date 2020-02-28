package br.pucrio.vinhos.model;
import java.util.List;

import br.pucrio.vinhos.dao.UvaDAO;
import br.pucrio.vinhos.dao.VinhoDAO;
import br.pucrio.vinhos.dao.ClienteDAO;

public class UvaVinhoManager {

	public static List<Vinho> consultarVinhosPorTipo( String tipo ) {
		VinhoDAO dao = new VinhoDAO();
		List<Vinho> vinhos = dao.selecionarPorTipo(tipo);
		return vinhos;
	}
	
	public static List<Vinho> consultarTodosVinhos() {
		VinhoDAO dao = new VinhoDAO();
		List<Vinho> vinhos = dao.selecionarTodos();
		return vinhos;
	}	
	
	public static void limparBD(){
		VinhoDAO vinhoDao = new VinhoDAO();
		List<Vinho> vinhos = vinhoDao.selecionarTodos();
		for (Vinho vinho : vinhos) {
			vinhoDao.apagar(vinho.getIdVinho());
		}
		System.out.println("Vinhos apagados com sucesso!");
		
		UvaDAO uvaDao = new UvaDAO();
		List<Uva> uvas = uvaDao.selecionarTodos();
		for (Uva uva : uvas){
			uvaDao.apagar(uva.getIdUva());
		}
		System.out.println("Uvas apagadas com sucesso!");
	}
	
	public static void popularBD() {
		limparBD();
		
		UvaDAO uvaDAO = new UvaDAO();
		VinhoDAO vinhoDao = new VinhoDAO();
		
		Uva uva1 = new Uva("Cabernet Sauvignon");
		uvaDAO.inserir(uva1);
		
		Uva uva2 = new Uva("Uva Rose");
		uvaDAO.inserir(uva2);
			
		Uva uva3 = new Uva("Uva Verde");
		uvaDAO.inserir(uva3);
		
		Vinho novo = new Vinho("Santa Helena", 2016, TipoVinhoEnum.TINTO.getTipo(), uva1, 4, 37.78);
		vinhoDao.inserir(novo);
		
		novo = new Vinho("Santa Sara", 2018, TipoVinhoEnum.ROSE.getTipo(), uva2, 3, 22.99);
		vinhoDao.inserir(novo);
		
		novo = new Vinho("Santa Maria", 2017, TipoVinhoEnum.BRANCO.getTipo(), uva3, 2, 88.65);
		vinhoDao.inserir(novo);
	}
	
	public static String cadastrarVinho( String nomeVinho, int anoVinho, String tipoVinho, double precoVinho, int qtdEstoque, int idUva ) {
		VinhoDAO dao = new VinhoDAO();
		
		// Verifica se todos os campos estao preenchidos.
		if( nomeVinho == null || anoVinho <= 0 || tipoVinho == null || precoVinho < 0 || qtdEstoque < 0){
			String mensagem = "Nao foi possivel cadastrar o vinho: Preencha todos os campos obrigatorios.";
			return mensagem;
		}
		
		// Verifica se ja existe vinho com este nome
		Vinho existente = dao.selecionarPorNome(nomeVinho);
		if( existente != null ) {
			String mensagem = "Nao foi possivel cadastrar o vinho: Ja existe outro vinho com este nome . ";
			return mensagem;
		}
		
		Uva uva = consultarUvaPorId(idUva);
		Vinho novo = new Vinho(nomeVinho, anoVinho, tipoVinho, uva, qtdEstoque, precoVinho);
		
		try {
			dao.inserir(novo);
			String mensagem = "Vinho " + novo.getNomeVinho() + " inserido com sucesso.";
			return mensagem;
		}catch( Exception e) {
		e.printStackTrace();
		String mensagem = "Nao foi possivel cadastrar o vinho";
		return mensagem;
		}	
	}
	
	//#################### Cadastrar Cliente ##################
	public static String cadastrarCliente( String nomeCliente, String idadeCliente) {
		ClienteDAO dao = new ClienteDAO();
		
		// Verifica se todos os campos estao preenchidos.
		if( nomeCliente == null || idadeCliente == null){
			String mensagem = "Nao foi possivel cadastrar o cliente: Preencha todos os campos obrigatorios.";
			return mensagem;
		}
		
		// Verifica se ja existe cliente com este nome
		Cliente existente = dao.selecionarPorNome(nomeCliente);
		if( existente != null ) {
			String mensagem = "Nao foi possivel cadastrar o cliente: Ja existe outro cliente com este nome . ";
			return mensagem;
		}
				
		Cliente novo = new Cliente(nomeCliente, idadeCliente);
		
		try {
			dao.inserir(novo);
			String mensagem = "Cliente " + novo.getNomeCliente() + " inserido com sucesso.";
			return mensagem;
		}catch( Exception e) {
		e.printStackTrace();
		String mensagem = "Nao foi possivel cadastrar o cliente";
		return mensagem;
		}	
	}
	
	// Clientes
	public static List<Cliente> consultarTodosClientes() {
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.selecionarTodos();
		return clientes;
	}
	
	// Uva
	public static List<Uva> consultarTodasUvas() {
		UvaDAO dao = new UvaDAO();
		List<Uva> uvas = dao.selecionarTodos();
		return uvas;
	}
	
	public static Uva consultarUvaPorId(int idUva) {
		UvaDAO dao = new UvaDAO();
		Uva uva = dao.selecionarPorId(idUva);
		return uva;
	}
}
