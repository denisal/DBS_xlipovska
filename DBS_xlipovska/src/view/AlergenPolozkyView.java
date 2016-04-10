/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AlergenPolozkyCtrl;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Denisa
 */
public class AlergenPolozkyView {
    protected void pridajAlergen(int pocet, String nazov) throws SQLException, ClassNotFoundException{
        new AlergenView().vypisAlergeny();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Vyberte z alergenov: ");
        for(int i=0;i<pocet;i++){
            int id=sc.nextInt();
            new AlergenPolozkyCtrl().pridajAlergenPolozky(nazov, id);
        }
    }
}
