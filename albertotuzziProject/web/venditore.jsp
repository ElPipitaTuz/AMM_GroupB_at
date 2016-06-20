<%-- 
    Document   : venditore
    Created on : Jun 14, 2016, 1:26:01 PM
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
                <li><a href="login.jsp"><strong>Sign In</strong></a></li>
                <li><a href="cliente.html"><strong>Buy</strong></a></li>
            </ul>
            </nav>
            <!-- fine shortcuts -->
        </div>
        
        
        <div class="contenuto">
            
            <c:choose>
                
                <c:when test="${Buyer == true || logId == null}">
                    
                    <p>Restricted section, please <a href="login.jsp"> login </a> to continue</p>    
        
                </c:when>
                    
                <c:when test="${noCompilato == true}">
                    
                    <p> You have to fill all the fields </p>
                    <p> <a href="venditore.jsp"> Go on </a> </p>
                    <c:set var="Seller" scope="session" value="true" />
                    
                </c:when>
               
                <c:when test="${Seller == true}">
                    <h2><b>Welcome back mr. ${venditore.getNome()} 
                            ${venditore.getCognome()}</b></h2>
                        
                        <p>CF:</p>
                        <p>${venditore.getId()}</p>
                        
                        <p>your credit:</p>
                        <p>${venditore.getSaldo()} $</p>
                        
                        <form action="login.html" method="post">
                        <button type="submit" name="Logout" value="Logout">Sign Out</button>
                        </form>
                        
                         <c:if test="${notBuyer!= null}">
                
                            <p>${notBuyer}</p>
                
                        </c:if>

                    <h2><strong><b>New Object Form</b></strong></h2>
                    
            
                    <form action="venditore.html" method="post"> 
                
                        <label for="objname">Object name</label>
                        <input type="text" name="name" 
                            id="objname" value="" />
                        <br />
                
                        <label for="objURL">Object URL</label>
                        <input type="url" name="URL" 
                            id="objURL" value="" />
                        <br />
                
                        <label for="objDescr">Object brief description</label>
                        <textarea rows="3" cols="10" 
                            name="descr" id="objDescr"> 
                            describe object </textarea>
                        <br />
                
                        <label for="objPrice">Object price($)</label>
                        <input type="number" name="price" 
                            id="objPrice" value="0" />
                        <br />
                
                        <label for="objNumber">n of objects available</label>
                        <input type="number" name="number" 
                            id="objNumber" value="0" />
                        <br />
                
                        <button type="submit" name="SubmitSell" 
                                value="new product">Submit</button>
                        <br />
                        <button type="submit" name="ObjectMod" 
                                value="mod product">Update</button>
                        <br />
                        <label for="objToDel">Object to Delete code</label>
                        <input type="number" name="code" 
                            id="objToDel" value="0" />
                        
                        <button type="submit" name="ObjectCanc" 
                                value="del product">Delete</button>
                
                    </form>
                
                </c:when>
                    
                <c:when test="${riepilogoIns == true}">
            
                    <div>
                    <h3> New Object </h3>
                        <table>  
                            <tr>
                                <th><b>Object</b></th>
                                <th><b>Photo</b></th>
                                <th><b>Description</b></th>
                                <th><b>Remaining</b></th>
                                <th><b>Price</b></th>
                            </tr>
                
                            <tr>
                                <td> ${ObjectAdded.nome} </td>
                                <td> <img title="${ObjectAdded.nome}"
                                          src="${ObjectAdded.URL}" 
                                    width="70" height="nome}"/> </td>
                                <td class="Descrizione"> 
                                    ${ObjectAdded.descr} </td>
                                <td> ${ObjectAdded.number} </td>
                                <td> ${ObjectAdded.price} $ </td>
                            </tr>
                        </table>
                
                        <p> <a href="venditore.jsp"> Confirm and proceed </a> </p>
                        <c:set var="Seller" scope="session" value="true" />
                
                    </div>
                
                </c:when>    
                    
                    <c:when test="${riepilogoMod == true}">
            
                    <div>
                    <h3> Updated Object </h3>
                        <table>  
                            <tr>
                                <th><b>Object</b></th>
                                <th><b>Photo</b></th>
                                <th><b>Description</b></th>
                                <th><b>Remaining</b></th>
                                <th><b>Price</b></th>
                            </tr>
                
                            <tr>
                                <td> ${ObjectAdded.nome} </td>
                                <td> <img title="${ObjectAdded.nome}"
                                          src="${ObjectAdded.URL}" 
                                    width="70" height="nome}"/> </td>
                                <td class="Descrizione"> 
                                    ${ObjectAdded.descr} </td>
                                <td> ${ObjectAdded.number} </td>
                                <td> ${ObjectAdded.price} $ </td>
                            </tr>
                        </table>
                
                        <p> <a href="venditore.jsp"> Confirm and proceed </a> </p>
                        <c:set var="Seller" scope="session" value="true" />
                
                    </div>
                
                </c:when>    
                    
                <c:when test="${riepilogoCanc == true}">
            
                    <div>
                    <h3> Deleted Object </h3>
                        <table>  
                            <tr>
                                <th><b>Object</b></th>
                                <th><b>Photo</b></th>
                                <th><b>Description</b></th>
                                <th><b>Remaining</b></th>
                                <th><b>Price</b></th>
                            </tr>
                
                            <tr>
                                <td> ${ObjectAdded.nome} </td>
                                <td> <img title="${ObjectAdded.nome}"
                                          src="${ObjectAdded.URL}" 
                                    width="70" height="nome}"/> </td>
                                <td class="Descrizione"> 
                                    ${ObjectAdded.descr} </td>
                                <td> ${ObjectAdded.number} </td>
                                <td> ${ObjectAdded.price} $ </td>
                            </tr>
                        </table>
                
                        <p> <a href="venditore.jsp"> Confirm and proceed </a> </p>
                        <c:set var="Seller" scope="session" value="true" />
                
                    </div>
                
                </c:when>        
                    
            </c:choose>
            
        </div>
    </body>
    
</html>
