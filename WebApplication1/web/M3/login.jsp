<%-- 
    Document   : login
    Created on : Apr 27, 2016, 4:08:46 PM
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
           <meta name="descrizione" content="login section">
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
        <li><a href="cliente.html"><strong>Buy</strong></a></li>
        <li><a href="venditore.html"><strong>Sell</strong></a></li>
    </ul>
</nav>
             <!-- fine shortcuts -->
    </div>
    
    <div class="contenuto">
        <c:if test="${error!= null}">
                <p>${error}</p>
            </c:if>

        <h2><strong><b>Sign in</b></strong></h2>

<form action="Login" method="post"> 
     <input type="hidden" name="cmd" value="login">
        <label for="usrnm">ins. username</label>
        <input type="text" name="usrnm" 
               id="usrnm" value="usrnm" />
        <br />
        <label for="psswrd">ins. password</label>
        <input type="password" name="psswrd" 
               id="psswrd" value="psswrd" />
        <br />
        <button type="submit" name="Submit" value="Login">enter</button>  
        
        </form>
    </div>

</body>
    
</html>
