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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denisa
 */
public class PolozkaObjednavkyCtrl {

    private int vratPocKs(int polId, int objId) throws SQLException {
        String QUERY = "SELECT pocet_ks FROM polozka_objednavky WHERE polozka_id=" + polId + " AND objednavka_id=" + objId + ";";
        Connection conn = null;
        Statement stmt = null;
        String DRIVER = "org.postgresql.Driver";
        String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";
        int pocKs;

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjednavkaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conn = DriverManager.getConnection(DB, "postgres", "deni");
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);
        if (rs.next()) {
            pocKs = rs.getInt("pocet_ks");
        } else {
            return 0;
        }

        return pocKs;
    }

    public void zmazPolozkuObjednavky(int stol, String nazovPol, int pocetKs) throws SQLException {
        PolozkaCtrl pc = new PolozkaCtrl();
        ObjednavkaCtrl oc = new ObjednavkaCtrl();
        int idPol = pc.vratIdPolozky(nazovPol);
        int idObj = oc.vratIdObj(stol);
        int aktPocet = vratPocKs(idPol, idObj);
        int kusy;
        Connection conn = null;
        Statement stmt = null;
        try {
            if (idObj != 0) {

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
                if (aktPocet > pocetKs) {
                    aktPocet -= pocetKs;
                    String QUERY_UPDATE = "UPDATE polozka_objednavky SET pocet_ks=" + aktPocet + " WHERE objednavka_id=" + idObj + " AND polozka_id=" + idPol + ";";
                    stmt.executeUpdate(QUERY_UPDATE);
                    System.out.println("Polozky boli stornovane");

                } else if (aktPocet == pocetKs) {
                    String QUERY_DELETE = "DELETE FROM polozka_objednavky WHERE objednavka_id=" + idObj + " AND polozka_id=" + idPol + ";";
                    stmt.executeUpdate(QUERY_DELETE);
                    System.out.println("Polozky boli stornovane");
                } else {
                    System.out.println("Zadali ste nespravny pocet ks");
                }

                conn.commit();
                conn.close();
                stmt.close();

            } else {
                System.out.println("Neexistujuca/uz vyplatena objednavka");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            conn.rollback();
            System.exit(0);
        }
    }

    public void pridajPolozkuObjednavky(int stol, String nazovPol, int pocetKs) throws SQLException {
        PolozkaCtrl pc = new PolozkaCtrl();
        ObjednavkaCtrl oc = new ObjednavkaCtrl();
        int kusy;
        int idPol = pc.vratIdPolozky(nazovPol);
        int idObj = oc.vratIdObj(stol);
        Connection conn = null;
        Statement stmt = null;
        try {
            if ((idObj != 0)&&(idPol !=0)) {

                String DRIVER = "org.postgresql.Driver";
                String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";
                String QUERY_INSERT = "INSERT INTO polozka_objednavky (id,pocet_ks,objednavka_id,polozka_id) VALUES (DEFAULT," + pocetKs + "," + idObj + "," + idPol + ");";

                try {
                    Class.forName(DRIVER);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ObjednavkaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }

                conn = DriverManager.getConnection(DB, "postgres", "deni");
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
                kusy = vratPocKs(idPol, idObj);
                if (kusy == 0) {
                    stmt.executeUpdate(QUERY_INSERT);
                    System.out.println("Polozky boli pripisane k objednavke");
                } else {
                    kusy += pocetKs;
                    String QUERY_UPDATE = "UPDATE polozka_objednavky SET pocet_ks=" + kusy + " WHERE objednavka_id=" + idObj + " AND polozka_id=" + idPol + ";";
                    stmt.executeUpdate(QUERY_UPDATE);
                    System.out.println("Polozky boli pripisane k objednavke");
                }

                conn.commit();
                conn.close();
                stmt.close();

            } else {
                System.out.println("Zadali ste nespravne cislo stola, alebo nespravny nazov polozky");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            conn.rollback();
            System.exit(0);
        }
    }

}
