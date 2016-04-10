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
public class Blocek {
    private String polozka;
    private double jednCena;
    private int pocKs;
    private double celkovaCena;

    public Blocek(String polozka, double jednCena, int pocKs, double celkovaCena) {
        this.polozka = polozka;
        this.jednCena = jednCena;
        this.pocKs = pocKs;
        this.celkovaCena = celkovaCena;
    }

    public String getPolozka() {
        return polozka;
    }

    public double getJednCena() {
        return jednCena;
    }

    public int getPocKs() {
        return pocKs;
    }

    public double getCelkovaCena() {
        return celkovaCena;
    }
    
    
}
