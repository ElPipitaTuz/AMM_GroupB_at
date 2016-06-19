/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesNservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "Cliente", urlPatterns = {"/cliente.html"}, loadOnStartup = 0)
public class Cliente extends HttpServlet {
    
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
            throws ServletException, IOException, SQLException {
        
        HttpSession session = request.getSession(false);
        request.setAttribute("riepilogoOgg", false);
        request.setAttribute("rifiutato", false);
        request.setAttribute("acquistato", false);
        
        ArrayList<Oggetto> listaOggetti = new ArrayList<Oggetto>();
        listaOggetti = BacuccuFactory.getInstance().getOggettiList();
        request.setAttribute("listaArticoli", listaOggetti);
        
        //accesso login --> cliente
        if(session.getAttribute("logId") == null){
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }
        
        //accesso per URL cliente
        else if (session.getAttribute("logId") != null){
            switch ((String)session.getAttribute("Utente")){
                case ("Seller"): {
                    session.setAttribute("Seller", true);
                    request.setAttribute("notBuyer", "You are a Seller!!");
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }
                case ("Buyer"): { 
                 
                    
                    if (request.getParameter("objCode") != null){
                        
                        session.setAttribute("Buyer", false);
                        request.setAttribute("riepilogoOgg", true);
                        String c_1 = request.getParameter("objCode");
                        Oggetto o1 = BacuccuFactory.getInstance().getOggetto(Integer.parseInt(c_1));
                        request.setAttribute("obj", o1);
                        request.getRequestDispatcher("cliente.jsp").forward(request, response); 
                    }  
                    
                    else if (request.getParameter("objCodeCh") != null){
                        String c_2 = request.getParameter("objCodeCh");
                        Oggetto o2 = BacuccuFactory.getInstance().getOggetto(Integer.parseInt(c_2));
                        UtenteCliente comp = BacuccuFactory.getInstance().catchBuyer((int) session.getAttribute("cf")); 
                        String transResult = BacuccuFactory.getInstance().doTransaction(o2, comp);
                                                                                        
                        if (transResult == "ok") {
                        
                            request.setAttribute("obj", o2);
                            request.setAttribute("acquistato", true);
                            request.getRequestDispatcher("cliente.jsp").forward(request, response);
                        }
                        
                        else {
                            request.setAttribute("rifiutato", true);
                            request.getRequestDispatcher("cliente.jsp").forward(request, response);
                        }
                    }
                        
                    else{
                        request.setAttribute("listaArticoli", listaOggetti);
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);                     
                    }
                }
            }
          
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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