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
     * wuerfel des spielbrettes
     */
    private Wuerfel derWuerfel;
    /**
     * alle Felder des Spielbrettes
     */
    private List<Feld> felder = new ArrayList<Feld>();
    private Feld afelder[];
    private Feld efelder[];
    private Feld zfelder[];
    private Feld endkreisfeld;
    private SpielbrettAusgabe Output;
    /**
     * alle Felder des Spielfeldes
     */
    private final List<Feld> spielkreis = new LinkedList<Feld>();
    private Logger log;
    private String objektname;
    private Spiel dasSpiel;
  

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
    
    public Spielbrett(Logger logger, SpielbrettAusgabe derOutput , Spiel dasspiel, String oname) {
        
        this.objektname = oname;
        log = logger; 
        log.log(objektname, "Konstrucktor Spielbrett() gestartet mit Parameter " + oname + " .");
        dasSpiel = dasspiel;
        this.Output = derOutput;
        
        Feld blauAnfang = new Feld(log, "blauAnfang", this, "Anfangsfeld", 4, 4, "blau"); //0

        Feld standard1 = new Feld(log, "standard1", this, "Standardfeld", 5, 5, "weiss");
        Feld standard2 = new Feld(log, "standard2", this, "Standardfeld", 6, 6, "weiss");
        Feld standard3 = new Feld(log, "standard3", this, "Standardfeld", 5, 7, "weiss");
        Feld standard4 = new Feld(log, "standard4", this, "Standardfeld", 4, 8, "weiss");
        Feld standard5 = new Feld(log, "standard5", this, "Standardfeld", 2, 8, "weiss");
        Feld standard6 = new Feld(log, "standard5", this, "Standardfeld", 0, 8, "weiss");
        Feld zeFeldrot = new Feld(log, "zeFeldrot", this, "zeFeld", 0, 10, "weiss");
        
        Feld rotAnfang = new Feld(log, "rotAnfang", this, "Anfangsfeld", 0, 12, "rot"); //

        Feld standard7 = new Feld(log, "standard7", this, "Standardfeld", 2, 12, "weiss");
        Feld standard8 = new Feld(log, "standard8",this, "Standardfeld", 4, 12, "weiss");
        Feld standard9 = new Feld(log, "standard9", this, "Standardfeld", 5, 13, "weiss");
        Feld standard10 = new Feld(log, "standard10", this, "Standardfeld", 6, 14, "weiss");
        Feld standard11 = new Feld(log, "standard11", this, "Standardfeld", 5, 15, "weiss");
        Feld standard12 = new Feld(log, "standard7", this, "Standardfeld", 4, 16, "weiss");
        Feld zeFeldgruen = new Feld(log, "zeFeldgruen", this, "zeFeld", 5, 17, "weiss");

        Feld gruenAnfang = new Feld(log, "gruenAnfang", this, "Anfangsfeld", 6, 18, "gruen");
        Feld standard13 = new Feld(log, "standard13", this, "Standardfeld", 7, 17, "weiss");
        Feld standard14 = new Feld(log, "standard14", this, "Standardfeld", 8, 16, "weiss");
        Feld standard15 = new Feld(log, "standard15", this, "Standardfeld", 10, 16, "weiss");
        Feld standard16 = new Feld(log, "standard16", this, "Standardfeld", 12, 16, "weiss");
        Feld standard17 = new Feld(log, "standard17", this, "Standardfeld", 13, 17, "weiss");
        Feld standard18 = new Feld(log, "standard13", this, "Standardfeld", 14, 18, "weiss");
        Feld zeFeldpink = new Feld(log, "zeFeldpink", this, "zeFeld", 15, 17, "weiss");

        Feld pinkAnfang = new Feld(log, "pinkAnfang", this, "Anfangsfeld", 16, 16, "pink");

        Feld standard19 = new Feld(log, "standard19", this, "Standardfeld", 15, 15, "weiss");
        Feld standard20 = new Feld(log, "standard120", this, "Standardfeld", 14, 14, "weiss");
        Feld standard21 = new Feld(log, "standard21", this, "Standardfeld", 15, 13, "weiss");
        Feld standard22 = new Feld(log, "standard22", this, "Standardfeld", 16, 12, "weiss");
        Feld standard23 = new Feld(log, "standard23", this, "Standardfeld", 18, 12, "weiss");
        Feld standard24 = new Feld(log, "standard19", this, "Standardfeld", 20, 12, "weiss");
        Feld zeFeldgelb = new Feld(log, "zeFeldgelb", this, "zeFeld", 20, 10, "weiss");

        Feld gelbAnfang = new Feld(log, "gelbAnfang", this, "Anfangsfeld", 20, 8, "gelb");
        Feld standard25 = new Feld(log, "standard125", this, "Standardfeld", 18, 8, "weiss");
        Feld standard26 = new Feld(log, "standard26", this, "Standardfeld", 16, 8, "weiss");
        Feld standard27 = new Feld(log, "standard27", this, "Standardfeld", 15, 7, "weiss");
        Feld standard28 = new Feld(log, "standard28", this, "Standardfeld", 14, 6, "weiss");
        Feld standard29 = new Feld(log, "standard16", this, "Standardfeld", 15, 5, "weiss");
        Feld standard30 = new Feld(log, "standard125", this, "Standardfeld", 16, 4, "weiss");
        Feld zeFeldschwarz = new Feld(log, "zeFeldschwarz", this, "zeFeld", 15, 3, "weiss");

        Feld schwarzAnfang = new Feld(log, "schwarzAnfang", this, "Anfangsfeld", 14, 2, "schwarz");

        Feld standard31 = new Feld(log, "standard31", this, "Standardfeld", 13, 3, "weiss");
        Feld standard32 = new Feld(log, "standard32", this, "Standardfeld", 12, 4, "weiss");      
        Feld standard33 = new Feld(log, "standard33", this, "Standardfeld", 10, 4, "weiss");
        Feld standard34 = new Feld(log, "standard34", this, "Standardfeld", 8, 4, "weiss");
        Feld standard35 = new Feld(log, "standard35", this, "Standardfeld", 7, 3, "weiss");
        Feld standard36 = new Feld(log, "standard31", this, "Standardfeld", 6, 2, "weiss");
        
        Feld zeFeldblau = new Feld(log, "zeFeldblau", this, "zeFeld", 5, 3, "weiss");
        
        //erzeugt Zielfelder von blau
        Feld blauZiel1 = new Feld(log, "blauZiel1", this, "Zielfeld", 6, 4, "blau");
        Feld blauZiel2 = new Feld(log, "blauZiel2", this, "Zielfeld", 7, 5, "blau");
        Feld blauZiel3 = new Feld(log, "blauZiel3", this, "Zielfeld", 8, 6, "blau");
        Feld blauZiel4 = new Feld(log, "blauZiel2", this, "Zielfeld", 9, 7, "blau");
        //erzeugt Zielfelder von rot
        Feld rotZiel1 = new Feld(log, "rotZiel1", this, "Zielfeld", 1, 10, "rot");
        Feld rotZiel2 = new Feld(log, "rotZiel2", this, "Zielfeld", 2, 10, "rot");
        Feld rotZiel3 = new Feld(log, "rotZiel3", this, "Zielfeld", 3, 10, "rot");
        Feld rotZiel4 = new Feld(log, "rotZiel1", this, "Zielfeld", 4, 10, "rot");
        //erzeugt Zielfelder von gruen
        Feld gruenZiel1 = new Feld(log, "gruenZiel1", this, "Zielfeld", 6, 16, "gruen");
        Feld gruenZiel2 = new Feld(log, "gruenZiel2", this, "Zielfeld", 7, 15, "gruen");
        Feld gruenZiel3 = new Feld(log, "gruenZiel3", this, "Zielfeld", 8, 14, "gruen");
        Feld gruenZiel4 = new Feld(log, "gruenZiel1", this, "Zielfeld", 9, 13, "gruen");
        //erzeugt Zielfelder von pink
        Feld pinkZiel1 = new Feld(log, "pinkZiel1", this, "Zielfeld", 14, 16, "pink");
        Feld pinkZiel2 = new Feld(log, "pinkZiel2", this, "Zielfeld", 13, 15, "pink");
        Feld pinkZiel3 = new Feld(log, "pinkZiel3", this, "Zielfeld", 12, 14, "pink");
        Feld pinkZiel4 = new Feld(log, "pinkZiel1", this, "Zielfeld", 11, 13, "pink");
        //erzeugt Zielfelder von gelb
        Feld gelbZiel1 = new Feld(log, "gelbZiel1", this, "Zielfeld", 19, 10, "gelb");
        Feld gelbZiel2 = new Feld(log, "gelbZiel2", this, "Zielfeld", 18, 10, "gelb");
        Feld gelbZiel3 = new Feld(log, "gelbZiel3", this, "Zielfeld", 17, 10, "gelb");
        Feld gelbZiel4 = new Feld(log, "gelbZiel1", this, "Zielfeld", 16, 10, "gelb");
        //erzeugt Zielfelder von schwarz
        Feld schwarzZiel1 = new Feld(log, "schwarzZiel1", this, "Zielfeld", 14, 4, "schwarz");
        Feld schwarzZiel2 = new Feld(log, "schwarzZiel2", this, "Zielfeld", 13, 5, "schwarz");
        Feld schwarzZiel3 = new Feld(log, "schwarzZiel3", this, "Zielfeld", 12, 6, "schwarz");
        Feld schwarzZiel4 = new Feld(log, "schwarzZiel1", this, "Zielfeld", 11, 7, "schwarz");
       
        

        
        //erzeugt startfelder von blau
        Feld blauStart1 = new Feld(log, "blauStart1", this, "Startfeld", 2, 2, "blau");
        Feld blauStart2 = new Feld(log, "blauStart2", this, "Startfeld", 2, 0, "blau");
        Feld blauStart3 = new Feld(log, "blauStart3", this, "Startfeld", 0, 2, "blau");
        Feld blauStart4 = new Feld(log, "blauStart4", this, "Startfeld", 0, 0, "blau");
        //erzeugt startfelder von rot
        Feld rotStart1 = new Feld(log, "rotStart1", this, "Startfeld", 0, 18, "rot");
        Feld rotStart2 = new Feld(log, "rotStart2", this, "Startfeld", 0, 20, "rot");
        Feld rotStart3 = new Feld(log, "rotStart3", this, "Startfeld", 2, 18, "rot");
        Feld rotStart4 = new Feld(log, "rotStart4", this, "Startfeld", 2, 20, "rot");
        //erzeugt startfelder von gruen
        Feld gruenStart1 = new Feld(log, "gruenStart1", this, "Startfeld", 9, 18, "gruen");
        Feld gruenStart2 = new Feld(log, "gruenStart2", this, "Startfeld", 9, 20, "gruen");
        Feld gruenStart3 = new Feld(log, "gruenStart3", this, "Startfeld", 11, 18, "gruen");
        Feld gruenStart4 = new Feld(log, "gruenStart4", this, "Startfeld", 11, 20, "gruen");
        //erzeugt startfelder von pink
        Feld pinkStart1 = new Feld(log, "pinkStart1", this, "Startfeld", 20, 18, "pink");
        Feld pinkStart2 = new Feld(log, "pinkStart2", this, "Startfeld", 20, 20, "pink");
        Feld pinkStart3 = new Feld(log, "pinkStart3", this, "Startfeld", 18, 18, "pink");
        Feld pinkStart4 = new Feld(log, "pinkStart4", this, "Startfeld", 18, 20, "pink");
        //erzeugt startfelder von gelb
        Feld gelbStart1 = new Feld(log, "gelbStart1", this, "Startfeld", 18, 2, "gelb");
        Feld gelbStart2 = new Feld(log, "gelbStart2", this, "Startfeld", 18, 0, "gelb");
        Feld gelbStart3 = new Feld(log, "gelbStart3", this, "Startfeld", 20, 2, "gelb");
        Feld gelbStart4 = new Feld(log, "gelbStart4", this, "Startfeld", 20, 0, "gelb");
        //erzeugt startfelder von schwarz
        Feld schwarzStart1 = new Feld(log, "schwarzStart1", this, "Startfeld", 11, 2, "schwarz");
        Feld schwarzStart2 = new Feld(log, "schwarzStart2", this, "Startfeld", 11, 0, "schwarz");
        Feld schwarzStart3 = new Feld(log, "schwarzStart3", this, "Startfeld", 9, 2, "schwarz");
        Feld schwarzStart4 = new Feld(log, "schwarzStart4", this, "Startfeld", 9, 0, "schwarz");
        

        //public Spielfigur(String oname, Logger logger, Feld starterfeld, Spieler derSpieler) {
        Spielfigur Blau1 = new Spielfigur("Blau1",log, blauStart1 , 0, dasspiel);
        Spielfigur Blau2 = new Spielfigur("Blau2",log, blauStart2 , 0, dasspiel);
        Spielfigur Blau3 = new Spielfigur("Blau3",log, blauStart3 , 0, dasspiel);
        Spielfigur Blau4 = new Spielfigur("Blau4",log, blauStart4 , 0, dasspiel);
        
        
        Spielfigur Rot1 = new Spielfigur("Rot1",log, rotStart1 , 1, dasspiel);
        Spielfigur Rot2 = new Spielfigur("Rot2",log, rotStart2 , 1, dasspiel);
        Spielfigur Rot3 = new Spielfigur("Rot3",log, rotStart3 ,1, dasspiel);
        Spielfigur Rot4 = new Spielfigur("Rot4",log, rotStart4 ,1, dasspiel);
        
        Spielfigur Gruen1 = new Spielfigur("Gruen1",log, gruenStart1 , 2, dasspiel);
        Spielfigur Gruen2 = new Spielfigur("Gruen2",log, gruenStart2 , 2, dasspiel);
        Spielfigur Gruen3 = new Spielfigur("Gruen3",log, gruenStart3 , 2, dasspiel);
        Spielfigur Gruen4 = new Spielfigur("Gruen4",log, gruenStart4 , 2, dasspiel);
      
        
        Spielfigur Pink1 = new Spielfigur("Pink1",log, pinkStart1 , 3, dasspiel);
        Spielfigur Pink2 = new Spielfigur("Pink2",log, pinkStart2 , 3, dasspiel);
        Spielfigur Pink3 = new Spielfigur("Pink3",log, pinkStart3 , 3, dasspiel);
        Spielfigur Pink4 = new Spielfigur("Pink4",log, pinkStart4 , 3, dasspiel);
        
        Spielfigur Gelb1 = new Spielfigur("Gelb1",log, gelbStart1 , 4, dasspiel);
        Spielfigur Gelb2 = new Spielfigur("Gelb2",log, gelbStart2 , 4, dasspiel);
        Spielfigur Gelb3 = new Spielfigur("Gelb3",log, gelbStart3 , 4, dasspiel);
        Spielfigur Gelb4 = new Spielfigur("Gelb4",log, gelbStart4 , 4, dasspiel);
        
        Spielfigur Schwarz1 = new Spielfigur("Schwarz1",log, schwarzStart1 , 5, dasspiel);
        Spielfigur Schwarz2 = new Spielfigur("Schwarz2",log, schwarzStart2 , 5, dasspiel);
        Spielfigur Schwarz3 = new Spielfigur("Schwarz3",log, schwarzStart3 , 5, dasspiel);
        Spielfigur Schwarz4 = new Spielfigur("Schwarz4",log, schwarzStart4 , 5, dasspiel);
       
        Feld[] a = {blauAnfang, rotAnfang, gruenAnfang, pinkAnfang, gelbAnfang, schwarzAnfang};
        this.afelder = a;
        Feld[] e = {zeFeldblau, zeFeldrot, zeFeldgruen, zeFeldpink, zeFeldgelb, zeFeldschwarz};
        this.efelder = e;
        Feld[] z = {blauZiel1, rotZiel1, gruenZiel1, pinkZiel1, gelbZiel1, schwarzZiel1};
        this.zfelder = z;
        this.endkreisfeld = zeFeldblau;
        
        Wuerfel derWuerfel = new Wuerfel(log,"Wuerfel",1,6,this.Output);
        this.dasSpiel.setWuerfel(derWuerfel);
        log.log(objektname, "Methode Spielbrett() beendet.");
        
        
    }
    
    
    
    

    public void Spielbrett3(Logger logger, SpielbrettAusgabe derOutput , Spiel dasspiel, String oname) {
        
        this.objektname = oname;
        log = logger; 
        log.log(objektname, "Konstrucktor Spielbrett() gestartet mit Parameter " + oname + " .");
        dasSpiel = dasspiel;
        this.Output = derOutput;
        
        Feld blauAnfang = new Feld(log, "blauAnfang", this, "Anfangsfeld", 11, 0, "blau"); //0

        Feld standard1 = new Feld(log, "standard1", this, "Standardfeld", 12, 2, "weiss");
        Feld standard2 = new Feld(log, "standard2", this, "Standardfeld", 12, 4, "weiss");
        Feld standard3 = new Feld(log, "standard3", this, "Standardfeld", 12, 7, "weiss");
        Feld standard4 = new Feld(log, "standard4", this, "Standardfeld", 14, 5, "weiss");
        Feld standard5 = new Feld(log, "standard5", this, "Standardfeld", 16, 3, "weiss");
        Feld zeFeldrot = new Feld(log, "zeFeldrot", this, "zeFeld", 18, 3, "weiss");
        
        Feld rotAnfang = new Feld(log, "rotAnfang", this, "Anfangsfeld", 19, 5, "rot"); //

        Feld standard7 = new Feld(log, "standard7", this, "Standardfeld", 18, 7, "weiss");
        Feld standard8 = new Feld(log, "standard8",this, "Standardfeld", 16, 9, "weiss");
        Feld standard9 = new Feld(log, "standard9", this, "Standardfeld", 14, 11, "weiss");
        Feld standard10 = new Feld(log, "standard10", this, "Standardfeld", 16, 11, "weiss");
        Feld standard11 = new Feld(log, "standard11", this, "Standardfeld", 18, 11, "weiss");
        Feld zeFeldgruen = new Feld(log, "zeFeldgruen", this, "zeFeld", 20, 12, "weiss");

        Feld gruenAnfang = new Feld(log, "gruenAnfang", this, "Anfangsfeld", 20, 14, "gruen");
        Feld standard13 = new Feld(log, "standard13", this, "Standardfeld", 18, 15, "weiss");
        Feld standard14 = new Feld(log, "standard14", this, "Standardfeld", 16, 15, "weiss");
        Feld standard15 = new Feld(log, "standard15", this, "Standardfeld", 14, 15, "weiss");
        Feld standard16 = new Feld(log, "standard16", this, "Standardfeld", 15, 18, "weiss");
        Feld standard17 = new Feld(log, "standard17", this, "Standardfeld", 16, 20, "weiss");
        Feld zeFeldpink = new Feld(log, "zeFeldpink", this, "zeFeld", 17, 22, "weiss");

        Feld pinkAnfang = new Feld(log, "pinkAnfang", this, "Anfangsfeld", 15, 24, "pink");

        Feld standard19 = new Feld(log, "standard19", this, "Standardfeld", 13, 22, "weiss");
        Feld standard20 = new Feld(log, "standard120", this, "Standardfeld", 12, 20, "weiss");
        Feld standard21 = new Feld(log, "standard21", this, "Standardfeld", 10, 17, "weiss");
        Feld standard22 = new Feld(log, "standard22", this, "Standardfeld", 8, 20, "weiss");
        Feld standard23 = new Feld(log, "standard23", this, "Standardfeld", 7, 22, "weiss");
        Feld zeFeldgelb = new Feld(log, "zeFeldgelb", this, "zeFeld", 5, 24, "weiss");

        Feld gelbAnfang = new Feld(log, "gelbAnfang", this, "Anfangsfeld", 3, 22, "gelb");
        Feld standard25 = new Feld(log, "standard125", this, "Standardfeld", 4, 20, "weiss");
        Feld standard26 = new Feld(log, "standard26", this, "Standardfeld", 5, 18, "weiss");
        Feld standard27 = new Feld(log, "standard27", this, "Standardfeld", 6, 15, "weiss");
        Feld standard28 = new Feld(log, "standard28", this, "Standardfeld", 4, 15, "weiss");
        Feld standard29 = new Feld(log, "standard16", this, "Standardfeld", 2, 15, "weiss");
        Feld zeFeldschwarz = new Feld(log, "zeFeldschwarz", this, "zeFeld", 0, 14, "weiss");

        Feld schwarzAnfang = new Feld(log, "schwarzAnfang", this, "Anfangsfeld", 0, 12, "schwarz");

        Feld standard31 = new Feld(log, "standard31", this, "Standardfeld", 2, 11, "weiss");
        Feld standard32 = new Feld(log, "standard32", this, "Standardfeld", 4, 11, "weiss");      
        Feld standard33 = new Feld(log, "standard33", this, "Standardfeld", 6, 11, "weiss");
        Feld standard34 = new Feld(log, "standard34", this, "Standardfeld", 4, 9, "weiss");
        Feld standard35 = new Feld(log, "standard35", this, "Standardfeld", 2, 7, "weiss");
        Feld zeFeldtuerkis = new Feld(log, "zeFeldtuerkis", this, "zeFeld", 1, 5, "weiss");

        Feld tuerkisAnfang = new Feld(log, "tuerkisAnfang", this, "Anfangsfeld", 2, 3, "tuerkis");

        Feld standard37 = new Feld(log, "standard37", this, "Standardfeld", 4, 3, "weiss");
        Feld standard38 = new Feld(log, "standard38", this, "Standardfeld", 6, 5, "weiss");
        Feld standard39 = new Feld(log, "standard39", this, "Standardfeld", 8, 7, "weiss");
        Feld standard40 = new Feld(log, "standard40", this, "Standardfeld", 8, 4, "weiss");
        Feld standard41 = new Feld(log, "standard41", this, "Standardfeld", 8, 2, "weiss");
        Feld zeFeldblau = new Feld(log, "zeFeldblau", this, "zeFeld", 9, 0, "weiss");
        
        //erzeugt Zielfelder von blau
        Feld blauZiel1 = new Feld(log, "blauZiel1", this, "Zielfeld", 10, 2, "blau");
        Feld blauZiel2 = new Feld(log, "blauZiel2", this, "Zielfeld", 10, 5, "blau");
        Feld blauZiel3 = new Feld(log, "blauZiel3", this, "Zielfeld", 10, 8, "blau");
        //erzeugt Zielfelder von rot
        Feld rotZiel1 = new Feld(log, "rotZiel1", this, "Zielfeld", 17, 5, "rot");
        Feld rotZiel2 = new Feld(log, "rotZiel2", this, "Zielfeld", 15, 7, "rot");
        Feld rotZiel3 = new Feld(log, "rotZiel3", this, "Zielfeld", 13, 9, "rot");
        //erzeugt Zielfelder von gruen
        Feld gruenZiel1 = new Feld(log, "gruenZiel1", this, "Zielfeld", 18, 13, "gruen");
        Feld gruenZiel2 = new Feld(log, "gruenZiel2", this, "Zielfeld", 16, 13, "gruen");
        Feld gruenZiel3 = new Feld(log, "gruenZiel3", this, "Zielfeld", 14, 13, "gruen");
        //erzeugt Zielfelder von pink
        Feld pinkZiel1 = new Feld(log, "pinkZiel1", this, "Zielfeld", 15, 22, "pink");
        Feld pinkZiel2 = new Feld(log, "pinkZiel2", this, "Zielfeld", 14, 20, "pink");
        Feld pinkZiel3 = new Feld(log, "pinkZiel3", this, "Zielfeld", 12, 17, "pink");
        //erzeugt Zielfelder von gelb
        Feld gelbZiel1 = new Feld(log, "gelbZiel1", this, "Zielfeld", 5, 22, "gelb");
        Feld gelbZiel2 = new Feld(log, "gelbZiel2", this, "Zielfeld", 6, 20, "gelb");
        Feld gelbZiel3 = new Feld(log, "gelbZiel3", this, "Zielfeld", 8, 17, "gelb");
        //erzeugt Zielfelder von schwarz
        Feld schwarzZiel1 = new Feld(log, "schwarzZiel1", this, "Zielfeld", 2, 13, "schwarz");
        Feld schwarzZiel2 = new Feld(log, "schwarzZiel2", this, "Zielfeld", 4, 13, "schwarz");
        Feld schwarzZiel3 = new Feld(log, "schwarzZiel3", this, "Zielfeld", 6, 13, "schwarz");
        //erzeugt Zielfelder von tuerkis
        Feld tuerkisZiel1 = new Feld(log, "tuerkisZiel1", this, "Zielfeld", 3, 5, "tuerkis");
        Feld tuerkisZiel2 = new Feld(log, "tuerkisZiel2", this, "Zielfeld", 5, 7, "tuerkis");
        Feld tuerkisZiel3 = new Feld(log, "tuerkisZiel3", this, "Zielfeld", 7, 9, "tuerkis");

        
        //erzeugt startfelder von blau
        Feld blauStart1 = new Feld(log, "blauStart1", this, "Startfeld", 13, 1, "blau");
        Feld blauStart2 = new Feld(log, "blauStart2", this, "Startfeld", 15, 1, "blau");
        Feld blauStart3 = new Feld(log, "blauStart3", this, "Startfeld", 14, 3, "blau");
        //erzeugt startfelder von rot
        Feld rotStart1 = new Feld(log, "rotStart1", this, "Startfeld", 20, 8, "rot");
        Feld rotStart2 = new Feld(log, "rotStart2", this, "Startfeld", 20, 10, "rot");
        Feld rotStart3 = new Feld(log, "rotStart3", this, "Startfeld", 18, 9, "rot");
        //erzeugt startfelder von gruen
        Feld gruenStart1 = new Feld(log, "gruenStart1", this, "Startfeld", 19, 17, "gruen");
        Feld gruenStart2 = new Feld(log, "gruenStart2", this, "Startfeld", 18, 19, "gruen");
        Feld gruenStart3 = new Feld(log, "gruenStart3", this, "Startfeld", 17, 17, "gruen");
        //erzeugt startfelder von pink
        Feld pinkStart1 = new Feld(log, "pinkStart1", this, "Startfeld", 11, 24, "pink");
        Feld pinkStart2 = new Feld(log, "pinkStart2", this, "Startfeld", 9, 24, "pink");
        Feld pinkStart3 = new Feld(log, "pinkStart3", this, "Startfeld", 10, 22, "pink");
        //erzeugt startfelder von gelb
        Feld gelbStart1 = new Feld(log, "gelbStart1", this, "Startfeld", 3, 17, "gelb");
        Feld gelbStart2 = new Feld(log, "gelbStart2", this, "Startfeld", 2, 19, "gelb");
        Feld gelbStart3 = new Feld(log, "gelbStart3", this, "Startfeld", 1, 17, "gelb");
        //erzeugt startfelder von schwarz
        Feld schwarzStart1 = new Feld(log, "schwarzStart1", this, "Startfeld", 0, 8, "schwarz");
        Feld schwarzStart2 = new Feld(log, "schwarzStart2", this, "Startfeld", 2, 9, "schwarz");
        Feld schwarzStart3 = new Feld(log, "schwarzStart3", this, "Startfeld", 0, 10, "schwarz");
        //erzeugt startfelder von tuerkis
        Feld tuerkisStart1 = new Feld(log, "tuerkisStart1", this, "Startfeld", 5, 1, "tuerkis");
        Feld tuerkisStart2 = new Feld(log, "tuerkisStart2", this, "Startfeld", 7, 1, "tuerkis");
        Feld tuerkisStart3 = new Feld(log, "tuerkisStart3", this, "Startfeld", 6, 3, "tuerkis");

        //public Spielfigur(String oname, Logger logger, Feld starterfeld, Spieler derSpieler) {
        Spielfigur Blau1 = new Spielfigur("Blau1",log, blauStart1 , 0, dasspiel);
        Spielfigur Blau2 = new Spielfigur("Blau2",log, blauStart2 , 0, dasspiel);
        Spielfigur Blau3 = new Spielfigur("Blau3",log, blauStart3 , 0, dasspiel);
        
        
        Spielfigur Rot1 = new Spielfigur("Rot1",log, rotStart1 , 1, dasspiel);
        Spielfigur Rot2 = new Spielfigur("Rot2",log, rotStart2 , 1, dasspiel);
        Spielfigur Rot3 = new Spielfigur("Rot3",log, rotStart3 ,1, dasspiel);
        
        Spielfigur Gruen1 = new Spielfigur("Gruen1",log, gruenStart1 , 2, dasspiel);
        Spielfigur Gruen2 = new Spielfigur("Gruen2",log, gruenStart2 , 2, dasspiel);
        Spielfigur Gruen3 = new Spielfigur("Gruen3",log, gruenStart3 , 2, dasspiel);
      
        
        Spielfigur Pink1 = new Spielfigur("Pink1",log, pinkStart1 , 3, dasspiel);
        Spielfigur Pink2 = new Spielfigur("Pink2",log, pinkStart2 , 3, dasspiel);
        Spielfigur Pink3 = new Spielfigur("Pink3",log, pinkStart3 , 3, dasspiel);
        
        Spielfigur Gelb1 = new Spielfigur("Gelb1",log, gelbStart1 , 4, dasspiel);
        Spielfigur Gelb2 = new Spielfigur("Gelb2",log, gelbStart2 , 4, dasspiel);
        Spielfigur Gelb3 = new Spielfigur("Gelb3",log, gelbStart3 , 4, dasspiel);
        
        Spielfigur Schwarz1 = new Spielfigur("Schwarz1",log, schwarzStart1 , 5, dasspiel);
        Spielfigur Schwarz2 = new Spielfigur("Schwarz2",log, schwarzStart2 , 5, dasspiel);
        Spielfigur Schwarz3 = new Spielfigur("Schwarz3",log, schwarzStart3 , 5, dasspiel);
        
        Spielfigur Tuerkis1 = new Spielfigur("Tuerkis1",log, tuerkisStart1 , 6, dasspiel);
        Spielfigur Tuerkis2 = new Spielfigur("Tuerkis2",log, tuerkisStart2 , 6, dasspiel);
        Spielfigur Tuerkis3 = new Spielfigur("Tuerkis3",log, tuerkisStart3 , 6, dasspiel);
       
        //public Wuerfel(Logger logger, String name, int wuerfelmin, int wuerfelmax, SpielbrettAusgabe out) {
        
        Wuerfel derWuerfel = new Wuerfel(log,"Wuerfel",1,6,this.Output);
        this.dasSpiel.setWuerfel(derWuerfel);
        log.log(objektname, "Methode Spielbrett() beendet.");
        
        
    }
     public void Spielbrett2(Logger logger, SpielbrettAusgabe derOutput , Spiel dasspiel, String oname) {
        
        this.objektname = oname;
        log = logger; 
        log.log(objektname, "Konstrucktor Spielbrett() gestartet mit Parameter " + oname + " .");
        dasSpiel = dasspiel;
        this.Output = derOutput;
         
        Feld blauAnfang = new Feld(log, "blauAnfang", this, "Anfangsfeld", 10, 0, "blau"); //0

        Feld standard1 = new Feld(log, "standard1", this, "Standardfeld", 11, 2, "weiss");
        Feld standard2 = new Feld(log, "standard2", this, "Standardfeld", 12, 4, "weiss");
        Feld standard3 = new Feld(log, "standard3", this, "Standardfeld", 12, 7, "weiss");
        Feld standard4 = new Feld(log, "standard4", this, "Standardfeld", 15, 6, "weiss");
        Feld standard5 = new Feld(log, "standard5", this, "zeFeld", 17, 5, "weiss");

        Feld rotAnfang = new Feld(log, "rotAnfang", this, "Anfangsfeld", 19, 4, "rot"); //

        Feld standard7 = new Feld(log, "standard7", this, "Standardfeld", 18, 7, "weiss");
        Feld standard8 = new Feld(log, "standard8",this, "Standardfeld", 17, 9, "weiss");
        Feld standard9 = new Feld(log, "standard9", this, "Standardfeld", 15, 11, "weiss");
        Feld standard10 = new Feld(log, "standard10", this, "Standardfeld", 17, 12, "weiss");
        Feld standard11 = new Feld(log, "standard11", this, "zeFeld", 19, 13, "weiss");

        Feld gruenAnfang = new Feld(log, "gruenAnfang", this, "Anfangsfeld", 20, 15, "gruen");

        Feld standard13 = new Feld(log, "standard13", this, "Standardfeld", 18, 16, "weiss");
        Feld standard14 = new Feld(log, "standard14", this, "Standardfeld", 16, 16, "weiss");
        Feld standard15 = new Feld(log, "standard15", this, "Standardfeld", 14, 16, "weiss");
        Feld standard16 = new Feld(log, "standard16", this, "Standardfeld", 14, 19, "weiss");
        Feld standard17 = new Feld(log, "standard17", this, "zeFeld", 14, 21, "weiss");

        Feld pinkAnfang = new Feld(log, "pinkAnfang", this, "Anfangsfeld", 14, 24, "pink");

        Feld standard19 = new Feld(log, "standard19", this, "Standardfeld", 12, 22, "weiss");
        Feld standard20 = new Feld(log, "standard120", this, "Standardfeld", 11, 20, "weiss");
        Feld standard21 = new Feld(log, "standard21", this, "Standardfeld", 10, 18, "weiss");
        Feld standard22 = new Feld(log, "standard22", this, "Standardfeld", 9, 20, "weiss");
        Feld standard23 = new Feld(log, "standard23", this, "zeFeld", 8, 22, "weiss");

        Feld gelbAnfang = new Feld(log, "gelbAnfang", this, "Anfangsfeld", 6, 24, "gelb");

        Feld standard25 = new Feld(log, "standard125", this, "Standardfeld", 6, 21, "weiss");
        Feld standard26 = new Feld(log, "standard26", this, "Standardfeld", 6, 19, "weiss");
        Feld standard27 = new Feld(log, "standard27", this, "Standardfeld", 6, 16, "weiss");
        Feld standard28 = new Feld(log, "standard28", this, "Standardfeld", 4, 16, "weiss");
        Feld standard29 = new Feld(log, "standard29", this, "zeFeld", 2, 16, "weiss");

        Feld schwarzAnfang = new Feld(log, "schwarzAnfang", this, "Anfangsfeld", 0, 15, "schwarz");

        Feld standard31 = new Feld(log, "standard31", this, "Standardfeld", 1, 13, "weiss");
        Feld standard32 = new Feld(log, "standard32", this, "Standardfeld", 3, 12, "weiss");
        Feld standard33 = new Feld(log, "standard33", this, "Standardfeld", 5, 11, "weiss");
        Feld standard34 = new Feld(log, "standard34", this, "Standardfeld", 3, 9, "weiss");
        Feld standard35 = new Feld(log, "standard35", this, "zeFeld", 2, 7, "weiss");

        Feld tuerkisAnfang = new Feld(log, "tuerkisAnfang", this, "Anfangsfeld", 1, 4, "tuerkis");

        Feld standard37 = new Feld(log, "standard37", this, "Standardfeld", 3, 5, "weiss");
        Feld standard38 = new Feld(log, "standard38", this, "Standardfeld", 5, 6, "weiss");
        Feld standard39 = new Feld(log, "standard39", this, "Standardfeld", 8, 7, "weiss");
        Feld standard40 = new Feld(log, "standard40", this, "Standardfeld", 8, 4, "weiss");
        Feld standard41 = new Feld(log, "standard41", this, "zeFeld", 9, 2, "weiss");
        
        //erzeugt Zielfelder von blau
        Feld blauZiel1 = new Feld(log, "blauZiel1", this, "Zielfeld", 10, 3, "blau");
        Feld blauZiel2 = new Feld(log, "blauZiel2", this, "Zielfeld", 10, 5, "blau");
        Feld blauZiel3 = new Feld(log, "blauZiel3", this, "Zielfeld", 10, 7, "blau");
        //erzeugt Zielfelder von rot
        Feld rotZiel1 = new Feld(log, "rotZiel1", this, "Zielfeld", 17, 6, "rot");
        Feld rotZiel2 = new Feld(log, "rotZiel2", this, "Zielfeld", 15, 8, "rot");
        Feld rotZiel3 = new Feld(log, "rotZiel3", this, "Zielfeld", 13, 10, "rot");
        //erzeugt Zielfelder von gruen
        Feld gruenZiel1 = new Feld(log, "gruenZiel1", this, "Zielfeld", 18, 14, "gruen");
        Feld gruenZiel2 = new Feld(log, "gruenZiel2", this, "Zielfeld", 16, 14, "gruen");
        Feld gruenZiel3 = new Feld(log, "gruenZiel3", this, "Zielfeld", 14, 14, "gruen");
        //erzeugt Zielfelder von pink
        Feld pinkZiel1 = new Feld(log, "pinkZiel1", this, "Zielfeld", 13, 21, "pink");
        Feld pinkZiel2 = new Feld(log, "pinkZiel2", this, "Zielfeld", 12, 19, "pink");
        Feld pinkZiel3 = new Feld(log, "pinkZiel3", this, "Zielfeld", 12, 17, "pink");
        //erzeugt Zielfelder von gelb
        Feld gelbZiel1 = new Feld(log, "gelbZiel1", this, "Zielfeld", 7, 21, "gelb");
        Feld gelbZiel2 = new Feld(log, "gelbZiel2", this, "Zielfeld", 8, 19, "gelb");
        Feld gelbZiel3 = new Feld(log, "gelbZiel3", this, "Zielfeld", 8, 17, "gelb");
        //erzeugt Zielfelder von schwarz
        Feld schwarzZiel1 = new Feld(log, "schwarzZiel1", this, "Zielfeld", 2, 14, "schwarz");
        Feld schwarzZiel2 = new Feld(log, "schwarzZiel2", this, "Zielfeld", 4, 14, "schwarz");
        Feld schwarzZiel3 = new Feld(log, "schwarzZiel3", this, "Zielfeld", 6, 14, "schwarz");
        //erzeugt Zielfelder von tuerkis
        Feld tuerkisZiel1 = new Feld(log, "tuerkisZiel1", this, "Zielfeld", 3, 6, "tuerkis");
        Feld tuerkisZiel2 = new Feld(log, "tuerkisZiel2", this, "Zielfeld", 5, 8, "tuerkis");
        Feld tuerkisZiel3 = new Feld(log, "tuerkisZiel3", this, "Zielfeld", 7, 10, "tuerkis");

        
        //erzeugt startfelder von blau
        Feld blauStart1 = new Feld(log, "blauStart1", this, "Startfeld", 14, 1, "blau");
        Feld blauStart2 = new Feld(log, "blauStart2", this, "Startfeld", 16, 2, "blau");
        Feld blauStart3 = new Feld(log, "blauStart3", this, "Startfeld", 14, 3, "blau");
        //erzeugt startfelder von rot
        Feld rotStart1 = new Feld(log, "rotStart1", this, "Startfeld", 19, 8, "rot");
        Feld rotStart2 = new Feld(log, "rotStart2", this, "Startfeld", 20, 11, "rot");
        Feld rotStart3 = new Feld(log, "rotStart3", this, "Startfeld", 18, 10, "rot");
        //erzeugt startfelder von gruen
        Feld gruenStart1 = new Feld(log, "gruenStart1", this, "Startfeld", 19, 19, "gruen");
        Feld gruenStart2 = new Feld(log, "gruenStart2", this, "Startfeld", 18, 21, "gruen");
        Feld gruenStart3 = new Feld(log, "gruenStart3", this, "Startfeld", 17, 19, "gruen");
        //erzeugt startfelder von pink
        Feld pinkStart1 = new Feld(log, "pinkStart1", this, "Startfeld", 11, 24, "pink");
        Feld pinkStart2 = new Feld(log, "pinkStart2", this, "Startfeld", 9, 24, "pink");
        Feld pinkStart3 = new Feld(log, "pinkStart3", this, "Startfeld", 10, 22, "pink");
        //erzeugt startfelder von gelb
        Feld gelbStart1 = new Feld(log, "gelbStart1", this, "Startfeld", 3, 19, "gelb");
        Feld gelbStart2 = new Feld(log, "gelbStart2", this, "Startfeld", 2, 21, "gelb");
        Feld gelbStart3 = new Feld(log, "gelbStart3", this, "Startfeld", 1, 19, "gelb");
        //erzeugt startfelder von schwarz
        Feld schwarzStart1 = new Feld(log, "schwarzStart1", this, "Startfeld", 1, 8, "schwarz");
        Feld schwarzStart2 = new Feld(log, "schwarzStart2", this, "Startfeld", 2, 10, "schwarz");
        Feld schwarzStart3 = new Feld(log, "schwarzStart3", this, "Startfeld", 0, 11, "schwarz");
        //erzeugt startfelder von tuerkis
        Feld tuerkisStart1 = new Feld(log, "tuerkisStart1", this, "Startfeld", 4, 2, "tuerkis");
        Feld tuerkisStart2 = new Feld(log, "tuerkisStart2", this, "Startfeld", 6, 1, "tuerkis");
        Feld tuerkisStart3 = new Feld(log, "tuerkisStart3", this, "Startfeld", 6, 3, "tuerkis");

        //public Spielfigur(String oname, Logger logger, Feld starterfeld, Spieler derSpieler) {
        Spielfigur Blau1 = new Spielfigur("Blau1",log, blauStart1 , 0, dasspiel);
        Spielfigur Blau2 = new Spielfigur("Blau2",log, blauStart2 , 0, dasspiel);
        Spielfigur Blau3 = new Spielfigur("Blau3",log, blauStart3 , 0, dasspiel);
        
        
        Spielfigur Rot1 = new Spielfigur("Rot1",log, rotStart1 , 1, dasspiel);
        Spielfigur Rot2 = new Spielfigur("Rot2",log, rotStart2 , 1, dasspiel);
        Spielfigur Rot3 = new Spielfigur("Rot3",log, rotStart3 ,1, dasspiel);
        
        Spielfigur Gruen1 = new Spielfigur("Gruen1",log, gruenStart1 , 2, dasspiel);
        Spielfigur Gruen2 = new Spielfigur("Gruen2",log, gruenStart2 , 2, dasspiel);
        Spielfigur Gruen3 = new Spielfigur("Gruen3",log, gruenStart3 , 2, dasspiel);
      
        
        Spielfigur Pink1 = new Spielfigur("Pink1",log, pinkStart1 , 3, dasspiel);
        Spielfigur Pink2 = new Spielfigur("Pink2",log, pinkStart2 , 3, dasspiel);
        Spielfigur Pink3 = new Spielfigur("Pink3",log, pinkStart3 , 3, dasspiel);
        
        Spielfigur Gelb1 = new Spielfigur("Gelb1",log, gelbStart1 , 4, dasspiel);
        Spielfigur Gelb2 = new Spielfigur("Gelb2",log, gelbStart2 , 4, dasspiel);
        Spielfigur Gelb3 = new Spielfigur("Gelb3",log, gelbStart3 , 4, dasspiel);
        
        Spielfigur Schwarz1 = new Spielfigur("Schwarz1",log, schwarzStart1 , 5, dasspiel);
        Spielfigur Schwarz2 = new Spielfigur("Schwarz2",log, schwarzStart2 , 5, dasspiel);
        Spielfigur Schwarz3 = new Spielfigur("Schwarz3",log, schwarzStart3 , 5, dasspiel);
        
        Spielfigur Tuerkis1 = new Spielfigur("Tuerkis1",log, tuerkisStart1 , 6, dasspiel);
        Spielfigur Tuerkis2 = new Spielfigur("Tuerkis2",log, tuerkisStart2 , 6, dasspiel);
        Spielfigur Tuerkis3 = new Spielfigur("Tuerkis3",log, tuerkisStart3 , 6, dasspiel);
       
        //public Wuerfel(Logger logger, String name, int wuerfelmin, int wuerfelmax, SpielbrettAusgabe out) {
        
        Wuerfel derWuerfel = new Wuerfel(log,"Wuerfel",1,6,this.Output);
        this.dasSpiel.setWuerfel(derWuerfel);
        log.log(objektname, "Methode Spielbrett() beendet.");
        
        
    }
    /**
     *    |  0|  1|  2|  3|  4|  5|  6|  7|  8|  9| 10| 11| 12| 13| 14| 15| 16| 17| 18| 19| 20|
     * | 0|   |   |   |   |   |   |   |   |f7 |   |ref|   |raf|   |   |   |   |   |   |   |   |
     * | 1|  .|bs1|bs2|.  | . | . |   |  .|   |  .|rz1|.  |.  | . | . |.  |  .|rs1|rs2|.  | . |
     * | 2|   |bs3|bs4|   |   |   |   |   |f6 |   |rz2|   |f10|   |   |   |   |rs3|rs4|   | . |
     * | 3| . |  .|.  |.  | . | . |   | . |   |  .|rz3|   |.  |   | . |.  | . | . |  .|.  | . |
     * | 4|   |   |   |   |baf|   |   |   |f5 |   |rz4|   |f11|   |   |   |f15|   |   |   |  .|
     * | 5|   | . |   |bef|   |f2 |   |f4 |.  |.  |   |   |.  |f12|.  |f14|.  |tef|.  |.  | . |
     * | 6|.  |.  |f47|   |bz1|.  |f3 |   |.  |.  |   |   |.  |   |f13|.  |tz1|.. |taf|.  |   |
     * | 7|.  |   |   |f46|   |bz2|.  |.  |.  |.  |   |   |.  |.  |.  |tz2|.  |f18|   |.  |.  |
     * | 8| . |  .|.  |.  |f45| . |bz3|.  |   |  .| . |  .| . | . |tz3|.  |f19| . | . |.  |.  |
     * | 9|   |ss1|ss2|   |   |.  |.  |bz4|   |.  |   |   |.  |tz4|.  |.  |   |ts1|ts2|.  |.  |
     * |10| . |ss3|ss4|.  |f44| . |   | . |   |  .| . |   | . |  .| . |.  |f20|ts3|ts4|.  |   |
     * |11| . |  .|.  |.  | . | . |   |sz4|   |  .| . |  .| . |pz4| . |.  | . | . | . |.  |   |
     * |12| . |  .|.  |.  |f43| . |sz3| . |   |  .| . |  .| . | . |pz3|.  |f21| . | . |.  | . |
     * |13|.  |   |.  |f42|.  |sz2|.  |   |.  |.  |   |   |.. |   |.  |pz2|   |f22|.  |   |  .|
     * |14|.  |.  |saf|.  |sz1|.  |f37|.  |.  |.  |   |   |.  |   |f27|.  |pz1|.  |f23|.  |  .|
     * |15|.  |   |   |sef|.  |f38|.  |f36|.  |.  |   |   |.  |f28|   |f26|.  |pef|   |.  | . |
     * |16|.  |.  |   |.  |f39|.  |   |.. |f35|.  |gz4|   |f29|.  |   |.  |paf|.  |.  |.  |  .|
     * |17|.  |   |.  |   |   |.  |.  |   |.  |   |gz3|   |.  |  .|.  | . | . |.  |.  |.  |  .|
     * |18| . |gs1|gs2|.  |  .| . |   | . |f34|.  |gz2|  .|f30| . | . |.  | . |ps1|ps2|.  | . |
     * |19|   |gs3|gs4|.  |   |.  |.  |   |.  |.  |gz1| . |  .| . | . | . |.  |ps3|ps4| . | . |
     * |20| . |  .|.  |.  |  .| . |   | . |gaf|.  |gef|  .|f31| . | . |.  | . |  .| . |.  |  .|
     * |21|   |   |.  |   |.  |   |.  |   |   |.  |   |  .|.  |   | . |  .| . | . | . | . |  .|
     * |22|.  |.  |   |.  |.  |.  |   |.  |   |.  |  .|  .|.  | . | ..|  .|  .|  .| . |  .| . |
     * |23| . | . |.  |.  |  .| . |   |  .|   |   |  .|  .|  .|  .|  .| . |  .|  .|  .|.  | . |
     * |24|.. |   | . |   |.  |   |   |   |   | . |.  |.  |.  |.  |.  |  .|.  | . | . |.  |.  |
     * |25| . | . |  .| . | . | . |  .|  .| . |.  |.  |.  |.  | . |.  |.  |.  |.  | . |.  |.  |
     * |26| . | . |  .| . | . | . | . |  .| . |  .|  .|  .| . |  .|  .|  .|  .|  .|  .| . |.  |
     * |27| . | . |  .| . |.  | . | . |  .| . | . |.  |.  | . |.  |.  |  .|  .|  .|  .| . |.  |
     * |28| . | . |  .| . | . | . | . |  .|   | . |   |  .| . |  .| . | . |  .|  .|  .| . |.  |
     * |29| . | . |.  |.. | . | . | . |.  |.  |.  | . |  .| . | . | . | . |.. |.  |.  |.  |.  |
     * |30| . | . |  .| . | . |.  | . |   | . | . | . |   | . |  .| . | . | . | . |  .| . |.  |
     * |31| . | . |.. | . |.  |.  |.  |.  |.  |.  |.  |  .|.  | . |.  |.  |.  |.  |.  |.  |.  |
     * |32| . | . | . | . |  .| . |.  |.  |.  | . | . |  .|.. |  .| . | . | . | . |   | . |  .|
     * Idee eines Spielbretts für 6 Spieler, entsprechend der GUI-Darstellung
     * 
     * @param logger
     * @param derOutput
     * @param dasspiel
     * @param oname 
     */
    
    /**
     * fügt ein neues Feld in die Felderliste ein
     *
     * @param dasFeld
     * @return integer index des neu hinzugefügten objektes
     */
    public int feldhinzufuegen(Feld dasFeld) {
        log.log(objektname, "Methode feldhinzufuegen() gestartet mit Parameter " + dasFeld + " .");

        felder.add(dasFeld);
        log.log(objektname, "Methodenrückgabe: " + felder.lastIndexOf(dasFeld));
        log.log(objektname, "Methode feldhinzufuegen() beendet.");
        return felder.lastIndexOf(dasFeld);
    }
      
     /**
     * fügt ein neues Feld in die Spüielkreisliste ein
     *
     * @param dasFeld
     * @return integer index des neu hinzugefügten objektes
     */
    public void kreisfeldhinzufuegen(Feld dasFeld) {
        log.log(objektname, "Methode kreisfeldhinzufuegen() gestartet mit Parameter " + dasFeld + " .");
        this.spielkreis.add(dasFeld);
        log.log(objektname, "Methode kreisfeldhinzufuegen() beendet.");
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
     * Getter-Methode fuer Felder
     * @return felder
     */
    public List<Feld> getFelder(){
    return felder;
    }
    /**
     * getter-Methode fuer Output
     * @return Output
     */
    public SpielbrettAusgabe getOutput(){
    return Output;
    }

    public Feld[] getAfelder() {
        return afelder;
    }

    public Feld[] getEfelder() {
        return efelder;
    }

    public Feld[] getZfelder() {
        return zfelder;
    }

    public Feld getEndkreisfeld() {
        return endkreisfeld;
    }
    
    
     /**
      * getter-Methode fuer Objektname, kann auch die jeweilige Farbe sein
     * @return the farbe
     */
    public String getobjektname() {
        log.log(objektname, "Methode getobjektname() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + objektname);
        log.log(objektname, "Methode getobjektname() beendet.");
        return objektname;
    }


    
}
