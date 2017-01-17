/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_zaliczeniowy;

/**
 *
 * @author Dominik
 */
class Singleton {
    private static Singleton inst;
    private int iloscStatkowSoj=7, iloscPojazdowSoj=8;
    
    public Singleton(){  
    }
    
    public static Singleton inst() {
        if (inst == null){
            inst = new Singleton();
        }
        return inst;        
    }
    
    
    public int iloscStatkowSoj () {
        return iloscStatkowSoj;
    }
    
    public int iloscPojazdowSoj () {
        return iloscPojazdowSoj;
    }
}
