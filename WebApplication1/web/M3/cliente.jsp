<%-- 
    Document   : cliente
    Created on : Apr 27, 2016, 4:54:55 PM
    Author     : albertotuzzi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
          <title>Buy</title>
          <meta charset="UTF-8">
           <meta name="viewport" content="width=device-width, initial-scale=1.0">
           <meta name="author" content="Alberto Tuzzi">
           <meta name="keywords" content="e-commerce, football, bacuccu">
           <meta name="descrizione" content="buy section">
           <link href="CSS/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    
<body>
    <div class="header">
            <h1><a href="descrizione.html"><strong><b>BACUCCU F.C. Official Online Store</b></strong></a></h1>
         <p><b>-making Cagliari 7-football history since 2007-</b></p>
                 <!-- fine intestazione -->
    </div>
    
    <div class="scorciatoie">       
<nav>
    <p><b>Shortcuts</b></p>
    <ul>
        <li><a href="descrizione.html"><strong>Home_Page</strong></a></li>
        <li><a href="login.html"><strong>Sign_In</strong></a></li>
        <li><a href="venditore.html"><strong>Sell</strong></a></li>
    </ul>
</nav>
        <!-- fine shortcuts-->
        </div>

    <div class="contenuto">
        
        <c:choose>
            
        <c:when test="${Seller == true}">
            <p>Restricted section, please login to continue</p>    
        </c:when>
        
        <c:when test="${Buyer == true}"> 
            
    <h2><b>Hi ${cliente.getnomeCliente()}, welcome to the Merch Section</b></h2>
    
    <p>CF:</p>
            <p>${cliente.getcf()}</p>
    <p>your credit:</p>
            <p>${cliente.getCredito()} $</p>
    
    <p>scroll down and click on "add to cart" to select the items you desire</p>
    
        <h3><strong>Our Stuff</strong></h3>
        
         
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
            
        
        </c:when> 
            
        <c:when test="${riepilogoOgg == true}">
            <div>
            <table>
                <tr> 
                    <th><b>Object</b></th>
                    <th><b>Photo</b></th>
                    <th><b>Remaining</b></th>
                    <th><b>Price</b></th>
                </tr>
               
                <tr class="dispari">
                    <td> ${obj.objName} </td>
                    <td> <img title="${obj.objName}" src="${obj.objURL}" 
                              width="70" height="90" alt="${obj.objName}"/> </td>
                    <td> ${obj.objNumber} </td>
                    <td> ${obj.objPrice} $ </td>
                </tr>
            </table>
                
                <p>your credit: ${cliente.credito} $ </p>    
            <p> <a href="cliente.html?objCodeCh=${obj.objCode}"> Confirm buying </a> </p>
            </div>
        </c:when>  
            
        <c:when test="${acquistato == true}">
                <p> Object bought </p>
                <p> <a href="cliente.html"> Go on </a> </p>
        </c:when>
                
        <c:when test="${rifiutato == true}">
            <p> Warning, not enough credit! </p>
            <p> <a href="cliente.html"> Go on </a> </p>
        </c:when>
                
        </c:choose>
    
       </div>

    </body>

</html>