<%-- 
    Document   : cliente
    Created on : Jun 14, 2016, 12:57:11 PM
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
        <link href="CSS/style.css" rel="stylesheet" type="text/css" media="screen" />
        
        <!-- jQuery -->
        <script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/filter.js"></script>
      
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
                <li><a href="login.jsp"><strong>Sign In</strong></a></li>
                <li><a href="venditore.jsp"><strong>Sell</strong></a></li>
            </ul>
            </nav>
            <!-- fine shortcuts-->
        </div>

        <div class="contenuto">
            
            <c:choose>
                
                <c:when test="${Seller == true || logId == null}">
                   
                    <p>Restricted section, please <a href="login.jsp"> login </a> to continue</p>    
         
                    
                </c:when>
                    
                <c:when test="${Buyer == true}"> 
            
                    <h2><b>Hi ${cliente.getNome()}, 
                            welcome to the Merch Section</b></h2>
    
                        <p>Buyer ID:</p>
                        <p>${cliente.getId()}</p>
                        <p>your credit:</p>
                        <p>${cliente.getSaldo()} $</p>
                        
                        <c:if test="${notSeller!= null}">
                
                            <p>${notSeller}</p>
                
                        </c:if>
                        
                        <form action="login.html" method="post">
                            <label for="log">Logout:</label>
                            <button id="log" class="logout" type="submit" name="Logout" value="Logout">Sign Out</button>
                        </form>
                        <br />
                        <br />
                        <br />
                        <p>Scroll down, or use the filter, and click on "add to cart" 
                            to select the items you desire</p>
   
                        <div class="filtro">
                            <label for="query">filter</label>
                            <input type="text" name="filter" 
                                 id="query" />
                            <br />
                        </div>    
                        
                        
    
                    <h3 class="noMatchMessage"><strong>Our Stuff</strong></h3>
        
         
                    <table id="listaArticoli">
                       
                        <tr>
                            <th><b>Object</b></th>
                            <th><b>Photo</b></th>
                            <th><b>Remaining</b></th>
                            <th><b>Price</b></th>
                            <th><b>Add</b></th>
                        </tr>
                        
                    <c:forEach var="o" items="${listaArticoli}">
                        <tr class="dispari">
                            <td>${o.nome}</td>
                            <td><img title="${o.nome}" 
                                     alt="${o.nome}" 
                                src="${o.URL}" 
                                width="70" height="90"></td>
                            <td>${o.number}</td>
                            <td>${o.price} $</td>
                            <td><a href="cliente.html?objCode=${o.code}"
                                   <b>Add to Cart</b></a></td>
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
                            <td> ${obj.nome} </td>
                            <td> <img title="${obj.nome}" src="${obj.URL}" 
                              width="70" height="90" alt="${obj.nome}"/> </td>
                            <td> ${obj.number} </td>
                            <td> ${obj.price} $ </td>
                        </tr>
                        
                    </table>
                
                    <p>your credit: ${cliente.getSaldo()} $ </p>    
                    <p> <a href="cliente.html?objCodeCh=${obj.code}"> 
                            Confirm</a> </p>
                    </div>
                            
                </c:when> 
                    
                <c:when test="${acquistato == true}">
                    
                    <p> Object bought </p>
                    <p> <a href="cliente.html"> Go on </a> </p>
                    <c:set var="Buyer" scope="session" value="true" />
                </c:when>
                    
                
                <c:when test="${rifiutato == true}">
                    
                    <p> Warning, not enough credit! </p>
                    <p> <a href="cliente.html"> Go on </a> </p>
                    <c:set var="Buyer" scope="session" value="true" />
                </c:when>    
            
            </c:choose>
            
        </div>

    </body>

</html>
