<%-- 
    Document   : login
    Created on : Jun 14, 2016, 12:40:57 PM
    Author     : albertotuzzi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alberto Tuzzi">
        <meta name="keywords" content="e-commerce, football, bacuccu">
        <link href="CSS/style.css" rel="stylesheet" 
              type="text/css" media="screen" />
    </head>
    
    <body>
        
        <div class="header">
            <h1><a href="descrizione.jsp"><strong><b>BACUCCU F.C. Official 
                            Online Store</b></strong></a></h1>
                <p><b>-making Cagliari 7-football history since 2007-</b></p>
            <!-- fine intestazione -->
        </div>
    
        <div class="scorciatoie">
            <nav>
                <p><b>Shortcuts</b></p>
                <ul>
                    <li><a href="descrizione.jsp"><strong>Home</strong></a></li>
                    <li><a href="cliente.jsp"><strong>Buy</strong></a></li>
                    <li><a href="venditore.jsp"><strong>Sell</strong></a></li>
                </ul>
            </nav>
            <!-- fine shortcuts -->
        </div>
    
        <div class="contenuto">
            
            <c:if test="${error!= null}">
                
                <p>${error}</p>
                
            </c:if>
            
            <c:if test="${notLogout == true}">
                
                <p>You have to logout from current session!!</p>
                <form action="login.html" method="post">
                        <button type="submit" name="Logout" value="Logout">Sign Out</button>
                        </form>
                
            </c:if>
            
            <!-- messaggio di errore -->
            
            <h2><strong><b>Sign in</b></strong></h2>

            <form action="login.html" method="post"> 
                <label for="usrnm">Username</label>
                <input class="inbox" type="text" name="usrnm" 
                    id="usrnm" value="" />
                <br />
                
                <label class="inbox" for="psswrd">Password</label>
                <input type="password" name="psswrd" 
                    id="psswrd" value="" />
                <br />
                <br />
                <button type="submit" name="Submit" value="Login">enter</button>  
            </form>
        </div>

    </body>
    
</html>
