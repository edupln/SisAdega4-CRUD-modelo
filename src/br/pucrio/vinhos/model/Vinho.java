package br.pucrio.vinhos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Vinho")
public class Vinho {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idVinho", nullable = false)
	private int idVinho;

	@Column(name = "nomeVinho")
	private String nomeVinho;

	@Column(name = "ano")
	private int ano;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "qtdEstoque")
	private int qtdEstoque;

	@Column(name = "preco")
	private double preco;

	@JoinColumn(name = "idUva", referencedColumnName = "idUva", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Uva uva;		

	public Vinho() {}

	public Vinho(String nomeVinho, int ano, String tipo, Uva uva, int qtdEstoque, double preco) {
		super();
		this.nomeVinho = nomeVinho;
		this.ano = ano;
		this.tipo = tipo;
		this.uva = uva;
		this.qtdEstoque = qtdEstoque;
		this.preco = preco;
	}

	public int getIdVinho() {
		return idVinho;
	}
	public void setIdVinho(int idVinho) {
		this.idVinho = idVinho;
	}
	public String getNomeVinho() {
		return nomeVinho;
	}
	public void setNomeVinho(String nomeVinho) {
		this.nomeVinho = nomeVinho;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Uva getUva() {
		return uva;
	}
	public void setUva(Uva uva) {
		this.uva = uva;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}	

}
