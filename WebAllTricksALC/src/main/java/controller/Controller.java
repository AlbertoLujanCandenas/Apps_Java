package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bici;
import model.DAOBici;
import model.DAOMarca;
import model.Marca;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArrayList<Marca> marcas;
	private ArrayList<Bici> bicis;

	private ArrayList<Bici> biciFavorita;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		RequestDispatcher dispatcher;
		if (op.equals("inicio")) {
			
			bicis = new DAOBici().getBiciByMarca("%", null, "%");
			request.setAttribute("bicis", bicis);
			marcas = new DAOMarca().getMarca();
			session.setAttribute("marcas", marcas);
			
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);

		} else if (op.equals("dameBicis")) {
			String marca = request.getParameter("marca");
			String marcaSeleccionada = new DAOMarca().getMarcaSola(marca);
 			bicis = new DAOBici().getBiciByMarca(marca,null,"%");
			request.setAttribute("biciMarca", bicis);
			request.setAttribute("marcaSeleccionada", marcaSeleccionada);
			
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			
		}else if(op.equals("ordenar")) {
			String ordenado = request.getParameter("ordenado");
			bicis = new DAOBici().getBiciByMarca("%", ordenado, "%");
			System.out.println(ordenado);
			
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			
		}else if(op.equals("fav")){
 			biciFavorita = new DAOBici().getBiciByMarca("%",null,"1");
			request.setAttribute("biciFavorita", biciFavorita);
			
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			
		}else if(op.equals("ponerFav")) {
			String marca = request.getParameter("marca");
			String marcaSeleccionada = new DAOMarca().getMarcaSola(marca);
			bicis = new DAOBici().setFav(marcaSeleccionada, 1);
			request.setAttribute("biciMarca", bicis);
			request.setAttribute("marcaSeleccionada", marcaSeleccionada);
 			
 			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
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
