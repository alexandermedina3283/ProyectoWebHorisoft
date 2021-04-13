package com.horisoft.modelo;

import java.sql.Date;

public class ReservaSalonSocial extends Inscripcion {
	
	private Date fechaPago;
	private String numeroComprobante;
	private int valorDeposito;
	

	public ReservaSalonSocial(int idInscripcion, Date fechaInicioActividad, Date horaInicioActividad,
			Date fechaFinActividad, Date horaFinActividad, String estadoInscripcion, int idResidente, int idActividad, Date fechaPago, String numeroComprobante, int valorDeposito) {
		super(idInscripcion, fechaInicioActividad, horaInicioActividad, fechaFinActividad, horaFinActividad,
				estadoInscripcion, idResidente, idActividad);
		
		
		this.fechaPago=fechaPago;
		this.numeroComprobante=numeroComprobante;
		this.valorDeposito=valorDeposito;
		
	}


	public ReservaSalonSocial(int idInscripcion, Date fechaInicioActividad, Date horaInicioActividad,
			Date fechaFinActividad, Date horaFinActividad, String estadoInscripcion, int idResidente, int idActividad) {
		super(idInscripcion, fechaInicioActividad, horaInicioActividad, fechaFinActividad, horaFinActividad,
				estadoInscripcion, idResidente, idActividad);
	}


	public Date getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}


	public String getNumeroComprobante() {
		return numeroComprobante;
	}


	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}


	public int getValorDeposito() {
		return valorDeposito;
	}


	public void setValorDeposito(int valorDeposito) {
		this.valorDeposito = valorDeposito;
	}


	@Override
	public String toString() {
		return "ReservaSalonSocial [fechaPago=" + fechaPago + ", numeroComprobante=" + numeroComprobante
				+ ", valorDeposito=" + valorDeposito + "]";
	}

	

}
