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

import com.horisoft.dao.ParqueaderoDAO;
import com.horisoft.modelo.Parqueadero;

/**
 * Servlet implementation class ParqueaderoController
 */
@WebServlet("/ParqueaderoController")
public class ParqueaderoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParqueaderoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		if (opcion.equals("crearParqueadero")) {
			System.out.println("seleccionó crear");
			RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/parqueadero/crearParqueadero.jsp");
			requestDispacher.forward(request, response);
			
		}else if(opcion.equals("listarParqueadero")) {	
			
			ParqueaderoDAO parqueaderoDAO = new ParqueaderoDAO();
			List<Parqueadero> lista=new ArrayList<>();
			try {
				lista=parqueaderoDAO.obtenerParqueaderos();
				for (Parqueadero parqueadero : lista) {
					
					System.out.println(parqueadero);
				}
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/parqueadero/listarParqueadero.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("seleccionó listar");
			
		}else if (opcion.equals("editar")) {
			String id=request.getParameter("idParqueadero");
			System.out.println("Editar id: "+id);
			ParqueaderoDAO parqueaderoDAO = new ParqueaderoDAO();
			Parqueadero parqueadero = new Parqueadero(0, id, id, id, 0, id, id, 0, id, id);
			try {
				parqueadero=parqueaderoDAO.obtenerParqueaderos(id);
				System.out.println(parqueadero);
				request.setAttribute("parqueadero", parqueadero);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/parqueadero/editarParqueadero.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(opcion.equals("eliminar")) {
			ParqueaderoDAO parqueaderoDAO = new ParqueaderoDAO();
			String id=request.getParameter("idParqueadero");
			try {
				parqueaderoDAO.eliminar(id);
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

			ParqueaderoDAO parqueaderoDAO = new ParqueaderoDAO();
			Parqueadero parqueadero = new Parqueadero(0, opcion, opcion, opcion, 0, opcion, opcion, 0, opcion, opcion);
			parqueadero.setIdParqueadero(request.getParameter("idParqueadero"));
			parqueadero.setUbicacionParqueadero(request.getParameter("ubicacionParqueadero"));
			parqueadero.setPlacaVehiculo(request.getParameter("placaVehiculo"));
			parqueadero.setModeloVehiculo(Integer.parseInt(request.getParameter("modeloVehiculo")));
			parqueadero.setColorVehiculo(request.getParameter("colorVehiculo"));
			parqueadero.setMarcaVehiculo(request.getParameter("marcaVehiculo"));
			parqueadero.setApartamento(Integer.parseInt(request.getParameter("numApartamento")));
			parqueadero.setTorre(request.getParameter("numTorre"));
			parqueadero.setClaseVehiculo(Integer.parseInt(request.getParameter("claseVehiculo")));

			try {
				parqueaderoDAO.guardar(parqueadero);
				System.out.println("Registro guardado");

				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if (opcion.equals("editar")) {
			Parqueadero parqueadero = new Parqueadero(0, opcion, opcion, opcion, 0, opcion, opcion, 0, opcion, opcion);
			ParqueaderoDAO parqueaderoDAO = new ParqueaderoDAO();
			parqueadero.setIdParqueadero(request.getParameter("idParqueadero"));
			parqueadero.setUbicacionParqueadero(request.getParameter("ubicacionParqueadero"));
			parqueadero.setPlacaVehiculo(request.getParameter("placaVehiculo"));
			parqueadero.setModeloVehiculo(Integer.parseInt(request.getParameter("modeloVehiculo")));
			parqueadero.setColorVehiculo(request.getParameter("colorVehiculo"));
			parqueadero.setMarcaVehiculo(request.getParameter("marcaVehiculo"));
			parqueadero.setApartamento(Integer.parseInt(request.getParameter("numApartamento")));
			parqueadero.setTorre(request.getParameter("numTorre"));
			parqueadero.setClaseVehiculo(Integer.parseInt(request.getParameter("claseVehiculo")));					
			
			try {
				parqueaderoDAO.editar(parqueadero);
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
