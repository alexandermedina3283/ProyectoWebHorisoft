package com.horisoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.horisoft.conexion.Conexion;
import com.horisoft.modelo.Usuario;

public class UsuarioDAO {

	private Connection connection;/*atributo de tipo conenection*/
	private PreparedStatement statement;/*atributo para generar canal de conexion para las sentencias sql parametrizadas*/
	private boolean estadoOperacion;/*variable para saber estado de la operacion sql*/

	
	/*metodo para guardar un usuario, recibe como parametro un objeto de la clase Usuario*/
	public boolean guardar(Usuario usuario) throws SQLException {
		String sql=null; /*variable que almacena la sentencia*/
		estadoOperacion=false;
		connection=obtenerConexion();/*obtener conexion a la bd*/
		
		try {
			connection.setAutoCommit(false);
			sql="insert into usuario (id_usuario,nombre_usuario,contrasena,estado_usuario,rol_usuario) values (?,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, null);/*no se pasa atributo del modelo por que es autoincrementable*/
			statement.setString(2, usuario.getNombreUsuario());
			statement.setString(3, usuario.getContrasena());
			statement.setString(4, usuario.getEstadoUsuario());
			statement.setString(5, usuario.getRolUsuario());
			
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
	
	/*metodo para editar un usuario*/
	public boolean editar(Usuario usuario) throws SQLException {
		
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="update usuario set nombre_usuario=?, contrasena=?,estado_usuario=?,rol_usuario=? where id_usuario=?";
			statement=connection.prepareStatement(sql);			
			statement.setString(1, usuario.getNombreUsuario());
			statement.setString(2, usuario.getContrasena());
			statement.setString(3, usuario.getEstadoUsuario());
			statement.setString(4, usuario.getRolUsuario());
			statement.setInt(5, usuario.getIdUsuario());
			
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
	
	/*metodo para eliminar un usuario*/
	public boolean eliminar(int idUsuario) throws SQLException {

		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="delete from usuario where id_usuario=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idUsuario);
			
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
	
	/*metodo para mostrar listado usuarios*/
	public List<Usuario> obtenerUsuarios() throws SQLException {
		
		ResultSet resultSet=null;
		List<Usuario> listaUsuarios = new ArrayList<>();
		
				
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			
			sql="select * from usuario";
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Usuario usuario=new Usuario();
				usuario.setIdUsuario(resultSet.getInt(1));
				usuario.setNombreUsuario(resultSet.getString(2));
				usuario.setContrasena(resultSet.getString(3));
				usuario.setEstadoUsuario(resultSet.getString(4));
				usuario.setRolUsuario(resultSet.getString(5));
				listaUsuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return listaUsuarios;

	}
	
	/*metodo para mostrar solo un usuario*/
	public Usuario obtenerUsuarios(int idUsuario) throws SQLException {

		ResultSet resultSet=null;
		Usuario usuario=new Usuario();		
				
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			
			sql="select * from usuario where id_usuario=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idUsuario);
			
			
			
			
			resultSet=statement.executeQuery();
			if (resultSet.next()) {
				
				usuario.setIdUsuario(resultSet.getInt(1));
				usuario.setNombreUsuario(resultSet.getString(2));
				usuario.setContrasena(resultSet.getString(3));
				usuario.setEstadoUsuario(resultSet.getString(4));
				usuario.setRolUsuario(resultSet.getString(5));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return usuario;

	}
	
	/*Metodo validar usuario*/
	
	public boolean validarUsuario(String nombreUsuario, String contrasena) throws SQLException {
		
				
		ResultSet resultSet = null;
		estadoOperacion = false;
		String sql = null;
		connection = obtenerConexion();

		try {

			sql = "select * from usuario where nombre_usuario=? and contrasena=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, nombreUsuario);
			statement.setString(2, contrasena);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {

				estadoOperacion = true;

			} else {

				estadoOperacion = false;
			}

			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return estadoOperacion;

	}
	
	
	
	/* metodo para obtener la conexion desde el pool, el metodo retorna una conexion a la bd*/
	
	private Connection obtenerConexion() throws SQLException {
		
		return Conexion.getConnection();
	}
	
}
