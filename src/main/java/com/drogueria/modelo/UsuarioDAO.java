package com.drogueria.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
	
	Conexion conectar;
	PreparedStatement sentencia;
	ResultSet resultado;

	public UsuarioDAO() {
		
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioDTO validarUsuario(String user, String pass) {
		conectar = new Conexion();
		UsuarioDTO usuario = new UsuarioDTO();
		String sql = "SELECT * FROM usuario WHERE usuario = ? and password = ?";
		System.out.println("ENTRO METODO");
		try {
			sentencia = conectar.getBase().prepareStatement(sql);
			sentencia.setString(1, user);
			sentencia.setString(2, pass);
			resultado = sentencia.executeQuery();
			System.out.println("ENTRO TRY");
			while (resultado.next()) {
				usuario.setCedula(Long.parseLong(resultado.getString(2)));
				usuario.setNombre(resultado.getString(3));
				usuario.setEmail(resultado.getString(4));
				usuario.setUsuario(resultado.getString(5));
				usuario.setContrasena(resultado.getString(6));
				System.out.println("ENTRO FINAL WHLIE");
				System.out.println(usuario.getContrasena());
			}
		} catch (Exception e) {
			System.out.println("ENTRO CATCH");
			// TODO: handle exception
		}
		return usuario;
	}
	
	public boolean crearUsuario(long cedula,String nombre,String email, String usuario, String password) {
		conectar = new Conexion();
		UsuarioDTO userDTO = new UsuarioDTO(cedula, nombre, email, usuario, password);
		String sql = "INSERT INTO usuario (cedula_usuario,nombre_usuario,email_usuario,usuario,password) VALUES (?,?,?,?,?)";
		System.out.println("ENTRO METODO");
		try {
			sentencia = conectar.getBase().prepareStatement(sql);
			sentencia.setString(1, String.valueOf(userDTO.getCedula()));
			sentencia.setString(2, userDTO.getNombre());
			sentencia.setString(3, userDTO.getEmail());
			sentencia.setString(4, userDTO.getUsuario());
			sentencia.setString(5, userDTO.getContrasena());
			if (sentencia.executeUpdate() > 0) {
                return true;
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public UsuarioDTO consultarUsuario(String cedula) {
		conectar = new Conexion();
		UsuarioDTO userDTO = new UsuarioDTO();
		String sql = "SELECT * FROM usuario WHERE cedula_usuario = ?";
		try {
			sentencia = conectar.getBase().prepareStatement(sql);
			sentencia.setString(1, cedula);
			resultado = sentencia.executeQuery();
			System.out.println("Entro en try");
			while (resultado.next()) {
				userDTO.setCedula(Long.parseLong(resultado.getString(2)));
				userDTO.setNombre(resultado.getString(3));
				userDTO.setEmail(resultado.getString(4));
				userDTO.setUsuario(resultado.getString(5));
				userDTO.setContrasena(resultado.getString(6));
				System.out.println(userDTO.getContrasena());
			}
		} catch (Exception e) {
			System.out.println("Entro en catch");
			// TODO: handle exception
		}
		return userDTO;
	}
	
	public static void main(String[] args) {
		UsuarioDTO usuario = new UsuarioDTO();
		UsuarioDAO dao = new UsuarioDAO();
		usuario = dao.consultarUsuario("1022420439");
		System.out.println(usuario.getUsuario());
		System.out.println(usuario.getContrasena());
	}

}
