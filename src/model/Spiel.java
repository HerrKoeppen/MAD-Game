/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;

/**
 * Die Klasse Spiel verwaltet die Variablen die fuer den generellen Spielablauf
 * wichtig sind:
 *
 *
 *
 * @author Louie Noel Siaa Krueger
 */
public class Spiel {

    public Spielbrett dasSpielbrett;
    //Der Integer Runde gibt an in welcher Runde man sich befindet.
    public int Runde;
    //Der Integer BotAnzahl gibt an wie viele Bots bei den Spiel mitspielen sollen.
    public int BotAnzahl;

    public int SpielerAnzahl;
    public int GesamtSpielerAnzahl;
    //Der Boolean beendet gibt an ob das Spiel beendet ist.true=beendet
    public boolean beendet;
    //Die ArrayListe AlleSpieler beinhaltet alle Spieler im Spiel
    public Spieler[] AlleSpieler = new Spieler[7];
    //Die Arrayliste AlleSpielfiguren beeinhaltet alle Spielfiguren im Spiel.
    public Spielfigur[] AlleSpielfiguren = new Spielfigur[21];
    //Das Objekt aktiverSpieler der Klasse Spieler gibt an welcher Spieler momentan am Zug ist.   
    public Spieler aktiverSpieler;
    private String objektname;
    private Logger log;
    private Wuerfel derWuerfel;
    public SpielbrettAusgabe output;
    /**
     * array mit allen moeglichen farben, die reinfolge ist folgende: Blau, Rot,
     * GrÃ¼n, Pink, Gelb, Schwarz, Tuerkis und wird bei allen möglichen funktionen
     * so übernommen die farbe eines spielers ist spielbrett[spieler.id];
     */
    public final String[] Farben = {"blau", "rot", "gruen", "pink", "gelb", "schwarz", "tuerkis"};

    

    public Spiel(Logger logger, String oname,int diebotanzahl) {
        this.objektname = oname;
        log = logger;
        log.log(objektname, "Konstrucktor Spiel() gestartet mit Parameter " +" .");
        this.BotAnzahl= diebotanzahl;
        this.output = new SpielbrettAusgabe(this, log, "ANSI");
        //setBotAnzahl(BotAnzahl);
        SpielStarten();
        //spielen();
        log.log(objektname, "Konstrucktor Spiel() beendet.");
    }

    /**
     * Setzt Integer Botanzahl auf den Ã¼bergebenen Wert BotAnzahl.
     *
     * @param Botanzahl
     
    public void setBotAnzahl(int Botanzahl) {
        log.log(objektname, "Methode setBotAnzahl() gestartet mit Parameter " + Botanzahl + " .");

        this.BotAnzahl = Botanzahl;

        log.log(objektname, "Methode setBotAnzahl() beendet.");
    }
    */
    /**
     * Setzt Integer Spieleranzahl auf den Ã¼bergebenen Wert SpielerAnzahl.
     *
     * @param Spieleranzahl
     */
    public void setSpielerAnzahl(int Spieleranzahl) {
        log.log(objektname, "Methode setSpieleranzahl() gestartet mit Parameter " + Spieleranzahl + " .");
        this.SpielerAnzahl = Spieleranzahl;
        log.log(objektname, "Methode setSpieleranzahl() beendet.");
    }

    /**
     * Setzt Integer Gesamtspieleranzahl auf den Ã¼bergebenen Wert
     * Gesamtspieleranzahl.
     *
     * @param Gesamtspieleranzahl
     */
    public void setGesamtSpielerAnzahl(int Gesamtspieleranzahl) {
        log.log(objektname, "Methode setGesamtspieleranzahl() gestartet mit Parameter " + Gesamtspieleranzahl + " .");
        this.GesamtSpielerAnzahl = Gesamtspieleranzahl;
        log.log(objektname, "Methode setGesamtspieleranzahl() beendet.");
    }

