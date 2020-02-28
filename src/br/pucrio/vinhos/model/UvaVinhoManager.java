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
}
