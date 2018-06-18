/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.logging.Level;
import model.Logger;
import model.Spiel;
import model.Spieler;
import model.SpielerComputer;
import model.SpielerMensch;
import model.Spielfigur;
import view.MADGUI;

/**
 *
 * @author hannah.claus
 */
public class Control {

    Logger log;
    Spiel dasSpiel;
    MADGUI gui;

    public Control() {
        log = new Logger();
        log.deactivate();
        dasSpiel = new Spiel(log, "Das Spiel", 6, this);
        gui = new MADGUI(log, dasSpiel, this);
        //GUI starten

        gui.setVisible(true);

        gui.darstellungAnzeigen();
        int rueckgabe = -1;
        gui.getSpielVerlaufOutput().append("Spiel gestartet.\n");

        while (rueckgabe != 1) {
            Spieler ich;
            //Ausschreiben aller einzelmethoden zur besseren Handhabung an dieser Stelle
            if (dasSpiel.aktiverSpieler instanceof SpielerComputer){
            ich = (SpielerComputer) dasSpiel.aktiverSpieler;
            }
            else
            {
            ich = (SpielerMensch) dasSpiel.aktiverSpieler;
            }
            gui.getSpielVerlaufOutput().append("Aktiver Spieler: "+ich.getobjektname()+"\n");

            //ziehen
            if (ich.hatGewonnen()) {
                rueckgabe = 1;
            }
            if (ich.getgezogen() < 4) {

                //habe ich nur Spielfiguren im Startkreis
                if (ich.alleSpielerImStartkreis()) {
                    //-> ja, dann bis zu dreimal würfeln und hoffe auf eine 6
                    for (int i = 0; i < 4; i++) {
                        System.out.println(ich.getobjektname() + " darf noch " + (3 - i) + " mal wuerfeln.");

                        // ist es eine 6?
                        int wuerfel = ich.wuerfeln();
                        aktualisieren();
                        if (wuerfel == 6) {
                            ich.getSpielfiguren()[0].herauskommen();

                            //ich.Spielfiguren[0].herauskommen();
                            //ich.dasSpiel.output.spielAusgabe();

                            ich.setgezogen(0);

                            rueckgabe = 0;
                        }

                    }

                    ich.setgezogen(0);
                    rueckgabe = 0;
                } //-> nein, einmal würfeln
                else {  //unnoetige zeile aber lieber doppelt als keinmal

                    int Random = ich.wuerfeln();
                    aktualisieren();

                    List<Spielfigur> moeglSpielfiguren = ich.moeglSpielfiguren(Random);
                    if (moeglSpielfiguren.isEmpty()) {
                        System.out.println("Du kannst nicht ziehen.Muhahaha(böses Lachen)");

                    } else {

                        moeglSpielfiguren.get(0).laufen(Random);

                    }

                }

            }
            ich.setgezogen(0);
            //ich habe doch schon gewonnen: ich mache nichts
            log.log(ich.getobjektname(), "Methode ziehen() beendet.");
            if (ich.hatGewonnen()) {
                rueckgabe = 1;
            }
            rueckgabe = 0;
            //ziehen

            //wechsel aktiver Spieler
            if (rueckgabe == 1) {
                System.out.println(dasSpiel.aktiverSpieler.getobjektname() + " hat gewonnen");
            } else {
                System.out.println(dasSpiel.aktiverSpieler.getobjektname() + "'s Zug ist beendet");
                dasSpiel.aktiverSpielerIndex = dasSpiel.aktiverSpielerIndex + 1;
                if (dasSpiel.aktiverSpielerIndex == dasSpiel.AlleSpieler.length) {
                    dasSpiel.aktiverSpielerIndex = 0;
                }
                dasSpiel.aktiverSpieler = dasSpiel.AlleSpieler[dasSpiel.aktiverSpielerIndex];
                if (dasSpiel.zugNr % dasSpiel.AlleSpieler.length == 0) {
                    dasSpiel.Runde = dasSpiel.Runde + 1;
                    System.out.println("Neue Runde: " + dasSpiel.Runde);
                }
                dasSpiel.zugNr = dasSpiel.zugNr + 1;
                //wechsel aktiver Spieler

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    java.util.logging.Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }
                gui.darstellungAnzeigen();
            }
        }
    
    }

    public void aktualisieren() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        gui.darstellungAnzeigen();
        gui.WuerfelAusgeben(dasSpiel.getWuerfel().getZahl());
        this.dasSpiel.output.akt();
        this.gui.WuerfelAusgeben(this.dasSpiel.getWuerfel().getZahl());

    }
    
    
    public void wuerfeln(){
        
        
        // code  smh here
        // request: need pop up menu
        this.dasSpiel.getWuerfel().wuerfeln();
   
    
    
    
    }

    public static void main(String[] args) {
        Control c = new Control();
    }

   
}
