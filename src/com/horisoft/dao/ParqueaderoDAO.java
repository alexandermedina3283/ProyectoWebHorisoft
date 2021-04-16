package com.horisoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.horisoft.conexion.Conexion;
import com.horisoft.modelo.Parqueadero;


public class ParqueaderoDAO {

	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public boolean guardar(Parqueadero parqueadero) throws SQLException {
		String sql=null; 
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="insert into parqueadero_vehiculo (id_parqueadero,ubicacion_parqueadero, placa_vehiculo, modelo_vehiculo, color_vehiculo,marca_vehiculo, numero_apartamento, numero_torre, id_clase_vehiculo) values (?,?,?,?,?,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, parqueadero.getIdParqueadero());
			statement.setString(2, parqueadero.getUbicacionParqueadero());
			statement.setString(3, parqueadero.getPlacaVehiculo());
			statement.setInt(4, parqueadero.getModeloVehiculo());
			statement.setString(5, parqueadero.getColorVehiculo());
			statement.setString(6, parqueadero.getMarcaVehiculo());
			statement.setInt(7, parqueadero.getApartamento());
			statement.setString(8, parqueadero.getTorre());
			statement.setInt(9, parqueadero.getClaseVehiculo());					
						
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
	
	public List<Parqueadero> obtenerParqueaderos() throws SQLException {

		ResultSet resultSet = null;
		List<Parqueadero> listaParqueaderos = new ArrayList<>();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {

			sql = "select * from parqueadero_vehiculo";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				
				Parqueadero parqueadero = new Parqueadero(0, sql, sql, sql, 0, sql, sql, 0, sql, sql);								
				parqueadero.setIdParqueadero(resultSet.getString(1));
				parqueadero.setUbicacionParqueadero(resultSet.getString(2));
				parqueadero.setPlacaVehiculo(resultSet.getString(3));
				parqueadero.setModeloVehiculo(resultSet.getInt(4));
				parqueadero.setColorVehiculo(resultSet.getString(5));
				parqueadero.setMarcaVehiculo(resultSet.getString(6));
				parqueadero.setApartamento(Integer.parseInt(resultSet.getString(7)));
				parqueadero.setTorre(resultSet.getString(8));
				parqueadero.setClaseVehiculo(Integer.parseInt(resultSet.getString(9)));					
				
				listaParqueaderos.add(parqueadero);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaParqueaderos;

	}
	
	public Parqueadero obtenerParqueaderos(String idParqueadero) throws SQLException {

		ResultSet resultSet=null;
		Parqueadero parqueadero=new Parqueadero(0, idParqueadero, idParqueadero, idParqueadero, 0, idParqueadero, idParqueadero, 0, idParqueadero, idParqueadero);		
				
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			
			sql="select * from parqueadero_vehiculo where id_parqueadero=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, idParqueadero);			
				
			
			resultSet=statement.executeQuery();
			if (resultSet.next()) {
				
				
				parqueadero.setIdParqueadero(resultSet.getString(1));
				parqueadero.setUbicacionParqueadero(resultSet.getString(2));
				parqueadero.setPlacaVehiculo(resultSet.getString(3));
				parqueadero.setModeloVehiculo(Integer.parseInt(resultSet.getString(4)));
				parqueadero.setColorVehiculo(resultSet.getString(5));
				parqueadero.setMarcaVehiculo(resultSet.getString(6));
				parqueadero.setApartamento(Integer.parseInt(resultSet.getString(7)));
				parqueadero.setTorre(resultSet.getString(8));
				parqueadero.setClaseVehiculo(Integer.parseInt(resultSet.getString(9)));
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return parqueadero;

	}
	
	public boolean editar(Parqueadero parqueadero) throws SQLException {
		
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="update parqueadero_vehiculo set placa_vehiculo=?, modelo_vehiculo=?, color_vehiculo=?, marca_vehiculo=?, id_clase_vehiculo=? where id_parqueadero=?";
			statement=connection.prepareStatement(sql);				
			statement.setString(1, parqueadero.getPlacaVehiculo());	
			statement.setInt(2, parqueadero.getModeloVehiculo());
			statement.setString(3, parqueadero.getColorVehiculo());
			statement.setString(4, parqueadero.getMarcaVehiculo());
			statement.setInt(5, parqueadero.getClaseVehiculo());
			statement.setString(6, parqueadero.getIdParqueadero());
			
						
			
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
	
	public boolean eliminar(String idParqueadero) throws SQLException {

		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="delete from parqueadero_vehiculo where id_parqueadero=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, idParqueadero);
			
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
