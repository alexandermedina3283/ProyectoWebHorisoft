package com.horisoft.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.horisoft.dao.UsuarioDAO;
import com.horisoft.modelo.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion=request.getParameter("opcion");
		if (opcion.equals("crear")) {
			System.out.println("seleccionó crear");
			RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/crear.jsp");
			requestDispacher.forward(request, response);
			
		}else if(opcion.equals("listar")) {	
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario> lista=new ArrayList<>();
			try {
				lista=usuarioDAO.obtenerUsuarios();
				for (Usuario usuario : lista) {
					
					System.out.println(usuario);
				}
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("seleccionó listar");
		}else if (opcion.equals("editar")) {
			int id=Integer.parseInt(request.getParameter("idUsuario"));
			System.out.println("Editar id: "+id);
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = new Usuario();
			try {
				usuario=usuarioDAO.obtenerUsuarios(id);
				System.out.println(usuario);
				request.setAttribute("usuario", usuario);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/editar.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion.equals("eliminar")) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			int id=Integer.parseInt(request.getParameter("idUsuario"));
			try {
				usuarioDAO.eliminar(id);
				System.out.println("Registro eliminado correctamente");
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion=request.getParameter("opcion");
		
		if (opcion.equals("guardar")) {
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = new Usuario();
			usuario.setNombreUsuario(request.getParameter("nombreUsuario"));
			usuario.setContrasena(request.getParameter("contraUsuario"));
			usuario.setEstadoUsuario(request.getParameter("estadoUsuario"));
			usuario.setRolUsuario(request.getParameter("rolUsuario"));
			
			try {
				usuarioDAO.guardar(usuario);
				System.out.println("Registro guardado");
				
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion.equals("editar")) {
			Usuario usuario = new Usuario();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuario.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
			usuario.setNombreUsuario(request.getParameter("nombreUsuario"));
			usuario.setContrasena(request.getParameter("contraUsuario"));
			usuario.setEstadoUsuario(request.getParameter("estadoUsuario"));
			usuario.setRolUsuario(request.getParameter("rolUsuario"));
			try {
				usuarioDAO.editar(usuario);
				System.out.println("Registro actualizado");
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(opcion.equals("validar")) {
			
			System.out.println("seleccionó Validar usuario");
			String NombreUsuario = request.getParameter("nombreUsuario");
			String Clave = request.getParameter("contraUsuario");			
			UsuarioDAO usuarioDAO = new UsuarioDAO();			
			
			
			try {
				if(usuarioDAO.validarUsuario(NombreUsuario, Clave)) {				
					
					RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/Bienvenida.jsp");
					requestDispacher.forward(request, response);
					
				}else {
					
					RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/crear.jsp");
					requestDispacher.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		
		
		//doGet(request, response);
	}

}
