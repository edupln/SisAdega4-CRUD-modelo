package br.pucrio.vinhos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Uva")
public class Uva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idUva", nullable = false)
	private int idUva;
	
	@Column(name = "nomeUva")
	private String nomeUva;
	
	public Uva(){}
	
	public Uva(String nomeUva) {
		super();
		this.nomeUva = nomeUva;
	}
	
	public int getIdUva() {
		return idUva;
	}
	public void setIdUva(int idUva) {
		this.idUva = idUva;
	}
	public String getNomeUva() {
		return nomeUva;
	}
	public void setNomeUva(String nomeUva) {
		this.nomeUva = nomeUva;
	}	
}
