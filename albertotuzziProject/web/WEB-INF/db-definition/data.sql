/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  albertotuzzi
 * Created: Jul 11, 2016
 */

INSERT INTO CLIENTE (id, nome, cognome, username, password, credito)
VALUES (default, 'Joel', 'Zimmerman', 'deadmau5', 'strobe', 5.83),
       (default, 'Sonny', 'Moore', 'skrillex', 'smns', 922.41);

INSERT INTO VENDITORE (id, nome, cognome, username, password, credito)
VALUES (default, 'Alberto', 'Tuzzi', 'a.tuzzi', '0000', 2345.98),
       (default, 'Renato', 'Diana', 'r.diana', '1111', 1067.81);

INSERT INTO OGGETTO (code, nome, descrizione, quant, url, prezzo, vend)
VALUES (default, 'Home Kit', 'match home kit', 344, 'images_web/home_kit.jpg', 89.90, 1),
                (default, 'Away Kit', 'match away kit', 298, 'images_web/away_kit.jpg', 89.90, 1),
                (default, 'Bacuccu F.C. logo Sticker', 'bacuccus logo sticker', 560, 'images_web/scudetto_bacuccu.jpg', 0.80, 2),
                (default, 'Game Socks', 'match cotton socks', 421, 'images_web/calzettoni_bacuccu.jpg', 9.90, 1),
                (default, 'Bacuccu T-Shirt', 'casual bacuccu t-shirt', 232, 'images_web/ILovebacuccu.jpg', 89.90, 2);
