package com.drogueria.modelo;

import java.sql.*;

/**
 * Clase conexion que se usa para conectarse con la base de datos
 * @author cesar
 *
 */
public class Conexion {
	private Connection base = null;
    private String url = "jdbc:mysql://localhost:3306/drogueria";
    private String user = "root";
    private String pass = "admin";
    
    /**
     * Constructos que se inicializa estableciendo la conexion con la base de datos
     */
	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            base = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion OK");
        } catch (Exception ex) {
            System.out.println("Error conexion");
        }
	}
	
	/**
	 * Metodo que cierra la conexion con la base de datos
	 */
	public void cerrarConexion() {
        try {
            base.close();
        } catch (Exception ex) {
        	System.out.println("Error al cerrar base");
        }
    }
	
	/*
	 * Getters y Setters
	 */
	public Connection getBase() {
		return base;
	}

	public void setBase(Connection base) {
		this.base = base;
	}
	
	
	
}
