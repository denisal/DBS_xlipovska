/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Blocek;
import model.PolozkaUctu;

/**
 *
 * @author Denisa
 */
public class PolozkaUctuCtrl extends AllTablesController{
    
    public LinkedList<Blocek> VytvorUcet(int stol) throws SQLException{
        ObjednavkaCtrl oc = new ObjednavkaCtrl();
        int idObj = oc.vratIdObj(stol);
      
        if (idObj != 0) {
            Connection conn = null;
            Statement stmt = null;
            String DRIVER = "org.postgresql.Driver";
            String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";
            String QUERY = "SELECT p.nazov, p.cena, po.pocet_ks, p.cena*po.pocet_ks AS \"celk_cena\" FROM polozka p JOIN polozka_objednavky po ON p.id=po.polozka_id WHERE po.objednavka_id="+idObj+";";
            LinkedList<Blocek> result = new LinkedList<Blocek>();

            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ObjednavkaCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }

            conn = DriverManager.getConnection(DB, "postgres", "deni");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next())
                 result.add(new Blocek(rs.getString("nazov"),rs.getDouble("cena"),rs.getInt("pocet_ks"),rs.getDouble("celk_cena")));
            return result;

        } else {
            System.out.println("Neexistujuca/uz vyplatena objednavka");
            return null;
        }
        
    }
    @Override
    protected Object processRow(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
