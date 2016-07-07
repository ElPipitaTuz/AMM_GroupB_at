<%-- 
    Document   : listaFiltrataJson
    Created on : Jul 7, 2016, 4:01:01 PM
    Author     : albertotuzzi
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:array>
    <c:forEach var="o" items="${listaObj}">
        <json:object>
            <json:property name="nome" value="${o.nome}"/>
            <json:property name="prezzo" value="${o.price}"/>
            <json:property name="id" value="${o.code}"/>
            <json:property name="pezzi" value="${o.number}"/>
            <json:property name="url" value="${o.url}"/>
        </json:object>
    </c:forEach>
</json:array>
