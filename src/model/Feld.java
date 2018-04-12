/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author hannah
 */
public class Feld {

/**
 * gibt an, ob Feld Startfeld ist
 * boolean: true oder false
 */    
private boolean Startfeld;
/**
 * gibt an, ob Feld Zielfeld ist
 * boolean: true oder false
 */
private boolean	Zielfeld;
/**
 * gibt an, ob Feld A-Feld ist
 * boolean: true oder false
 */
private boolean aFeld;
/**
 * gibt an, ob Feld Startfeld ist
 * boolean: true oder false
 */
private boolean Standardfeld; 
/**
 * gibt X-Position des Feldes auf dem Spielbrett an
 * integer
 */
private int positionX;
/**
 * gibt Y-Position des Feldes auf dem Spielbrett an
 * integer
 */
private int positionY;
/**
 * gibt ID des Feldes auf dem Spielbrett an
 * integer
 */
private int Id;
/** 
 * gibt an, ob Feld besetzt ist
 * boolean: true oder false
 */	
private boolean istBesetzt;
/**
 * gibt Farbe des jeweiligen Feldes an
 * String
 * Start-, A-Feld und Zielfeld: sieben Farben
 * Standardfeld: weiß
 */
private String farbe;

public int feld(int indexd, String feldart, int Xposition, int Yposition, String spieler)
{
    this.Id = indexd;
    this.istBesetzt = false;
    this.positionX = Xposition;
    this.positionY = Yposition;
    this.farbe = spieler;
        
    return 0;
}
}
