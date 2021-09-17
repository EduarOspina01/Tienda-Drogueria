package com.drogueria.modelo;

/**
 * Clase de DTO de la tabla Usuario del proyecto drogueria ciclo3
 * @author cesar
 *
 */
public class UsuarioDTO {
	
	private long cedula;
	private String nombre;
	private String email;
	private String usuario;
	private String contrasena;

	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa el objeto con los parametos usuario y contraseña
	 * @param usuario 
	 * @param contrasena
	 */
	public UsuarioDTO(String usuario, String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	
	/**
	 * Constructor que inicializa todos los atributos de la tabla usuario
	 * @param cedula
	 * @param nombre
	 * @param email
	 * @param usuario
	 * @param contrasena
	 */
	public UsuarioDTO(long cedula, String nombre, String email, String usuario, String contrasena) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.email = email;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	
	/*
	 * Getters y Setters
	 */
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
