/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 *
 * @author Denisa
 */
public class MainView {
    public void zobrazRozhranie() throws IOException, ClassNotFoundException, SQLException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        
        
        while (true){
            System.out.println("---------------------------------------------------------------");
            System.out.println("Vitajte v systeme, pre pokracovanie zadajte jeden z prikazov: \n polozky - pre vstup do menu s polozkami\n objednavky - pre vstup do menu s objednavkami\n alergeny - pre vstup do menu s alergenmi\n exit - pre ukoncenie programu");
            System.out.println("---------------------------------------------------------------");
            str = br.readLine();
            if(str.equals("exit"))
                break;
            if(str.equals("polozky")){
                new PolozkaView().pracujSPolozkou();
            }
            else if(str.equals("objednavky")){
                new ObjednavkaView().pracujSObjednavkou();
            }
            else if(str.equals("alergeny")){
                new AlergenView().pracujSAlergenom();
            }
        }
    }
}
