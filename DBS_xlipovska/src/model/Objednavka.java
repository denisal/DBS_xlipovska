/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Denisa
 */
public class Objednavka {
    private int id;
    private Date datum;
    private Time cas;
    private boolean vyplatena;

    public Objednavka(int id, Date datum, Time cas, boolean vyplatena) {
        this.id = id;
        this.datum = datum;
        this.cas = cas;
        this.vyplatena = vyplatena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Time getCas() {
        return cas;
    }

    public void setCas(Time cas) {
        this.cas = cas;
    }

    public boolean isVyplatena() {
        return vyplatena;
    }

    public void setVyplatena(boolean vyplatena) {
        this.vyplatena = vyplatena;
    }
    
    
    
    
}
