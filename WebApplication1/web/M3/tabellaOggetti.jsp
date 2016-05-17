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
            <c:forEach var="table" items="${listaArticoli}">
            <tr class="dispari">
                <td>${table.objName}</td>
                <td><img title="${table.objName}" alt="${table.objName}" 
                         src="images_web/scudetto_bacuccu.jpg" width="70" height="90"></td>
                <td>${table.objNumber}</td>
                <td>${table.objPrice} $</td>
                <td><a href="cliente.html?objCode=${table.objCode}"<b>Add to Cart</b></a></td>
            </tr>
            </c:forEach>  
        </table>    
        
      
        