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
public class Statek extends Plansza {
    
    int typ, pozx, pozy;
    
    public void ustaw(int typ, int pozx, int pozy) {
        this.typ=typ;
        this.pozx=pozx;
        this.pozy=pozy;
    }
    
    public void wyswietl(){
        System.out.println("typ: " + typ + " X: " + pozx + " Y: " + pozy);
    }
    
}
