<%-- 
    Document   : tabellaOggetti
    Created on : May 3, 2016, 11:47:50 AM
    Author     : albertotuzzi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


       
        <table>
            <tr>
                <th><b>Object</b></th>
                <th><b>Photo</b></th>
                <th><b>Remaining</b></th>
                <th><b>Price</b></th>
                <th><b>Add</b></th>
            </tr>
            <c:forEach var="Articolo" items="${listaArticoli}">
            <tr class="dispari">
                <td>${Articolo.objName}</td>
                <td><img title="${Articolo.objName}" alt="${Articolo.objName}" 
                         src="images_web/scudetto_bacuccu.jpg" width="70" height="90"></td>
                <td>${Articolo.objNumber}</td>
                <td>${Articolo.objPrice} $</td>
                <td><a href="cliente.jsp"><b>Add to Cart</b></a></td>
            </tr>
            </c:forEach>  
        </table>    
        
      
        