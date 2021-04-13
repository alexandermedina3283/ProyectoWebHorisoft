package com.horisoft.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
	
	/*creacion atributo de tipo basicdatasource*/
	private static BasicDataSource dataSource=null; /*static porque cuando acceda al pool no crea un objeto, se utiliza directamente la clase */
	
	/*metodo que devuelva un objeto de tipo datasource que contendra los datos necesarios para la conexion*/
	private static DataSource getDataSource() {
		
		/*parametros del pool de conexiones*/
		if (dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("");
			dataSource.setUrl("jdbc:mysql://localhost:3306/horisoft?useTimezone=true&serverTimezone=UTC");
			dataSource.setMaxIdle(10);/* Cuantas conexiones pueden estar activas */
			dataSource.setMaxTotal(10);/* Total de conexiones */
			dataSource.setMaxWaitMillis(5000);/* Tiempo espera para la conexión */
			
		}
		
		return dataSource;
	}
	
	/*Metodo para retornar la conexion */
	public static Connection getConnection() throws SQLException {
		
		return getDataSource().getConnection();
	}

}
