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
     * boolean welche angett, ob die Figur ihrem anfangsfeld steht
     */
    private boolean aufzefeld;
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
    private int Spielerid;

    /**
     * boolean, gibt an, ob sich Spielfigur bewegen kann oder nicht Zugpflichten
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
    public Spielfigur(Feld starterfeld, int SpielerId, Spiel dasSpiel) {
        this.Spielerid = SpielerId;
        this.startfeld = starterfeld;
        this.positionX = this.startfeld.getPositionX();
        this.positionY = this.startfeld.getPositionY();
        this.aktfeld = this.startfeld;
        this.feldnummer = this.startfeld.getID();
        this.aufafeld = false;
        this.aufspielfeld = false;
        this.aufstartfeld = true;
        this.aufzielfeld = false;
        this.aufStandardfeld = false;
        this.aufzefeld = false;
        this.zugfaehigkeit = false;
        this.id = dasSpiel.setSpielfigur(this);

    }

    public Spielfigur(String oname, Logger logger, Feld starterfeld, int SpielerId, Spiel dasSpiel) {

        this(starterfeld, SpielerId, dasSpiel);
        objektname = oname;
        log = logger;
        log.log(objektname, "Konstrucktor SpielFigur() beendet mit Parameter ");

    }

    public void Spielersetzen(Spiel dasSpiel) {
        log.log(objektname, "Methode Spielersetzen() gestartet.");

        if (!(dasSpiel.AlleSpieler[Spielerid] == null)) {
            this.team = dasSpiel.AlleSpieler[Spielerid];
            this.team.setSpielfigur(this);
            this.farbe = this.team.getfarbe();
            this.team.getSpiel().getoutput().SpielerSetzen(this);

        }
        log.log(objektname, "Methodenrückgabe: " + 1);
        log.log(objektname, "Methode Spielersetzen() beendet.");
    }

    /**
     * setzt Figur auf sein Afeld
     *
     * @return 1 bei fehler sonst 0
     */
    public int herauskommen() {
        log.log(objektname, "Methode herauskommen() gestartet.");
        if (this.team.getafeld().getIstBesetzt() && !this.team.getafeld().getHausbesetzer().getFarbe().equals(this.farbe)) {
            schlagen(this.team.getafeld());
        }
        if (this.setzten(this.team.getafeld()) == 0) {
            log.log(objektname, "Methodenrückgabe: " + 0);
            log.log(objektname, "Methode herauskommen() beendet.");
            System.out.println(this.team.getobjektname() + " kommt mit " + this.objektname + " raus.");
            System.out.println(this.team.getobjektname() + " ist nochmal am Zug.");
            int a = this.team.ziehen2();
            return 0;
        } else {
            log.log(objektname, "Methodenrückgabe: " + 1);
            log.log(objektname, "Methode herauskommen() beendet.");
            return 1;
        }

    }

    /**
     * bewegt eine Figur um ein Feld je nach dem, welche Augenzahl man
     * gewuerfelt hat, fuehrt man diese Funktion dementsprechend oft aus
     *
     * @return 1 bei fehler sonst 0
     */
    public int bewegen() {

        /**
         * ID des aktuellen Feldes wird angegeben um einen Schritt voran zu
         * gehen, muss man die id des aktuellen Feldes um 1 erhoehen
         *
         */
        log.log(objektname, "Methode bewegen() gestartet.");
        this.setzten(this.team.getSpiel().getSpielbrett().getFelder().get(this.aktfeld.getID() + 1));
        this.team.getSpiel().getoutput().SpielerSetzen(this);

        log.log(objektname, "Methodenrückgabe: " + 1);
        log.log(objektname, "Methode bewegen() beendet.");
        return 1;
    }

    /**
     *
     * @param Baka
     * @return
     */
    public Feld holpfad(Feld Baka) {

        log.log(objektname, "Methode holpfad() gestartet.");

        switch (Baka.getFeldtyp().toLowerCase()) { // bester und elegantester Switch von allen
            case "startfeld":
                return this.startfeld;
            case "zefeld":
                if (this.team.getzefeld().getID() == Baka.getID()) {
                    return this.team.getzielfeld();
                }
            case "afeld":
            case "standardfeld":
                if (Baka.getID() == 41) {
                    return this.team.getSpiel().getSpielbrett().getFelder().get(0);
                }
                return this.team.getSpiel().getSpielbrett().getFelder().get(Baka.getID() + 1);
            case "zielfeld":
                if (this.team.getSpiel().getSpielbrett().getFelder().get(Baka.getID() + 1).getFarbe().equals(Baka.getFarbe())) {
                    return this.team.getSpiel().getSpielbrett().getFelder().get(Baka.getID() + 1);
                }
                return this.startfeld;
            default:
                System.out.println("Error: Holpfad()-Switch hat mal wieder nicht angeschlagen");
                return this.startfeld;
        }
        /**
         * break; } log.log(objektname, "Methodenrückgabe: " + Baka);
         * log.log(objektname, "Methode holpfad() beendet."); return
         * this.aktfeld;
         */

    }

    /**
     *
     * @param augen
     * @return
     */
    public int laufen(int augen) {

        Feld zielfeld = this.aktfeld;
        for (int i = 0; i < augen; i++) 
        {
            zielfeld = this.holpfad(zielfeld);
        }
        if (augen == 6 && this.aufstartfeld)
        {
            this.herauskommen();
            return 0;
        }
        else if(zielfeld != this.startfeld)
        {
            if (zielfeld.getIstBesetzt() && !zielfeld.getHausbesetzer().getFarbe().equals(this.farbe))
            {
                schlagen(zielfeld);
                System.out.println("schlag");
            }
            this.setzten(zielfeld);
        }
        this.team.setgezogen((this.team.getgezogen() + 1));
            if (augen == 6) 
            {
                this.team.ziehen2();
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
        this.team.getSpiel().getoutput().feldeinfuegen(this.aktfeld);
        this.aktfeld.setIstBesetzt(false);
        this.aktfeld.setHausbesetzer(null);
        this.aktfeld = zielfeld;
        this.positionX = this.aktfeld.getPositionX();
        this.positionY = this.aktfeld.getPositionY();
        this.feldnummer = this.aktfeld.getID();
        this.aufspielfeld = false;
        this.setAufstartfeld(false);
        this.aufzielfeld = false;
        switch (this.aktfeld.getFeldtyp().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "startfeld":
                this.setAufstartfeld(true);
                break;
            case "afeld":
                this.aufspielfeld = true;
                this.aufafeld = true;
                break;
            case "zielfeld":
                this.aufspielfeld = true;
                this.aufzielfeld = true;
                break;
            case "standardfeld":
                this.aufspielfeld = true;
                this.aufStandardfeld = true;
                break;
            case "efeld":
            case "zefeld":
                this.aufzefeld = true;
                this.aufspielfeld = true;
                break;
            default:
                break;
        }

        this.aktfeld.setIstBesetzt(true);
        this.aktfeld.setHausbesetzer(this);
        this.team.getSpiel().getoutput().SpielerSetzen(this);
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
        if (dasFEld.getHausbesetzer() != null) {
            dasFEld.getHausbesetzer().zurueckgehen();
        }
        log.log(objektname, "Methodenrückgabe: " + 1);
        log.log(objektname, "Methode schlagen() beendet.");
        return 0;
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
        Feld zielfeld = this.aktfeld;
        for (int i = 0; i > felderAnzahl; i++) {
            zielfeld = this.holpfad(zielfeld);
        }
        if (this.isAufstartfeld()) {
            if (felderAnzahl != 6) {
                this.zugfaehigkeit = false;
                return this.zugfaehigkeit;

            }
            zielfeld = this.team.getafeld();
        }

        if (zielfeld.getIstBesetzt() && zielfeld.getHausbesetzer().getFarbe().equals(this.farbe)) {
            this.zugfaehigkeit = false;
            return this.zugfaehigkeit;
        }
        this.zugfaehigkeit = true;

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
     * @param ZuLaufendeFeldanzahl
     * @return
     */
    public int getPrioritaet(int ZuLaufendeFeldanzahl) {

        Feld zielfeld = this.aktfeld;
        //holt das Zielfeld
        for (int a = 0; a < ZuLaufendeFeldanzahl; a++) {
            zielfeld = this.holpfad(zielfeld);
        }

        if (zielfeld.equals(this.startfeld) && !this.aufstartfeld) {
            return 0;
        }
        System.out.println("Zielfeld  von " + this.objektname + " ist " + zielfeld.getobjektname());
        //Sucht die Postion des Feldes in der Liste der Spielfigur
        switch (this.aktfeld.getFeldtyp().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "startfeld":
                //Wenn eine 6 gewürfelt wurde und die Spielfigur im Startkreis steht.
                if (ZuLaufendeFeldanzahl == 6) {
                    if (this.team.getafeld().getIstBesetzt()) {
                        if (this.team.getafeld().getHausbesetzer().getTeam().equals(this.team)) {
                            return 0;
                        } // //falls Gegner auf dem aFeld steht
                        else {
                            return 3;
                        }
                    } else {
                        return 2;
                    }
                }
                return 0;
            case "afeld":
                if (this.aktfeld.equals(this.team.getafeld()) && this.team.SpielerImStartkreis()) {
                    if (zielfeld.getIstBesetzt()) {
                        //Wenn das Zielfeld von dem gleichen Team besetzt ist 
                        if (!this.team.getafeld().getHausbesetzer().farbe.toLowerCase().equals(this.farbe.toLowerCase())) {
                            return 3;
                        } else {
                            return 0;
                        } //Wenn das Zielfeld von einen Gegner besetzt ist

                    }
                    return 2;
                }
            case "standardfeld":
                if (!zielfeld.getZielfeld()) {
                    if (zielfeld.getIstBesetzt()) {
                        //Wenn das Zielfeld von dem gleichen Team besetzt ist 
                        if (zielfeld.getHausbesetzer().farbe.equals(this.farbe)) {
                            return 0;
                        } //Wenn das Zielfeld von einen Gegner besetzt ist
                        else {
                            return 2;
                        }
                    }
                    return 1;
                }
            case "zefeld":
            case "efeld":
                if (zielfeld.getIstBesetzt()) {
                    return 0;
                }
                return 2;
            case "zielfeld":
                if (zielfeld.getIstBesetzt()) {
                    return 0;
                }
                return 1;
            default:
                return 0;
        }

        //Wenn eine Figur nicht gehen kann
    }

    /**
     * gett zurueck, ob sich figur auf einem spielfeld befindet getter methode
     * für aufzielfeld
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
     * @return the farbe
     */
    public String getobjektname() {
        log.log(objektname, "Methode getobjektname() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + objektname);
        log.log(objektname, "Methode getobjektname() beendet.");
        return objektname;
    }

    public Feld getaktFeld() {
        log.log(objektname, "Methode getFarbe() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + "Feld " + this.aktfeld.getID());
        log.log(objektname, "Methode getFarbe() beendet.");
        return this.aktfeld;
    }

    /**
     * @param farbe the farbe to set
     */
    public void setFarbe(String farbe) {
        log.log(objektname, "Methode setFarbe() gestartet mit Parameter " + farbe + " .");

        log.log(objektname, "Methode setFarbe() beendet.");
        this.farbe = farbe;
    }

    public boolean getaufStartfeld() {
        return this.aufstartfeld;

    }

}
