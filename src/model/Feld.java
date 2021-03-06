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
     * gibt an ob sich Feld im Feld befindet
     */
    private boolean imSpielkreis;
    /**
     * gibt an, ob Feld A-Feld ist boolean: true oder false
     * Anfangsfeld einer bestimmten Farbe
     */
    private boolean aFeld;
     /**
     * gibt an, ob Feld A-Feld ist boolean: true oder false
     * Anfangsfeld einer bestimmten Farbe
     */
    private boolean zeFeld;
     /**
     * gibt an, ob Feld E-Feld ist boolean: true oder false
     * Endfeld einer bestimmten Farbe, Eingang zu den Zielfeldern
     * Durch das E-Feld wird signalisiert, dass die Figur einer Farbe in ihren Zielbereich eintreten muss
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
    private int positionX ;
    /**
     * gibt Y-Position des Feldes auf dem Spielbrett an integer
     */
    private int positionY ;
    /**
     * gibt ID des Feldes auf dem Spielbrett an integer
     */
    private int id;
    /**
     * gibt an, ob Feld besetzt ist boolean: true oder false
     */
    private boolean istBesetzt;
    /**
     * gibt an, wer das Feld besetzt
     */
    private Spielfigur hausbesetzer;
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
     * @param feldart:string, lÃ¤sst verschieden Schreibweisen des
     * Standardfeld(standard; Standartfeld; standardfeld), Startfeld(start,
     * startfeld, Startfeld), Zielfeld(ziel, zielfeld, Zielfeld), aFeld(a,
     * afeld, Afeld, A-Feld, Anfangsfeld, anfangsfeld) zu.
     * @param xposition:int die X-koordinate des feldes auf dem Spielbrett
     * @param yposition:int die Y-koordinate des feldes auf dem Spielbrett
     * @param teamfarbe:string die farbe des Feldes
     */
    public Feld(Logger logger, String oname, Spielbrett dasspielbrett, String feldart, int xposition, int yposition, String teamfarbe) {
        log = logger;
        objektname = oname;
        this.istBesetzt = false;
        this.positionX = xposition;
        this.positionY = yposition;
        this.farbe = teamfarbe;
        this.hausbesetzer = null;
        
        this.id = dasspielbrett.feldhinzufuegen(this);

        this.Standardfeld = false;
        this.Startfeld = false;
        this.Zielfeld = false;
        this.aFeld = false;
        switch (feldart.toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "start":
            case "startfeld":
                this.Startfeld = true;
                break;
            case "a":
            case "afeld":
            case "a-feld":
            case "anfangsfeld":
                this.aFeld = true;
                this.imSpielkreis = true;
                dasspielbrett.kreisfeldhinzufuegen(this);
                break;
            case "ziel":
            case "zielfeld":
                this.Zielfeld = true;
                break;
            case "standard":
            case "Standardfeld":
             case "standardfeld":
                this.Standardfeld = true;
                this.imSpielkreis = true;
                dasspielbrett.kreisfeldhinzufuegen(this);
                break;
            case "efeld":
            case "zefeld":
            case "zieleintrittsfeld":
                this.eFeld = true;
                this.imSpielkreis = true;
                dasspielbrett.kreisfeldhinzufuegen(this);
                break;
            default:
                break;
        }
        //log.log("Feld " + id, "ist ein " + farbe + "es " + feldart);
        dasspielbrett.getOutput().feldeinfuegen(this);
    }


    /**
     * getter-methode von id
     * gibt die ID des Feldes zurueck
     *
     * @return id
     */
    public int getID() {
        log.log(objektname,"Methode getID() gestartet.");
        log.log(objektname,"Methodenrückgabe: "+id);
        log.log(objektname,"Methode getID() beendet.");
        return id;
    }

    /**
     * getter-methode von positionX
     *
     * @return positionX
     */
    public int getPositionX() {
        log.log(objektname,"Methode getPositionX() gestartet.");
        log.log(objektname,"Methodenrückgabe: "+positionX);
        log.log(objektname,"Methode getPositionX() beendet.");
        return positionX;
    }
    /**
     * getter-methode von imSpielkreis
     *
     * @return positionX
     */
    public boolean getImSpielkreis() {
        log.log(objektname,"Methode getPositionX() gestartet.");
        log.log(objektname,"Methodenrückgabe: "+this.imSpielkreis);
        log.log(objektname,"Methode getPositionX() beendet.");
        return this.imSpielkreis;
    }

    /**
     * getter-methode von positionY
     *
     * @return positionY
     */
    public int getPositionY() {
        log.log(objektname,"Methode getPositionY() gestartet.");
        log.log(objektname,"Methodenrückgabe: "+positionY);
        log.log(objektname,"Methode getPositionY() beendet.");
        return positionY;
    }
    /**
     * setter methode fuer IstBesetzt
     * @param neu:boolean
     * @return ist unnötig
     */
    public int setIstBesetzt(boolean neu) {
    this.istBesetzt = neu; 
    return 0;
    }
    /**
     * Getter methode fuer IstBesetzt
     * @return istBestzt
     */
    public boolean getIstBesetzt() {
     return this.istBesetzt; 
    }
    /**
     * getter methode fuer feldtyp
     * @return feldtyp: string
     */
    public String getFeldtyp() {
    if (this.Startfeld){
    return "Startfeld";} 
    if (this.eFeld){
    return "zeFeld";} 
    if (this.aFeld){
    return "aFeld";} 
    if (this.Zielfeld){
    return "Zielfeld";} 
    if (this.Standardfeld){
    return "Standardfeld";} 
    return "Fehler";
    }
    /**
     * Getter methode fuer hausbesetzter
     * @return istBestzt
     */
    public Spielfigur getHausbesetzer() {
     return this.hausbesetzer; 
    }
    /**
     * 
     * @return aFeld
     */
    public boolean getaFeld(){
    return this.aFeld;
   
    }
    public boolean getZielfeld(){
    return this.Zielfeld;
   
    }
    /**
     * 
     * @return farbe 
     */
    public String getFarbe(){
    return this.farbe;
    }
    
    /**
     * Setter-Methode fuer Hausbesetzer
     * @param derSchnorrer 
     */
    public void setHausbesetzer(Spielfigur derSchnorrer){
    this.hausbesetzer = derSchnorrer;
    }
    
    
    
     /**
      * getter-Methode fuer Objektname 
     * @return the farbe
     */
    public String getobjektname() {
        log.log(objektname, "Methode getobjektname() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + objektname);
        log.log(objektname, "Methode getobjektname() beendet.");
        return objektname;
    }
    

}
