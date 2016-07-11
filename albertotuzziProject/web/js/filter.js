/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    
    $("#query").keyup(function() {
        
        //recupera il valore di Filtra
        var text= $("#query").val(); 
        
        $.ajax({
            url : "filter.json",
            data:{
                key: "search",
                queryText: text
            },
            dataType: "json",
        
            success: function(data, state){
                aggiornaListaArticoli(data, state);
            },
            error: function(data, state){
                print("errore");
            }
        });

        
        function aggiornaListaArticoli(listaObj){
            
            if (listaObj.length !== 0){
                $("#listaArticoli").empty();
            
                var newtrt = document.createElement("tr");
                var newtd1t = document.createElement("th");
                var newtd2t = document.createElement("th");
                var newtd3t = document.createElement("th");
                var newtd4t = document.createElement("th");
                var newtd5t = document.createElement("th");
            
                newtrt.setAttribute("class", "intest");
                        
                var td1t = document.createTextNode("Object");
                newtd1t.appendChild(td1t);
            
                var td2t = document.createTextNode("Photo");
                newtd2t.appendChild(td2t);
                
                var td3t = document.createTextNode("Remaining");
                newtd3t.appendChild(td3t);
                
                var td4t = document.createTextNode("Price");
                newtd4t.appendChild(td4t);
                
                var td5t = document.createTextNode("Add");
                newtd5t.appendChild(td5t);
            
                newtrt.appendChild(newtd1t);
                newtrt.appendChild(newtd2t);
                newtrt.appendChild(newtd3t);
                newtrt.appendChild(newtd4t);
                newtrt.appendChild(newtd5t);
            
                $("#listaArticoli").append(newtrt);
            
                for(var o in listaObj){
                
                    var newtr = document.createElement("tr");
                    var newtd1 = document.createElement("td");
                    var newtd2 = document.createElement("td");
                    var newtd3 = document.createElement("td");
                    var newtd4 = document.createElement("td");
                    var newtd5 = document.createElement("td");
                
                    newtr.setAttribute("class", "pari");
                                
                    var td1 = document.createTextNode(listaObj[o].nome);
                    newtd1.appendChild(td1);
                
                    var td2 = document.createElement("img");
                    td2.setAttribute("title", "Foto");
                    td2.setAttribute("alt", "Foto " + listaObj[o].nome);
                    td2.setAttribute("width", "70");
                    td2.setAttribute("height", "90");
                    td2.setAttribute("src", listaObj[o].getURL());
                    newtd2.appendChild(td2);
                
                    var td3 = document.createTextNode(listaObj[o].number);
                    newtd3.appendChild(td3);
                
                    var td4 = document.createTextNode(listaObj[o].price + " $");
                    newtd4.appendChild(td4);
                
                    var link = document.createElement("a");
                    link.setAttribute("href", "cliente.html?objCode=" + listaObj[o].code);
                    var registraTxt = document.createTextNode("Add to cart");
                    link.appendChild(registraTxt);
                    newtd5.appendChild(link);
                
                    newtr.appendChild(newtd1);
                    newtr.appendChild(newtd2);
                    newtr.appendChild(newtd3);
                    newtr.appendChild(newtd4);
                    newtr.appendChild(newtd5);
                
                    $("#listaArticoli").append(newtr); 
                }
            }
            
            else {
                $("#listaArticoli").empty();
                $("#paragrafo").empty();
                
                var ad = document.createTextNode("Nessun oggetto trovato");
               
                $("#paragrafo").append(ad);
            }
        }
    });
});


