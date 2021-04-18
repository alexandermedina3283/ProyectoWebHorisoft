package com.horisoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.horisoft.conexion.Conexion;
import com.horisoft.modelo.Residente;

public class ResidenteDAO {

	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public boolean guardar(Residente residente) throws SQLException {
		String sql=null; 
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="insert into residente (id_residente,nombre_residente,apellido_residente,identificacion_residente,fecha_nacimiento,telefono_residente,email_residente,estado_residente,numero_apartamento,numero_torre,id_categoria) values (?,?,?,?,?,?,?,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, null);
			statement.setString(2, residente.getNombre());
			statement.setString(3, residente.getApellido());
			statement.setString(4, residente.getIdentificacion());
			statement.setDate(5, residente.getFechaNacimiento());
			statement.setString(6, residente.getTelefono());
			statement.setString(7, residente.getEmail());
			statement.setString(8, residente.getEstado());
			statement.setInt(9, residente.getApartamento());
			statement.setString(10, residente.getTorre());
			statement.setInt(11, residente.getCategoria());
			
			
			estadoOperacion=statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		
		return estadoOperacion;

	}
	
	public List<Residente> obtenerResidentes() throws SQLException {

		ResultSet resultSet = null;
		List<Residente> listaResidentes = new ArrayList<>();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {

			sql = "select id_residente,nombre_residente,apellido_residente, identificacion_residente,fecha_nacimiento, telefono_residente, email_residente, estado_residente, numero_apartamento, numero_torre, id_categoria from residente";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Residente residente = new Residente(0, sql, sql, 0, sql, sql, sql, null, sql, sql, sql, 0);
				residente.setIdResidente(resultSet.getInt(1));
				residente.setNombre(resultSet.getString(2));
				residente.setApellido(resultSet.getString(3));
				residente.setIdentificacion(resultSet.getString(4));
				residente.setFechaNacimiento(resultSet.getDate(5));
				residente.setTelefono(resultSet.getString(6));
				residente.setEmail(resultSet.getString(7));
				residente.setEstado(resultSet.getString(8));
				residente.setApartamento(Integer.parseInt(resultSet.getString(9)));
				residente.setTorre(resultSet.getString(10));
				residente.setCategoria(resultSet.getInt(11));				
				listaResidentes.add(residente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaResidentes;

	}
	
	public Residente obtenerResidentes(int idResidente) throws SQLException {

		ResultSet resultSet=null;
		Residente residente=new Residente(idResidente, null, null, idResidente, null, null, null, null, null, null, null, idResidente);		
				
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			
			sql="select id_residente,nombre_residente,apellido_residente, identificacion_residente,fecha_nacimiento, telefono_residente, email_residente, estado_residente, numero_apartamento, numero_torre, id_categoria from residente where id_residente=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idResidente);			
				
			
			resultSet=statement.executeQuery();
			if (resultSet.next()) {
				
				
				residente.setIdResidente(Integer.parseInt(resultSet.getString(1)));
				residente.setNombre(resultSet.getString(2));
				residente.setApellido(resultSet.getString(3));
				residente.setIdentificacion(resultSet.getString(4));
				residente.setFechaNacimiento(resultSet.getDate(5));
				residente.setTelefono(resultSet.getString(6));
				residente.setEmail(resultSet.getString(7));
				residente.setEstado(resultSet.getString(8));
				residente.setApartamento(Integer.parseInt(resultSet.getString(9)));
				residente.setTorre(resultSet.getString(10));
				residente.setCategoria(Integer.parseInt(resultSet.getString(11)));
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return residente;

	}
	
	public boolean editar(Residente residente) throws SQLException {
		
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="update residente set nombre_residente=?, apellido_residente=?, identificacion_residente=?, fecha_nacimiento=?, telefono_residente=?,email_residente=?,estado_residente=?,id_categoria=?  where id_residente=?";
			statement=connection.prepareStatement(sql);				
			statement.setString(1, residente.getNombre());	
			statement.setString(2, residente.getApellido());
			statement.setString(3, residente.getIdentificacion());
			statement.setDate(4, residente.getFechaNacimiento());
			statement.setString(5, residente.getTelefono());
			statement.setString(6, residente.getEmail());
			statement.setString(7, residente.getEstado());			
			statement.setInt(8, residente.getCategoria());
			statement.setInt(9, residente.getIdResidente());
			
			
			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		

		return estadoOperacion;

	}
	
	public boolean eliminar(int idResidente) throws SQLException {

		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="delete from residente where id_residente=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idResidente);
			
			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		

		return estadoOperacion;

	}
	
	private Connection obtenerConexion() throws SQLException {

		return Conexion.getConnection();
	}
	
}
