/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import model.Logger;
import model.Spiel;
import view.MADGUI;

/**
 *
 * @author hannah.claus
 */
public class Control {
    
    Logger log;
    Spiel dasSpiel;
    MADGUI gui;
    
    public Control(){
        log = new Logger();
        dasSpiel = new Spiel(log, "Das Spiel", 6);
        gui = new MADGUI(log,dasSpiel);
        //GUI starten
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MADGUI().setVisible(true);
            }
        });
        */
        gui.setVisible(true);
        gui.darstellungAnzeigen();
        while (dasSpiel.spieleEinenZug()!=1){
            gui.darstellungAnzeigen();
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        gui.darstellungAnzeigen();

    }
    
    public void wuerfelwaehlen(){
    
    
    }
    public static void main(String[] args){
        Control c = new Control();
    }
    
    
}
