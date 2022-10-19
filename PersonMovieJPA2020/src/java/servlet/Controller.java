/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entities.Movie;
import entities.Person;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author pacopulido
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    private EntityTransaction transaction;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        
        String op;
        String sql;
        Query query;
        List<Person> lp;
        List<Movie> lm;
        
        EntityManager em = (EntityManager) session.getAttribute("em");
        if (em == null) {
            em = jpautil.JPAUtil.getEntityManagerFactory().createEntityManager();
            session.setAttribute("em", em);
        }

        op = request.getParameter("op");

        if (op.equals("inicio")) {
            sql = "select p from Person p";
            query = em.createQuery(sql);
            lp = query.getResultList();
            session.setAttribute("lp", lp);
            
            sql = "select m from Movie m";
            query = em.createQuery(sql);
            lm = query.getResultList();
            session.setAttribute("lm", lm);

            session.setAttribute("ficha", "person");
            dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);

        } else if (op.equals("personomovie")) {
            String ficha = request.getParameter("ficha");
            session.setAttribute("ficha", ficha);
            dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        } else if (op.equals("movies")) {  // aquí no se llega->se llamó a la vista con ajax desde mainview
            String i = (String) request.getParameter("i");
            lp = (List<Person>)session.getAttribute("lp");
            Person person = lp.get(Integer.parseInt(i)); 
            List<Movie> lmp = person.getMovieList();
            request.setAttribute("lmp", lmp);
            dispatcher = request.getRequestDispatcher("movies.jsp");
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
