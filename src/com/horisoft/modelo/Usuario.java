package com.horisoft.modelo;

public class Usuario {
	
	/*atributos de la clase*/
	private int idUsuario;
	private String nombreUsuario;
	private String contrasena;
	private String estadoUsuario;
	private String rolUsuario;
	
	/*Constructor con los atributos*/
	public Usuario(int idUsuario, String nombreUsuario, String contrasena, String estadoUsuario, String rolUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.estadoUsuario = estadoUsuario;
		this.rolUsuario = rolUsuario;
	}
	
	/*Constructor vacio*/
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	/*Metodos getter y setter para que se pueda acceder a los atributos desde afuera de la clase*/
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public String getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}
	/*creacion metodo toString se usa para retornar todos los atributos de la clase*/
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena
				+ ", estadoUsuario=" + estadoUsuario + ", rolUsuario=" + rolUsuario + "]";
	}
	
	
	
	
	
	

}
