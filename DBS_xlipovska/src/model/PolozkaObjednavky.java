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
public class PolozkaObjednavky {
    private int id;
    private int pocetKs;

    public PolozkaObjednavky(int id, int pocetKs) {
        this.id = id;
        this.pocetKs = pocetKs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPocetKs() {
        return pocetKs;
    }

    public void setPocetKs(int pocetKs) {
        this.pocetKs = pocetKs;
    }
    
    
}
