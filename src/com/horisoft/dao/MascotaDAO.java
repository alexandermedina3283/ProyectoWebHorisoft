package com.horisoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.horisoft.conexion.Conexion;
import com.horisoft.modelo.Mascota;



public class MascotaDAO {

	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public boolean guardar(Mascota mascota) throws SQLException {
		String sql=null; 
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="insert into mascota (id_mascota,nombre_mascota,clase_mascota,numero_apartamento,numero_torre) values (?,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, null);
			statement.setString(2, mascota.getNombre());
			statement.setString(3, mascota.getClase());
			statement.setInt(4, mascota.getApartamento());
			statement.setString(5, mascota.getTorre());
			
			estadoOperacion=statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();/*devuelve la conexion al pool*/
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		
		return estadoOperacion;

	}
	
	
	
	public List<Mascota> obtenerMascotas() throws SQLException {
		
		ResultSet resultSet=null;
		List<Mascota> listaMascotas = new ArrayList<>();
		
				
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			
			sql="select * from mascota";
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Mascota mascota=new Mascota(0, sql, sql, 0, sql, sql);
				mascota.setIdMascota(resultSet.getInt(1));
				mascota.setNombre(resultSet.getString(2));
				mascota.setClase(resultSet.getString(3));
				mascota.setApartamento(Integer.parseInt(resultSet.getString(4)));
				mascota.setTorre(resultSet.getString(5));
				listaMascotas.add(mascota);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return listaMascotas;

	}
	
	public Mascota obtenerMascotas(int idMascota) throws SQLException {

		ResultSet resultSet=null;
		Mascota mascota=new Mascota(idMascota, null, null, idMascota, null, null);		
				
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			
			sql="select * from mascota where id_mascota=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idMascota);			
				
			
			resultSet=statement.executeQuery();
			if (resultSet.next()) {
				
				mascota.setIdMascota(resultSet.getInt(1));
				mascota.setNombre(resultSet.getString(2));
				mascota.setClase(resultSet.getString(3));
				mascota.setApartamento(Integer.parseInt(resultSet.getString(4)));
				mascota.setTorre(resultSet.getString(5));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return mascota;

	}
	
	public boolean editar(Mascota mascota) throws SQLException {
		
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="update mascota set nombre_mascota=?, clase_mascota=? where id_mascota=?";
			statement=connection.prepareStatement(sql);			
			statement.setString(1, mascota.getNombre());
			statement.setString(2, mascota.getClase());
			statement.setInt(3, mascota.getIdMascota());
						
			
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
	
	public boolean eliminar(int idMascota) throws SQLException {

		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="delete from mascota where id_mascota=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idMascota);
			
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
