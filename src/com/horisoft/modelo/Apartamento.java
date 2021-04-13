package com.horisoft.modelo;

public class Apartamento {

	private int apartamento;
	private String torre;
	private String estadoCartera;
	
	public Apartamento(int apartamento, String torre, String estadoCartera) {
		super();
		this.apartamento = apartamento;
		this.torre = torre;
		this.estadoCartera = estadoCartera;
	}

	public Apartamento() {
		super();
	}

	public int getApartamento() {
		return apartamento;
	}

	public void setApartamento(int apartamento) {
		this.apartamento = apartamento;
	}

	public String getTorre() {
		return torre;
	}

	public void setTorre(String torre) {
		this.torre = torre;
	}

	public String getEstadoCartera() {
		return estadoCartera;
	}

	public void setEstadoCartera(String estadoCartera) {
		this.estadoCartera = estadoCartera;
	}

	@Override
	public String toString() {
		return "Apartamento [apartamento=" + apartamento + ", torre=" + torre + ", estadoCartera=" + estadoCartera
				+ "]";
	}
	
	
	
}
