package com.drogueria.modelo;

import java.sql.*;

public class Conexion {
	private Connection base = null;
    private String url = "jdbc:mysql://localhost:3306/drogueria";
    private String user = "root";
    private String pass = "admin";

	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            base = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion OK");
        } catch (Exception ex) {
            System.out.println("Error conexion");
        }
	}
	
	public void cerrarConexion() {
        try {
            base.close();
        } catch (Exception ex) {
        	System.out.println("Error al cerrar base");
        }
    }

	public Connection getBase() {
		return base;
	}

	public void setBase(Connection base) {
		this.base = base;
	}
	
	
	
}
