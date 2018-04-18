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
     * gibt an zu welchen spieler die Figur gehÃ¶rt
     */
    private Spieler team; 
    /**
     * eine String fÃ¼r die Farbe der Spielfigur
     */
    private String farbe;
    /**
     * boolean, gibt an, ob sich Spielfigur bewegen kann oder nicht
     * Zugpflichten muessen hier beachtet werden:
     * 1. Schlagpflicht (wichtigste Pflicht)
     * 2. Figur von Startfeld auf A-Feld, bei 6
     * 3. Figur von A-Feld wegsetzen, sofern noch Figuren im Startkreis
     * 4. Einruecken in Zielfeld
     */
    private boolean zugfaehigkeit;
    
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
        this.zugfaehigkeit = false;
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
     * @param zielfeld
     * @return 1 bei fehler sonst 0 
     */
    public int setzten(Feld zielfeld)
    {
        return 1;
    }
    /**
     * schickt eine andere Figur zurÃ¼ck auf ihre startposition
     * @return 1 bei fehler sonst 0 
     */
    public int schlagen()
    {   
        return 1;
    }
    
    /**
     * setzt figur zurÃ¼ck auf startposition
     * @return 1 bei fehler sonst 0 
     */
    public int zurueckgehen()
    {
     if (this.setzten(this.getStartfeld())== 0)
        {
             return 0;
        }
     else   
        {
            return 1;  
        }
    }
    /**
     * beurteilt, ob sich eine Spielfigur um eine bestimmte Anzahl von Felder fortbewegen kann
     * @param felderAnzahl Anzahl der Felder, die vortgerueckt werden soll
     * @return true, wenn der Zug möglich ist, sonst false
     */
    public boolean kannSichBewegen(int felderAnzahl){
        
        
        return zugfaehigkeit;
    }
    /**
     * gibt zurück od sich figur auf einem spielfeld befindet
     * getter methode für aufzielfeld
     * @return aufzielfeld:boolean 
     */
    public boolean gibAufZielfeld(){
        return this.isAufzielfeld();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the positionX
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * @param positionX the positionX to set
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * @return the positionY
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * @param positionY the positionY to set
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * @return the startfeld
     */
    public Feld getStartfeld() {
        return startfeld;
    }

    /**
     * @param startfeld the startfeld to set
     */
    public void setStartfeld(Feld startfeld) {
        this.startfeld = startfeld;
    }

    /**
     * @return the aktfeld
     */
    public Feld getAktfeld() {
        return aktfeld;
    }

    /**
     * @param aktfeld the aktfeld to set
     */
    public void setAktfeld(Feld aktfeld) {
        this.aktfeld = aktfeld;
    }

    /**
     * @return the feldnummer
     */
    public int getFeldnummer() {
        return feldnummer;
    }

    /**
     * @param feldnummer the feldnummer to set
     */
    public void setFeldnummer(int feldnummer) {
        this.feldnummer = feldnummer;
    }

    /**
     * @return the aufzielfeld
     */
    public boolean isAufzielfeld() {
        return aufzielfeld;
    }

    /**
     * @param aufzielfeld the aufzielfeld to set
     */
    public void setAufzielfeld(boolean aufzielfeld) {
        this.aufzielfeld = aufzielfeld;
    }

    /**
     * @return the aufstartfeld
     */
    public boolean isAufstartfeld() {
        return aufstartfeld;
    }

    /**
     * @param aufstartfeld the aufstartfeld to set
     */
    public void setAufstartfeld(boolean aufstartfeld) {
        this.aufstartfeld = aufstartfeld;
    }

    /**
     * @return the aufafeld
     */
    public boolean isAufafeld() {
        return aufafeld;
    }

    /**
     * @param aufafeld the aufafeld to set
     */
    public void setAufafeld(boolean aufafeld) {
        this.aufafeld = aufafeld;
    }

    /**
     * @return the aufspielfeld
     */
    public boolean isAufspielfeld() {
        return aufspielfeld;
    }

    /**
     * @param aufspielfeld the aufspielfeld to set
     */
    public void setAufspielfeld(boolean aufspielfeld) {
        this.aufspielfeld = aufspielfeld;
    }

    /**
     * @return the team
     */
    public Spieler getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(Spieler team) {
        this.team = team;
    }

    /**
     * @return the farbe
     */
    public String getFarbe() {
        return farbe;
    }

    /**
     * @param farbe the farbe to set
     */
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
    
}
