/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Set;

/**
 *
 * @author Denisa
 */
public class TypPolozky {
    private int id;
    private String nazov;
    private Set<Polozka> polozky;

    public Set<Polozka> getPolozky() {
        return polozky;
    }

    public void setPolozky(Set<Polozka> polozky) {
        this.polozky = polozky;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNazov(String nazov){
        this.nazov=nazov;
    }
    
    public String getNazov(){
        return this.nazov;
    }
    
    public TypPolozky(){}
    
    public TypPolozky(String nazov){
        setNazov(nazov);
    }
}
