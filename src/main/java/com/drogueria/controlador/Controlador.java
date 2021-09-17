package com.drogueria.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		switch (accion) {
		case "Principal":
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
			break;
		case "Usuario":
			request.getRequestDispatcher("Usuario.jsp").forward(request, response);
			break;
		case "Cliente":
			//request.getRequestDispatcher("Menu.jsp").forward(request, response);
			break;
		case "Proveedor":
			//request.getRequestDispatcher("Menu.jsp").forward(request, response);
			break;
		case "Producto":
			//request.getRequestDispatcher("Menu.jsp").forward(request, response);
			break;
		case "Ventas":
			//request.getRequestDispatcher("Menu.jsp").forward(request, response);
			break;
		case "Reporte":
			//request.getRequestDispatcher("Menu.jsp").forward(request, response);
			break;
		
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
