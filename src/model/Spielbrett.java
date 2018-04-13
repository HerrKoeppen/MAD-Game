/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Klasse Spielbrett erzeugt mit dem Spielbrett eine Basis
 * auf der die  Felder und Figuren/Spieler eines Spieles gemanaged werden.   
 * @author koeppen
 */
public class Spielbrett {
    /**
     * anzahl der spieler auf dem Feld
     */
    private int Spieleranzahl;
    /**
     * array mit ALLEN MÖGLICHEN FARBEN
     */
    public String[] Farben = new String[7];
    /**
     * baut Spielfeld ab zurück auf standard
     */
    public void raumen(){}
    /**
     * baut Feld neu auf
     */
    public void aufbauen(){}
}

