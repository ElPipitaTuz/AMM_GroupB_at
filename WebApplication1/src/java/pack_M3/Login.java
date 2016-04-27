/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_M3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author albertotuzzi
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(true);
        
        if(request.getParameter("submit") != null)
        {
            // Preleva i dati inviati
            String username = request.getParameter("usrnm");
            String password = request.getParameter("psswrd");
            
            ArrayList<Utente_cliente> listaClienti = BacuccuFactory.getInstance().getClienteList();
            for(Utente_cliente c : listaClienti)
            {
                if(c.getusrnm().equals(username) && 
                        c.getpsswrd().equals(password))
                {
                    session.setAttribute("loggedIn", true);
                 
                        request.setAttribute("cliente", c);
                        request.getRequestDispatcher("").forward(request, response);  
                                    
                }
                
            }
            
            ArrayList<Utente_venditore> listaVenditori = BacuccuFactory.getInstance().getVenditoreList();
            for(Utente_venditore v : listaVenditori)
            {
                if(v.getusrnm().equals(username) && 
                        v.getpsswrd().equals(password))
                {
                    session.setAttribute("loggedIn", true);
                 
                        request.setAttribute("venditore", v);
                        request.getRequestDispatcher("").forward(request, response);  
                                    
                }
                
            }
            
        }
        request.getRequestDispatcher("Web Pages/M3/login.jsp").forward(request, response);
 
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
