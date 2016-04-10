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

/**
 *
 * @author Denisa
 */
public abstract class AllTablesController {
    private Connection conn=null;
    private Statement stmt = null;
    private String DRIVER = "org.postgresql.Driver";
    private String DB = "jdbc:postgresql://localhost:5432/DBS_projekt";
    
    protected LinkedList select(String query) throws ClassNotFoundException, SQLException{
        LinkedList result = new LinkedList();
        
        Class.forName(DRIVER);
        try {
            this.conn=DriverManager.getConnection(DB, "postgres", "deni");
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				result.add(processRow(rs));
			}
        } catch (SQLException ex) {
            Logger.getLogger(AllTablesController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            return result;
        }
        
    }
    protected abstract Object processRow(ResultSet rs) throws SQLException;
}
