/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 * Klasse Wuerfel speichert eine Augenzahl zwischen, welche durchs wuerfeln
 * pseudo-zufÃ¤llig geÃ¤ndert werden kann. Beim erzeugen wir die hÃ¶chste und
 * niedrigste Augenzahl festgelegt
 *
 * @author leon
 */
public class Wuerfel {
    /**
     * name des objekts fuer den log
     */
    private String objektname;
    private Logger log;
    /**
     * ist die aktuelle Augenzahl des Wuerfels
     */
    private int dieZahl;
    /**
     * ist die niedrigste Augenzahl
     */
    private int min;
    /**
     * ist die hoechstmoegliche Augenzahl
     */
    private int max;
    private SpielbrettAusgabe output;

    /**
     * kostruktor:erzeugt ein Objekt der klasse wuerfel
     *
     * @param wuerfelmin:integer die niedrigste Augenzahl
     * @param wuerfelmax:integer ist die hÃ¶chstmÃ¶gliche Augenzahl
     */
    public Wuerfel(int wuerfelmin, int wuerfelmax, SpielbrettAusgabe out) {
        this.output = out;
        min = wuerfelmin;
        max = wuerfelmax;
    }
    /**
     * kostruktor:erzeugt ein Objekt der klasse wuerfel. Gibt dem Objhekt außerdem einen frei wählbaren Namen.
     * @param logger Loggerobjekt zu Diagnosezwecken
     * @param name Name des Objekts
     * @param wuerfelmin die niedrigste Augenzahl
     * @param wuerfelmax ist die hoechstmoegliche Augenzahl
     */
    public Wuerfel(Logger logger, String name, int wuerfelmin, int wuerfelmax, SpielbrettAusgabe out) {
        this.output = out;
        objektname = name;
        log = logger;
        min = wuerfelmin;
        max = wuerfelmax;
    }

    /**
     * gibt die aktuelle Augenzahl des wÃ¼rfels zurÃ¼ck
     *
     * @return integer
     */
    public int getZahl() {
        log.log(objektname,"Methode Zahl() gestartet.");
        log.log(objektname,"Methodenrückgabe: "+dieZahl);
        log.log(objektname,"Methode getZahl() beendet.");
        return dieZahl;
    }

    /**
     * erzeugt eine pseudo-randomzahl im bereich von min - max und setzt die
     * aktuelle Augenzah: dieZahl auf diese
     *
     * @return dieNeueZahl:integer
     */
    public int wuerfeln() {
        log.log(objektname, "Start der Methode wuerfeln().");
        int augen = 0;
        Random rand = new Random();
        augen = rand.nextInt((max - min) + 1) + min;
        this.dieZahl = augen;
        //System.out.println(augen);
        this.output.wuerfelausgeben(augen);
        log.log(objektname, "Augenzahl " + augen + " gewuerfelt.");
        log.log(objektname, "Methode wuerfeln() beendet.");

        return augen;
    }
    /**
     * setzt log auf logger
     * macht ein wuerfelobjekt mit einem logger bekannt
     * @param logger 
     */
    public void loggerSetzen(Logger logger) {
        log = logger;
    }
    
    
     /**
     * @return the farbe
     */
    public String getobjektname() {
        log.log(objektname, "Methode getobjektname() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + objektname);
        log.log(objektname, "Methode getobjektname() beendet.");
        return objektname;
    }

    
}
