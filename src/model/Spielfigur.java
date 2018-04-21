/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Klasse Spielfigur erzeugt einezelne Spielfiguren und verwaltet deren
 * verhalten, wie bewegen, schlagen etc. Funktionen arbeiten mit returnwerten
 * als fehlermeldung: 0 ist immer super fÃ¼r unterschiedliche probleme kÃ¶nnen
 * andere integers festgelegt werden
 *
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
     * boolean welche angett, ob die Figur im Ziel ist
     */
    private boolean aufzielfeld;
    /**
     * boolean welche angett, ob die Figur im Start steht
     */
    private boolean aufstartfeld;
    /**
     * boolean welche angett, ob die Figur ihrem anfangsfeld steht
     */
    private boolean aufafeld;
    /**
     * boolean welche angett, ob die Figur momentan im spielfeld ist
     */
    private boolean aufspielfeld;
    /**
     * boolean welche angett, ob die Figur momentan auf einem Standard ist
     */
    private boolean aufStandardfeld;
    /**
     * gett an zu welchen spieler die Figur gehÃ¶rt
     */
    private Spieler team;
    /**
     * eine String fÃ¼r die Farbe der Spielfigur
     */
    private String farbe;
    private Logger log;
    private String objektname;

    /**
     * boolean, gett an, ob sich Spielfigur bewegen kann oder nicht Zugpflichten
     * muessen hier beachtet werden: 1. Schlagpflicht (wichtigste Pflicht) 2.
     * Figur von A-Feld wegsetzen, sofern noch Figuren im Startkreis 3. Figur
     * von Startfeld auf A-Feld, bei 6 4. Einruecken in Zielfeld
     */
    private boolean zugfaehigkeit;

    /**
     * Konstruktor fÃ¼r die klasse Spielfigur erzeugt eine neue Spielfigur
     *
     * @param id der Spielfigur
     * @param starterfeld die grundposition der spielfigur auf der sie erzeugt
     * wird
     * @param spieler die SpielerzugehÃ¶rigkeit
     */
    public Spielfigur(int id, Feld starterfeld, Spieler derSpieler) {
        this.startfeld = starterfeld;
        this.positionX = this.startfeld.getPositionX();
        this.positionY = this.startfeld.getPositionY();
        this.aktfeld = this.startfeld;
        this.feldnummer = this.startfeld.getID();
        this.aufafeld = false;
        this.aufspielfeld = false;
        this.aufstartfeld = true;
        this.aufzielfeld = false;
        this.zugfaehigkeit = false;
        this.team = derSpieler;
        //this.farbe = this.team.getfarbe();
    }

    public Spielfigur(String oname, Logger logger, int id, Feld starterfeld, Spieler derSpieler) {

        this(id, starterfeld, derSpieler);
        objektname = oname;
        log = logger;

    }

    /**
     * setzt Figur auf sein Afeld
     *
     * @return 1 bei fehler sonst 0
     */
    public int herauskommen() {
        log.log(objektname, "Methode herauskommen() gestartet.");

        if (this.setzten(this.team.getafeld())== 0)
        {
             log.log(objektname, "Methodenrückgabe: " + 0);
             log.log(objektname, "Methode herauskommen() beendet.");
            return 0;
        }
         else   
        {
            log.log(objektname, "Methodenrückgabe: " + 1);
            log.log(objektname, "Methode herauskommen() beendet.");
            return 1;  
        }
       
    }

    /**
     * bewegt eine Figur um ein Feld
     *je nach dem, welche Augenzahl man gewuerfelt hat, fuehrt man diese Funktion
     * dementsprechend oft aus
     * @return 1 bei fehler sonst 0
     */
    public int bewegen() {
        
        /**
         * ID des aktuellen Feldes wird angegeben
         * um einen Schritt voran zu gehen, muss man die id des aktuellen Feldes um 1 erhoehen
         * 
         */
        aktfeld.getID();
        id = feldnummer + 1; 
        // id = id + 1; 
        
        
        log.log(objektname, "Methode bewegen() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + 1);
        log.log(objektname, "Methode bewegen() beendet.");
        return 1;
    }
    public int laufen(int augen){
        Feld backup = this.aktfeld;
        if (this.team.getSpiel().getSpielbrett().getFelder().get((aktfeld.getID() + augen)).getImSpielkreis() && !this.team.getSpiel().getSpielbrett().getFelder().get((aktfeld.getID() + augen)).getHausbesetzer().getFarbe().equals(this.farbe)){
        this.schlagen(this.team.getSpiel().getSpielbrett().getFelder().get((aktfeld.getID() + augen)));
        }
        
        for(int i = 0; i > augen; i++){
            if(this.bewegen() == 1){
            this.setzten(backup);
            return 1;
            }
      
    }
          return 0;
    }
    /**
     * setzt Figur auf ein Feld: Zielfeld Methode ist fuer sprunge geeignet (zb.
     * rauskommen, geschlagenwerden nicht aber fuer das reguläre laufen
     * empfohlen) Achtung zielfeld steht nicht fuer Zielfeld sondern fuer das
     * neue Feld der Figur
     *
     * @param zielfeld
     * @return 1 bei fehler sonst 0
     */
    public int setzten(Feld zielfeld) {
        log.log(objektname, "Methode setzen() gestartet.");
        this.aktfeld.setIstBesetzt(false);
        this.aktfeld = zielfeld;
        this.positionX = this.aktfeld.getPositionX();
        this.positionY = this.aktfeld.getPositionY();
        this.feldnummer = this.aktfeld.getID();
        this.aufspielfeld = false;
        this.aufstartfeld = false;
        this.aufzielfeld = false;
        switch (this.aktfeld.getFeldtyp().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
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
        this.aktfeld.setIstBesetzt(true);
        log.log(objektname, "Methode setzen() beendet.");
        log.log(objektname, "Methodenrückgabe: " + 0);
        return 0;
    }

    /**
     * schickt eine andere Figur zurueck auf ihre startposition
     *
     * @return 1 bei fehler sonst 0
     */
    public int schlagen(Feld dasFEld) {
        log.log(objektname, "Methode schlagen() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + 1);
        log.log(objektname, "Methode schlagen() beendet.");
        return 1;
    }

    /**
     * setzt figur zurÃ¼ck auf startposition
     *
     * @return 1 bei fehler sonst 0
     */
    public int zurueckgehen() {
        log.log(objektname, "Methode zurueckgehen() gestartet.");

        if (this.setzten(this.startfeld) == 0) {
            log.log(objektname, "Methodenrückgabe: " + 0);
            log.log(objektname, "Methode zurueckgehen() beendet.");
            return 0;
        } else {
            log.log(objektname, "Methodenrückgabe: " + 1);
            log.log(objektname, "Methode zurueckgehen() beendet.");
            return 1;
        }
    }

    /**
     * beurteilt, ob sich eine Spielfigur um eine bestimmte Anzahl von Felder
     * fortbewegen kann beurteilt, ob sich eine SPielfigur um eine bestimmte
     * Anzahl von Felder fortbewegen kann
     *
     * @param felderAnzahl Anzahl der Felder, die vortgerueckt werden soll
     * @return true, wenn der Zug möglich ist, sonst false
     */
    public boolean kannSichBewegen(int felderAnzahl) {
        log.log(objektname, "Methode kannSichBewegen() gestartet mit Parameter " + felderAnzahl + " .");
        log.log(objektname, "Methodenrückgabe: " + zugfaehigkeit);
        log.log(objektname, "Methode kannSichBewegen() beendet.");

        return zugfaehigkeit;
    }

    /**
     * Die Methode überprüft wie hoch die Priorität des Zuges ist. 0-Der Zug
     * darf nicht druchgeführt werden 1-Der Zug darf durchgeführt werden 2-Der
     * Zug muss durchgeführt werden 3-Doppelter Zug-Zwang. Dies sind die
     * Pflichten: 1. Schlagpflicht (wichtigste Pflicht) 2. Figur von A-Feld
     * wegsetzen, sofern noch Figuren im Startkreis 3. Figur von Startfeld auf
     * A-Feld, bei 6 4. Einruecken in Zielfeld
     *
     * @param felderanzahl
     * @return
     */
    public int getPrioritaet(int ZuLaufendeFeldanzahl) {
        int PositionImFeld;
        //Sucht die Postion des Feldes in der Liste der Spielfigur
        for (int i = 0; i < 200; i++) {
            if (team.getFelder().get(i).equals(this.aktfeld)) {
                PositionImFeld = i;
            }

            return 4;

        }
        //Nur für die Syntax
        PositionImFeld = -1;
        //Wenn das Zielfeld besetzt ist
        if (team.getFelder().get(PositionImFeld + ZuLaufendeFeldanzahl).getIstBesetzt()) {
            //Wenn das Zielfeld vom gleichen Team besetzt ist
            if (team.getFelder().get(PositionImFeld + ZuLaufendeFeldanzahl).getHausbesetzer().getFarbe().equals(team.getFelder().get(PositionImFeld).getHausbesetzer().getFarbe())) {
                return 0;
            } else {
                //Wenn das Zielfeld von einer anderen Farbe besetzt ist,die Spielfigur auf dem A-Feld steht und Spieler im Startkreis sind.
                if (team.getFelder().get(PositionImFeld).getFeldtyp().equals("aFeld") && team.SpielerImStartkreis() == true) {
                    return 3;
                }

                //Wenn das Zielfeld von einer anderen Farbe besetzt ist.
                return 2;

            }

        } //Wenn das Zielfeld nicht exestiert.(Ende der ArrayListe)
        else if (team.getFelder().get(PositionImFeld + ZuLaufendeFeldanzahl) == null) {
            return 0;
        }
        return 1;
    }
        
    

    /**
     * gett zurueck, ob sich figur auf einem spielfeld befindet getter methode für
     * aufzielfeld
     *
     * @return aufzielfeld:boolean
     */
    public boolean getAufZielfeld() {
        log.log(objektname, "Methode getAufZielfeld() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + this.isAufzielfeld());
        log.log(objektname, "Methode getAufZielfeld() beendet.");
        return this.isAufzielfeld();
    }

    /**
     * @return the id
     */
    public int getId() {
        log.log(objektname, "Methode getID() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + id);
        log.log(objektname, "Methode getID() beendet.");
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        log.log(objektname, "Methode setID() gestartet mit Parameter " + id + " .");
        log.log(objektname, "Methode setID() beendet.");
        this.id = id;
    }

    /**
     * @return the positionX
     */
    public int getPositionX() {
        log.log(objektname, "Methode getPositionX() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + positionX);
        log.log(objektname, "Methode getPositionX() beendet.");
        return positionX;
    }

    /**
     * @param positionX the positionX to set
     */
    public void setPositionX(int positionX) {
        log.log(objektname, "Methode setPositionX() gestartet mit Parameter " + positionX + " .");

        log.log(objektname, "Methode setPositionX() beendet.");
        this.positionX = positionX;
    }

    /**
     * @return the positionY
     */
    public int getPositionY() {
        log.log(objektname, "Methode getPositionY() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + positionY);
        log.log(objektname, "Methode getPositionY() beendet.");
        return positionY;
    }

    /**
     * @param positionY the positionY to set
     */
    public void setPositionY(int positionY) {
        log.log(objektname, "Methode setPositionY() gestartet mit Parameter " + positionY + " .");

        log.log(objektname, "Methode setPositionY() beendet.");
        this.positionY = positionY;
    }

    /**
     * @return the startfeld
     */
    public Feld getStartfeld() {
        log.log(objektname, "Methode getStartfeld() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + startfeld);
        log.log(objektname, "Methode getStartfeld() beendet.");
        return startfeld;
    }

    /**
     * @param startfeld the startfeld to set
     */
    public void setStartfeld(Feld startfeld) {
        log.log(objektname, "Methode setStartfeld() gestartet mit Parameter " + startfeld + " .");

        log.log(objektname, "Methode setStartfeld() beendet.");
        this.startfeld = startfeld;
    }

    /**
     * @return the aktfeld
     */
    public Feld getAktfeld() {
        log.log(objektname, "Methode getAktfeld() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + aktfeld);
        log.log(objektname, "Methode getAktfeld() beendet.");
        return aktfeld;
    }

    /**
     * @param aktfeld the aktfeld to set
     */
    public void setAktfeld(Feld aktfeld) {
        log.log(objektname, "Methode setAktfeld() gestartet mit Parameter " + aktfeld + " .");

        log.log(objektname, "Methode setAktfeld() beendet.");
        this.aktfeld = aktfeld;
    }

    /**
     * @return the feldnummer
     */
    public int getFeldnummer() {
        log.log(objektname, "Methode getFeldnummer() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + feldnummer);
        log.log(objektname, "Methode getFeldnummer() beendet.");
        return feldnummer;
    }

    /**
     * @param feldnummer the feldnummer to set
     */
    public void setFeldnummer(int feldnummer) {
        log.log(objektname, "Methode setFeldnummer() gestartet mit Parameter " + feldnummer + " .");

        log.log(objektname, "Methode setFeldnummer() beendet.");
        this.feldnummer = feldnummer;
    }

    /**
     * @return the aufzielfeld
     */
    public boolean isAufzielfeld() {
        log.log(objektname, "Methode isAufzielfeld() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + aufzielfeld);
        log.log(objektname, "Methode isAufzielfeld() beendet.");
        return aufzielfeld;
    }

    /**
     * @param aufzielfeld the aufzielfeld to set
     */
    public void setAufzielfeld(boolean aufzielfeld) {
        log.log(objektname, "Methode setAufzielfeld() gestartet mit Parameter " + aufzielfeld + " .");

        log.log(objektname, "Methode setAufzielfeld() beendet.");
        this.aufzielfeld = aufzielfeld;
    }

    /**
     * @return the aufstartfeld
     */
    public boolean isAufstartfeld() {
        log.log(objektname, "Methode istAufstartfeld() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + aufstartfeld);
        log.log(objektname, "Methode isAufstartfeld() beendet.");
        return aufstartfeld;
    }

    /**
     * @param aufstartfeld the aufstartfeld to set
     */
    public void setAufstartfeld(boolean aufstartfeld) {
        log.log(objektname, "Methode setAufstartfeld() gestartet mit Parameter " + aufstartfeld + " .");

        log.log(objektname, "Methode setAufstartfeld() beendet.");
        this.aufstartfeld = aufstartfeld;
    }

    /**
     * @return the aufafeld
     */
    public boolean isAufafeld() {
        log.log(objektname, "Methode istAufafeld() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + aufafeld);
        log.log(objektname, "Methode isAufafeld() beendet.");
        return aufafeld;
    }

    /**
     * @param aufafeld the aufafeld to set
     */
    public void setAufafeld(boolean aufafeld) {
        log.log(objektname, "Methode setAufafeld() gestartet mit Parameter " + aufafeld + " .");

        log.log(objektname, "Methode setAufafeld() beendet.");
        this.aufafeld = aufafeld;
    }

    /**
     * @return the aufspielfeld
     */
    public boolean isAufspielfeld() {
        log.log(objektname, "Methode isAufspielfeld() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + aufspielfeld);
        log.log(objektname, "Methode isAufspielfeld() beendet.");
        return aufspielfeld;
    }

    /**
     * @param aufspielfeld the aufspielfeld to set
     */
    public void setAufspielfeld(boolean aufspielfeld) {
        log.log(objektname, "Methode setAufspielfeld() gestartet mit Parameter " + aufspielfeld + " .");

        log.log(objektname, "Methode setAufspielfeld() beendet.");
        this.aufspielfeld = aufspielfeld;
    }

    /**
     * @return the team
     */
    public Spieler getTeam() {
        log.log(objektname, "Methode getTeam() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + team);
        log.log(objektname, "Methode getTeam() beendet.");
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(Spieler team) {
        log.log(objektname, "Methode setTeam() gestartet mit Parameter " + team + " .");

        log.log(objektname, "Methode setTeam() beendet.");
        this.team = team;
    }

    /**
     * @return the farbe
     */
    public String getFarbe() {
        log.log(objektname, "Methode getFarbe() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + farbe);
        log.log(objektname, "Methode getFarbe() beendet.");
        return farbe;
    }

    /**
     * @param farbe the farbe to set
     */
    public void setFarbe(String farbe) {
        log.log(objektname, "Methode setFarbe() gestartet mit Parameter " + farbe + " .");

        log.log(objektname, "Methode setFarbe() beendet.");
        this.farbe = farbe;
    }
    


}
