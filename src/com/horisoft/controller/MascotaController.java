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

import com.horisoft.dao.MascotaDAO;
import com.horisoft.modelo.Mascota;



/**
 * Servlet implementation class MascotaController
 */
@WebServlet("/MascotaController")
public class MascotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MascotaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		if (opcion.equals("crearMascota")) {
			System.out.println("seleccionó crear");
			RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/mascota/crearMascota.jsp");
			requestDispacher.forward(request, response);
			
		}else if(opcion.equals("listarMascota")) {	
			
			MascotaDAO mascotaDAO = new MascotaDAO();
			List<Mascota> lista=new ArrayList<>();
			try {
				lista=mascotaDAO.obtenerMascotas();
				for (Mascota mascota : lista) {
					
					System.out.println(mascota);
				}
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/mascota/listarMascota.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("seleccionó listar");
			
		}else if (opcion.equals("editar")) {
			int id=Integer.parseInt(request.getParameter("idMascota"));
			System.out.println("Editar id: "+id);
			MascotaDAO mascotaDAO = new MascotaDAO();
			Mascota mascota = new Mascota(id, opcion, opcion, id, opcion, opcion);
			try {
				mascota=mascotaDAO.obtenerMascotas(id);
				System.out.println(mascota);
				request.setAttribute("mascota", mascota);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/mascota/editarMascota.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(opcion.equals("eliminar")) {
			MascotaDAO mascotaDAO = new MascotaDAO();
			int id=Integer.parseInt(request.getParameter("idMascota"));
			try {
				mascotaDAO.eliminar(id);
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
		
		String opcion=request.getParameter("opcion");
		
		if (opcion.equals("guardar")) {
			
			MascotaDAO mascotaDAO = new MascotaDAO();
			Mascota mascota = new Mascota(0, opcion, opcion, 0, opcion, opcion);
			mascota.setNombre(request.getParameter("nombreMascota"));
			mascota.setClase(request.getParameter("claseMascota"));
			mascota.setApartamento(Integer.parseInt(request.getParameter("numApartamento")));
			mascota.setTorre(request.getParameter("numTorre"));
			
			try {
				mascotaDAO.guardar(mascota);
				System.out.println("Registro guardado");
				
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (opcion.equals("editar")) {
			Mascota mascota = new Mascota(0, opcion, opcion, 0, opcion, opcion);
			MascotaDAO mascotaDAO = new MascotaDAO();
			mascota.setIdMascota(Integer.parseInt(request.getParameter("idMascota")));
			mascota.setNombre(request.getParameter("nombreMascota"));
			mascota.setClase(request.getParameter("claseMascota"));
			mascota.setApartamento(Integer.parseInt(request.getParameter("numApartamento")));
			mascota.setTorre(request.getParameter("numTorre"));
			try {
				mascotaDAO.editar(mascota);
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
