<%-- 
    Document   : listaArticoliJson
    Created on : Jun 12, 2016, 7:06:42 PM
    Author     : albertotuzzi
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="obj" items="${listaArticoli}">
        <json:object>
            <json:property name="nome" value="${obj.nome}"/>
            <json:property name="cognome" value="${alunno.cognome}"/>
            <json:property name="id" value="${alunno.id}"/>
        </json:object>
    </c:forEach>
</json:array>
