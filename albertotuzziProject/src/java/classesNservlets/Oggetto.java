/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesNservlets;

/**
 *
 * @author albertotuzzi
 */

public class Oggetto {
    
    private int code;
    private int id_v;
    private String nome;
    private float price;
    private String descr;
    private String URL;
    private int number;
    
    /* Constructor */
    public Oggetto()
    {
        code = 0;
        id_v= 0;
        nome = "";
        price = 0;
        descr = "";
        URL = "";
        number =0;
        
    }
    
    
    public String getNome() 
    {
        return nome;
    }

    
    public void setNome(String nome_in) 
    {
        this.nome = nome_in;
    }

    
    public int getCode() 
    {
        return code;
    }

    
    public void setCode(int code_in) 
    {
        this.code = code_in;
    }
    
    public float getPrice()
    {
        return price;
    }
    
    public void setPrice(float prezzo)
    {
        this.price = prezzo;
    }
    
    public void setDescr(String descrizione)
    {
        this.descr= descrizione;
    }
    
    public String getDescr()
    {
        return descr;
    }
    
    public String getURL()
    {
        return URL;
    }
    
    public void setURL(String img)
    {
        this.URL = img;
    }
    
    public void setNumber(int quantity)
    {
        this.number = quantity;
    }
    
    public int getNumber()
    {
        return number;
    }
   
    public void setIdV(int id_venditore)
    {
        this.id_v= id_venditore;
    }
    
    public int getIdV()
    {
        return id_v;
    }
    
    
}