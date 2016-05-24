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
public class Saldo {
    
    private double saldo;
    private int cf_poss;
    
    public Saldo(){
    
        saldo=0.0;
        cf_poss=0;
        
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double getPoss() {
        return cf_poss;
    }

    public void setPoss(int cf_in) {
        this.cf_poss = cf_in;
    }
    
    
}
