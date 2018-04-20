/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 * Die Klasse SpielerComputer beinhaltet zum einen, den Namen der Spieler,
 * die Farbe, die den Spielern momentan zu geordnet ist und
 * ordnet die Spielfiguren (jeder besitzt 4 Spielfiguren) den Spielern zu. 
 * @author Lion
 */
public class SpielerComputer implements Spieler{
    /**
     * Die Namen der Spieler.
     */
    public String Name;
    /**
     * Die Farbe des Spielers/Spielfigur.
     */
    public String Farbe;
    /**
     * ordnet jedem Spieler 4 Spielfiguren mit jeweils der gleichen Farbe zu
     */
    public Spielfigur[] Spielfiguren = new Spielfigur[4];
    
    private Logger log;
    private String objektname;
    /**
     * den der Spieler sollte wissen wo er startet.
     */
    private Feld aFeld;      
    public SpielerComputer(){}
    
    public SpielerComputer(String oname, Logger logger){
        objektname = oname;
        log = logger;
    }
    
    @Override
    public void ziehen(int gezogen) {
        log.log(objektname,"Methode ziehen() gestartet.");
        log.log(objektname,"Methode ziehen() beendet.");
      /** while(true){
       if (wuerfeln)
       
       }**/
    }

    @Override
    public int wuerfeln() {
        log.log(objektname,"Methode wuerfeln() gestartet.");
        int augenzahl = 0;
        log.log(objektname,"Methodenrückgabe: "+augenzahl);
        log.log(objektname,"Methode wuerfeln() beendet.");
        return augenzahl;
    }
    
    @Override
    public Feld gibafeld(){
    return aFeld;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Feld> getFelder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Spiel gibSpiel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}