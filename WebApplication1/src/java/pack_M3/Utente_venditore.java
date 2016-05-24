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
    private String psswrd;
    private double credito;
    private Saldo saldo;
    
    //cotruttore
    public Utente_venditore(){
        cf = 0;
        nomeVenditore = "";
        cognomeVenditore = "";
        usrnm = "";
        psswrd = "";
        credito = 0.0;
    }
    
    
    //metodi//
    
    public String getnomeVenditore(){
        return nomeVenditore;
    }

    public void setnomeVenditore(String nomeVenditore){
        this.nomeVenditore = nomeVenditore;
    }
    
    public String getcognomeVenditore(){
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
    
    public String getpsswrd(){
        return psswrd;
    }

    public void setpsswrd(String psswrd){
        this.psswrd = psswrd;
    }
    
    public void setCredito(double cr){
        this.credito = cr;
        }
    
    public double getCredito(){
        return credito;
    }
    
    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }
    
}
