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
    <h2><b>Hi ${Utente_cliente.nomeCliente}, welcome to the Merch Section</b></h2>
    
    <p>your credit:</p>
            <p>${Utente_cliente.saldo} $</p>
    
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
         
            <jsp:include page="tabellaOggetti.jsp"/>
            
        </table>
       </div>

    </body>

</html>