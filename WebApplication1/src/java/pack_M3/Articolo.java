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
    
//    public enum ArticoloId{
//        ArticoloId_Home_kit,
//        ArticoloId_Away_kit,
//        ArticoloId_bottoms,
//        ArticoloId_socks,
//        ArticoloId_t_shirt,
//        ArticoloId_key_keeper,
//        ArticoloId_paper,
//        ArticoloId_Zippo,
//    } 
    
    public String objName;
    public String objURL;
    public String objDescr;
    public double objPrice;
    public int objNumber;
    
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


    

