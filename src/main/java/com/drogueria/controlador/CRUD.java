package com.drogueria.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long cedula;
		cedula=Long.parseLong(request.getParameter("id"));
		System.out.println(cedula);
		userDTO = crud.consultarUsuario(String.valueOf(cedula));
		request.setAttribute("usuario", userDTO);
		request.getRequestDispatcher("Usuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		String cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String usuario = request.getParameter("user");
		String contrasena = request.getParameter("pass");
		String consultar = request.getParameter("Consultar");
		String Agregar = request.getParameter("Agregar");
		String Listar = request.getParameter("Listar_Usuarios");
		String eliminar = request.getParameter("Eliminar");
		String modificar = request.getParameter("Actualizar");
		if (Listar != null) {
			List lista = crud.listarUsuario();
			request.setAttribute("usuarios", lista);
			request.getRequestDispatcher("Usuario.jsp").forward(request, response);
		}
		if (consultar != null) {
			if (cedula != "") {
				userDTO = crud.consultarUsuario(cedula);
				if (userDTO.getCedula() != 0) {
					List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
					lista.add(userDTO);
					request.setAttribute("usuarios", lista);
					request.getRequestDispatcher("Usuario.jsp").forward(request, response);
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('El usuario no existe');");
					out.println("location='Usuario.jsp';");
					out.println("</script>");
				}

			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Por favor ingrese el campo cedula');");
				out.println("location='Usuario.jsp';");
				out.println("</script>");
			}
		}
		if (Agregar != null) {
			if (cedula != "" && nombre != "" && email != "" && usuario != "" && contrasena != "") {
				userDTO = crud.consultarUsuario(cedula);
				if (userDTO.getCedula() == Long.parseLong(cedula)) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('El usuario ya existe');");
					out.println("location='Usuario.jsp';");
					out.println("</script>");
				} else {
					boolean ban = crud.crearUsuario(Long.parseLong(cedula), nombre, email, usuario, contrasena);
					if (ban) {
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Usuario Creado');");
						out.println("location='Usuario.jsp';");
						out.println("</script>");
					} else {
						out.println("Ha ocurrido un error");
					}
				}
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Por favor dilegencia todos los campos');");
				out.println("location='Usuario.jsp';");
				out.println("</script>");
			}
		}
		if (eliminar != null) {
			if (cedula != "") {
				boolean user = crud.eliminarUsuario(cedula);
				if (user != false) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('El usuario ha sido eliminado');");
					out.println("location='Usuario.jsp';");
					out.println("</script>");

				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Cedula errada');");
					out.println("location='Usuario.jsp';");
					out.println("</script>");

				}
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Por favor ingrese el campo cedula');");
				out.println("location='Usuario.jsp';");
				out.println("</script>");

			}
		}
		if (modificar != null) {
			if (cedula != "" && nombre != "" && email != "" && usuario != "" && contrasena != "") {
				userDTO.setCedula(Long.parseLong(cedula));
				userDTO.setNombre(nombre);
				userDTO.setEmail(email);
				userDTO.setUsuario(usuario);
				userDTO.setContrasena(contrasena);
					boolean ban = crud.modificarUsuario(cedula,userDTO);
					if (ban) {
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Datos del Usuario Actualizados');");
						out.println("location='Usuario.jsp';");
						out.println("</script>");
					} else {
						out.println("Ha ocurrido un error");
					}
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Datos faltantes: Por favor dilegencia todos los campos');");
				out.println("location='Usuario.jsp';");
				out.println("</script>");
			}
		}
	}
}
