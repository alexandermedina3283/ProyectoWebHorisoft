package com.horisoft.modelo;

import java.sql.Date;

public class Comentario {

	private int idComentario;
	private Date fechaComentario;
	private String descripcion;
	private String autorComentario;
	private int idInscripcion;
	
	public Comentario(int idComentario, Date fechaComentario, String descripcion, String autorComentario,
			int idInscripcion) {
		super();
		this.idComentario = idComentario;
		this.fechaComentario = fechaComentario;
		this.descripcion = descripcion;
		this.autorComentario = autorComentario;
		this.idInscripcion = idInscripcion;
	}

	public Comentario() {
		super();
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public Date getFechaComentario() {
		return fechaComentario;
	}

	public void setFechaComentario(Date fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAutorComentario() {
		return autorComentario;
	}

	public void setAutorComentario(String autorComentario) {
		this.autorComentario = autorComentario;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", fechaComentario=" + fechaComentario + ", descripcion="
				+ descripcion + ", autorComentario=" + autorComentario + ", idInscripcion=" + idInscripcion + "]";
	}
	
	
	
}
