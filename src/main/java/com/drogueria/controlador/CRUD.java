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
 * Servlet implementation class CRUD
 */
@WebServlet("/CRUD")
public class CRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO crud = new UsuarioDAO();
	private UsuarioDTO userDTO = new UsuarioDTO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		String cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String usuario = request.getParameter("user");
		String contrasena = request.getParameter("pass");
		String consultar = request.getParameter("btnConsultar");
		String crear = request.getParameter("btnCrear");
		if (consultar != null) {
			if(cedula != "") {
				userDTO = crud.consultarUsuario(cedula);
				if(userDTO.getCedula() != 0) {
					out.println("<h1>Consulta </h1><br>");
					out.println("<p>Cédula: "+ userDTO.getCedula()+" </p><br>");
					out.println("<p>Nombre: "+ userDTO.getNombre()+" </p><br>");
					out.println("<p>E-mail: "+ userDTO.getEmail()+" </p><br>");
					out.println("<p>Usuario: "+ userDTO.getUsuario()+" </p><br>");
					out.println("<p>Contraseña: "+ userDTO.getContrasena()+" </p><br>");
					out.println("<a href = 'Usuario.jsp'>Volver </a>");
				}else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('El usuario no existe');");
					out.println("location='Usuario.jsp';");
					out.println("</script>");
				}
					
			}else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Por favor ingrese el campo cedula');");
				out.println("location='Usuario.jsp';");
				out.println("</script>");
			}
		}
		if (crear != null) {
			if (cedula != "" && nombre != "" && email != "" && usuario != "" && contrasena != "" ) {
				userDTO = crud.validarUsuario(usuario, contrasena);
				if (userDTO.getCedula()==Long.parseLong(cedula)) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('El usuario ya existe');");
					out.println("location='Usuario.jsp';");
					out.println("</script>");
				}else {
					boolean ban = crud.crearUsuario(Long.parseLong(cedula), nombre, email, usuario, contrasena);
					if (ban) {
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Usuario Creado');");
						out.println("location='Usuario.jsp';");
						out.println("</script>");
					}else {
						out.println("Ha ocurrido un error");
					}
				}
			}else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Por favor dilegencia todos los campos');");
				out.println("location='Usuario.jsp';");
				out.println("</script>");
			}
		}
		
		
	}

}
