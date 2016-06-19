package classesNservlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class Login extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";               
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 

    public void init(){

        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;

        try {

            Class.forName(JDBC_DRIVER);

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

        }

        BacuccuFactory.getInstance().setConnectionString(dbConnection);

    } 

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
	String username = request.getParameter("usrnm");
        String password = request.getParameter("psswrd");
        request.setAttribute("notLogout", false);
        
        ArrayList<Oggetto> listaOggetti = BacuccuFactory.getInstance().getOggettiList();
         
        
        if(request.getParameter("Submit") == null) {
            
            if(request.getParameter("Logout") != null)//logout
            {
                session.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);     
            }
            
            if (session.getAttribute("logId") != null) {
                switch ((String) session.getAttribute("Utente")) {
                    case ("Buyer"): {
                        request.setAttribute("listaArticoli", listaOggetti);
                        request.getRequestDispatcher("cliente.html").forward(request, response);
                        break;
                    }
                    case ("Seller"): {
                        request.setAttribute("riepilogoOgg", false);
                        request.getRequestDispatcher("venditore.html").forward(request, response);
                        break;}
                    }   
            }
            else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        
        
        else if (request.getParameter("Submit") != null){            
        
            Utente u = BacuccuFactory.getInstance().getUtente(username, password);
            
            if(session.getAttribute("logId") != null){
                
               request.setAttribute("notLogout", true);
               request.getRequestDispatcher("login.jsp").forward(request, response);
            }
               
            if(u != null)
               {
                    session.setAttribute("logId", true);
                    session.setAttribute("cf", u.getId());
                    
                    if(u instanceof UtenteVenditore){
                        
                        session.setAttribute("venditore", u);
                        session.setAttribute("Seller", true);
	                session.setAttribute("Utente", "Seller");
                        request.setAttribute("riepilogoOgg", false);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }
                       
                    else{
                        
                        session.setAttribute("cliente", u);
                        session.setAttribute("Buyer", true);
		        session.setAttribute("Utente", "Buyer");
                        request.setAttribute("listaArticoli", listaOggetti);
                        request.setAttribute("riepilogoOgg", false);
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    
                    }
                
                }
            
            
            request.setAttribute("error", "Username or Password are incorrect, please try again");
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