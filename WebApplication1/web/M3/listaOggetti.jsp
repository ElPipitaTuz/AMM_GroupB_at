<%-- 
    Document   : listaOggetti
    Created on : Apr 26, 2016, 11:43:19 AM
    Author     : albertotuzzi
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<ul>
    <c:forEach var="Articolo" items="${listaArticoli}">
       
        <li>${Articolo.objName}</li>
        
    </c:forEach>    
        
</ul>