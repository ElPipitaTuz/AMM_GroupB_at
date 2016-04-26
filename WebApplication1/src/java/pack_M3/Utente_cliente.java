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
    private int psswrd;
    
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
    
    public int getpsswrd(){
        return psswrd;
    }

    public void setpsswrd(int psswrd){
        this.psswrd = psswrd;
    }
    
}
