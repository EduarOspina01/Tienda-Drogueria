package com.drogueria.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drogueria.modelo.UsuarioDAO;
import com.drogueria.modelo.UsuarioDTO;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO crud = new UsuarioDAO();
	private UsuarioDTO userDTO = new UsuarioDTO();  
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
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
		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");
		if (menu.equals("Principal")) {
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
		}
		if (menu.equals("Usuario")) {
			request.getRequestDispatcher("Usuario.jsp").forward(request, response);
		}
		if (menu.equals("Cliente")) {
			//request.getRequestDispatcher("Usuario.jsp").forward(request, response);
		}
		if (menu.equals("Proveedor")) {
			//request.getRequestDispatcher("Usuario.jsp").forward(request, response);
		}
		if (menu.equals("Producto")) {
			//request.getRequestDispatcher("Usuario.jsp").forward(request, response);
		}
		if (menu.equals("Ventas")) {
			//request.getRequestDispatcher("Usuario.jsp").forward(request, response);
		}
		if (menu.equals("Reporte")) {
			//request.getRequestDispatcher("Usuario.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
