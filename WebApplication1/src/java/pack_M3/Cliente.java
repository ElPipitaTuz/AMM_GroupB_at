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
@WebServlet(name = "Cliente", urlPatterns = {"/cliente.html"})
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
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(true);
        
        ArrayList<Utente_cliente> listaClienti = BacuccuFactory.getInstance().getClienteList();
            for(Utente_cliente c : listaClienti)
            {
                if(c instanceof Utente_cliente){
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
                
                else{
                    try(PrintWriter out = response.getWriter()){
                        out.println("<!DOCTYPE html>");
                        out.println("<title>Access Denied</title>");
                        out.println("<meta charset=\"UTF-8\">");
                        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                        out.println("<meta name=\"author\" content=\"Alberto Tuzzi\">");
                        out.println("<link href=\"CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<div class=\"header\">");
                        out.println("<h1><a href=\"descrizione.html\"><strong><b>BACUCCU F.C. Official Online Store</b></strong></a></h1>");
                        out.println("<p><b>-making Cagliari 7-football history since 2007-</b></p>");
                        out.println("</div>");
                        out.println("<div class=\"scorciatoie\">");
                        out.println("<nav>");
                        out.println("<p><b>Shortcuts</b></p>");
                        out.println("<ul>");
                        out.println("<li><a href=\"descrizione.html\"><strong>Home_Page</strong></a></li>");
                        out.println("<li><a href=\"login.html\"><strong>Sign_In</strong></a></li>");
                        out.println("<li><a href=\"cliente.html\"><strong>Buy</strong></a></li>");
                        out.println("</ul>");
                        out.println("</nav>");
                        out.println("</div>");
                        out.println("<div class=\"contenuto\">");
                        out.println("<h2>Access Denied</h2>");
                        out.println("<p>you are not a seller</p>");
                        out.println("</div>");
                        out.println("</body>");
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
