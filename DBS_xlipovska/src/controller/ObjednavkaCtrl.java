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
import model.Objednavka;

/**
 *
 * @author Denisa
 */
public class ObjednavkaCtrl extends AllTablesController {

    public LinkedList<Objednavka> selectAllObjednavka() throws SQLException, ClassNotFoundException {
        return select("SELECT * FROM objednavka");
    }

    public void vytvorObjednavku(int cisloStola) throws SQLException {
        int kontrola = vratIdObj(cisloStola);
        Connection conn = null;
        Statement stmt = null;

        try {
            if (kontrola == 0) {
                String DRIVER = "org.postgresql.Driver";
                String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";
                String QUERY = "INSERT INTO objednavka(id,datum,cas,vyplatena,casnik_id,stol_id) VALUES (DEFAULT,current_date,current_time,false,1," + cisloStola + ");";

                try {
                    Class.forName(DRIVER);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ObjednavkaCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }

                conn = DriverManager.getConnection(DB, "postgres", "deni");
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
                stmt.executeUpdate(QUERY);
                conn.commit();
                conn.close();
                stmt.close();
                System.out.println("Objednavka bola vytvorena");
            } else {
                System.out.println("Pre dany stol uz existuje objednavka");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            conn.rollback();
            System.exit(0);
        }

    }

    @Override
    protected Object processRow(ResultSet rs) throws SQLException {
        return (new Objednavka(rs.getInt("id"), rs.getDate("datum"), rs.getTime("cas"), rs.getBoolean("vyplatena")));
    }

    protected int vratIdObj(int idStol) throws SQLException {
        int idObj;

        Connection conn = null;
        Statement stmt = null;
        String DRIVER = "org.postgresql.Driver";
        String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";
        String QUERY = "SELECT id FROM objednavka WHERE stol_id='" + idStol + "' AND vyplatena=false;";

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjednavkaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conn = DriverManager.getConnection(DB, "postgres", "deni");
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);
        if (rs.next()) {
            idObj = rs.getInt("id");
        } else {
            return 0;
        }

        return idObj;
    }

    public void zaplatObjednavku(int idStol) throws SQLException {
        int idObj = vratIdObj(idStol);
        Connection conn = null;
        Statement stmt = null;
        try {
            if (idObj != 0) {

                String DRIVER = "org.postgresql.Driver";
                String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";
                String QUERY_UPDATE = "UPDATE objednavka SET vyplatena=true WHERE id=" + idObj + ";";

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
                System.out.println("Objednavka bola zaplatena");
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

}
