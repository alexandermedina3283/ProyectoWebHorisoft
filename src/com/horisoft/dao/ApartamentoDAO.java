package com.horisoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.horisoft.conexion.Conexion;
import com.horisoft.modelo.Apartamento;


public class ApartamentoDAO {

	private Connection connection;/*atributo de tipo conenection*/
	private PreparedStatement statement;/*atributo para generar canal de conexion para las sentencias sql parametrizadas*/
	private boolean estadoOperacion;/*variable para saber estado de la operacion sql*/

	
	/*metodo para guardar un apartamento, recibe como parametro un objeto de la clase Apartamento*/
	public boolean guardar(Apartamento apartamento) throws SQLException {
		String sql=null; /*variable que almacena la sentencia*/
		estadoOperacion=false;
		connection=obtenerConexion();/*obtener conexion a la bd*/
		
		try {
			connection.setAutoCommit(false);
			sql="insert into apartamento (numero_apartamento,numero_torre,estado_cartera) values (?,?,?)";
			statement=connection.prepareStatement(sql);
			
			statement.setInt(1, apartamento.getApartamento());
			statement.setString(2, apartamento.getTorre());
			statement.setString(3, apartamento.getEstadoCartera());
			
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
	
	/*metodo para editar un apartamento*/
	public boolean editar(Apartamento apartamento) throws SQLException {
		
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="update apartamento set numero_apartamento=?, numero_torre=?,estado_cartera=? where numero_apartamento=? and numero_torre=?";
			statement=connection.prepareStatement(sql);			
			statement.setInt(1, apartamento.getApartamento());
			statement.setString(2, apartamento.getTorre());
			statement.setString(3, apartamento.getEstadoCartera());
			statement.setInt(4, apartamento.getApartamento());
			statement.setString(5, apartamento.getTorre());
			
			
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
	
	/*metodo para eliminar un apartamento*/
	public boolean eliminar(int apartamento, String torre) throws SQLException {

		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="delete from apartamento where numero_apartamento=? and numero_torre=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, apartamento);
			statement.setString(2, torre);
			
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
	
	/*metodo para mostrar listado apartamentos*/
	public List<Apartamento> obtenerApartamentos() throws SQLException {
		
		ResultSet resultSet=null;
		List<Apartamento> listaApartamentos = new ArrayList<>();
		
				
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			
			sql="select * from apartamento";
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Apartamento apartamento = new Apartamento();
				apartamento.setApartamento(resultSet.getInt(1));
				apartamento.setTorre(resultSet.getString(2));
				apartamento.setEstadoCartera(resultSet.getString(3));
				listaApartamentos.add(apartamento);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return listaApartamentos;

	}
	
	/*metodo para mostrar solo un apartamento*/
	public Apartamento obtenerApartamentos(int apartamento, String torre) throws SQLException {

		ResultSet resultSet=null;
		Apartamento apartamentom=new Apartamento();		
				
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			
			sql="select * from apartamento where numero_apartamento=? and numero_torre=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, apartamento);
			statement.setString(2, torre);
			
			
			
			resultSet=statement.executeQuery();
			if (resultSet.next()) {
				
				apartamentom.setApartamento(resultSet.getInt(1));
				apartamentom.setTorre(resultSet.getString(2));
				apartamentom.setEstadoCartera(resultSet.getString(3));
							
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return apartamentom;

	}
	
	
	
	/* metodo para obtener la conexion desde el pool, el metodo retorna una conexion a la bd*/
	
	private Connection obtenerConexion() throws SQLException {
		
		return Conexion.getConnection();
	}
	
}

	

