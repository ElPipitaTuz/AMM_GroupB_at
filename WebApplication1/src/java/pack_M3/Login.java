/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_M3;

import java.io.IOException;
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
@WebServlet(name = "Login", urlPatterns = {"/login.html"})
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
        
        HttpSession session = request.getSession();
	String username =request.getParameter("Username");
        String password =request.getParameter("Password");
        
        ArrayList<Articolo> listaArticoli = BacuccuFactory.getInstance().getArticoloList();
                
        if(request.getParameter("Submit") == null) {
            
            if (session.getAttribute("logId") != null) {
                switch ((String) session.getAttribute("Utente")) {
                    case ("cliente"): {
                        request.setAttribute("listaArticoli", listaArticoli);
                        request.setAttribute("Buyer", true);
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                        break;
                    }
                    case ("venditore"): {
                        request.setAttribute("Seller", true);
                        request.setAttribute("riepilogoOgg", false);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                        break;}
                    }   
            }
            else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        
        
        else if (request.getParameter("Submit") != null){            
        
            ArrayList<Utente_venditore> listaVenditori = BacuccuFactory.getInstance().getVenditoreList();
            
            for(Utente_venditore u : listaVenditori)
            {
                if(u.getusrnm().equals(username) && u.getpsswrd().equals(password))
                {   
                    session.setAttribute("logId", true);
                    session.setAttribute("cf", u.getcf());
                    
                    if(u instanceof Utente_venditore)
                    {
                        session.setAttribute("venditore", u);
			session.setAttribute("Utente", "venditore");
                        request.setAttribute("Seller", true);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }
                    else
                    {
                        session.setAttribute("cliente", u);
			session.setAttribute("Utente", "cliente");
                        request.setAttribute("Buyer", true);
                        request.setAttribute("listaArticoli", listaArticoli);
                        request.getRequestDispatcher("cliente.jsp")
                                .forward(request, response);
                    }
                }
            }
                request.setAttribute("error", "Username or Password are incorrect, try again");
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
