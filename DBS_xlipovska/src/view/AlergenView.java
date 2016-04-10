/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AlergenCtrl;
import controller.PolozkaCtrl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;
import model.Alergen;
import model.AlergenStatistika;

/**
 *
 * @author Denisa
 */
public class AlergenView {
    
    public void pracujSAlergenom() throws SQLException, IOException, ClassNotFoundException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("Ste v menu pre alergeny");
        System.out.println("pre zobrazenie vsetkych alergenov: 1");
        System.out.println("pre zobrazenie alergenov a pocet jedal, v ktorych sa nachadzaju: 2");
       
        str = br.readLine();
        if (str.equals("1")) {
            vypisAlergeny();
        } else if (str.equals("2")) {
            zobrazStatistikuAlergenov();
        }
    }
    
    protected void vypisAlergeny() throws SQLException, ClassNotFoundException{
        LinkedList<Alergen> output = new LinkedList<Alergen>();
        
        output=new AlergenCtrl().selectAllAlergen();
        
         for(Alergen a:output){
             System.out.println(a.getId() +" | "+a.getNazov() +" | "+a.getPopis() );
         }
    }
   
    protected void zobrazStatistikuAlergenov() throws ClassNotFoundException, SQLException {
        LinkedList<AlergenStatistika> output = new LinkedList<AlergenStatistika>();

        output = new AlergenCtrl().vratStatistikuAlergenov();

        for (AlergenStatistika as : output) {
            System.out.println("alergen: "+as.getNazovAlergenu()+" | pocet jedal, v ktorych sa nachadza: "+ as.getPocetJedal());
        }
    }
}
