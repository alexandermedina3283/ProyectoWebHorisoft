package com.horisoft.modelo;

public class Mascota extends Apartamento {

	private int idMascota;
	private String nombre;
	private String clase;
	
	
	public Mascota(int apartamento, String torre, String estadoCartera,int idMascota, String nombre, String clase) {
		super(apartamento, torre, estadoCartera);
		
				
		this.idMascota=idMascota;
		this.nombre=nombre;
		this.clase=clase;
		
		
	}
	
	
	public Mascota(int apartamento, String torre, String estadoCartera) {
		super(apartamento, torre, estadoCartera);
	}




	public int getIdMascota() {
		return idMascota;
	}


	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getClase() {
		return clase;
	}


	public void setClase(String clase) {
		this.clase = clase;
	}


	@Override
	public String toString() {
		return "Mascota [idMascota=" + idMascota + ", nombre=" + nombre + ", clase=" + clase + "]";
	}
	
	
	
	
	
}
