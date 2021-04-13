package com.horisoft.modelo;

import java.sql.Date;

public class Residente extends Apartamento {

	private int idResidente;
	private String nombre;
	private String apellido;
	private String identificacion;
	private Date fechaNacimiento;
	private String telefono;
	private String email;
	private String estado;
	private String categoria;
		
	
	public Residente(int apartamento, String torre, String estadoCartera, int idResidente, String nombre, String apellido, String identificacion, Date fechaNacimiento, String telefono, String email, String estado, String categoria) {
		super(apartamento, torre, estadoCartera);
		
		this.idResidente=idResidente;
		this.nombre=nombre;
		this.apellido=apellido;
		this.identificacion=identificacion;
		this.fechaNacimiento=fechaNacimiento;
		this.telefono=telefono;
		this.email=email;
		this.estado=estado;
		this.categoria=categoria;
	}


	public Residente(int apartamento, String torre, String estadoCartera) {
		super(apartamento, torre, estadoCartera);
	}


	public int getIdResidente() {
		return idResidente;
	}


	public void setIdResidente(int idResidente) {
		this.idResidente = idResidente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Residente [idResidente=" + idResidente + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", identificacion=" + identificacion + ", fechaNacimiento=" + fechaNacimiento + ", telefono="
				+ telefono + ", email=" + email + ", estado=" + estado + ", categoria=" + categoria + "]";
	}

	

}
