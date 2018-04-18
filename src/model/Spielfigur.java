/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Klasse Spielfigur erzeugt einezelne Spielfiguren
 * und verwaltet deren verhalten, wie bewegen, schlagen etc. 
 * Funktionen arbeiten mit returnwerten als fehlermeldung: 0 ist immer super
 * fÃ¼r unterschiedliche probleme kÃ¶nnen andere integers festgelegt werden
 * @author johanna
 */
public class Spielfigur {
    /**
     * id der spielfigur macht sie einzigartig
     */
    private int id;
    /**
     * beschreibt die X-Koordinate auf dem Spielbrett 
     */
    private int positionX;
    /**
     * beschreibt die Y-Koordinate auf dem Spielbrett
     */
    private int positionY;
    /**
     * Ausgangsposition einer Spielfigur, jedes braucht eine eigene
     */
    private Feld startfeld;
    /**
     * das aktuelle Feld auf dem die Figur steht
     */
    private Feld aktfeld;
    /**
     * die feldnummer auf dem die Figur steht
     */
    private int feldnummer;
    /**
     * boolean welche angibt, ob die Figur im Ziel ist
     */
    private boolean aufzielfeld;
    /**
     * boolean welche angibt, ob die Figur im Start steht
     */
    private boolean aufstartfeld;
    /**
     * boolean welche angibt, ob die Figur ihrem anfangsfeld steht
     */
    private boolean aufafeld;
    /**
     * boolean welche angibt, ob die Figur momentan im spielfeld ist
     */   
    private boolean aufspielfeld;
     /**
     * boolean welche angibt, ob die Figur momentan auf einem Standard ist
     */   
    private boolean aufStandardfeld;
    /**
     * gibt an zu welchen spieler die Figur gehÃ¶rt
     */
    private Spieler team; 
    /**
     * eine String fÃ¼r die Farbe der Spielfigur
     */
    private String farbe;
    
    /**
     * Konstruktor fÃ¼r die klasse Spielfigur
     * erzeugt eine neue Spielfigur
     * @param id der Spielfigur 
     * @param starterfeld die grundposition der spielfigur auf der sie erzeugt wird
     * @param spieler die SpielerzugehÃ¶rigkeit 
     */
    public Spielfigur(int id, Feld starterfeld, Spieler derSpieler){
        this.startfeld = starterfeld;
        this.positionX = this.startfeld.gibPositionX();
        this.positionY = this.startfeld.gibPositionY();
        this.aktfeld = this.startfeld;
        this.feldnummer = this.startfeld.gibID();
        this.aufafeld = false;
        this.aufspielfeld = false;
        this.aufstartfeld = true;
        this.aufzielfeld = false;
        this.team = derSpieler;
        //this.farbe = this.team.gibfarbe();
    }
    
    /**
     * setzt Figur auf sein Afeld 
     * @return 1 bei fehler sonst 0 
     */
    public int herauskommen()
    {
       /*if (this.setzten(this.team.gibafeld())== 0)
        {
             return 0;
        }
     else   
        {
            return 1;  
        }*/
        return 5;
    }
    /**
     * bewegt eine Figur um ein Feld
     * @return 1 bei fehler sonst 0 
     */
    public int bewegen()
    {   
        return 1;
    }
    /**
     * setzt Figur auf ein Feld: Zielfeld
     * Methode ist fuer sprunge geeignet (zb. rauskommen, geschlagenwerden
     * nicht aber fuer das reguläre laufen empfohlen)
     * Achtung zielfeld steht nicht fuer Zielfeld sondern 
     * fuer das neue Feld der Figur
     * @param zielfeld
     * @return 1 bei fehler sonst 0 
     */
    public int setzen(Feld zielfeld)
    {
        this.aktfeld.setzIstBesetzt(false);
        this.aktfeld = zielfeld;
        this.positionX = this.aktfeld.gibPositionX();
        this.positionY = this.aktfeld.gibPositionY();
        this.feldnummer = this.aktfeld.gibID();
        this.aufspielfeld = false;
        this.aufstartfeld = false;
        this.aufzielfeld = false;
        switch (this.aktfeld.gibFeldtyp().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "Startfeld":
                this.aufstartfeld = true;
                break;
            case "aFeld":
                this.aufspielfeld = true;
                this.aufafeld = true;
                break;
            case "Zielfeld":
                this.aufspielfeld = true;
                this.aufzielfeld = true;
                break;
            case "Standartfeld":
                this.aufspielfeld = true;
                this.aufStandardfeld = true;
                break;
            default:
                break;
        }
        this.aktfeld.setzIstBesetzt(true);
        return 0;
    }
    /**
     * schickt eine andere Figur zurÃ¼ck auf ihre startposition
     * @return 1 bei fehler sonst 0 
     */
    public int schlagen(int index)
    {   
        return 1;
    }
    
    /**
     * setzt figur zurÃ¼ck auf startposition
     * @return 1 bei fehler sonst 0 
     */
    public int zurueckgehen()
    {
     if (this.setzen(this.startfeld)== 0)
        {
             return 0;
        }
     else   
        {
            return 1;  
        }
    }
    /**
     * beurteilt, ob sich eine SPielfigur um eine bestimmte Anzahl von Felder fortbewegen kann
     * @param felderAnzahl Anzahl der Felder, die vortgerueckt werden soll
     * @return true, wenn der Zug möglich ist, sonst false
     */
    public boolean kannSichBewegen(int felderAnzahl){
        return false;
    }
    /**
     * gibt zurück od sich figur auf einem spielfeld befindet
     * getter methode für aufzielfeld
     * @return aufzielfeld:boolean 
     */
    public boolean gibAufZielfeld(){
        return this.aufzielfeld;
    }
    
}
