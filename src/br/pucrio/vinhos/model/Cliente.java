package br.pucrio.vinhos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idCliente", nullable = false)
	private int idCliente;
	
	@Column(name = "nomeCliente")
	private String nomeCliente;
	
	@Column(name = "idadeCliente")
	private String idadeCliente;
	
	public Cliente(){}
	
	public Cliente(String nomeCliente, String idadeCliente) {
		super();
		this.nomeCliente = nomeCliente;
		this.idadeCliente = idadeCliente;
	}	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}	
	public String getIdadeCliente() {
		return idadeCliente;
	}
	public void setIdadeCliente(String idadeCliente) {
		this.idadeCliente = idadeCliente;
	}	
}