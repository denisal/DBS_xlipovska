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
public class Polozka {
    private int id;
    private String nazov;
    private String popis;
    private double cena;
    private TypPolozky typ;

    public Polozka(String nazov, String popis, double cena) {
        this.nazov = nazov;
        this.popis = popis;
        this.cena = cena;
    }
    
    public Polozka(){}

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public TypPolozky getTyp() {
        return typ;
    }

    public void setTyp(TypPolozky typ) {
        this.typ = typ;
    }

   
    
}
