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
public class Alergen {
    private int id;
    private String nazov;
    private String popis;
    
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
    
    public void setPopis(String popis){
        this.popis=popis;
    }
    
    public String getPopis(){
        return this.popis;
    }
    
    public Alergen(){}
    
    public Alergen(int id, String nazov, String popis){
        setId(id);
        setNazov(nazov);
        setPopis(popis);
    }
}
