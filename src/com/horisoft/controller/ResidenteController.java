package com.horisoft.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.horisoft.dao.ResidenteDAO;
import com.horisoft.modelo.Residente;


/**
 * Servlet implementation class ResidenteController
 */
@WebServlet("/ResidenteController")
public class ResidenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidenteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		if (opcion.equals("crearResidente")) {
			System.out.println("seleccionó crear");
			RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/residente/crearResidente.jsp");
			requestDispacher.forward(request, response);
			
		}else if(opcion.equals("listarResidente")) {	
			
			ResidenteDAO residenteDAO = new ResidenteDAO();
			List<Residente> lista=new ArrayList<>();
			try {
				lista=residenteDAO.obtenerResidentes();
				for (Residente residente : lista) {
					
					System.out.println(residente);
				}
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/residente/listarResidente.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("seleccionó listar");
			
		}else if (opcion.equals("editar")) {
			int id=Integer.parseInt(request.getParameter("idResidente"));
			System.out.println("Editar id: "+id);
			ResidenteDAO residenteDAO = new ResidenteDAO();
			Residente residente = new Residente(id, opcion, opcion, id, opcion, opcion, opcion, null, opcion, opcion, opcion, id);
			try {
				residente=residenteDAO.obtenerResidentes(id);
				System.out.println(residente);
				request.setAttribute("residente", residente);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/residente/editarResidente.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(opcion.equals("eliminar")) {
			ResidenteDAO residenteDAO = new ResidenteDAO();
			int id=Integer.parseInt(request.getParameter("idResidente"));
			try {
				residenteDAO.eliminar(id);
				System.out.println("Registro eliminado correctamente");
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");

		if (opcion.equals("guardar")) {

			ResidenteDAO residenteDAO = new ResidenteDAO();
			Residente residente = new Residente(0, opcion, opcion, 0, opcion, opcion, opcion, null, opcion, opcion, opcion, 0);
			residente.setNombre(request.getParameter("nombreResidente"));
			residente.setApellido(request.getParameter("apellidoResidente"));
			residente.setIdentificacion(request.getParameter("identificacionResidente"));
			residente.setFechaNacimiento(Date.valueOf(request.getParameter("fechaNacimiento")));
			residente.setTelefono(request.getParameter("telefonoResidente"));
			residente.setEmail(request.getParameter("emailResidente"));
			residente.setEstado(request.getParameter("estadoResidente"));
			residente.setApartamento(Integer.parseInt(request.getParameter("numApartamento")));
			residente.setTorre(request.getParameter("numTorre"));
			residente.setCategoria(Integer.parseInt(request.getParameter("categoriaResidente")));
			
			
			try {
				residenteDAO.guardar(residente);
				System.out.println("Registro guardado");

				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if (opcion.equals("editar")) {
			ResidenteDAO residenteDAO = new ResidenteDAO();
			Residente residente = new Residente(0, opcion, opcion, 0, opcion, opcion, opcion, null, opcion, opcion, opcion, 0);
			residente.setIdResidente(Integer.parseInt(request.getParameter("idResidente")));
			residente.setNombre(request.getParameter("nombreResidente"));
			residente.setApellido(request.getParameter("apellidoResidente"));
			residente.setIdentificacion(request.getParameter("identificacionResidente"));
			residente.setFechaNacimiento(Date.valueOf(request.getParameter("fechaNacimiento")));
			residente.setTelefono(request.getParameter("telefonoResidente"));
			residente.setEmail(request.getParameter("emailResidente"));
			residente.setEstado(request.getParameter("estadoResidente"));
			residente.setApartamento(Integer.parseInt(request.getParameter("numApartamento")));
			residente.setTorre(request.getParameter("numTorre"));
			residente.setCategoria(Integer.parseInt(request.getParameter("categoriaResidente")));				
			
			try {
				residenteDAO.editar(residente);
				System.out.println("Registro actualizado");
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
