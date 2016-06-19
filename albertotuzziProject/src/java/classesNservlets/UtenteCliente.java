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

public class UtenteCliente extends Utente {
     
    protected float saldo_c;

    /* Constructor */
    public UtenteCliente()
    {
        
        super();
        
    }

    public float getSaldo(){
        
        return saldo_c;
    
    }
    
    public void setSaldo(float saldo_in){
    
        this.saldo_c = saldo_in;
    
    }


}
