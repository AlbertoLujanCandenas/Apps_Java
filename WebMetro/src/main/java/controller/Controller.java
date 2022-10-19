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

import model.DAOEstacion;
import model.DAOLinea;
import model.Estacion;
import model.LineaLista;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArrayList<LineaLista> lineas;

	private ArrayList<Estacion> estaciones;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        //El constructor del servelet, que esta vacio
        //El controller recibe una petición, hace lo que tiene que hacer y despues devuelve algo
    }

    //---------Podemos pasar datos tanto por doGet o por doPost, en el caso de pasarlo por doPost, el metodo los redirigira al doGet y el doGet 
    //---------es el que se encarga de gestionarlo todo, es Dios.
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Hay que pasarle datos o al session o al request
		
	//Estas 3 lineas son las mas importantes ---------------------------------------
		
		//En session meteremos datos que luego se descargaran desde el otro lado, las variables prevalecen hasta que se cierra el navegador,
		//como una nube donde estan las varaibles. Si subo 2 variables con el mismo nombre se queda la ultima
		HttpSession session = request.getSession();
		//Obtenemos la session de la pag para modificarla si es necesario
		
		//Aqui se recibe lo que tiene que hacer el controller, por asi decirlo el metodo que debera ejecutar
		String op = request.getParameter("op");
		
		//Para pasarle el control a las vistas, con esto se va a hacer luego un forward
		RequestDispatcher dispatcher;
		
	//------------------------------------------------------------------------------	
		
		/*Lo mejor para poner datos:
		 * - request: cosas que cambian continuamente (estaciones, cambian dependiendo de que linea se elija)
		 * - session: cosas que no cambian (lineas, siempre son las mismas)
		 */
		
		if (op.equals("inicio")) {
			//Los DAOs se encargan de obtener los datos, el controller solo se los pasa al session o al request(los datos solo duran una ida y venida)
			lineas = new DAOLinea().getLineas();
			
			//Las lineas obtenidas las metemos en session
			session.setAttribute("lineas", lineas);
			
			//Que abra la pagina home.jsp y que se vea en el navegador esa pagina
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			//Redirige request y response al dispatcher

		} else if (op.equals("dameestaciones")) {
			
			//Guardamos el numero de la linea que se ha elegido
			String linea = request.getParameter("linea");
			
			//Con DAOEstacion obtenemos las estaciones con la linea
			estaciones = new DAOEstacion().getEstaciones(linea);
			
			//Colocamos lo mismo de antes, pero lo metemos en el request porque estara recalculando todo el rato
			request.setAttribute("estaciones", estaciones);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//
	}

}
