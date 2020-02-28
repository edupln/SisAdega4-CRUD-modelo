package br.pucrio.vinhos.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.pucrio.vinhos.model.Uva;

public class UvaDAO extends CommonsDAO {

	public boolean apagar(int identificador) {
		EntityManagerFactory factory = HibernateUtil.getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();
		Uva resultado = manager.find(Uva.class, identificador);
		try {
			manager.getTransaction().begin();
			manager.remove( resultado );
			manager.getTransaction().commit();
		} catch( Exception e ){
			e.printStackTrace();
			return false;
		}
		manager.close();	
		return true;
	}


	@Override
	public List<Uva> selecionarTodos() {
		List<Uva> resultado = new ArrayList<Uva>();
		EntityManagerFactory factory = HibernateUtil.getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();		
	    Query query = manager.createQuery("from Uva c order by idUva");
	    resultado = query.getResultList();
	    manager.close();
		return resultado;
	}

	@Override
	public Uva selecionarPorId(int idUva) {
		EntityManagerFactory factory = HibernateUtil.getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select u from Uva u where u.idUva = :idUva");
		query.setParameter("idUva", idUva);
		if( query.getResultList() != null && !query.getResultList().isEmpty()  ) {
			Uva resultado = (Uva)query.getResultList().get(0);
			manager.close();
			return resultado;
		} 
		manager.close();
		return null;
	}
	
	public Uva selecionarPorNome( String nomeUva ) {
		EntityManagerFactory factory = HibernateUtil.getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select u from Uva u where u.nomeUva = :nomeUva order by idUva");
		query.setParameter("nomeUva", nomeUva);
		if( query.getResultList() != null && !query.getResultList().isEmpty()  ) {
			Uva resultado = (Uva)query.getResultList().get(0);
			manager.close();
			return resultado;
		} 
		manager.close();
		return null;
	}
	
}
