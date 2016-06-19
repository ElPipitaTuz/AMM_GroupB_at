package classesNservlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"}, loadOnStartup = 0)
public class Venditore extends HttpServlet {
    
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
        
        HttpSession session = request.getSession(false);
        request.setAttribute("riepilogoIns", false);
        request.setAttribute("noCompilato", false);
                
        //Controllo per accesso da Login a Venditore, passando per il link senza fare il login
        if (session.getAttribute("logId") == null){
            request.setAttribute("Buyer", true);
            request.getRequestDispatcher("venditore.jsp").forward(request, response);
        }

        else if(session.getAttribute("logId") != null){
            switch ((String)session.getAttribute("Utente")){
                case("Buyer"): {
                    session.setAttribute("Buyer", true);
                    request.setAttribute("notSeller", "You are a buyer!!");
                    request.getRequestDispatcher("cliente.html").forward(request, response);
                }
                case ("Seller"):{
                    //Form Venditore
                    
                    if(request.getParameter("SubmitSell") != null){
                        Oggetto nObj = new Oggetto();
                        nObj.setNome(request.getParameter("name"));
                        nObj.setURL(request.getParameter("URL"));
                        nObj.setDescr(request.getParameter("descr"));
                                                                    
                        try {
                            nObj.setNumber(Integer.parseInt(request.getParameter("number")));
                        } 
                        
                        catch (Exception e) {
                            nObj.setNumber(0);
                        }

                        try {
                            nObj.setPrice(Float.parseFloat(request.getParameter("price")));
                        } 

                        catch (Exception e) {
                            nObj.setPrice(0);
                        }
                        
                        if (nObj.getNome() != null && nObj.getURL() != null && nObj.getDescr() != null &&
                            nObj.getNumber() != 0 && nObj.getPrice() != 0.0) {
                          
                        
                            request.setAttribute("ObjectAdded", nObj);
                            session.setAttribute("Seller", false);
                            request.setAttribute("riepilogoIns", true);
                            request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    
                        }
                        else {
                            session.setAttribute("Buyer", false);
                            session.setAttribute("Seller", false);
                            request.setAttribute("noCompilato", true);
                            request.getRequestDispatcher("venditore.jsp").forward(request, response);
                        }
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
