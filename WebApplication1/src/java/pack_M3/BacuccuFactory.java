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
    
    public ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
    
    private ArrayList<Utente_cliente> listaClienti = new ArrayList<Utente_cliente>();
  
    private ArrayList<Utente_venditore> listaVenditori = new ArrayList<Utente_venditore>();
    
    
    private BacuccuFactory(){
    
    //articoli//
        Articolo articolo_1 = new Articolo();
        articolo_1.setobjName("Home Kit");
        articolo_1.setobjURL("lol");
        articolo_1.setobjDescr("pippo");
        articolo_1.setobjPrice(89.90);
        articolo_1.setobjNumber(233);
        listaArticoli.add(articolo_1);
        
        Articolo articolo_2 = new Articolo();
        articolo_2.setobjName("Away Kit");
        articolo_2.setobjURL("lol");
        articolo_2.setobjDescr("pippo");
        articolo_2.setobjPrice(89.90);
        articolo_2.setobjNumber(212);
        listaArticoli.add(articolo_2);
        
        Articolo articolo_3 = new Articolo();
        articolo_3.setobjName("Match Bottoms");
        articolo_3.setobjURL("lol");
        articolo_3.setobjDescr("pippo");
        articolo_3.setobjPrice(35.90);
        articolo_3.setobjNumber(165);
        listaArticoli.add(articolo_3);

        Articolo articolo_4 = new Articolo();
        articolo_4.setobjName("Match socks");
        articolo_4.setobjURL("lol");
        articolo_4.setobjDescr("pippo");
        articolo_4.setobjPrice(9.90);
        articolo_4.setobjNumber(132);
        listaArticoli.add(articolo_4);
        
        Articolo articolo_5 = new Articolo();
        articolo_5.setobjName("T-shirt");
        articolo_5.setobjURL("lol");
        articolo_5.setobjDescr("pippo");
        articolo_5.setobjPrice(25.90);
        articolo_5.setobjNumber(302);
        listaArticoli.add(articolo_5);
        
        Articolo articolo_6 = new Articolo();
        articolo_6.setobjName("Key-keeper");
        articolo_6.setobjURL("lol");
        articolo_6.setobjDescr("pippo");
        articolo_6.setobjPrice(3.90);
        articolo_6.setobjNumber(404);
        listaArticoli.add(articolo_6);
        
        Articolo articolo_7 = new Articolo();
        articolo_7.setobjName("Bathroom Paper");
        articolo_7.setobjURL("lol");
        articolo_7.setobjDescr("pippo");
        articolo_7.setobjPrice(1.90);
        articolo_7.setobjNumber(132);
        listaArticoli.add(articolo_7);
        
        Articolo articolo_8 = new Articolo();
        articolo_8.setobjName("Zippo lighter");
        articolo_8.setobjURL("lol");
        articolo_8.setobjDescr("pippo");
        articolo_8.setobjPrice(6.90);
        articolo_8.setobjNumber(173);
        listaArticoli.add(articolo_8);

        //utenti clienti//
        
        Utente_cliente cliente_1 = new Utente_cliente();
        cliente_1.setnomeCliente("Joel");
        cliente_1.setcognomeCliente("Zimmerman");
        cliente_1.setcf(01);
        cliente_1.setusrnm("deadmau5");
        cliente_1.setpsswrd(01);
        listaClienti.add(cliente_1);
        
        Utente_cliente cliente_2 = new Utente_cliente();
        cliente_2.setnomeCliente("Sonny");
        cliente_2.setcognomeCliente("Moore");
        cliente_2.setcf(02);
        cliente_2.setusrnm("skrillex");
        cliente_2.setpsswrd(02);
        listaClienti.add(cliente_2);
        
        //utenti venditori//
        
        Utente_venditore vend_1 = new Utente_venditore();
        vend_1.setnomeVenditore("Alberto");
        vend_1.setcognomeVenditore("Tuzzi");
        vend_1.setcf(03);
        vend_1.setusrnm("a.tuzzi");
        vend_1.setpsswrd(03);
        listaVenditori.add(vend_1);
        
        Utente_venditore vend_2 = new Utente_venditore();
        vend_2.setnomeVenditore("Renato");
        vend_2.setcognomeVenditore("Diana");
        vend_2.setcf(04);
        vend_2.setusrnm("r.diana");
        vend_2.setpsswrd(04);
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
