package com.horisoft.modelo;

public class Parqueadero extends Apartamento {
	
	private String idParqueadero;
	private int claseVehiculo;
	private String ubicacionParqueadero;
	private String placaVehiculo;
	private int modeloVehiculo;
	private String colorVehiculo;
	private String marcaVehiculo;

	public Parqueadero(int apartamento, String torre, String estadoCartera, String idParqueadero, int claseVehiculo, String ubicacionParqueadero, String placaVehiculo, int modeloVehiculo, String colorVehiculo, String marcaVehiculo) {
		super(apartamento, torre, estadoCartera);
		
		this.idParqueadero=idParqueadero;
		this.claseVehiculo=claseVehiculo;
		this.ubicacionParqueadero=ubicacionParqueadero;
		this.placaVehiculo=placaVehiculo;
		this.modeloVehiculo=modeloVehiculo;
		this.colorVehiculo=colorVehiculo;
		this.marcaVehiculo=marcaVehiculo;	
				
	}

	public Parqueadero(int apartamento, String torre, String estadoCartera) {
		super(apartamento, torre, estadoCartera);
	}

	public String getIdParqueadero() {
		return idParqueadero;
	}

	public void setIdParqueadero(String idParqueadero) {
		this.idParqueadero = idParqueadero;
	}

	public int getClaseVehiculo() {
		return claseVehiculo;
	}

	public void setClaseVehiculo(int claseVehiculo) {
		this.claseVehiculo = claseVehiculo;
	}

	public String getUbicacionParqueadero() {
		return ubicacionParqueadero;
	}

	public void setUbicacionParqueadero(String ubicacionParqueadero) {
		this.ubicacionParqueadero = ubicacionParqueadero;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public int getModeloVehiculo() {
		return modeloVehiculo;
	}

	public void setModeloVehiculo(int modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}

	public String getColorVehiculo() {
		return colorVehiculo;
	}

	public void setColorVehiculo(String colorVehiculo) {
		this.colorVehiculo = colorVehiculo;
	}

	public String getMarcaVehiculo() {
		return marcaVehiculo;
	}

	public void setMarcaVehiculo(String marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}

	@Override
	public String toString() {
		return "Parqueadero [idParqueadero=" + idParqueadero + ", claseVehiculo=" + claseVehiculo
				+ ", ubicacionParqueadero=" + ubicacionParqueadero + ", placaVehiculo=" + placaVehiculo
				+ ", modeloVehiculo=" + modeloVehiculo + ", colorVehiculo=" + colorVehiculo + ", marcaVehiculo="
				+ marcaVehiculo + "]";
	}
	
	

	

}
