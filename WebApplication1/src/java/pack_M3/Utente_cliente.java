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
public class Utente_cliente {
    
    private String nomeCliente;
    private String cognomeCliente;
    private int cf;
    private String usrnm;
    private String psswrd;
    private double credito;
    private Saldo saldo;
    
    //cotruttore
    
    public Utente_cliente(){
    
        nomeCliente="";
        cognomeCliente="";
        cf=0;
        usrnm="";
        psswrd="";
        credito= 0.0;
    
    }
    
    
    //metodi//
    
    public String getnomeCliente(){
        return nomeCliente;
    }

    public void setnomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }
    
    public String getconomeCliente(){
        return cognomeCliente;
    }

    public void setcognomeCliente(String cognomeCliente){
        this.cognomeCliente = cognomeCliente;
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
