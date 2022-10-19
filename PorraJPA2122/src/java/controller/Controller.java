package controller;

import entities.Apuesta;
import entities.Jornada;
import entities.Usuario;
import entities.Porra;
import entities.PorraPK;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.JPAUtil;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
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
                Query q;
                List<Jornada> jornadas;
                Jornada jornada;
                Usuario usuario;
                Porra porra;
                EntityTransaction t;
                String msg;
                
                EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
                
		if (op.equals("inicio")) {
                    q = em.createNamedQuery("Jornada.findAll");
                    jornadas = q.getResultList();
                    session.setAttribute("jornadas", jornadas);
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
		} else if (op.equals("vajornada")) {
                    String indexjornada = request.getParameter("jornada");
                    jornadas = (List<Jornada>)session.getAttribute("jornadas");
                    jornada = jornadas.get(Integer.parseInt(indexjornada));
                    session.setAttribute("partidos", jornada.getPartidoList());
                    session.setAttribute("indexjornada", indexjornada);
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
		} else if (op.equals("login")) {
                    String dni = request.getParameter("dni");
                    String nombre = request.getParameter("nombre");
                    usuario = em.find(Usuario.class, dni);
                    if (usuario==null) {
                        usuario = new Usuario(dni);
                        usuario.setNombre(nombre);
                        t = em.getTransaction();
                        t.begin();
                        em.persist(usuario);
                        t.commit();
                        msg="User created...";
                    }
                    else {
                        msg="Login user ok...";
                    }
                    
                    session.setAttribute("msg", msg);
                    session.setAttribute("usuario", usuario);
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
		} else if (op.equals("logout")) {
                    session.removeAttribute("usuario");
                    msg="Logout success...";
                    session.setAttribute("msg", msg);
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
		} else if (op.equals("apostar")) {
                    String dni = request.getParameter("dni");
                    String idpartido = request.getParameter("idpartido");
                    String goleslocal = request.getParameter("goleslocal");
                    String golesvisitante = request.getParameter("golesvisitante");
                    
                    // comprobamos primeramente si ya apostó para ese partido este usuario
                    // Si no lo hicieramos podríamos violar la primary key
                    PorraPK porraPK = new PorraPK(dni, Integer.parseInt(idpartido));
                    porra = em.find(Porra.class , porraPK);
                    if (porra!=null){
                        msg="Este usuario ya apostó por este partido";
                    }
                    else {
                        porra = new Porra(porraPK);
                        porra.setGoleslocal(Short.valueOf(goleslocal));
                        porra.setGolesvisitante(Short.valueOf(golesvisitante));

                        t = em.getTransaction();
                        t.begin();
                        em.persist(porra);
                        t.commit();   
                        msg="Anotada apuesta...";
                    }
                    session.setAttribute("msg", msg);
                    

                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
		} else if (op.equals("apuestas")) {
                    String idpartido = request.getParameter("idpartido");
                    String sql = "select p.goleslocal, p.golesvisitante, count(p) "
                            + "from Porra p where p.partido.idpartido=:idpartido "
                            + "group by p.goleslocal, p.golesvisitante";
                    q = em.createQuery(sql);
                    q.setParameter("idpartido", Short.valueOf(idpartido));
                    List<Object[]> resultList = q.getResultList();
                    List<Apuesta> apuestas = new ArrayList<>();
                    
                    for (Object[] row : resultList) {
                        apuestas.add(new Apuesta((Short) row[0], (Short) row[1], (Long) row[2]));
                    }
                    session.setAttribute("apuestas", apuestas);
                    dispatcher = request.getRequestDispatcher("showapuestas.jsp");
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
