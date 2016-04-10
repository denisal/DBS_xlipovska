/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ObjednavkaCtrl;
import controller.PolozkaCtrl;
import controller.PolozkaObjednavkyCtrl;
import controller.PolozkaUctuCtrl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.LinkedList;
import model.Blocek;
import model.Objednavka;
import model.Polozka;

/**
 *
 * @author Denisa
 */
public class ObjednavkaView {

    public void pracujSObjednavkou() throws IOException, ClassNotFoundException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("Ste v menu pre objednavky");
        System.out.println("pre zobrazenie vsetkych objednavok: 1");
        System.out.println("pre vytvorenie novej objednavky: 2");
        System.out.println("pre vystavenie uctu: 3");
        System.out.println("pre zaplatenie uctu: 4");
        System.out.println("pre pridanie polozky do objednavky: 5");
        System.out.println("pre storno polozky z objednavky: 6");
        str = br.readLine();
        if (str.equals("1")) {
            vypisObjednavky();
        } else if (str.equals("2")) {
            vytvorObjednavku();
        } else if (str.equals("3")) {
            vystavUcet();
        } else if (str.equals("4")) {
            zaplatObjednavku();
        }
        else if (str.equals("5")) {
            pridajPolozkuObjednavky();
        }
        else if (str.equals("6")) {
            zmazPolozkuObjednavky();
        }

    }

    protected void vypisObjednavky() throws SQLException, ClassNotFoundException {
        LinkedList<Objednavka> output = new LinkedList<Objednavka>();

        output = new ObjednavkaCtrl().selectAllObjednavka();

        for (Objednavka o : output) {
            System.out.println("id: " + o.getId() + ", datum vytvorenia: " + o.getDatum() + ", cas vytvorenia: " + o.getCas() + ", zaplatena: " + o.isVyplatena());
        }
    }

    private void vytvorObjednavku() throws IOException, SQLException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Zadajte cislo stola, na ktory chcete vytvorit objednavku: ");
        String cislo = br.readLine();

        new ObjednavkaCtrl().vytvorObjednavku(Integer.parseInt(cislo));
    }

    private void zaplatObjednavku() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Zadajte cislo stola, ku ktoremu chcete zmenit stav uctu na zaplateny: ");
        String cislo = br.readLine();

        new ObjednavkaCtrl().zaplatObjednavku(Integer.parseInt(cislo));
    }

    private void vystavUcet() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PolozkaUctuCtrl pu = new PolozkaUctuCtrl();
        System.out.print("Zadajte cislo stola, pre ktory chcete vystavit ucet: ");
        String cislo = br.readLine();
        double ucet=0;
        for(Blocek b : pu.VytvorUcet(Integer.parseInt(cislo))){
           System.out.println(b.getPolozka()+"\t|\t jednotkova cena: "+Math.round(b.getJednCena() * 100.0) / 100.0 + " EUR\t|\tpocet ks: "+b.getPocKs()+"\t|\tcelkova cena: "+Math.round(b.getCelkovaCena() * 100.0) / 100.0 + "EUR ");
           ucet+=b.getCelkovaCena();
        }
        System.out.println("Suma na zaplatenie: " + Math.round(ucet * 100.0) / 100.0 + "EUR ");
        
    }
    
    private void zmazPolozkuObjednavky() throws IOException, SQLException, ClassNotFoundException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Zadajte cislo stola: ");
        String stol = br.readLine();
        System.out.print("Zadajte nazov polozky: ");
        String nazov = br.readLine();
        System.out.print("Zadajte pocet kusov: ");
        String pocet = br.readLine();
        
        new PolozkaObjednavkyCtrl().zmazPolozkuObjednavky(Integer.parseInt(stol), nazov, Integer.parseInt(pocet));
                
    }
    
    private void pridajPolozkuObjednavky() throws IOException, SQLException, ClassNotFoundException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Zadajte cislo stola: ");
        String stol = br.readLine();
        System.out.print("Zadajte nazov polozky: ");
        String nazov = br.readLine();
        System.out.print("Zadajte pocet kusov: ");
        String pocet = br.readLine();
        
        new PolozkaObjednavkyCtrl().pridajPolozkuObjednavky(Integer.parseInt(stol), nazov, Integer.parseInt(pocet));
                
    }
}
