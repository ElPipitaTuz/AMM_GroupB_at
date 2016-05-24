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
@WebServlet(name = "Cliente", urlPatterns = {"/M3/cliente.html"})
public class Cliente extends HttpServlet {

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
        request.setAttribute("riepilogoOgg", false);
        
        ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
        listaArticoli = BacuccuFactory.getInstance().getArticoloList();
        
        //accesso login --> cliente
        if(session.getAttribute("logId") == null){
            request.setAttribute("Seller", true);
            request.getRequestDispatcher("/M3/cliente.jsp").forward(request, response);
        }
        
        //accesso per URL cliente
        else if (session.getAttribute("logId") != null){
            switch ((String)session.getAttribute("Utente")){
                case ("venditore"): {
                    request.setAttribute("Seller", true);
                    request.getRequestDispatcher("/M3/venditore.jsp").forward(request, response);
                    }
                case ("cliente"): { 
                                            
                    if (request.getParameter("objCode") != null){
                        String code = request.getParameter("objCode");
                        Articolo o1 = BacuccuFactory.getInstance().getArticolo(code);
                    
                        request.setAttribute("obj", o1);
                        request.setAttribute("riepilogoOgg", true);
                        request.getRequestDispatcher("/M3/cliente.jsp").forward(request, response); 
                    }  
                    
                    else if (request.getParameter("objCodeCh") != null){
                        String codech = request.getParameter("objCodeCh");
                        Articolo o2 = BacuccuFactory.getInstance().getArticolo(codech);
                        Double cnt = BacuccuFactory.getInstance().getCliente((int) session.getAttribute("cf")).getCredito();
                        request.setAttribute("credit", cnt);
                                                                                        
                        if (cnt > o2.getobjPrice()) {
                        
                            request.setAttribute("obj", o2);
                            request.setAttribute("acquistato", true);
                            request.getRequestDispatcher("/M3/cliente.jsp").forward(request, response);
                            BacuccuFactory.getInstance().getArticolo("objCodeCh").decrementobjNumber();
                        }
                        
                        else {
                            request.setAttribute("rifiutato", true);
                            request.getRequestDispatcher("/M3/cliente.jsp").forward(request, response);
                        }
                    }
                        
                    else{
                        request.setAttribute("Buyer", true);
                        
                        request.setAttribute("listaArticoli", listaArticoli);
                        request.getRequestDispatcher("/M3/cliente.jsp").forward(request, response);                     
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
