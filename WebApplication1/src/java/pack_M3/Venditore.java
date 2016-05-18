/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_M3;

import java.io.IOException;
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
@WebServlet(name = "Venditore", urlPatterns = {"/M3/venditore.html"})
public class Venditore extends HttpServlet {

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
                
        //Controllo per accesso da Login a Venditore, passando per il link senza fare il login
        if (session.getAttribute("logId") == null){
            request.setAttribute("Buyer", true);
            request.getRequestDispatcher("/M3/venditore.jsp").forward(request, response);
        }

        else if(session.getAttribute("logId") != null){
            switch ((String)session.getAttribute("Utente")){
                case("cliente"): {
                    request.setAttribute("Buyer", true);
                    request.getRequestDispatcher("/M3/cliente.jsp").forward(request, response);
                }
                case ("venditore"):{
                    //Form Venditore
                    if(request.getParameter("SubmitSell") != null){
                        Articolo nObj = new Articolo();
                        nObj.setobjCode(request.getParameter("objCode"));
                        nObj.setobjName(request.getParameter("objName"));
                        nObj.setobjURL(request.getParameter("objURL"));
                        nObj.setobjDescr(request.getParameter("objDescr"));
                                                                    
                        try {
                            nObj.setobjNumber(Integer.parseInt(request.getParameter("objNumber")));
                        } 
                        
                        catch (Exception e) {
                            nObj.setobjNumber(0);
                        }

                        try {
                            nObj.setobjPrice(Double.parseDouble(request.getParameter("objPrice")));
                        } 

                        catch (Exception e) {
                            nObj.setobjPrice(0);
                        }
                        
                        if (nObj.getobjName() != null && nObj.getobjURL() != null && nObj.getobjDescr() != null &&
                            nObj.getobjNumber() != 0 && nObj.getobjPrice() != 0.0) {
                          
                        
                            request.setAttribute("ObjectAdded", nObj);
                            request.setAttribute("riepilogoIns", true);
                            request.getRequestDispatcher("/M3/venditore.jsp").forward(request, response);
                    
                        }
                        else {
                            request.setAttribute("noCompilato", true);
                            request.getRequestDispatcher("/M3/venditore.jsp").forward(request, response);
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
