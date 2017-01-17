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
public class Pojazd extends Plansza {
    int typ, pozx, pozy, id;
    
    public void ustaw(int typ, int pozx, int pozy, int id) {
        this.typ=typ;
        this.pozx=pozx;
        this.pozy=pozy;
        this.id=id;
    }
    
    public void setpozycje(int pozx, int pozy) {
        this.pozx=pozx;
        this.pozy=pozy;
    }
    
    public void ustawtyp(int typ) {
        this.typ=typ;
    }
    
    public void wyswietl(){
        System.out.println("typ: " + typ + " X: " + pozx + " Y: " + pozy);
    }
    
    public String dane() {
        return ("Pojazd: " + typ + " " + pozx + " " +  pozy + " " + id + " \n");
    }
}
