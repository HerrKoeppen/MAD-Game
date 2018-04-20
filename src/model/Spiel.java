/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    public Spielfigur[] AlleSpielfiguren = new Spielfigur[28];
    //Das Objekt aktiverSpieler der Klasse Spieler gibt an welcher Spieler momentan am Zug ist.   
    public Spieler aktiverSpieler;
    private String objektname;
    private Logger log;
    private Wuerfel derWuerfel;
    private String[][] AsciiSpielbrett;

    /**
     * Konstrucktor der klasse Spiel
     */
    public Spiel() {
        //log.log("Spiel ", "baut neues Spiel auf");
        SetzeBotAnzahl(BotAnzahl);
        SpielStarten();
        spielen();
        //dasSpielbrett = new Spielbrett();
        //log.log("Spiel ", "Aye, Spiel ist bereit.");
    }

    public Spiel(Logger logger, String objektname) {
        this.objektname = objektname;
        log = logger;
        SetzeBotAnzahl(BotAnzahl);
        SpielStarten();
        spielen();
    }

    /**
     * Setzt Integer Botanzahl auf den Ã¼bergebenen Wert BotAnzahl.
     *
     * @param Botanzahl
     */
    public void SetzeBotAnzahl(int Botanzahl) {
        log.log(objektname, "Methode SetzeBotAnzahl() gestartet mit Parameter " + Botanzahl + " .");

        log.log(objektname, "Methode SetzeBotAnzahl() beendet.");
    }

    /**
     * Setzt Integer Spieleranzahl auf den Ã¼bergebenen Wert SpielerAnzahl.
     *
     * @param Spieleranzahl
     */
    public void SetzeSpielerAnzahl(int Spieleranzahl) {
        log.log(objektname, "Methode SetzeSpieleranzahl() gestartet mit Parameter " + Spieleranzahl + " .");

        log.log(objektname, "Methode SetzeSpieleranzahl() beendet.");
    }

    /**
     * Setzt Integer Gesamtspieleranzahl auf den Ã¼bergebenen Wert
     * Gesamtspieleranzahl.
     *
     * @param Gesamtspieleranzahl
     */
    public void SetzeGesamtSpielerAnzahl(int Gesamtspieleranzahl) {
        log.log(objektname, "Methode SetzeGesamtspieleranzahl() gestartet mit Parameter " + Gesamtspieleranzahl + " .");

        log.log(objektname, "Methode SetzeGesamtspieleranzahl() beendet.");
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
     * 25-28 Braun(SP 8)
     */
    public void SpielStarten() {
        //Spielbrett erzeugen
        log.log(objektname, "Methode SpielStarten() gestartet.");
        dasSpielbrett = new Spielbrett(log);
        log.log(objektname, "Methode hat das Spielbrett erzeugt");
        log.log(objektname, "Methode SpielStarten() beendet.");
    }

    /**
     * NeuesSpiel: Setz ALLE Variablen des Objekts zurueck.
     */
    public void NeuesSpiel() {
        log.log(objektname, "Methode NeuesSpiel() gestartet.");

        log.log(objektname, "Methode NeuesSpiel() beendet.");

    }

    /**
     * Die Funktion spielen sorgt fuer das eigentliche Spiel. Ein neuer Integer
     * "i" wird eingefuehrt. 1.i wird auf 0 gesetzt. 2.Die Funktion setzt die
     * Variable aktiverSpieler auf das Objekt der Liste AllerSpieler mit den
     * Index-Wert von der Variable i. 3.Solange die Variable beendet=false
     * ist,wird Schritt 3 wiederhohlt.(Schleife) Das Objekt das mit der Variable
     * aktiverSpieler referenziert ist darf einen Zug machen. i wird um eins
     * erhoeht.
     *
     */
    public void spielen() {
        log.log(objektname, "Methode spielen() gestartet.");

        //Startspieler ermitteln fehlt
        //aktives Spielen beginnt, Spielreihenfolge im Uhrzeigersinn
        log.log(objektname, "Methode spielen() beendet.");
    }

    public static void main(String args[]) {
        Logger log = new Logger("testlog.txt");
        Spiel test = new Spiel();
        log.logBeenden();
    }
    
    public Wuerfel gibWuerfel(){
    return derWuerfel;
    }
    
    public Spielbrett gibSpielbrett(){
    return dasSpielbrett;
    }
    
    /**| a| b| c| d| e| f| g| h| i| j| k| l| m| n| o| p| q| r| s| t| u| v| 
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
     **/
    public void AsciiSpielbrettErzeugen(){
   // String[][] AsciiSpielbrett = {{"|  ","|  ","|  ","|  ","|  ","|  ","|  ","|  ","|  ","|""  |AB|  |  |  |  |  |  |  |  |  |"},{""},{""},{""},{""},{""},{""},{""}};
    
    
    }
    public void spielAudgabe(){
    
    
    
    }
}