    /**
     *
     * Initilisiert alle notwendigen Grund-Werte fuer das Spiel. SpielStarten:
     * 1.Das Spiel startet und erstellt: -Spielbrett -7 Spieler(Je nach Wert bei
     * BotAnzahl werden Bots erstellt) -Fuegt diese in die ArrayListe
     * AlleSpieler -28 Spielfiguren -Fuegt diese in die ArrayListe
     * AlleSpielfiguren 2.Die Spielfiguren werden wie folgt mit Farben belegt
     * und den Spielern zugeordnet: 1-4 Blau (Spieler 1) 5-8 Rot (SP 2) 9-12
     * GrÃ¼n (SP 3) 13-16 Pink (SP 4) 17-20 Gelb (SP 5) 21-24 Schwarz(SP 7)
     * 25-28 Tuerkis(SP 8)
     */
    public void SpielStarten() {
        //Spielbrett erzeugen
        log.log(objektname, "Methode SpielStarten() gestartet.");
        dasSpielbrett = new Spielbrett(log,output,this,"Spielbrett");
        log.log(objektname, "Methode hat das Spielbrett erzeugt");
        log.log(objektname, "Methode SpielStarten() beendet.");
    }

    /**
     * NeuesSpiel: Setz ALLE Variablen des Objekts zurueck.
     */
    public void NeuesSpiel() {
        log.log(objektname, "Methode NeuesSpiel() gestartet.");
        dasSpielbrett = null;
        Runde = 0;
        BotAnzahl = 0;
        SpielerAnzahl = 0;
        GesamtSpielerAnzahl = 0;
        beendet = false;
        aktiverSpieler = null;
        objektname = null;
        log = null;
        derWuerfel = null;
        this.output = null;
        AlleSpielfiguren = null;
        AlleSpieler = null;

        log.log(objektname, "Methode NeuesSpiel() beendet.");

    }

    /**
     * Die Funktion spielen sorgt fuer das eigentliche Spiel. Alle Spieler
     * würfeln erst.Der mit der höchsten Würfelzahl beginnt das Spiel. Dannach
     * wird der nächste Spieler in der ArrayListe ermittelt.Wenn die ArrayListe
     * am Ende angekommen ist,dann fängt sie wieder vorne an. BEMERKUNGEN:Die
     * Methode ermittelt nicht wer als erstes die 6 gewürfelt hat.
     *
     */
    public void spielen() {
        log.log(objektname, "Methode spielen() gestartet.");
        int i = 0;
        int[] Ergebnisse = new int[7];
        while (AlleSpieler[i] != null) {
            Ergebnisse[i] = AlleSpieler[i].wuerfeln();

        }
        int[] ErgebnisseKopie = Ergebnisse;
        Arrays.sort(Ergebnisse);
        i = 0;
        while (ErgebnisseKopie[0] != Ergebnisse[i]) {
            i++;

        }
        while (beendet != true) {
            if (AlleSpieler[i] != null) {
                AlleSpieler[i].ziehen(AlleSpieler[i].wuerfeln());
                i++;
            }

            i = 0;

        }

        //Startspieler ermitteln fehlt
        //aktives Spielen beginnt, Spielreihenfolge im Uhrzeigersinn
        log.log(objektname, "Methode spielen() beendet.");
    }
/*
    public static void main(String args[]) {
        Logger log = new Logger("testlog.txt");
        Spiel test = new Spiel(log,"test",0);
        log.logBeenden();
    }
    */
    public Wuerfel getWuerfel(){
    return derWuerfel;
    }
    
    public void setWuerfel(Wuerfel ww){
    this.derWuerfel = ww;
    }

    public Spielbrett getSpielbrett() {
        return dasSpielbrett;
    }
    
     public SpielbrettAusgabe getoutput() {
        return this.output;
    }
     public void spielfigurenVerteilen(){
          log.log(objektname, "Methode spielfigurenVerteilen() gestartet.");
         for(Spielfigur i :this.AlleSpielfiguren){
         if (i != null){
         i.Spielersetzen(this);}
     }
          log.log(objektname, "Methode spielfigurenVerteilen() beendet.");
     
     }
     
      public int setSpielfigur(Spielfigur dieSpielfigur) {
        log.log(objektname, "Methode setSpielfigur() gestartet mit Parameter " + dieSpielfigur + " .");
        int i = 0;
        while (AlleSpielfiguren[i] != null) {
            i++;
        }
        AlleSpielfiguren[i] = dieSpielfigur;
        log.log(objektname, "Methode setSpielfigur() beendet.");
        return i;

    }
       public int setSpieler(Spieler derSpieler) {
        log.log(objektname, "Methode setSpieler() gestartet mit Parameter " + derSpieler + " .");
        int i = 0;
        while (AlleSpieler[i] != null) {
            i++;
        }
        this.AlleSpieler[i] = derSpieler;
           log.log(objektname, "Methodenrückgabe: " + i);
        log.log(objektname, "Methode setSpieler() beendet.");
        return i;
    }



}
