/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Die Klasse Spiel verwaltet die VAriablen die fÃ¼r den generellen Spielablauf
 * wichtig sind: Der Integer Runde gibt an in welcher Runde man sich befindet.
 * Der Integer BotAnzahl gibt an wie viele Bots bei den Spiel mitspielen sollen.
 * Der Boolean beendet gibt an ob das Spiel beendet ist.true=beendet Die
 * ArrayListe AlleSpieler beinhaltet alle Spieler im Spiel Die Arrayliste
 * AlleSpielfiguren beeinhaltet alle Spielfiguren im Spiel. Das Objekt
 * aktiverSpieler der Klasse Spieler gibt an welcher Spieler momentan am Zug
 * ist.
 *
 * @author Louie Noel Siaa KrÃ¼ger
 */
public class Spiel {
    public Spielbrett dasSpielbrett;
    public int Runde;
    public int BotAnzahl;
    public boolean beendet;
    public Spieler[] AlleSpieler = new Spieler[7];
    public Spielfigur[] AlleSpielfiguren = new Spielfigur[28];
    public Spieler aktiverSpieler;
    
    
    /**
     * Konstrucktor der klasse Spiel
     */
    public Spiel(){
    
    }
    
    /**
     * Setzt Integer Botanzahl auf den Ã¼bergebenen Wert BotAnzahl.
     *
     * @param Botanzahl
     */
    public void SetzeBotAnzahl(int Botanzahl) {

    }

    /**
     *
     * Initilisiert alle notwendigen Grund-Werte fÃ¼r das Spiel. SpielStarten:
     * 1.Das Spiel startet und erstellt: -Spielbrett -7 Spieler(Je nach Wert bei
     * BotAnzahl werden Bots erstellt) -FÃ¼gt diese in die ArrayListe AlleSpieler
     * -28 Spielfiguren -FÃ¼gt diese in die ArrayListe AlleSpielfiguren 2.Die
     * Spielfiguren werden wie folgt mit Farben belegt und den Spielern
     * zugeordnet: 1-4 Blau (Spieler 1) 5-8 Rot (SP 2) 9-12 GrÃ¼n (SP 3) 13-16
     * Pink (SP 4) 17-20 Gelb (SP 5) 21-24 Schwarz(SP 7) 25-28 Braun(SP 8)
     */
    public void SpielStarten() {

    }

    /**
     * NeuesSpiel: Setz ALLE Variablen des Objekts zurÃ¼ck.
     */
    public void NeuesSpiel() {

    }

    /**
     * Die Funktion spielen sorgt fÃ¼r das eigentliche Spiel. Ein neuer Integer
     * "i" wird eingefÃ¼hrt. 1.i wird auf 0 gesetzt. 2.Die Funktion setzt die
     * Variable aktiverSpieler auf das Objekt der Liste AllerSpieler mit den
     * Index-Wert von der Variable i. 3.Solange die Variable beendet=false
     * ist,wird Schritt 3 wiederhohlt.(Schleife) Das Objekt das mit der Variable
     * aktiverSpieler referenziert ist darf einen Zug machen. i wird um eins
     * erhÃ¶ht.
     *
     *
     *
     */
    public void spielen() {

    }
}
