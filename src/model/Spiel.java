/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.Arrays;
import controller.Control;
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
    public int zugNr;
    //Der Integer BotAnzahl gibt an wie viele Bots bei den Spiel mitspielen sollen.
    public int BotAnzahl;

    public int SpielerAnzahl;
    public int GesamtSpielerAnzahl;
    //Der Boolean beendet gibt an ob das Spiel beendet ist.true=beendet
    public boolean beendet;
    //Die ArrayListe AlleSpieler beinhaltet alle Spieler im Spiel
    //+ALTE VERSION+ public Spieler[] AlleSpieler = new Spieler[7];
    public Spieler[] AlleSpieler = new Spieler[6];
    //Die Arrayliste AlleSpielfiguren beeinhaltet alle Spielfiguren im Spiel.
    //ALTE VERSION+ public Spielfigur[] AlleSpielfiguren = new Spielfigur[21];
    public Spielfigur[] AlleSpielfiguren = new Spielfigur[24];
    //Das Objekt aktiverSpieler der Klasse Spieler gibt an welcher Spieler momentan am Zug ist.   
    public Spieler aktiverSpieler;
    public int aktiverSpielerIndex; 
    private String objektname;
    private Logger log;
    private Wuerfel derWuerfel;
    public SpielbrettAusgabe output;
    public Control c;
    /**
     * array mit allen moeglichen farben, die reinfolge ist folgende: Blau, Rot,
     * GrÃ¼n, Pink, Gelb, Schwarz, Tuerkis und wird bei allen möglichen
     * funktionen so übernommen die farbe eines spielers ist
     * spielbrett[spieler.id];
     */
    public final String[] Farben = {"blau", "rot", "gruen", "pink", "gelb", "schwarz", "tuerkis"};

    public Spiel(Logger logger, String oname, int diebotanzahl , Control co) {

        //setBotAnzahl(BotAnzahl);
        SpielStarten(logger, oname, diebotanzahl);
        this.c = co;
        //spielen();
        log.log(objektname, "Konstrucktor Spiel() beendet.");
    }

    /**
     * Setzt Integer Botanzahl auf den Ã¼bergebenen Wert BotAnzahl.
     *
     * @param Botanzahl
     *
     * public void setBotAnzahl(int Botanzahl) { log.log(objektname, "Methode
     * setBotAnzahl() gestartet mit Parameter " + Botanzahl + " .");
     *
     * this.BotAnzahl = Botanzahl;
     *
     * log.log(objektname, "Methode setBotAnzahl() beendet."); }
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
    public void SpielStarten(Logger logger, String oname, int diebotanzahl) {
        //Spielbrett erzeugen
        this.objektname = oname;
        log = logger;
        log.log(objektname, "Methode SpielStarten() gestartet.");

        this.BotAnzahl = diebotanzahl;
        this.output = new SpielbrettAusgabe(this, log, "ANSI");
        dasSpielbrett = new Spielbrett(log, output, this, "Spielbrett");
        int a;
        //+ALTE VERSION+ for (int i = 0; i < (7 - this.BotAnzahl); i++) {
        for (int i = 0; i < (6 - this.BotAnzahl); i++) {

            this.SpielerAnzahl = i;
        }
        switch (this.BotAnzahl) { // sehr netter Switch der den Typ des Feldes festlegt
            /*+ALTE VERSION+ case 7:
                Spieler Computer6 = new SpielerComputer("(Computer) Gargamel", log, this);
            */
            case 6:
                Spieler Computer5 = new SpielerComputer("(Computer) Fynnia", log, this);
            case 5:
                Spieler Computer4 = new SpielerComputer("(Computer) Eve", log, this);
            case 4:
                Spieler Computer3 = new SpielerComputer("(Computer) Dave", log, this);
            case 3:
                Spieler Computer2 = new SpielerComputer("(Computer) Charles der II", log, this);
            case 2:
                Spieler Computer1 = new SpielerComputer("(Computer) Barbarianna", log, this);
            case 1:
                Spieler Computer = new SpielerComputer("(Computer) Azrael", log, this);
            case 0:
            default:
                break;
        }
        this.SpielerAnzahl += this.BotAnzahl;
        
        this.aktiverSpielerIndex = 0;
    this.aktiverSpieler = AlleSpieler[aktiverSpielerIndex];
    zugNr = 0;
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
        this.Runde = 0;
        /*int i = 0;
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
         */
        //+ALTE VERSION+ for (int i = 7; !beendet; i++) {
        for (int i = 6; !beendet; i++) {
            int a = i % this.SpielerAnzahl;
            if (AlleSpieler[a] != null) {
                System.out.println(AlleSpieler[a].getobjektname() + " ist am Zug");
                if (AlleSpieler[a].ziehen() == 1) {
                    System.out.println(AlleSpieler[a].getobjektname() + " hat gewonnen");
                    beendet = true;
                    break;
                }
                System.out.println(AlleSpieler[a].getobjektname() + "'s Zug ist beendet");
                /* +ALTE VERSION+ if (i / 7 > ((i -1) / 7)) {
                    this.Runde = i / 7;
                    System.out.println("Runde " + this.Runde + ":");
                }
                */
                
                if (i / 6 > ((i -1) / 6)) {
                    this.Runde = i / 6;
                    System.out.println("Runde " + this.Runde + ":");
                }
            }

        }
        this.output.spielAusgabe();

        //Startspieler ermitteln fehlt
        //aktives Spielen beginnt, Spielreihenfolge im Uhrzeigersinn
        log.log(objektname, "Methode spielen() beendet.");
    }
    /**
     * Es wird genau ein Zug des jeweils aktiven Spielers gespielt.
     * Dadurch kann im view der Zustand nach einem Zug angezeigt werden.
     * @return Der Rückgabewert der Methode ziehen. Ist dieser 1, dann ist das Spiel beendet.
     */
    public int spieleEinenZug(){
       log.log(objektname, "Methode spieleEinenZug() gestartet.");
       
       System.out.println(aktiverSpieler.getobjektname() + " ist am Zug. Zug Nummer:"+zugNr);
       int schalter = aktiverSpieler.ziehen();
       if(schalter==1){
           System.out.println(aktiverSpieler.getobjektname() + " hat gewonnen");
       }
       else{
           System.out.println(aktiverSpieler.getobjektname() + "'s Zug ist beendet");
           aktiverSpielerIndex = aktiverSpielerIndex+1;
           if (aktiverSpielerIndex==AlleSpieler.length){
               aktiverSpielerIndex=0;
           }
           aktiverSpieler = AlleSpieler[aktiverSpielerIndex];
           if (zugNr%AlleSpieler.length==0){
               Runde=Runde+1;
               System.out.println("Neue Runde: "+Runde);
           }
           zugNr = zugNr+1;
           
                          
 
       }
       log.log(objektname, "Methode spieleEinenZug() beendet.");
       return schalter;
       
    }

    /*
    public static void main(String args[]) {
        Logger log = new Logger("testlog.txt");
        Spiel test = new Spiel(log,"test",0);
        log.logBeenden();
    }
     */
    /**
     * getter-Methode fuer Wuerfel
     *
     * @return derWuerfel
     */
    public Wuerfel getWuerfel() {
        return derWuerfel;
    }

    /**
     * Setter-Meyhode fuer Wuerfel
     *
     * @param ww
     */
    public void setWuerfel(Wuerfel ww) {
        this.derWuerfel = ww;
    }

    /**
     * Getter-Methode fuer Spielbrett
     *
     * @return dasSpielbrett
     */
    public Spielbrett getSpielbrett() {
        return dasSpielbrett;
    }

    /**
     * Getter-Methode fuer Output
     *
     * @return output
     */
    public SpielbrettAusgabe getoutput() {
        return this.output;
    }

    /**
     * eine Methode, die alle Spielfiguren der jewiligen Farben auf dem
     * Spielbrett verteilt und auf ihre anfaenglichen Positionen setzt
     */
    public void spielfigurenVerteilen() {
        log.log(objektname, "Methode spielfigurenVerteilen() gestartet.");
        for (Spielfigur i : this.AlleSpielfiguren) {
            if (i != null) {
                i.Spielersetzen(this);
            }
        }
        log.log(objektname, "Methode spielfigurenVerteilen() beendet.");

    }

    /**
     * setzt alle Spielfiguren einer Farbe
     *
     * @param dieSpielfigur
     * @return i
     */
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

    /**
     * setzt alle mitspielenden Spieler
     *
     * @param derSpieler
     * @return i
     */
    public int setfarbSpieler(Spieler derSpieler) {
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

    /**
     * setzt alle mitspielenden Spieler
     *
     * @param derSpieler
     * @return i
     */
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
