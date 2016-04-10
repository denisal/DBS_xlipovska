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
public class PolozkaUctu {
    private int id;
    private int idPolObj;
    private int idUcet;

    public PolozkaUctu(int id, int idPolObj, int idUcet) {
        this.id = id;
        this.idPolObj = idPolObj;
        this.idUcet = idUcet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPolObj() {
        return idPolObj;
    }

    public void setIdPolObj(int idPolObj) {
        this.idPolObj = idPolObj;
    }

    public int getIdUcet() {
        return idUcet;
    }

    public void setIdUcet(int idUcet) {
        this.idUcet = idUcet;
    }
    
    
    
}
