<%-- 
    Document   : listaFiltrataJson
    Created on : Jul 1, 2016, 10:24:45 AM
    Author     : albertotuzzi
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:array>
    <c:forEach var="current" items="${listaArticoli}">
        <json:object>
            <json:property name="nome" value="${current.nome}"/>
            <json:property name="price" value="${current.price}"/>
            <json:property name="code" value="${current.code}"/>
            <json:property name="number" value="${current.number}"/>
            <json:property name="url" value="${current.URL}"/>
        </json:object>
    </c:forEach>
</json:array>