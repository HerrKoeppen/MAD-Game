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
    
    private int positionX;
    private int positionY;
    private Feld startfeld;
    private Feld aktfeld;
    private int feldnummer;
    
    private boolean aufzielfeld;
    private boolean aufstartfeld;
    private boolean aufafeld;
    private boolean aufspielfeld;
    
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

    public void setzten()
    {
    }
    
    public void schlagen()
    {
    }
    /**
     * 
     * @return 
     */
    public int zurueckgehen()
    {
     if (this.bewegen(startfeld)== 0){
         return 0;}
     else {return 1;  }
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
