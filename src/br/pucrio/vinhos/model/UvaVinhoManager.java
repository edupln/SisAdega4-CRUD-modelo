package br.pucrio.vinhos.model;
import java.util.List;

import br.pucrio.vinhos.dao.UvaDAO;
import br.pucrio.vinhos.dao.VinhoDAO;

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
}
