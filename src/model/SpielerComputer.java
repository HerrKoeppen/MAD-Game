/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    public int Spielfiguren;
            
            
    @Override
    public void ziehen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int wuerfeln() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}