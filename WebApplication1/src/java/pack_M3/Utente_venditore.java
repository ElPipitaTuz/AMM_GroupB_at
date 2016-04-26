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
public class Utente_venditore {
    
    private String nomeVenditore;
    private String cognomeVenditore;
    private int cf;
    private String usrnm;
    private int psswrd;
    
    //metodi//
    
    public String getnomeVenditore(){
        return nomeVenditore;
    }

    public void setnomeVenditore(String nomeVenditore){
        this.nomeVenditore = nomeVenditore;
    }
    
    public String getconomeVenditore(){
        return cognomeVenditore;
    }

    public void setcognomeVenditore(String cognomeVenditore){
        this.cognomeVenditore = cognomeVenditore;
    }
    
    public String getusrnm(){
        return usrnm;
    }

    public void setusrnm(String usrnm){
        this.usrnm = usrnm;
    }
    
    public int getcf(){
        return cf;
    }

    public void setcf(int cf){
        this.cf = cf;
    }
    
    public int getpsswrd(){
        return psswrd;
    }

    public void setpsswrd(int psswrd){
        this.psswrd = psswrd;
    }
    
}
