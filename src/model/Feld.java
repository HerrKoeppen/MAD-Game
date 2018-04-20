/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Klasse Feld beschreibt ein Feld auf dem Spielbrett. kann verschieden Typen
 * haben: A-, Start- ,Standard- und Zielfeld
 *
 * @author hannah
 */
public class Feld {

    /**
     * gibt an, ob Feld Startfeld ist boolean: true oder false
     * Startfeld einer bestimmten Farbe
     */
    private boolean Startfeld;
    /**
     * gibt an, ob Feld Zielfeld ist boolean: true oder false
     * Zielfeld einer bestimmten Farbe
     */
    private boolean Zielfeld;
    /**
     * gibt an, ob Feld A-Feld ist boolean: true oder false
     * Anfangsfeld einer bestimmten Farbe
     */
    private boolean aFeld;
     /**
     * gibt an, ob Feld E-Feld ist boolean: true oder false
     * Endfeld einer bestimmten Farbe, Eingang zu den Zielfeldern
     */
    private boolean eFeld;
    /**
     * gibt an, ob Feld Startfeld ist boolean: true oder false
     * auf dem Standardfeld kann jede Figur stehen, egal welche Farbe sie hat
     * Standardfelder sind weiss
     */
    private boolean Standardfeld;
    /**
     * gibt X-Position des Feldes auf dem Spielbrett an integer
     */
    private int positionX;
    /**
     * gibt Y-Position des Feldes auf dem Spielbrett an integer
     */
    private int positionY;
    /**
     * gibt ID des Feldes auf dem Spielbrett an integer
     */
    private int id;
    /**
     * gibt an, ob Feld besetzt ist boolean: true oder false
     */
    private boolean istBesetzt;
    /**
     * gibt Farbe des jeweiligen Feldes an String Start-, A-Feld und Zielfeld:
     * sieben Farben Standardfeld: weiss
     */
    private String farbe;
    
    private Logger log;
    private String objektname;

    /**
     * Konstruktor:erzeugt ein Objekt der klasse Feld
     *
     * @param dasspielbrett know your origin
     * @param index:int sollte sich mit indexnummer von der Spielbrett array
     * decken
     * @param feldart:string, lÃ¤sst verschieden Schreibweisen des
     * Standardfeld(standard; Standartfeld; standardfeld), Startfeld(start,
     * startfeld, Startfeld), Zielfeld(ziel, zielfeld, Zielfeld), aFeld(a,
     * afeld, Afeld, A-Feld, Anfangsfeld, anfangsfeld) zu.
     * @param xposition:int die X-koordinate des feldes auf dem Spielbrett
     * @param yposition:int die Y-koordinate des feldes auf dem Spielbrett
     * @param teamfarbe:string die farbe des Feldes
     */
    public Feld(Spielbrett dasspielbrett, String feldart, int xposition, int yposition, String teamfarbe) {

        this.istBesetzt = false;
        this.positionX = xposition;
        this.positionY = yposition;
        this.farbe = teamfarbe;

        this.id = dasspielbrett.feldhinzufuegen(this);

        this.Standardfeld = false;
        this.Startfeld = false;
        this.Zielfeld = false;
        this.aFeld = false;

        switch (feldart.toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "start":
            case "startfeld":
            case "Startfeld":
                this.Startfeld = true;
                break;
            case "a":
            case "afeld":
            case "Afeld":
            case "A-Feld":
            case "Anfangsfeld":
            case "anfangsfeld":
                this.aFeld = true;
                break;
            case "ziel":
            case "Zielfeld":
            case "zielfeld":
                this.Zielfeld = true;
                break;
            case "standart":
            case "standartfeld":
            case "Standartfeld":
                this.Standardfeld = true;
                break;
            default:
                break;
        }
        //log.log("Feld " + id, "ist ein " + farbe + "es " + feldart);
    }

    public Feld(String oname, Logger logger, Spielbrett dasspielbrett, String feldart, int xposition, int yposition, String teamfarbe) {
        this(dasspielbrett, feldart, xposition, yposition, teamfarbe);
        log = logger;
        objektname = oname;
    }

    /**
     * getter-methode von id
     *
     * @return id
     */
    public int gibID() {
        log.log(objektname,"Methode gibID() gestartet.");
        log.log(objektname,"Methodenrückgabe: "+id);
        log.log(objektname,"Methode gibID() beendet.");
        return id;
    }

    /**
     * getter-methode von positionX
     *
     * @return positionX
     */
    public int gibPositionX() {
        log.log(objektname,"Methode gibPositionX() gestartet.");
        log.log(objektname,"Methodenrückgabe: "+positionX);
        log.log(objektname,"Methode gibPositionX() beendet.");
        return positionX;
    }

    /**
     * getter-methode von positionY
     *
     * @return positionY
     */
    public int gibPositionY() {
        log.log(objektname,"Methode gibPositionY() gestartet.");
        log.log(objektname,"Methodenrückgabe: "+positionY);
        log.log(objektname,"Methode gibPositionY() beendet.");
        return positionY;
    }
    /**
     * setter methode fuer IStBEsetzt
     * @param neu:boolean
     * @return ist unnötig
     */
    public int setzIstBesetzt(boolean neu) {
    this.istBesetzt = neu; 
    return 0;
    }
    /**
     * 
     * @return feldtyp: string
     */
    public String gibFeldtyp() {
    if (this.Startfeld){
    return "Startfeld";} 
    if (this.aFeld){
    return "aFeld";} 
    if (this.Zielfeld){
    return "Zielfeld";} 
    if (this.Standardfeld){
    return "Standardfeld";} 
    return "Fehler";
    }
    

}
