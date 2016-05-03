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
public class Articolo {
  
    
    private String objName;
    private String objURL;
    private String objDescr;
    private double objPrice;
    private int objNumber;
    
    //costruttore
    public Articolo(){
    
        objName="";
        objURL="";
        objDescr="";
        objPrice=0.0;
        objNumber=0;
        
    }
    
    //metodi//

    public String getobjName(){
        return objName;
    }

    public void setobjName(String objName){
        this.objName = objName;
    }

    public String getobjURL(){
        return objURL;
    } 
    
    public void setobjURL(String objURL){
        this.objURL = objURL;  
    }

    public String getobjDescr(){
        return objDescr;
    } 
    
    public void setobjDescr(String objDescr){
        this.objDescr = objDescr;  
    }

    public double getobjPrice(){
        return objPrice;
    }

    public void setobjPrice(double objPrice){
        this.objPrice = objPrice;
    }

    public int getobjNumber(){
        return objNumber;
    }

    public void setobjNumber(int objNumber){
        this.objNumber = objNumber;
    }
  
    
}


    

