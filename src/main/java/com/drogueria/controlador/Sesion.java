package com.drogueria.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.drogueria.modelo.UsuarioDAO;
import com.drogueria.modelo.UsuarioDTO;

/** Valida el inicio de sesion al modulo de drogueria
 * Servlet implementation class Sesion
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/** Peticion al servidor de inicio de sesion, este metodo se comunica con las usuario y responde a las peticiones del usuario
	 * Valida en base de datos que el usuario y contraseña sean correctas para seguir al inicio de sesion en los siguientes modulos
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); //Crea un objeto de la clase PrintWriter que permite mostrar salidas en codigo HTML
		String usuario = request.getParameter("txtUsuario"); // se almacena la peticion del usuario en una variable String
		String contrasena = request.getParameter("txtContraseña"); // se almacena la peticion del usuario en una variable String
		if (usuario != "" && contrasena != "" ) { //Condicional que valida si los campos no son vacios
			userDTO = crud.validarUsuario(usuario, contrasena);
			if (userDTO.getUsuario() == null || userDTO.getContrasena()==null) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Usuario o Contraseña Incorrecta');");
				out.println("location='Index.jsp';");
				out.println("</script>");
			}else {
				HttpSession sesion = request.getSession(true); // se inicia un objeto de tipo sesion
				response.sendRedirect("Menu.jsp");	// Se redirecciona a la pagina principal
				/**if(userDTO.getUsuario().equals(usuario) && userDTO.getContrasena().equals(contrasena)) { // Condicional que valida si los datos corresponden con la base de datos
					HttpSession sesion = request.getSession(true); // se inicia un objeto de tipo sesion
					response.sendRedirect("Menu.jsp");	// Se redirecciona a la pagina principal		
				}else { //Se envia una alerta indicando que el usuario o contraseña son incorrectos
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Usuario o Contraseña Incorrecta');");
					out.println("location='Index.jsp';");
					out.println("</script>");
				}**/
			}
		}else { //Se envia una alerta indicando que alguno de los campos estan vacios
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Por favor llene todos los campos');");
			out.println("location='Index.jsp';");
			out.println("</script>");
		}
		
	}

}
