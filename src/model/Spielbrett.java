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
    private SpielbrettAusgabe Output;
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
     * |**   |0 | 1| 2| 3| 4| 5| 6| 7| 8| 9|10|11|12|13|14|15|16|17|18|19|20|   
     * | 0|  |  |  |  |  |  |  |  |  |  |  |AB|  |  |  |  |  |  |  |  |  |  |  
     * | 1|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  | 
     * | 2|  |  |  |  |  |  |  |  |  |  |SW|  |SW|  |  |  |  |  |  |  |  |  | 
     * | 3|  |  |  |  |  |  |  |  |. |. |. |. |. |. |. |. |. |. |. |. |. |. | 
     * | 4|. |. |AB|. |. |. |. |. |. |SW|. |. |. |SW|. |. |. |..|. |. |AR|. | 
     * | 5|. |. |. |. |SW|. |. |. |. |. |. |. |. |. |. |. |. |. |SW|. |. |. | 
     * | 6|. |. |..|. |..|. |SW|. |. |. |. |. |. |. |. |. |SW|. |. |. |. |. | 
     * | 7|. |. |. |SW|. |. |. |. |. |SW|. |. |..|SW|. |. |. |. |. |SW|. |. | 
     * | 8|. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. | 
     * | 9|. |. |. |. |SW|. |. |. |. |. |. |. |. |. |. |. |. |. |SW|. |. |. | 
     * |10|. |. |. |. |. |. |. |. |. |..| .|. |. |. |. |. |. |. |. |. |. |. | 
     * |11|. |. |. |. |. |. |SW|. |. |. |. |. |. |. |. |. |SW|. |. |. |..|. | 
     * |12|. |. |. |. |SW|. |. |. |. |. |. |. |. | .| .| .| .| .|SW| .| .|. | 
     * |13|. |. |SW|. |. |..|. |. |. | .| .| .|. |. |. |. |. |. |. | .|SW| .| 
     * |14|. |AS|. |. |. |. |. |. |. |. | .| .| .| .| .|. |..| .| .| .|. |AG| 
     * |15|. |. | .| .|. |. | .| .| .| .| .| .| .| .| .| .| .|. | .| .| .|. | 
     * |16|. |. |..|SW|. |SW|. |SW|. | .|. |. |. |. |. |SW|. |SW|. |SW|. |. | 
     * |17|. |. | .| .| .| .| .| .| .| .| .|..|. |. |. |. |. |. |. |. |. |. | 
     * |18|. |. | .| .| .| .| .| .| .| .| .|SW| .| .| .| .| .| .| .| .| .| .|
     * |19|. |. | .| .| .| .|. |SW| .| .| .| .|. |. | .|SW|. | .| .| .| .| .| 
     * |20|. |. | .| .| .| .| .| .| .| .|SW| .|SW| .| .| .| .| .| .| .| .| .| 
     * |21|. |. | .| .|. |..| .|SW| .|. |. |. | .| .| .|SW| .| .|..|. |. |. | 
     * |22|. |. | .| .| .| .| .|. | .|SW| .| .| .|SW| .| .| .| .| .| .| .| .| 
     * |23|. |. | .| .|..| .|. |. |. |. |. |. |. | .|. |. |. |. |. |. |. |. | 
     * |24|. |. | .| .| .| .| .|AP|. |. |. | .| .| .|..|AG| .| .| .| .| .| .| 

     *
     *
     */
    public Spielbrett(Logger logger, SpielbrettAusgabe derOutput) {
        this.Output = derOutput;
        log = logger;
        
        Feld blauAnfang = new Feld(log, "blauAnfang", this, "Anfangsfeld", 10, 0, "blau"); //0

        Feld standard1 = new Feld(log, "standard1", this, "Standardfeld", 11, 2, "weiss");
        Feld standard2 = new Feld(log, "standard2", this, "Standardfeld", 12, 4, "weiss");
        Feld standard3 = new Feld(log, "standard3", this, "Standardfeld", 12, 7, "weiss");
        Feld standard4 = new Feld(log, "standard4", this, "Standardfeld", 15, 6, "weiss");
        Feld standard5 = new Feld(log, "standard5", this, "Standardfeld", 17, 5, "weiss");

        Feld rotAnfang = new Feld(log, "", this, "Anfangsfeld", 19, 4, "rot"); //

        Feld standard7 = new Feld(log, "", this, "Standardfeld", 18, 7, "weiss");
        Feld standard8 = new Feld(log, "",this, "Standardfeld", 17, 9, "weiss");
        Feld standard9 = new Feld(log, "", this, "Standardfeld", 15, 11, "weiss");
        Feld standard10 = new Feld(log, "", this, "Standardfeld", 17, 12, "weiss");
        Feld standard11 = new Feld(log, "", this, "Standardfeld", 19, 13, "weiss");

        Feld gruenAnfang = new Feld(log, "", this, "Anfangsfeld", 20, 15, "cyan");

        Feld standard13 = new Feld(log, "", this, "Standardfeld", 18, 16, "weiss");
        Feld standard14 = new Feld(log, "", this, "Standardfeld", 16, 16, "weiss");
        Feld standard15 = new Feld(log, "", this, "Standardfeld", 14, 16, "weiss");
        Feld standard16 = new Feld(log, "", this, "Standardfeld", 14, 19, "weiss");
        Feld standard17 = new Feld(log, "", this, "Standardfeld", 14, 21, "weiss");

        Feld pinkAnfang = new Feld(log, "", this, "Anfangsfeld", 14, 24, "pink");

        Feld standard19 = new Feld(log, "", this, "Standardfeld", 12, 22, "weiss");
        Feld standard20 = new Feld(log, "", this, "Standardfeld", 11, 20, "weiss");
        Feld standard21 = new Feld(log, "", this, "Standardfeld", 10, 18, "weiss");
        Feld standard22 = new Feld(log, "", this, "Standardfeld", 9, 20, "weiss");
        Feld standard23 = new Feld(log, "", this, "Standardfeld", 8, 22, "weiss");

        Feld gelbAnfang = new Feld(log, "", this, "Anfangsfeld", 6, 24, "gelb");

        Feld standard25 = new Feld(log, "", this, "Standardfeld", 6, 21, "weiss");
        Feld standard26 = new Feld(log, "", this, "Standardfeld", 6, 19, "weiss");
        Feld standard27 = new Feld(log, "", this, "Standardfeld", 6, 16, "weiss");
        Feld standard28 = new Feld(log, "", this, "Standardfeld", 4, 16, "weiss");
        Feld standard29 = new Feld(log, "", this, "Standardfeld", 2, 16, "weiss");

        Feld schwarzAnfang = new Feld(log, "", this, "Anfangsfeld", 0, 15, "schwarz");

        Feld standard31 = new Feld(log, "", this, "Standardfeld", 1, 13, "weiss");
        Feld standard32 = new Feld(log, "", this, "Standardfeld", 3, 12, "weiss");
        Feld standard33 = new Feld(log, "", this, "Standardfeld", 5, 11, "weiss");
        Feld standard34 = new Feld(log, "", this, "Standardfeld", 3, 9, "weiss");
        Feld standard35 = new Feld(log, "", this, "Standardfeld", 2, 7, "weiss");

        Feld braunAnfang = new Feld(log, "", this, "Anfangsfeld", 1, 4, "orange");

        Feld standard37 = new Feld(log, "", this, "Standardfeld", 3, 5, "weiss");
        Feld standard38 = new Feld(log, "", this, "Standardfeld", 5, 6, "weiss");
        Feld standard39 = new Feld(log, "", this, "Standardfeld", 8, 7, "weiss");
        Feld standard40 = new Feld(log, "", this, "Standardfeld", 8, 4, "weiss");
        Feld standard41 = new Feld(log, "", this, "Standardfeld", 9, 2, "weiss");
        
        //erzeugt Zielfelder von blau
        Feld blauZiel1 = new Feld(log, "", this, "Zielfeld", 10, 3, "blau");
        Feld blauZiel2 = new Feld(log, "", this, "Zielfeld", 10, 5, "blau");
        Feld blauZiel3 = new Feld(log, "", this, "Zielfeld", 10, 7, "blau");
        //erzeugt Zielfelder von rot
        Feld rotZiel1 = new Feld(log, "", this, "Zielfeld", 17, 6, "rot");
        Feld rotZiel2 = new Feld(log, "", this, "Zielfeld", 15, 8, "rot");
        Feld rotZiel3 = new Feld(log, "", this, "Zielfeld", 13, 10, "rot");
        //erzeugt Zielfelder von gruen
        Feld gruenZiel1 = new Feld(log, "", this, "Zielfeld", 18, 14, "cyan");
        Feld gruenZiel2 = new Feld(log, "", this, "Zielfeld", 16, 14, "cyan");
        Feld gruenZiel3 = new Feld(log, "", this, "Zielfeld", 14, 14, "cyan");
        //erzeugt Zielfelder von pink
        Feld pinkZiel1 = new Feld(log, "", this, "Zielfeld", 13, 21, "pink");
        Feld pinkZiel2 = new Feld(log, "", this, "Zielfeld", 12, 19, "pink");
        Feld pinkZiel3 = new Feld(log, "", this, "Zielfeld", 12, 17, "pink");
        //erzeugt Zielfelder von gelb
        Feld gelbZiel1 = new Feld(log, "", this, "Zielfeld", 7, 21, "gelb");
        Feld gelbZiel2 = new Feld(log, "", this, "Zielfeld", 8, 19, "gelb");
        Feld gelbZiel3 = new Feld(log, "", this, "Zielfeld", 8, 17, "gelb");
        //erzeugt Zielfelder von schwarz
        Feld schwarzZiel1 = new Feld(log, "", this, "Zielfeld", 2, 14, "schwarz");
        Feld schwarzZiel2 = new Feld(log, "", this, "Zielfeld", 4, 14, "schwarz");
        Feld schwarzZiel3 = new Feld(log, "", this, "Zielfeld", 6, 14, "schwarz");
        //erzeugt Zielfelder von braun
        Feld braunZiel1 = new Feld(log, "", this, "Zielfeld", 3, 6, "braun");
        Feld braunZiel2 = new Feld(log, "", this, "Zielfeld", 5, 8, "braun");
        Feld braunZiel3 = new Feld(log, "", this, "Zielfeld", 7, 10, "braun");

        
        //erzeugt startfelder von blau
        Feld blauStart1 = new Feld(log, "", this, "Startfeld", 14, 1, "blau");
        Feld blauStart2 = new Feld(log, "", this, "Startfeld", 16, 2, "blau");
        Feld blauStart3 = new Feld(log, "", this, "Startfeld", 14, 3, "blau");
        //erzeugt startfelder von rot
        Feld rotStart1 = new Feld(log, "", this, "Startfeld", 19, 8, "rot");
        Feld rotStart2 = new Feld(log, "", this, "Startfeld", 20, 11, "rot");
        Feld rotStart3 = new Feld(log, "", this, "Startfeld", 18, 10, "rot");
        //erzeugt startfelder von gruen
        Feld gruenStart1 = new Feld(log, "", this, "Startfeld", 19, 19, "cyan");
        Feld gruenStart2 = new Feld(log, "", this, "Startfeld", 18, 21, "cyan");
        Feld gruenStart3 = new Feld(log, "", this, "Startfeld", 17, 19, "cyan");
        //erzeugt startfelder von pink
        Feld pinkStart1 = new Feld(log, "", this, "Startfeld", 11, 24, "pink");
        Feld pinkStart2 = new Feld(log, "", this, "Startfeld", 9, 24, "pink");
        Feld pinkStart3 = new Feld(log, "", this, "Startfeld", 10, 22, "pink");
        //erzeugt startfelder von gelb
        Feld gelbStart1 = new Feld(log, "", this, "Startfeld", 3, 19, "gelb");
        Feld gelbStart2 = new Feld(log, "", this, "Startfeld", 2, 21, "gelb");
        Feld gelbStart3 = new Feld(log, "", this, "Startfeld", 1, 19, "gelb");
        //erzeugt startfelder von schwarz
        Feld schwarzStart1 = new Feld(log, "", this, "Startfeld", 1, 8, "schwarz");
        Feld schwarzStart2 = new Feld(log, "", this, "Startfeld", 2, 10, "schwarz");
        Feld schwarzStart3 = new Feld(log, "", this, "Startfeld", 0, 11, "schwarz");
        //erzeugt startfelder von braun
        Feld braunStart1 = new Feld(log, "", this, "Startfeld", 4, 2, "braun");
        Feld braunStart2 = new Feld(log, "", this, "Startfeld", 6, 1, "braun");
        Feld braunStart3 = new Feld(log, "", this, "Startfeld", 6, 3, "braun");

        
        // log.log("Spielbrett ", "steht bereit");
        
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
    public SpielbrettAusgabe getOutput(){
    return Output;
    }

}
