/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author koeppen
 */
public class Spielfigur {
    
    private int id;
    private int positionX;
    private int positionY;
    private Feld startfeld;
    private Feld aktfeld;
    private int feldnummer;
    
    private boolean aufzielfeld;
    private boolean aufstartfeld;
    private boolean aufafeld;
    /**
     * 
     */
    private boolean aufspielfeld;
    /**
     * 
     */
    private Spieler farbe; 
    
    
    public int spielfigur(int id, Feld starterfeld, Spieler spielerfarbe){
        this.startfeld = starterfeld;
        this.positionX = this.startfeld.gibpositionX();
        this.positionY = this.startfeld.gibpositionY();
        this.aktfeld = this.startfeld;
        this.feldnummer = this.startfeld.gibid();
        this.aufafeld = false;
        this.aufspielfeld = false;
        this.aufstartfeld = true;
        this.aufzielfeld = false;
        this.farbe = spielerfarbe;
        return 0;
    }
    
    
    public void herauskommen()
    {
    }
    /**
     * 
     * @param zielfeld 
     */
    public int bewegen(Feld zielfeld)
    {   return 1;
    }
    /**
     * 
     */
    public void setzten()
    {
    }
    /**
     * 
     */
    public void schlagen()
    {
    }
    
    /**
     * 
     * @return 0 
     */
    public int zurueckgehen()
    {
     if (this.bewegen(this.startfeld)== 0)
        {
             return 0;
        }
     else   
        {
            return 1;  
        }
    }
    
    
    
    
    /*
    Position/Zahl des Feldes
		Farbe
		auf Zielfeld?
		auf Startfeld?
		auf A-Feld?
		auf Spielfeld?
		
		herauskommen (vom Startfeld auf das A-Feld)
		bewegen
		setzen
		schlagen
		zurückgehen (zum Startfeld)

    */
}
