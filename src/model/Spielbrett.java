/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasse Spielbrett erzeugt mit dem Spielbrett eine Basis auf der die Felder
 * und Figuren/Spieler eines Spieles gemanaged werden.
 *
 * @author koeppen
 */
public class Spielbrett {

    /**
     * anzahl der spieler auf dem Feld
     */
    private int Spieleranzahl;
    /**
     * array mit allen moeglichen farben, die reinfolge ist folgende: Blau, Rot,
     * GrÃ¼n, Pink, Gelb, Schwarz, Braun und wird bei allen möglichen funktionen
     * so übernommen die farbe eines spielers ist spielbrett[spieler.id];
     */
    public String[] Farben = {"blau", "rot", "gruen", "pink", "gelb", "schwarz", "braun"};
    /**
     * wuerfel des spielbrettes
     */
    private Wuerfel derWuerfel;
    /**
     * alle Felder des Spielbrettes
     */
    private List<Feld> felder = new ArrayList<Feld>();
    /**
     * alle Felder des Spielfeldes
     */
    private final List<Feld> spielkreis = new LinkedList<Feld>();
    private Logger log;
    private String objektname;

    /**
     * konstruktor der klasse Spielbrett:
     *
     *
     * Aufbau: das spielbrett ist eine Stern mit 7 Zacken jede ZAckenspitze ist
     * ein A-Feld einer anderen Farbe zwischen den A Feldern liegen genau 7/5
     * andere normale Felder d. h. jede seite des sterns ist Funf/Vier seiten
     * lang die ZAcken sind gefüllt mit den zielfeldern (haeusern) rechts neben
     * jeder Zacken sind die 3/4 Startfelder in der mitte liegt der Würfel : die
     * aktAugenzahl
     *
     *
     * Hier ein paar ideen im Vergleich: ein Normales spiel(4 personen und 40-43
     * Felder) würde ohne doppelt wüfeln und rauskommen bzw. schlagen und
     * blockiert sein einen erwartungswert von ca. 48 runden und 190 zügen
     * haben. 1. version: das spielbrett ist eine Stern mit 7 Zacken ZAcke: a s
     * s n-z n s s n z n n z n n z n Figuren: 4 Felder: 56-59 (7*8+ zielfelder)
     * E(Runden): ca. 67 E(Züge): ca. 460
     *
     * 2. version: ZAcke: a s s n-z n s n z n n z n n n Figuren: 3 Felder: 56-59
     * (7*8+ zielfelder) E(Runden): ca. 49 E(Züge): ca. 342
     *
     * !! meine Empfehlung: 3. version
     *
     * a s s
     * n-z n s n z n n z n Figuren: 3 Felder: 42-44 (7*6+ zielfelder) E(Runden):
     * ca. 37 E(Züge): ca. 258
     *
     * Nachteil: wenn man nach dem Rauskojmmen eine 6 würfelt Vorteil :das spiel
     * ist ein mittelmas von einer gemäßigten spiellänge (zugzahl), runden
     * technisch aber nicht zu kurz sodass es nicht zu schnell geht
     *
     *
     *
     * |**| a| b| c| d| e| f| g| h| i| j| k| l| m| n| o| p| q| r| s| t| u| v| 
     * | 1|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  
     * | 2|  |  |  |  |  |  |  |  |  |  |  |AB|  |  |  |  |  |  |  |  |  |  |  
     * | 3|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  | 
     * | 4|  |  |  |  |  |  |  |  |  |  |SW|  |SW|  |  |  |  |  |  |  |  |  | 
     * | 5|  |  |  |  |  |  |  |  |. |. |. |. |. |. |. |. |. |. |. |. |. |. | 
     * | 6|. |. |AB|. |. |. |. |. |. |SW|. |. |. |SW|. |. |. |..|. |. |AR|. | 
     * | 7|. |. |. |. |SW|. |. |. |. |. |. |. |. |. |. |. |. |. |SW|. |. |. | 
     * | 8|. |. |..|. |..|. |SW|. |. |. |. |. |. |. |. |. |SW|. |. |. |. |. | 
     * | 9|. |. |. |SW|. |. |. |. |. |SW|. |. |..|SW|. |. |. |. |. |SW|. |. | 
     * |10|. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. | 
     * |11|. |. |. |. |SW|. |. |. |. |. |. |. |. |. |. |. |. |. |SW|. |. |. | 
     * |12|. |. |. |. |. |. |. |. |. |..| .|. |. |. |. |. |. |. |. |. |. |. | 
     * |13|. |. |. |. |. |. |SW|. |. |. |. |. |. |. |. |. |SW|. |. |. |..|. | 
     * |14|. |. |. |. |SW|. |. |. |. |. |. |. |. | .| .| .| .| .|SW| .| .|. | 
     * |15|. |. |SW|. |. |..|. |. |. | .| .| .|. |. |. |. |. |. |. | .|SW| .| 
     * |16|. |AS|. |. |. |. |. |. |. |. | .| .| .| .| .|. |..| .| .| .|. |AG| 
     * |17|. |. | .| .|. |. | .| .| .| .| .| .| .| .| .| .| .|. | .| .| .|. | 
     * |18|. |. |..|SW|. |SW|. |SW|. | .|. |. |. |. |. |SW|. |SW|. |SW|. |. | 
     * |19|. |. | .| .| .| .| .| .| .| .| .|..|. |. |. |. |. |. |. |. |. |. | 
     * |20|. |. | .| .| .| .| .| .| .| .| .|SW| .| .| .| .| .| .| .| .| .| .|
     * |21|. |. | .| .| .| .|. |SW| .| .| .| .|. |. | .|SW|. | .| .| .| .| .| 
     * |22|. |. | .| .| .| .| .| .| .| .|SW| .|SW| .| .| .| .| .| .| .| .| .| 
     * |23|. |. | .| .|. |..| .|SW| .|. |. |. | .| .| .|SW| .| .|..|. |. |. | 
     * |24|. |. | .| .| .| .| .|. | .|SW| .| .| .|SW| .| .| .| .| .| .| .| .| 
     * |25|. |. | .| .|..| .|. |. |. |. |. |. |. | .|. |. |. |. |. |. |. |. | 
     * |26|. |. | .| .| .| .| .|AP|. |. |. | .| .| .|..|AG| .| .| .| .| .| .| 
     * |27|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
     *
     *
     */
    public Spielbrett(Logger logger) {

        Feld blauAnfang = new Feld(this, "Anfangsfeld", 0, 0, "blau");

        Feld standard1 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard2 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard3 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard4 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard5 = new Feld(this, "Standardfeld", 0, 0, "weiss");

        Feld rotAnfang = new Feld(this, "Anfangsfeld", 0, 0, "rot");

        Feld standard7 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard8 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard9 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard10 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard11 = new Feld(this, "Standardfeld", 0, 0, "weiss");

        Feld gruenAnfang = new Feld(this, "Anfangsfeld", 0, 0, "gruen");

        Feld standard13 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard14 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard15 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard16 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard17 = new Feld(this, "Standardfeld", 0, 0, "weiss");

        Feld pinkAnfang = new Feld(this, "Anfangsfeld", 0, 0, "pink");

        Feld standard19 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard20 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard21 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard22 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard23 = new Feld(this, "Standardfeld", 0, 0, "weiss");

        Feld gelbAnfang = new Feld(this, "Anfangsfeld", 0, 0, "gelb");

        Feld standard25 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard26 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard27 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard28 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard29 = new Feld(this, "Standardfeld", 0, 0, "weiss");

        Feld schwarzAnfang = new Feld(this, "Anfangsfeld", 0, 0, "schwarz");

        Feld standard31 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard32 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard33 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard34 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard35 = new Feld(this, "Standardfeld", 0, 0, "weiss");

        Feld braunAnfang = new Feld(this, "Anfangsfeld", 0, 0, "braun");

        Feld standard37 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard38 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard39 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard40 = new Feld(this, "Standardfeld", 0, 0, "weiss");
        Feld standard41 = new Feld(this, "Standardfeld", 0, 0, "weiss");

        //erzeugt startfelder von blau
        Feld blauStart1 = new Feld(this, "Startfeld", 0, 0, "blau");
        Feld blauStart2 = new Feld(this, "Startfeld", 0, 0, "blau");
        Feld blauStart3 = new Feld(this, "Startfeld", 0, 0, "blau");
        //erzeugt startfelder von rot
        Feld rotStart1 = new Feld(this, "Startfeld", 0, 0, "rot");
        Feld rotStart2 = new Feld(this, "Startfeld", 0, 0, "rot");
        Feld rotStart3 = new Feld(this, "Startfeld", 0, 0, "rot");
        //erzeugt startfelder von gruen
        Feld gruenStart1 = new Feld(this, "Startfeld", 0, 0, "gruen");
        Feld gruenStart2 = new Feld(this, "Startfeld", 0, 0, "gruen");
        Feld gruenStart3 = new Feld(this, "Startfeld", 0, 0, "gruen");
        //erzeugt startfelder von pink
        Feld pinkStart1 = new Feld(this, "Startfeld", 0, 0, "pink");
        Feld pinkStart2 = new Feld(this, "Startfeld", 0, 0, "pink");
        Feld pinkStart3 = new Feld(this, "Startfeld", 0, 0, "pink");
        //erzeugt startfelder von gelb
        Feld gelbStart1 = new Feld(this, "Startfeld", 0, 0, "gelb");
        Feld gelbStart2 = new Feld(this, "Startfeld", 0, 0, "gelb");
        Feld gelbStart3 = new Feld(this, "Startfeld", 0, 0, "gelb");
        //erzeugt startfelder von schwarz
        Feld schwarzStart1 = new Feld(this, "Startfeld", 0, 0, "schwarz");
        Feld schwarzStart2 = new Feld(this, "Startfeld", 0, 0, "schwarz");
        Feld schwarzStart3 = new Feld(this, "Startfeld", 0, 0, "schwarz");
        //erzeugt startfelder von braun
        Feld braunStart1 = new Feld(this, "Startfeld", 0, 0, "braun");
        Feld braunStart2 = new Feld(this, "Startfeld", 0, 0, "braun");
        Feld braunStart3 = new Feld(this, "Startfeld", 0, 0, "braun");

        //erzeugt Zielfelder von blau
        Feld blauZiel1 = new Feld(this, "Zielfeld", 0, 0, "blau");
        Feld blauZiel2 = new Feld(this, "Zielfeld", 0, 0, "blau");
        Feld blauZiel3 = new Feld(this, "Zielfeld", 0, 0, "blau");
        //erzeugt Zielfelder von rot
        Feld rotZiel1 = new Feld(this, "Zielfeld", 0, 0, "rot");
        Feld rotZiel2 = new Feld(this, "Zielfeld", 0, 0, "rot");
        Feld rotZiel3 = new Feld(this, "Zielfeld", 0, 0, "rot");
        //erzeugt Zielfelder von gruen
        Feld gruenZiel1 = new Feld(this, "Zielfeld", 0, 0, "gruen");
        Feld gruenZiel2 = new Feld(this, "Zielfeld", 0, 0, "gruen");
        Feld gruenZiel3 = new Feld(this, "Zielfeld", 0, 0, "gruen");
        //erzeugt Zielfelder von pink
        Feld pinkZiel1 = new Feld(this, "Zielfeld", 0, 0, "pink");
        Feld pinkZiel2 = new Feld(this, "Zielfeld", 0, 0, "pink");
        Feld pinkZiel3 = new Feld(this, "Zielfeld", 0, 0, "pink");
        //erzeugt Zielfelder von gelb
        Feld gelbZiel1 = new Feld(this, "Zielfeld", 0, 0, "gelb");
        Feld gelbZiel2 = new Feld(this, "Zielfeld", 0, 0, "gelb");
        Feld gelbZiel3 = new Feld(this, "Zielfeld", 0, 0, "gelb");
        //erzeugt Zielfelder von schwarz
        Feld schwarzZiel1 = new Feld(this, "Zielfeld", 0, 0, "schwarz");
        Feld schwarzZiel2 = new Feld(this, "Zielfeld", 0, 0, "schwarz");
        Feld schwarzZiel3 = new Feld(this, "Zielfeld", 0, 0, "schwarz");
        //erzeugt Zielfelder von braun
        Feld braunZiel1 = new Feld(this, "Zielfeld", 0, 0, "braun");
        Feld braunZiel2 = new Feld(this, "Zielfeld", 0, 0, "braun");
        Feld braunZiel3 = new Feld(this, "Zielfeld", 0, 0, "braun");

        // log.log("Spielbrett ", "steht bereit");
        log = logger;
    }

