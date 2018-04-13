/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 * Klasse Wuerfel speichert eine Augenzahl zwischen, welche durchs wuerfeln
 * pseudo-zufÃ¤llig geÃ¤ndert werden kann. Beim erzeugen wir die hÃ¶chste 
 * und niedrigste Augenzahl festgelegt
 * @author leon
 */
public class Wuerfel {
    /**
     * ist die aktuelle Augenzahl des Wuerfels
     */
    private int dieZahl;
    /**
     * ist die niedrigste Augenzahl
     */ 
    private int min;
    /**
     * ist die hÃ¶chstmÃ¶gliche Augenzahl
     */
    private int max;
    /**
     * kostruktor:erzeugt ein Objekt der klasse wuerfel
     * @param wuerfelmin:integer die niedrigste Augenzahl
     * @param wuerfelmax:integer ist die hÃ¶chstmÃ¶gliche Augenzahl
     */
    public Wuerfel(int wuerfelmin, int wuerfelmax) {
        min = wuerfelmin;
        max = wuerfelmax;
    }
    /**
     * gibt die aktuelle Augenzahl des wÃ¼rfels zurÃ¼ck
     * @return integer 
     */
    public int gibZahl(){
    return dieZahl;
    }
    /**
     * erzeugt eine pseudo-randomzahl im bereich von min - max
     * und setzt die aktuelle Augenzah: dieZahl auf diese
     * @return dieNeueZahl:integer
     */
    public int wuerfeln(){
    Random rand = null;
    int augen = rand.nextInt((max - min) + 1) + min;
    dieZahl = augen;
    return augen;
    }
}  
