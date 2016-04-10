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
import model.Polozka;
import model.TypPolozky;

/**
 *
 * @author Denisa
 */
public class PolozkaCtrl extends AllTablesController {

    public LinkedList<Polozka> selectAllPolozka() throws SQLException, ClassNotFoundException {
        return select("SELECT * FROM polozka");
    }

    public LinkedList<Polozka> selectAllJedlo() throws ClassNotFoundException, SQLException {
        return select("SELECT * FROM polozka JOIN typ_polozky ON polozka.typ_polozky_id=typ_polozky.id WHERE typ_polozky.nazov = 'jedlo'");
    }

    public LinkedList<Polozka> selectAllPitie() throws ClassNotFoundException, SQLException {
        return select("SELECT * FROM polozka JOIN typ_polozky ON polozka.typ_polozky_id=typ_polozky.id WHERE typ_polozky.nazov = 'pitie'");
    }

    @Override
    protected Object processRow(ResultSet rs) throws SQLException {
        return (new Polozka(rs.getString("nazov"), rs.getString("popis"), rs.getDouble("cena")));
    }

    public boolean pridajPolozku(String nazov, String popis, double cena, int typ) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            String DRIVER = "org.postgresql.Driver";
            String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";
            String QUERY_INSERT = "INSERT INTO polozka (id, nazov, popis, cena, typ_polozky_id) VALUES (DEFAULT, '" + nazov + "', '" + popis + "', " + cena + "," + typ + ");";

            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ObjednavkaCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }

            conn = DriverManager.getConnection(DB, "postgres", "deni");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.executeUpdate(QUERY_INSERT);

            conn.commit();
            conn.close();
            stmt.close();
            if (typ == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            conn.rollback();
            System.exit(0);
        }

        return false;
    }

    public LinkedList<Polozka> vyberJedlaBezAlergenu(int alergenId) throws SQLException, ClassNotFoundException {
        return select("SELECT * FROM polozka WHERE typ_polozky_id=1 AND nazov NOT IN (SELECT p.nazov FROM polozka p JOIN alergen_polozky ap ON p.id=ap.polozka_id JOIN alergen a ON a.id=ap.alergen_id WHERE a.id=" + alergenId + ");");
    }

    public void zmenCenuPolozky(String nazov, double cena) throws SQLException {
        int id = vratIdPolozky(nazov);
        Connection conn = null;
        Statement stmt = null;
        try {
            if (id != 0) {

                String DRIVER = "org.postgresql.Driver";
                String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";
                String QUERY_UPDATE = "UPDATE polozka SET cena=" + cena + " WHERE id='" + id + "';";

                try {
                    Class.forName(DRIVER);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ObjednavkaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }

                conn = DriverManager.getConnection(DB, "postgres", "deni");
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
                stmt.executeUpdate(QUERY_UPDATE);
                conn.commit();
                conn.close();
                stmt.close();
            } else {
                System.out.println("Polozka neexistuje");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            conn.rollback();
            System.exit(0);
        }
    }

    protected int vratIdPolozky(String nazovPol) throws SQLException {
        int id;

        Connection conn = null;
        Statement stmt = null;
        String DRIVER = "org.postgresql.Driver";
        String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";
        String QUERY = "SELECT id FROM polozka WHERE nazov='" + nazovPol + "';";

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjednavkaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conn = DriverManager.getConnection(DB, "postgres", "deni");
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);
        if (rs.next()) {
            id = rs.getInt("id");
        } else {
            return 0;
        }
        return id;
    }

}
