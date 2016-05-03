<%-- 
    Document   : venditore
    Created on : Apr 27, 2016, 4:49:06 PM
    Author     : albertotuzzi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
          <title>Sell</title>
          <meta charset="UTF-8">
           <meta name="viewport" content="width=device-width, initial-scale=1.0">
           <meta name="author" content="Alberto Tuzzi">
           <meta name="keywords" content="e-commerce, football, bacuccu">
           <meta name="descrizione" content="sell section">
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
        <li><a href="cliente.html"><strong>Buy</strong></a></li>
    </ul>
</nav>
     <!-- fine shortcuts -->
       </div>
        
        
        <div class="contenuto">
            <h2><b>Welcome back mr. ${Utente_venditore.nomeVenditore} ${Utente_venditore.cognomeVenditore}</b></h2>
            <p>your credit:</p>
            <p>${Utente_venditore.saldo} $</p>
          

         <h3><strong><b>New Object</b></strong></h3>
<form action="venditore.html" method="post"> 
        <label for="objname">Object name</label>
        <input type="text" name="objname" 
               id="objname" value="objname" />
        <br />
        <label for="objURL">Object URL</label>
        <input type="url" name="objURL" 
               id="objURL" value="" />
        <br />
        <label for="objDescr">Object brief description</label>
        <textarea rows="3" cols="10" 
                name="objDescr" id="objDescr"> describe object </textarea>
        <br />
        <label for="objPrice">Object price($)</label>
        <input type="number" name="objPrice" 
               id="objPrice" value="0" />
        <br />
        <label for="objNumber">n of objects available</label>
        <input type="number" name="objNumber" 
               id="objNumber" value="0" />
        <br />
        <button type="submit">submit</button>
        </form>
        </div>
    </body>
</html>