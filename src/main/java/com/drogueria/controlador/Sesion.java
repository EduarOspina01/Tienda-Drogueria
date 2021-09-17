package com.drogueria.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drogueria.modelo.UsuarioDAO;
import com.drogueria.modelo.UsuarioDTO;

/**
 * Valida el inicio de sesion al modulo de drogueria Servlet implementation
 * class Sesion
 */
@WebServlet("/Sesion")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO crud = new UsuarioDAO();
	private UsuarioDTO userDTO = new UsuarioDTO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Peticion al servidor de inicio de sesion, este metodo se comunica con las
	 * usuario y responde a las peticiones del usuario Valida en base de datos que
	 * el usuario y contraseña sean correctas para seguir al inicio de sesion en los
	 * siguientes modulos
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");//Se crea este objeto que almacena un objeto de peticion del formulario HTML
		PrintWriter out = response.getWriter(); // Crea un objeto de la clase PrintWriter que permite mostrar salidas en
												// codigo HTML
		if (accion.equalsIgnoreCase("Ingresar")) { //condicional que valida que el objeto de peticion sea el mismo que el valor del httprequest
			String usuario = request.getParameter("txtUsuario"); // se almacena la peticion del usuario en una variable String
			String contrasena = request.getParameter("txtContraseña"); // se almacena la peticion del usuario en una variable String
			if (usuario != "" && contrasena != "") { // Condicional que valida si los campos no son vacios
				userDTO = crud.validarUsuario(usuario, contrasena); // metodo que valida en la base de datos y trae un objeto de tipo UsuarioDTO
				if (userDTO.getUsuario() != null || userDTO.getContrasena() != null) { //condicional que valida si el objeto usuario no esta nulo
					request.setAttribute("usuario", userDTO);//peticion que envia el valor de un objeto a un objeto en HTML
					request.getRequestDispatcher("Controlador?accion=Principal").forward(request, response);//Peticion que redirecciona por URL
				} else {
					request.getRequestDispatcher("Index.jsp").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("Index.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}

	}

}
