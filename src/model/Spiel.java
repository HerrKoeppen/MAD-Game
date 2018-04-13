/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Die Klasse Spiel verwaltet die VAriablen die für den generellen Spielablauf
 * wichtig sind.
 *
 *
 *
 * @author Louie Noel Siaa Krüger
 */
public class Spiel {

    /**
     * Der Integer Runde gibt an in welcher Runde man sich befindet. Eine Runde
     * ist beendet wenn alle Spieler einmal ihren Zug beendet haben.
     */
    public int Runde;
    /**
     * Der Integer BotAnzahl gibt an wie viele Bots bei den Spiel mitspielen
     * sollen.
     */
    public int BotAnzahl;
    /**
     * Der Boolean beendet gibt an ob das Spiel beendet ist.true=beendet
     */
    public boolean beendet;
    /**
     * Die ArrayListe AlleSpieler beinhaltet alle Spieler im Spiel
     */

    public Spieler[] AlleSpieler = new Spieler[7];
    /**
     * Die Arrayliste AlleSpielfiguren beeinhaltet alle Spielfiguren im Spiel.
     */
    public Spielfigur[] AlleSpielfiguren = new Spielfigur[28];
    /**
     * Das Objekt aktiverSpieler der Klasse Spieler gibt an welcher Spieler
     * momentan am Zug ist.
     */
    public Spieler aktiverSpieler;

    /**
     * Setzt Integer Botanzahl auf den übergebenen Wert BotAnzahl.
     *
     * @param Botanzahl
     */
    public void SetzeBotAnzahl(int Botanzahl) {

    }

    /**
     *
     * Initilisiert alle notwendigen Grund-Werte für das Spiel. SpielStarten:
     * 1.Das Spiel startet und erstellt: -Spielbrett -7 Spieler(Je nach Wert bei
     * BotAnzahl werden Bots erstellt) -Fügt diese in die ArrayListe AlleSpieler
     * -28 Spielfiguren -Fügt diese in die ArrayListe AlleSpielfiguren 2.Die
     * Spielfiguren werden wie folgt mit Farben belegt und den Spielern
     * zugeordnet: 1-4 Blau (Spieler 1) 5-8 Rot (SP 2) 9-12 Grün (SP 3) 13-16
     * Pink (SP 4) 17-20 Gelb (SP 5) 21-24 Schwarz(SP 7) 25-28 Braun(SP 8)
     */
    public void SpielStarten() {

    }

    /**
     * NeuesSpiel: Setz ALLE Variablen des Objekts zurück.
     */
    public void NeuesSpiel() {

    }

    /**
     * Die Funktion spielen sorgt für das eigentliche Spiel. Ein neuer Integer
     * "i" wird eingeführt. 1.i wird auf 0 gesetzt. 2.Die Funktion setzt die
     * Variable aktiverSpieler auf das Objekt der Liste AllerSpieler mit den
     * Index-Wert von der Variable i. 3.Solange die Variable beendet=false
     * ist,wird Schritt 3 wiederhohlt.(Schleife) Das Objekt das mit der Variable
     * aktiverSpieler referenziert ist darf einen Zug machen. i wird um eins
     * erhöht.
     *
     *
     *
     */
    public void spielen() {

    }
}
