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
            <json:property name="name" value="${o.getNome()}"/>
            <json:property name="price" value="${o.getPrice()}"/>
            <json:property name="code" value="${o.getCode()}"/>
            <json:property name="number" value="${o.getNumber()}"/>
            <json:property name="url" value="${o.getURL()}"/>
        </json:object>
    </c:forEach>
</json:array>
