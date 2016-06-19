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

public class UtenteVenditore extends Utente{
    
    protected float saldo_v;
    
    /* Constructor */
    public UtenteVenditore()
    {
        
        super();
        
    }
            
    public float getSaldo(){
        
        return saldo_v;
    
    }
    
    public void setSaldo(float saldo_in){
    
        this.saldo_v = saldo_in;
    
    }


}
