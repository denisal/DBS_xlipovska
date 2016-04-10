/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denisa
 */
public class AlergenPolozkyCtrl {

    public void pridajAlergenPolozky(String nazovPol, int alergen) throws SQLException {
        int idPol = new PolozkaCtrl().vratIdPolozky(nazovPol);
        Connection conn = null;
        Statement stmt = null;

        try {
            String DRIVER = "org.postgresql.Driver";
            String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";

            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ObjednavkaCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }

            conn = DriverManager.getConnection(DB, "postgres", "deni");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            String QUERY_INSERT = "INSERT INTO alergen_polozky (id, polozka_id, alergen_id) VALUES (DEFAULT, " + idPol + ", " + alergen + ");";
            stmt.executeUpdate(QUERY_INSERT);
            conn.commit();
            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            conn.rollback();
            System.exit(0);
        }
    }
}
