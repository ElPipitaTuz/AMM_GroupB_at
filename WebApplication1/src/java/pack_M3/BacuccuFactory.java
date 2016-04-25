/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_M3;

/**
 *
 * @author albertotuzzi
 */
import java.util.ArrayList;


public class BacuccuFactory {
    private static BacuccuFactory costr;
    public static BacuccuFactory getInstance() {
        if (costr == null) {
            costr = new BacuccuFactory();
        }
        return costr;
    }
    
    private ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
    
    private ArrayList<Utente_cliente> listaClienti = new ArrayList<Utente_cliente>();
  
    private ArrayList<Utente_venditore> listaVenditori = new ArrayList<Utente_venditore>();
    
    
    private BacuccuFactory(){
    
    //articoli//
        Articolo articolo_1 = new Articolo();
        articolo_1.objName = "Home Kit";
        articolo_1.objURL = "lol";
        articolo_1.objDescr = "pippo";
        articolo_1.objPrice = 89.90;
        articolo_1.objNumber = 233;
        listaArticoli.add(articolo_1);
        
        Articolo articolo_2 = new Articolo();
        articolo_2.objName = "Away Kit";
        articolo_2.objURL = "lol";
        articolo_2.objDescr = "pippo";
        articolo_2.objPrice = 89.90;
        articolo_2.objNumber = 212;
        listaArticoli.add(articolo_2);
        
        Articolo articolo_3 = new Articolo();
        articolo_3.objName = "Match Bottoms";
        articolo_3.objURL = "lol";
        articolo_3.objDescr = "pippo";
        articolo_3.objPrice = 35.90;
        articolo_3.objNumber = 165;
        listaArticoli.add(articolo_3);

        Articolo articolo_4 = new Articolo();
        articolo_4.objName = "Match socks";
        articolo_4.objURL = "lol";
        articolo_4.objDescr = "pippo";
        articolo_4.objPrice = 9.90;
        articolo_4.objNumber = 132;
        listaArticoli.add(articolo_4);
        
        Articolo articolo_5 = new Articolo();
        articolo_5.objName = "T-shirt";
        articolo_5.objURL = "lol";
        articolo_5.objDescr = "pippo";
        articolo_5.objPrice = 25.90;
        articolo_5.objNumber = 302;
        listaArticoli.add(articolo_5);
        
        Articolo articolo_6 = new Articolo();
        articolo_6.objName = "Key-keeper";
        articolo_6.objURL = "lol";
        articolo_6.objDescr = "pippo";
        articolo_6.objPrice = 3.90;
        articolo_6.objNumber = 404;
        listaArticoli.add(articolo_6);
        
        Articolo articolo_7 = new Articolo();
        articolo_7.objName = "Bathroom Paper";
        articolo_7.objURL = "lol";
        articolo_7.objDescr = "pippo";
        articolo_7.objPrice = 1.90;
        articolo_7.objNumber = 132;
        listaArticoli.add(articolo_7);
        
        Articolo articolo_8 = new Articolo();
        articolo_8.objName = "Zippo lighter";
        articolo_8.objURL = "lol";
        articolo_8.objDescr = "pippo";
        articolo_8.objPrice = 6.90;
        articolo_8.objNumber = 173;
        listaArticoli.add(articolo_8);

        //utenti clienti//
        
        Utente_cliente cliente_1 = new Utente_cliente();
        cliente_1.nomeCliente = "Joel";
        cliente_1.cognomeCliente = "Zimmerman";
        cliente_1.cf = 01;
        cliente_1.usrnm = "deadmau5";
        cliente_1.psswrd = 01;
        listaClienti.add(cliente_1);
        
        Utente_cliente cliente_2 = new Utente_cliente();
        cliente_2.nomeCliente = "Sonny";
        cliente_2.cognomeCliente = "Moore";
        cliente_2.cf = 02;
        cliente_2.usrnm = "skrillex";
        cliente_2.psswrd = 02;
        listaClienti.add(cliente_2);
        
        //utenti venditori//
        
        Utente_venditore vend_1 = new Utente_venditore();
        vend_1.nomeVenditore = "Alberto";
        vend_1.cognomeVenditore = "Tuzzi";
        vend_1.cf = 03;
        vend_1.usrnm = "a.tuzzi";
        vend_1.psswrd = 03;
        listaVenditori.add(vend_1);
        
        Utente_venditore vend_2 = new Utente_venditore();
        vend_2.nomeVenditore = "Renato";
        vend_2.cognomeVenditore = "Diana";
        vend_2.cf = 04;
        vend_2.usrnm = "r.diana";
        vend_2.psswrd = 04;
        listaVenditori.add(vend_2);
        
    }
    
    public ArrayList<Utente_cliente> getClienteList()
    {
        return listaClienti;
    }
    
    public Utente_cliente getCliente(int cf_in)
    {
        for(Utente_cliente c : listaClienti)
        {
            if(c.cf == cf_in)
                return c;
        }
        
        return null;
    }
    
    
    
    public ArrayList<Utente_venditore> getVenditoreList()
    {
        return listaVenditori;
    }
    
    public Utente_venditore getVenditore(int cf_in)
    {
        for(Utente_venditore v : listaVenditori)
        {
            if(v.cf == cf_in)
                return v;
        }
        
        return null;
    }
    
    
    
}
