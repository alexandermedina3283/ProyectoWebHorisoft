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

import com.horisoft.dao.ApartamentoDAO;
import com.horisoft.modelo.Apartamento;



/**
 * Servlet implementation class ApartamentoController
 */
@WebServlet("/ApartamentoController")
public class ApartamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartamentoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String opcion=request.getParameter("opcion");
		if (opcion.equals("crearapartamento")) {
			System.out.println("seleccionó crear apartamento");
			RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/apartamento/crearApto.jsp");
			requestDispacher.forward(request, response);
			
		}else if(opcion.equals("listarapartamento")) {	
			
			ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
			List<Apartamento> lista=new ArrayList<>();
			try {
				lista=apartamentoDAO.obtenerApartamentos();
				for (Apartamento apartamento : lista) {
					
					System.out.println(apartamento);
				}
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/apartamento/listarApartamento.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
			System.out.println("seleccionó listar");
			
		}else if (opcion.equals("editar")) {
			int apto=Integer.parseInt(request.getParameter("apartamento"));
			String torre= request.getParameter("torre");
			System.out.println("Editar apartamento: "+ apto + "Torre: " + torre);
			
			
			ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
			Apartamento apartamento = new Apartamento();
			try {
				apartamento=apartamentoDAO.obtenerApartamentos(apto,torre);
				System.out.println(apartamento);
				request.setAttribute("apartamento", apartamento);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/apartamento/editarApto.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
		}else if(opcion.equals("eliminar")) {
			ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
			int apto=Integer.parseInt(request.getParameter("apartamento"));
			String torre= request.getParameter("torre");
			try {
				apartamentoDAO.eliminar(apto, torre);
				System.out.println("Registro eliminado correctamente");
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String opcion = request.getParameter("opcion");

		if (opcion.equals("guardar")) {

			ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
			Apartamento apartamento = new Apartamento();
			apartamento.setApartamento(Integer.parseInt(request.getParameter("apartamento")));
			apartamento.setTorre(request.getParameter("torre"));
			apartamento.setEstadoCartera(request.getParameter("cartera"));

			try {
				apartamentoDAO.guardar(apartamento);
				System.out.println("Registro guardado");

				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);

			} catch (SQLException e) {				
				e.printStackTrace();
			}

		} else if (opcion.equals("editar")) {
			Apartamento apartamento = new Apartamento();
			ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
			apartamento.setApartamento(Integer.parseInt(request.getParameter("apartamento")));
			apartamento.setTorre(request.getParameter("torre"));
			apartamento.setEstadoCartera(request.getParameter("cartera"));
			
			try {
				apartamentoDAO.editar(apartamento);
				System.out.println("Registro actualizado");
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);

			} catch (SQLException e) {				
				e.printStackTrace();
			}

		}
	}
}
