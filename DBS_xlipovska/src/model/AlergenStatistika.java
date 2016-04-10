/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Denisa
 */
public class AlergenStatistika {
    private String nazovAlergenu;
    private int pocetJedal;

    public AlergenStatistika(String nazovAlergenu, int pocetJedal) {
        this.nazovAlergenu = nazovAlergenu;
        this.pocetJedal = pocetJedal;
    }

    public String getNazovAlergenu() {
        return nazovAlergenu;
    }

    public int getPocetJedal() {
        return pocetJedal;
    }
    
    
}
