/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PolozkaCtrl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;
import model.Polozka;

/**
 *
 * @author Denisa
 */
public class PolozkaView {

    public void pracujSPolozkou() throws IOException, ClassNotFoundException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("Ste v menu pre polozky");
        System.out.println("pre zobrazenie vsetkych jedal: 1");
        System.out.println("pre zobrazenie vsetkych napojov: 2");
        System.out.println("pre zobrazenie vsetkych jedal bez konkretneho alergenu: 3");
        System.out.println("pre pridanie noveho jedla: 4");
        System.out.println("pre pridanie noveho napoja: 5");
        System.out.println("pre zmenu ceny polozky: 6");
        str = br.readLine();
        if (str.equals("1")) {
            vypisJedla();
        } else if (str.equals("2")) {
            vypisPitia();
        } else if (str.equals("3")) {
            vypisJedlaBezAlergenu();
        } else if (str.equals("4")) {
            pridajJedlo();
        } else if (str.equals("5")) {
            pridajPitie();
        } else if (str.equals("6")) {
            zmenCenu();
        }
        

    }
    
    protected void vypisPolozky() throws SQLException, ClassNotFoundException{
        LinkedList<Polozka> output = new LinkedList<Polozka>();

        output = new PolozkaCtrl().selectAllPolozka();

        for (Polozka p : output) {
            System.out.println(p.getNazov() + " : " + p.getPopis() + " : " + Math.round(p.getCena() * 100.0) / 100.0 + "EUR");
        }
    }

    protected void vypisJedla() throws ClassNotFoundException, SQLException {
        LinkedList<Polozka> output = new LinkedList<Polozka>();

        output = new PolozkaCtrl().selectAllJedlo();

        for (Polozka p : output) {
            System.out.println(p.getNazov() + " : " + p.getPopis() + " : " + Math.round(p.getCena() * 100.0) / 100.0 + "EUR");
        }
    }

    protected void vypisPitia() throws ClassNotFoundException, SQLException {
        LinkedList<Polozka> output = new LinkedList<Polozka>();

        output = new PolozkaCtrl().selectAllPitie();

        for (Polozka p : output) {
            System.out.println(p.getNazov() + " : " + p.getPopis() + " : " + Math.round(p.getCena() * 100.0) / 100.0 + "EUR");
        }
    }

    protected void vypisJedlaBezAlergenu() throws ClassNotFoundException, SQLException {
        LinkedList<Polozka> output = new LinkedList<Polozka>();
        new AlergenView().vypisAlergeny();

        System.out.print("Zadajte cislo alergenu: ");

        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();

        output = new PolozkaCtrl().vyberJedlaBezAlergenu(id);

        for (Polozka p : output) {
            System.out.println(p.getNazov() + " : " + p.getPopis() + " : " + Math.round(p.getCena() * 100.0) / 100.0 + "EUR");
        }
    }

    private void pridajJedlo() throws IOException, SQLException, ClassNotFoundException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Zadajte nazov jedla: ");
        String nazov = br.readLine();
        System.out.print("Zadajte popis jedla: ");
        String popis = br.readLine();
        System.out.print("Zadajte cenu jedla: ");
        String cena = br.readLine();
        
        new PolozkaCtrl().pridajPolozku(nazov, popis, Double.parseDouble(cena), 1);
        
        System.out.print("Zadajte pocet alergenov: ");
        String pocet=br.readLine();
        new AlergenPolozkyView().pridajAlergen(Integer.parseInt(pocet), nazov);
        
    }
    
    private void pridajPitie() throws IOException, SQLException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        System.out.print("Zadajte nazov napoja: ");
        String nazov = br.readLine();
        System.out.print("Zadajte popis napoja: ");
        String popis = br.readLine();
        System.out.print("Zadajte cenu napoja: ");
        String cena = br.readLine();
        
        new PolozkaCtrl().pridajPolozku(nazov, popis, Double.parseDouble(cena), 2);
    }
    
    private void zmenCenu() throws SQLException, ClassNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        new PolozkaView().vypisPolozky();
         
        System.out.println("Zadajte nazov polozky, ktorej chcete zmenit cenu");          
        String nazov = br.readLine();
        System.out.print("Zadajte novu cenu polozky: ");
        String cena = br.readLine();
        
        new PolozkaCtrl().zmenCenuPolozky(nazov, Double.parseDouble(cena));
    }
}
