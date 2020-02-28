package br.pucrio.vinhos.model;

public enum TipoVinhoEnum {
	TINTO("Tinto"),
	BRANCO("Branco"),
	ROSE("Rose");	
	
	private TipoVinhoEnum(String tipo) {
		this.tipo = tipo;
	}
	
	String tipo;
	
	public String getTipo() {
		return this.tipo;
	}
}
