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

public abstract class Utente { 
    
    protected int id;
    protected String nome;
    protected String cognome;
    protected String usrnm;
    protected String psswrd;
    
    
    /* Constructor */
    public Utente()
    {
        id = 0;
        nome = "";
        cognome = "";
        usrnm="";
        psswrd="";
        
    }
  
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome_in) {
        this.nome = nome_in;
    }

    
    public String getCognome() {
        return cognome;
    }

    
    public void setCognome(String cognome_in) {
        this.cognome = cognome_in;
    }

    
    public String getUsername() {
        return usrnm;
    }

    
    public void setUsername(String username_in) {
        this.usrnm = username_in;
    }

    
    public String getPassword() {
        return psswrd;
    }

    
    public void setPassword(String password_in) {
        this.psswrd = password_in;
    }
    
    
}