    /**
     * fügt ein neues Feld in die Felderliste ein
     *
     * @param dasFeld
     * @return innteger index des neu hinzugefügten objektes
     */
    public int feldhinzufuegen(Feld dasFeld) {
        log.log(objektname, "Methode getPositionY() gestartet mit Parameter " + dasFeld + " .");

        felder.add(dasFeld);
        log.log(objektname, "Methodenrückgabe: " + felder.lastIndexOf(dasFeld));
        log.log(objektname, "Methode getPositionY() beendet.");
        return felder.lastIndexOf(dasFeld);
    }
     /**
     * fügt ein neues Feld in die Spüielkreisliste ein
     *
     * @param dasFeld
     * @return innteger index des neu hinzugefügten objektes
     */
    public void kreisfeldhinzufuegen(Feld dasFeld) {
        log.log(objektname, "Methode getPositionY() gestartet mit Parameter " + dasFeld + " .");
        this.spielkreis.add(dasFeld);
        log.log(objektname, "Methode getPositionY() beendet.");
    }

    /**
     * baut Spielfeld ab zurück auf standard
     */
    public void raeumen() {
        log.log(objektname,"Methode raeumen() gestartet.");
        log.log(objektname,"Methode raeumen() beendet.");
    }

    /**
     * baut Feld neu auf
     */
    public void aufbauen() {
        log.log(objektname,"Methode aufbauen() gestartet.");
        log.log(objektname,"Methode aufbauen() beendet.");
    }
    /**
     * 
     * @return 
     */
    public List<Feld> getFelder(){
    return felder;
    }

}
