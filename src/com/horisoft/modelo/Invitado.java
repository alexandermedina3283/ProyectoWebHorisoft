package com.horisoft.modelo;

public class Invitado {

	private int idInvitado;
	private String nombreInvitado;
	private String apellidoInvitado;
	private String identificacionInvitado;
	private int idInscripcion;

	public Invitado(int idInvitado, String nombreInvitado, String apellidoInvitado, String identificacionInvitado,
			int idInscripcion) {
		super();
		this.idInvitado = idInvitado;
		this.nombreInvitado = nombreInvitado;
		this.apellidoInvitado = apellidoInvitado;
		this.identificacionInvitado = identificacionInvitado;
		this.idInscripcion = idInscripcion;
	}

	public Invitado() {
		super();
	}

	public int getIdInvitado() {
		return idInvitado;
	}

	public void setIdInvitado(int idInvitado) {
		this.idInvitado = idInvitado;
	}

	public String getNombreInvitado() {
		return nombreInvitado;
	}

	public void setNombreInvitado(String nombreInvitado) {
		this.nombreInvitado = nombreInvitado;
	}

	public String getApellidoInvitado() {
		return apellidoInvitado;
	}

	public void setApellidoInvitado(String apellidoInvitado) {
		this.apellidoInvitado = apellidoInvitado;
	}

	public String getIdentificacionInvitado() {
		return identificacionInvitado;
	}

	public void setIdentificacionInvitado(String identificacionInvitado) {
		this.identificacionInvitado = identificacionInvitado;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	@Override
	public String toString() {
		return "Invitado [idInvitado=" + idInvitado + ", nombreInvitado=" + nombreInvitado + ", apellidoInvitado="
				+ apellidoInvitado + ", identificacionInvitado=" + identificacionInvitado + ", idInscripcion="
				+ idInscripcion + "]";
	}
	
	
}
