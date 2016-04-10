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
import model.Alergen;
import model.AlergenStatistika;

/**
 *
 * @author Denisa
 */
public class AlergenCtrl extends AllTablesController {

    public LinkedList<Alergen> selectAllAlergen() throws SQLException, ClassNotFoundException {
        return select("SELECT * FROM alergen");
    }

    @Override
    protected Object processRow(ResultSet rs) throws SQLException {
        return (new Alergen(rs.getInt("id"), rs.getString("nazov"), rs.getString("popis")));
    }

    public LinkedList<AlergenStatistika> vratStatistikuAlergenov() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        LinkedList<AlergenStatistika> result = new LinkedList<AlergenStatistika>();
        String DRIVER = "org.postgresql.Driver";
        String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";
        String QUERY = "SELECT a.nazov, COUNT(p.nazov) AS \"pocet_jedal\" FROM alergen a JOIN alergen_polozky ap ON ap.alergen_id=a.id JOIN polozka p ON ap.polozka_id = p.id GROUP BY a.id;";

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjednavkaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conn = DriverManager.getConnection(DB, "postgres", "deni");
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);

        while (rs.next()) {
            result.add(new AlergenStatistika(rs.getString("nazov"), rs.getInt("pocet_jedal")));
        }
        return result;
    }

}
