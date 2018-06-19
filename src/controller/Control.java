/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
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
        String antwort = JOptionPane.showInputDialog(null, "Wie viele Computerspieler gibt es?");
        int botanzahl = 6;
        try {
            botanzahl = Integer.parseInt(antwort);
        } catch (NumberFormatException nfe) {

        }
        dasSpiel = new Spiel(log, "Das Spiel", botanzahl, this);
        gui = new MADGUI(log, dasSpiel, this);
        //GUI starten

        gui.setVisible(true);

        gui.darstellungAnzeigen();
        int rueckgabe = -1;
        gui.getSpielVerlaufOutput().append("Spiel gestartet.\n");
        dasSpiel.zugNr = 1;

        gui.getSpielVerlaufOutput().append("Runde 1. Zug 1\n");

        while (rueckgabe != 1) {
            Spieler ich;
            //Ausschreiben aller einzelmethoden zur besseren Handhabung an dieser Stelle
            if (dasSpiel.aktiverSpieler instanceof SpielerComputer) {
                ich = (SpielerComputer) dasSpiel.aktiverSpieler;
            } else {
                ich = (SpielerMensch) dasSpiel.aktiverSpieler;
            }
            gui.getSpielVerlaufOutput().append("Aktiver Spieler: " + ich.getobjektname() + "\n");

            //ziehen
            if (ich.hatGewonnen()) {
                gui.getSpielVerlaufOutput().append(ich.getobjektname() + "hat das Spiel gewonnen.\n");
                rueckgabe = 1;
            }
            if (ich.getgezogen() < 4) {

                //habe ich nur Spielfiguren im Startkreis
                if (ich.alleSpielerImStartkreis()) {
                    //-> ja, dann bis zu dreimal würfeln und hoffe auf eine 6
                    for (int i = 0; i < 3; i++) {
                        System.out.println(ich.getobjektname() + " darf noch " + (3 - i) + " mal wuerfeln.");

                        // ist es eine 6?
                        if (dasSpiel.aktiverSpieler instanceof SpielerMensch) {
                            JOptionPane.showMessageDialog(null, "Klicke um zu würfeln.");
                        }
                        int wuerfel = ich.wuerfeln();
                        gui.getSpielVerlaufOutput().append(ich.getobjektname() + " hat " + this.dasSpiel.getWuerfel().getZahl() + " gewürfelt.\n");
                        aktualisieren();
                        if (wuerfel == 6) {
                            int geschlagen = ich.getSpielfiguren()[0].herauskommen();
                            gui.getSpielVerlaufOutput().append(ich.getobjektname() + " ist herausgekommen.\n");
                            //Welches ist die Rückgabe von herauskommen? Kann man hier einen Wert für das Schlagen beim Herauskommen einfügen?
                            /*
                            if(geschlagen==2){
                                gui.getSpielVerlaufOutput().append(ich.getobjektname()+ " HAT BEIM HERAUSKOMMEN GESCHLAGEN!\n");

                            }
                             */
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
                    if (dasSpiel.aktiverSpieler instanceof SpielerMensch) {
                        JOptionPane.showMessageDialog(null, "Klicke um zu würfeln.");
                    }
                    int Random = ich.wuerfeln();
                    gui.getSpielVerlaufOutput().append(ich.getobjektname() + " hat " + this.dasSpiel.getWuerfel().getZahl() + " gewürfelt.\n");
                    aktualisieren();

                    List<Spielfigur> moeglSpielfiguren = ich.moeglSpielfiguren(Random);
                    if (moeglSpielfiguren.isEmpty()) {
                        System.out.println("Du kannst nicht ziehen.Muhahaha(böses Lachen)");

                    } else {
                        if (ich instanceof SpielerComputer) {

                            int geschlagen = moeglSpielfiguren.get(0).laufen(Random);
                            //welches ist die Rückgabe von laufen()? Kann man hier einen Rückgabewert für einen Schlag einbauen?
                            //gui.getSpielVerlaufOutput().append(ich.getobjektname()+ " HAT GESCHLAGEN!\n");

                        } else {
                            ArrayList<String> values = new ArrayList();
                            for (int i = 0; i < moeglSpielfiguren.size(); i++) {
                                values.add(String.valueOf(i));
                            }

                            Object selected = JOptionPane.showInputDialog(null, "Welche Spielfigur möchtest du bewegen?", "Auswahl Spielfigur", JOptionPane.DEFAULT_OPTION, null, values.toArray(), "0");
                            if (selected != null) {//null if the user cancels. 
                                String selectedString = selected.toString();
                                int auswahl = Integer.parseInt(selectedString);
                                moeglSpielfiguren.get(auswahl).laufen(Random);
                            } else {
                                System.out.println("Abbruch. Ungültiger Zug.");
                            }
                        }
                    }

                }

            }
            ich.setgezogen(0);
            //ich habe doch schon gewonnen: ich mache nichts
            if (ich.hatGewonnen()) {
                rueckgabe = 1;
            }
            rueckgabe = 0;
            //ziehen

            //wechsel aktiver Spieler
            if (rueckgabe == 1) {
                gui.getSpielVerlaufOutput().append(dasSpiel.aktiverSpieler.getobjektname() + " hat gewonnen.\n");
            } else {
                gui.getSpielVerlaufOutput().append(dasSpiel.aktiverSpieler.getobjektname() + "'s Zug ist beendet.\n");
                dasSpiel.aktiverSpielerIndex = dasSpiel.aktiverSpielerIndex + 1;
                if (dasSpiel.aktiverSpielerIndex == dasSpiel.AlleSpieler.length) {
                    dasSpiel.aktiverSpielerIndex = 0;
                }
                dasSpiel.aktiverSpieler = dasSpiel.AlleSpieler[dasSpiel.aktiverSpielerIndex];
                if (dasSpiel.zugNr % dasSpiel.AlleSpieler.length == 0) {
                    dasSpiel.Runde = dasSpiel.Runde + 1;
                    gui.getSpielVerlaufOutput().append("Neue Runde: " + dasSpiel.Runde + "\n");
                }
                dasSpiel.zugNr = dasSpiel.zugNr + 1;
                gui.getSpielVerlaufOutput().append("Zug Nr: " + dasSpiel.zugNr + "\n");
                //wechsel aktiver Spieler

                try {
                    Thread.sleep(50);
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
        //this.dasSpiel.output.akt();

    }

    public void wuerfeln() {

        // code  smh here
        // request: need pop up menu
        this.dasSpiel.getWuerfel().wuerfeln();

    }

    public static void main(String[] args) {
        Control c = new Control();
    }

}
