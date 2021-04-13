package com.horisoft.modelo;

import java.sql.Date;

public class Inscripcion {
	
	private int idInscripcion;
	private Date fechaInicioActividad;
	private Date horaInicioActividad;
	private Date fechaFinActividad;
	private Date horaFinActividad;
	private String estadoInscripcion;
	private int idResidente;
	private int idActividad;
	
	public Inscripcion(int idInscripcion, Date fechaInicioActividad, Date horaInicioActividad, Date fechaFinActividad,
			Date horaFinActividad, String estadoInscripcion, int idResidente, int idActividad) {
		super();
		this.idInscripcion = idInscripcion;
		this.fechaInicioActividad = fechaInicioActividad;
		this.horaInicioActividad = horaInicioActividad;
		this.fechaFinActividad = fechaFinActividad;
		this.horaFinActividad = horaFinActividad;
		this.estadoInscripcion = estadoInscripcion;
		this.idResidente = idResidente;
		this.idActividad = idActividad;
	}

	public Inscripcion() {
		super();
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public Date getFechaInicioActividad() {
		return fechaInicioActividad;
	}

	public void setFechaInicioActividad(Date fechaInicioActividad) {
		this.fechaInicioActividad = fechaInicioActividad;
	}

	public Date getHoraInicioActividad() {
		return horaInicioActividad;
	}

	public void setHoraInicioActividad(Date horaInicioActividad) {
		this.horaInicioActividad = horaInicioActividad;
	}

	public Date getFechaFinActividad() {
		return fechaFinActividad;
	}

	public void setFechaFinActividad(Date fechaFinActividad) {
		this.fechaFinActividad = fechaFinActividad;
	}

	public Date getHoraFinActividad() {
		return horaFinActividad;
	}

	public void setHoraFinActividad(Date horaFinActividad) {
		this.horaFinActividad = horaFinActividad;
	}

	public String getEstadoInscripcion() {
		return estadoInscripcion;
	}

	public void setEstadoInscripcion(String estadoInscripcion) {
		this.estadoInscripcion = estadoInscripcion;
	}

	public int getIdResidente() {
		return idResidente;
	}

	public void setIdResidente(int idResidente) {
		this.idResidente = idResidente;
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	@Override
	public String toString() {
		return "Inscripcion [idInscripcion=" + idInscripcion + ", fechaInicioActividad=" + fechaInicioActividad
				+ ", horaInicioActividad=" + horaInicioActividad + ", fechaFinActividad=" + fechaFinActividad
				+ ", horaFinActividad=" + horaFinActividad + ", estadoInscripcion=" + estadoInscripcion
				+ ", idResidente=" + idResidente + ", idActividad=" + idActividad + "]";
	}
	
	
	
	
	
	

}
