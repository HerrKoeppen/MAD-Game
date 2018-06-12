/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.List;
/**
 *
 * @author koeppen
 */
public interface Spieler {

    /**
     *
     * @param gezogen
     */
   
    public int ziehen();
    public int getgezogen();

    /**
     *
     * @param c
     */
    public void setgezogen(int c);
    /**
     *
     * @return
     */
    public int wuerfeln();
    public Feld getafeld();
    public List<Feld> getFelder();
    public Spiel getSpiel();
    public boolean alleSpielerImStartkreis();
    public boolean SpielerImStartkreis();
    public Feld getzefeld();
    public String getfarbe();
    public Feld getzielfeld();
    public Spielfigur[] getSpielfiguren();
    public void setSpielfigur(Spielfigur dieSpielfigur);
    public String getobjektname();
    public void VerbleideneZügeErrechnen();
    public int SpielfigurZiehen(int Spielfigur);  
    public int getVerbleideneZüge();

}
