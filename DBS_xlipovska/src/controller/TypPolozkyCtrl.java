/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.TypPolozky;

/**
 *
 * @author Denisa
 */
public class TypPolozkyCtrl extends AllTablesController{
    
    public LinkedList<TypPolozky> selectAllTypPolozky() throws ClassNotFoundException, SQLException{
        return select("SELECT * FROM typ_polozky");
    }
    
    @Override
    protected Object processRow(ResultSet rs) throws SQLException {
        return (new TypPolozky(rs.getString("nazov")));
    }
    
}
