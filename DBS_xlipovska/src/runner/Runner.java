/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;

import controller.AlergenCtrl;
import controller.AlergenPolozkyCtrl;
import controller.ObjednavkaCtrl;
import controller.PolozkaCtrl;
import controller.PolozkaObjednavkyCtrl;
import controller.PolozkaUctuCtrl;
import controller.TypPolozkyCtrl;
import java.io.IOException;
import java.sql.SQLException;
import model.Alergen;
import model.Blocek;
import model.Polozka;
import model.TypPolozky;
import view.MainView;


/**
 *
 * @author Denisa
 */
public class Runner {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        new MainView().zobrazRozhranie();
             
    }
    
}
