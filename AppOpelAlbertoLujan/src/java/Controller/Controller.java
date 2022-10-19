package controller;

import Entities.Acabado;
import Entities.Modelo;
import Entities.Modeloacabado;
import Entities.Tipo;
import Entities.Usuario;
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
                EntityTransaction t;
                EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
                List<Tipo> tipos;
                List<Modelo> modelos;
                List<Modelo> modelosTipo;
                List<Acabado> acabados;
                Usuario usuario;
		if (op.equals("inicio")) {
                    session.removeAttribute("idcoche");
                    session.removeAttribute("acabados");
                    session.removeAttribute("cochepulsado");
                    session.removeAttribute("modelosTipo");
                    q = em.createNamedQuery("Tipo.findAll");
                    tipos = q.getResultList();
                    session.setAttribute("tipos", tipos);
                    q = em.createNamedQuery("Modelo.findAll");
                    modelos = q.getResultList();   
                    session.setAttribute("modelos", modelos);
                    
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
		} else if (op.equals("1")) {
                    session.removeAttribute("modelos");
                    q = em.createNamedQuery("Tipo.findAll");
                    tipos = q.getResultList();
                    
                    for(int i = 0; i < 1; i++){
                        modelosTipo = tipos.get(i).getModeloList();
                        session.setAttribute("modelosTipo", modelosTipo);
                    }
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
		}else if (op.equals("2")){
                    session.removeAttribute("modelos");
                    session.removeAttribute("modelosTipo");
                    q = em.createNamedQuery("Tipo.findAll");
                    tipos = q.getResultList();
                    
                    for(int i = 1; i < 2; i++){
                        modelosTipo = tipos.get(i).getModeloList();
                        session.setAttribute("modelosTipo", modelosTipo);
                    }
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                }else if (op.equals("3")){
                    session.removeAttribute("modelos");
                    session.removeAttribute("modelosTipo");
                    q = em.createNamedQuery("Tipo.findAll");
                    tipos = q.getResultList();
                    
                    for(int i = 2; i < 3; i++){
                        modelosTipo = tipos.get(i).getModeloList();
                        session.setAttribute("modelosTipo", modelosTipo);
                    }
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                }else if (op.equals("4")){
                    session.removeAttribute("modelos");
                    session.removeAttribute("modelosTipo");
                    q = em.createNamedQuery("Tipo.findAll");
                    tipos = q.getResultList();
                    
                    for(int i = 3; i < 4; i++){
                        modelosTipo = tipos.get(i).getModeloList();
                        session.setAttribute("modelosTipo", modelosTipo);
                    }
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                }else if(op.equals("login")){
                    String nick =(String) request.getParameter("nick");
                    String pass = (String) request.getParameter("pass");
                    
                    q = em.createQuery("SELECT u FROM Usuario u WHERE u.nick = :nick and u.pass = :pass");
                    q.setParameter("nick", nick);
                    q.setParameter("pass", pass);
                    
                    try{
                        usuario = (Usuario)q.getSingleResult();
                        
                    }catch(Exception e){
                        Short numero = 1;
                        usuario = new Usuario(numero);
                        usuario.setNick(nick);
                        usuario.setPass(pass);
                        
                        t = em.getTransaction();
                        t.begin();
                        em.persist(usuario);
                        t.commit();
                    }
                    
                    session.setAttribute("usuario", usuario);
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                }else if(op.equals("logout")){
                    session.removeAttribute("usuario");
                    
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                }else if(op.equals("cochepulsado")){
                    String idcoche = (String) request.getParameter("idcoche");
                    Modelo cochepulsado = em.find(Modelo.class, Short.parseShort(idcoche));
                    session.setAttribute("idcoche", cochepulsado);
                    
                    q = em.createNamedQuery("Acabado.findAll");
                    acabados = q.getResultList();
                    session.setAttribute("acabados", acabados);
                    
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
