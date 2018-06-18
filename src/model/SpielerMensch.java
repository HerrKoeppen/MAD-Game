/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Die Klasse SpielerMensch beinhaltet zum einen, den Namen der Spieler, die
 * Farbe, die den Spielern momentan zu geordnet ist und ordnet die Spielfiguren
 * (jeder besitzt 4 Spielfiguren) den Spielern zu.
 *
 * @author Lion
 */
public class SpielerMensch implements Spieler {

    private int id;
    /**
     * Die Namen der Spieler.
     */
    public String Name;
    /**
     * Die Farbe des Spielers/Spielfigur.
     */
    public String Farbe;
    /**
     * den der Spieler sollte wissen wo er startet.
     */
    private Feld aFeld;
    /**
     * den der Spieler sollte wissen wann er ins Ziel kommt.
     */
    private Feld zeFeld;
    /**
     * den der Spieler sollte wissen wo das Ziel ist.
     */
    private Feld zielfeld;
    /**
     * den der Spieler sollte wissen, was er spielt.
     */
    private Spiel dasSpiel;
    /**
     * Eine Liste mit 3 Spielfiguren.
     */
    public Spielfigur[] Spielfiguren = new Spielfigur[3];
    private int gezogen = 0;
     // Spielfigur in Spe (wurde auserwählt gezogen zu werden )
    private Spielfigur Spefigur = null;

    /**
     * Logger zu Diagnosezwecken
     */
    private Logger log;
    private String objektname;
    /**
     * Gibt an wie viele Züge der Spieler noch machen darf.
     */
    private int verbleideneZüge = 0;

    public SpielerMensch(String oname, Logger logger, Spiel dasspiel) {
        objektname = oname;
        log = logger;
        log.log(objektname, "konstrucktor SpielerMensch() gestartet.");
        this.dasSpiel = dasspiel;
        this.id = this.dasSpiel.setSpieler(this);
        this.Farbe = this.dasSpiel.Farben[id];
        log.log(objektname, "Spieler hat die Farbe: " + Farbe);

        this.aFeld = this.dasSpiel.getSpielbrett().getAfelder()[this.id];
        this.zeFeld = this.dasSpiel.getSpielbrett().getEfelder()[this.id];
        this.zielfeld = this.dasSpiel.getSpielbrett().getZfelder()[this.id];

        this.dasSpiel.spielfigurenVerteilen();
        String Figuren = " ";
        /*
        for (Spielfigur fig: this.Spielfiguren){
            if(fig == null){
            Figuren = Figuren + " Error";}
            else  {Figuren = Figuren + " " + fig.getobjektname();
            }
        }
        * **/
        for (int k = 0; k < 3; k++) {
            if (this.Spielfiguren[k] == null) {
                Figuren = "Error";
                break;
            } else {
                Figuren = Figuren + " " + this.Spielfiguren[k].getobjektname();

            }
        }
        if (!Figuren.equals("Error")) {
            log.log(objektname, "Spieler hat die Spielfiguren:" + Figuren);
            //System.out.println(Figuren);
        }
        log.log(objektname, "Methode SpielerMensch() beendet.");

    }

    /**
     * Setzt die Spielfigur an die letzte Stelle der Liste Spielfiguren.
     *
     * @param Spielfigur
     */
    public void setSpielfigur(Spielfigur dieSpielfigur) {
        log.log(objektname, "Methode setSpielfigur() gestartet mit Parameter " + dieSpielfigur + " .");
        for (int i = 0; i < 3; i++) {
            if (Spielfiguren[i] == null) {
                Spielfiguren[i] = dieSpielfigur;
                log.log(objektname, "Methode setSpielfigur() beendet.");
                return;

            }
        }

    }

    /**
     * ueberprueft, ob ein Spieler gewonnen hat (alle Spielfiguren im Zielkreis
     * hat)
     *
     * @return true, wenn der Spieler gewonnen hat, sonst false
     */
    public boolean hatGewonnen() {
        log.log(objektname, "Methode hatGewonnen() gestartet.");
        for (Spielfigur i : Spielfiguren) {
            if (!i.getAufZielfeld()) {
                log.log(objektname, "Methodenrückgabe: " + false);
                log.log(objektname, "Methode hatGewonnen() beendet.");
                return false;
            }
        }

        log.log(objektname, "Methodenrückgabe: " + true);
        log.log(objektname, "Methode hatGewonnen() beendet.");
        //System.out.println(this.objektname + " hat gewonnen");
        return true;
    }

    private int herauskommen() {

        for (int i = 0; i < 3; i++) {
            System.out.println(this.objektname + " darf noch " + (3 - i) + " mal wuerfeln.");
            this.dasSpiel.c.wuerfeln();
                // ist es eine 6?
                if (this.wuerfeln() == 6) {
                    spielfigWaehlen().herauskommen();
                    this.gezogen = 0;
                    return 0;
                }
            
        }
        System.out.println(this.objektname + "'s Zug ist beendet");
        this.gezogen = 0;
        return 0;

    }

    /**
     *
     * @return
     */
    @Override
    public int ziehen() {

        log.log(objektname, "Methode ziehen() gestartet.");
        //habe ich gewonnen? Wenn nein, dann mache ich einen normalen Zug
        if (this.hatGewonnen()) {
            return 1;
        }
        if (this.gezogen < 3) {

            //habe ich nur Spielfiguren im Startkreis
            if (this.alleSpielerImStartkreis()) {
                //-> ja, dann bis zu dreimal würfeln und hoffe auf eine 6
                return this.herauskommen();
            } //-> nein, einmal würfeln
            else {  //unnoetige zeile aber lieber doppelt als keinmal
                if (this.dasSpiel.output.wuerfeln()) {
                    int Random = this.wuerfeln();

                    List<Spielfigur> moeglSpielfiguren = this.moeglSpielfiguren(Random);
                    if (moeglSpielfiguren.isEmpty()) {
                        System.out.println("Du kannst nicht ziehen.Muhahaha(böses Lachen)");
                        return 0;

                    } else {

                        moeglSpielfiguren.get(this.dasSpiel.getoutput().Spielerwaehlen(moeglSpielfiguren)).laufen(Random);

                    }
                }

            }
        }
        this.gezogen = 0;
        //ich habe doch schon gewonnen: ich mache nichts
        log.log(objektname, "Methode ziehen() beendet.");
        if (this.hatGewonnen()) {
            return 1;
        }
        return 0;

    }

    /**
     *
     * @return
     *
     * public int ziehen2() {
     *
     * log.log(objektname, "Methode ziehen() gestartet."); //habe ich gewonnen?
     * Wenn nein, dann mache ich einen normalen Zug if (this.gezogen < 3) {
     * if (!this.hatGewonnen()) {
     * this.dasSpiel.output.spielAusgabe();
     * System.out.println(this.objektname + " ist am Zug");
     * //habe ich nur Spielfiguren im Startkreis
     * if (this.alleSpielerImStartkreis()) {
     * //-> ja, dann bis zu dreimal würfeln und hoffe auf eine 6 for (int i =
     * 0; i < 3; i++) {
     * System.out.println(this.objektname + " darf noch " + (3 - i) + " mal wuerfeln.");
     * if (this.dasSpiel.output.wuerfeln()) {
     * // ist es eine 6?
     * if (this.wuerfeln() == 6) {
     * int spieler = this.dasSpiel.getoutput().Spielerwaehlen(java.util.Arrays.asList(this.Spielfiguren));
     * this.Spielfiguren[spieler].herauskommen();
     * this.dasSpiel.output.spielAusgabe();
     * System.out.println(this.objektname + "'s Zug ist beendet");
     * this.gezogen = 0;
     * return 0;
     * }
     * }
     * }
     * System.out.println(this.objektname + "'s Zug ist beendet");
     * this.gezogen = 0;
     * return 0;
     * } //-> nein, einmal würfeln else { //unnoetige zeile aber lieber doppelt
     * als keinmal if (this.dasSpiel.output.wuerfeln()) { int Random =
     * this.wuerfeln();
     *
     * List<Spielfigur> moeglSpielfiguren = this.moeglSpielfiguren(Random); if
     * (moeglSpielfiguren.isEmpty()) { System.out.println("Du kannst nicht
     * ziehen.Muhahaha(böses Lachen)"); return 0;
     *
     * } else {
     *
     * moeglSpielfiguren.get(this.dasSpiel.getoutput().Spielerwaehlen(moeglSpielfiguren)).laufen(Random);
     *
     * }
     * }
     *
     * }
     *
     * }
     *
     * } else { System.out.println(this.objektname + " hat gewonnen."); return
     * 1; } if ((this.gezogen > 0)) { this.gezogen--; } else {
     * System.out.println(this.objektname + "'s Zug ist beendet"); }
     *
     * //ich habe doch schon gewonnen: ich mache nichts log.log(objektname,
     * "Methode ziehen() beendet."); return 0; } /
     *
     * /**
     * Methode gibt alle Spielfiguren zurück die für diesen Zug möglich währen
     * und benötigt dafür die gewürfelte Zahl.
     *
     *
     *
     *
     *
     * @param ZuLaufendeFeldanzahl
     * @return
     */
    public List<Spielfigur> moeglSpielfiguren(int ZuLaufendeFeldanzahl) {
        List<Spielfigur> moeglSpielfiguren = new LinkedList<>();
        List<Spielfigur> DPflichtSpielfiguren = new LinkedList<>();
        List<Spielfigur> DDPflichtSpielfiguren = new LinkedList<>();
        for (Spielfigur Spielfiguren1 : this.Spielfiguren) {
            //Wenn die Spielfigur ziehen kann.
            switch (Spielfiguren1.getPrioritaet(ZuLaufendeFeldanzahl)) {
                case 1:
                    moeglSpielfiguren.add(Spielfiguren1);
                    //Wenn die Spielfigur ziehen muss    
                    break;
                case 2:
                    DPflichtSpielfiguren.add(Spielfiguren1);
                    //Wenn die Spielfigur doppelt ziehen muss.    
                    break;
                case 3:
                    DDPflichtSpielfiguren.add(Spielfiguren1);
                    return DDPflichtSpielfiguren;
                default:
                    break;
            }
        }
        //Wenn es keine PflichtSpielfguren gibt
        if (DPflichtSpielfiguren.isEmpty()) {
            return moeglSpielfiguren;
            //Wenn es PflichtSpielfiguren gibt.
        } else {
            return DPflichtSpielfiguren;
        }

    }

    @Override
    public int wuerfeln() {
        log.log(objektname, "Methode wuerfeln() gestartet.");
        int augenzahl = this.dasSpiel.getWuerfel().wuerfeln();
        log.log(objektname, "Methodenrückgabe: " + augenzahl);
        log.log(objektname, "Methode wuerfeln() beendet.");
        return augenzahl;
    }

    /**
     * Die Methode gibt an ob sich alle Spielfiguren auf den Startfeldern
     * befinden.
     *
     * @return Boolean
     */
    @Override
    public boolean alleSpielerImStartkreis() {
        log.log(objektname, "Methode hatGewonnen() gestartet.");
        for (Spielfigur i : Spielfiguren) {
            if (!i.isAufstartfeld()) {
                log.log(objektname, "Methodenrückgabe: " + false);
                log.log(objektname, "Methode hatGewonnen() beendet.");

                return false;
            }
        }
        log.log(objektname, "Methodenrückgabe: " + true);
        log.log(objektname, "Methode hatGewonnen() beendet.");
        return true;
    }

    /**
     * Die Methode gibt an ob sich min. eine Spielfigur auf den Startfeldern
     * befindet.
     *
     * @return Boolean
     */
    public boolean SpielerImStartkreis() {
        log.log(objektname, "Methode hatGewonnen() gestartet.");
        for (Spielfigur i : Spielfiguren) {
            if (i.isAufstartfeld()) {
                log.log(objektname, "Methodenrückgabe: " + true);
                log.log(objektname, "Methode hatGewonnen() beendet.");

                return true;
            }
        }
        log.log(objektname, "Methodenrückgabe: " + false);
        log.log(objektname, "Methode hatGewonnen() beendet.");
        return false;
    }

    /**
     * Getter-Methode fuer aFeld, also Anfangsfeld
     *
     * @return aFeld
     */
    @Override
    public Feld getafeld() {
        return aFeld;
    }

    /**
     * Getter-Methode fuer ArrayList Felder
     *
     * @return null
     */
    @Override
    public List<Feld> getFelder() {
        return null;
    }

    /**
     * Getter-Methode fuer Spiel
     *
     * @return dasSpiel
     */
    @Override
    public Spiel getSpiel() {
        return this.dasSpiel;
    }

    /**
     * Getter-Methode fuer zeFeld, also Zieleintrittsfeld
     *
     * @return zeFeld
     */
    @Override
    public Feld getzefeld() {

        return zeFeld;
    }

    /**
     * Getter-Methode fuer farbe, gibt jeweilige Farbe der Figur zurueck
     *
     * @return Farbe
     */
    @Override
    public String getfarbe() {
        return this.Farbe;
    }

    /**
     * Getter-Methode fuer Zielfeld
     *
     * @return zielfeld
     */
    @Override
    public Feld getzielfeld() {
        return zielfeld;
    }

    /**
     * Getter-Methode fuer Spielfiguren, gibt Array mit den mitspielenden
     * Figuren zurueck
     *
     * @return Spielfiguren
     */
    @Override
    public Spielfigur[] getSpielfiguren() {
        return Spielfiguren;
    }

    /**
     * Getter-Methode fuer Objektname, kann auch Farbe der jeweiligen Figur sein
     *
     * @return the farbe, objektname
     */
    @Override
    public String getobjektname() {
        log.log(objektname, "Methode getobjektname() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + objektname);
        log.log(objektname, "Methode getobjektname() beendet.");
        return objektname;
    }

    @Override
    public int getgezogen() {
        return this.gezogen;
    }

    @Override
    public void setgezogen(int c) {
        this.gezogen = c;
    }

    /**
     * Die Methode setz die verbleidenen Züge auf 1 oder 3 jenachdem ob alle
     * Spielfiguren noch im Startkreis sind.
     *
     *
     */
    public void VerbleideneZügeErrechnen() {
        if (this.alleSpielerImStartkreis()) {
            this.verbleideneZüge = 3;
        } else {
            this.verbleideneZüge = 1;

        }

    }

    /**
     * Prüft ob sich die Spielfigur begwegen kann und bewegt diese
     * gegebenenfalls. 0 = Konnte sich bewegen. 1 = Kann sich nicht bewegen.
     *
     * @param Spielfigur
     * @return
     */
    public int SpielfigurZiehen(int Spielfigur) {
        if(this.SpielfigurZugMöglich(Spielfigur))
       {
       this.Spefigur = this.Spielfiguren[Spielfigur];
       }
       return 1;
        
        
        
        /**
        int SpielfigurIndex = Spielfigur--;
        if (this.verbleideneZüge != 0) {
            Spielfigur AusgewählteSpielfigur = this.getSpielfiguren()[SpielfigurIndex];
            List<Spielfigur> moeglSpielfiguren = this.moeglSpielfiguren(dasSpiel.getWuerfel().getZahl());
            if (moeglSpielfiguren.contains(AusgewählteSpielfigur)) {
                AusgewählteSpielfigur.laufen(dasSpiel.getWuerfel().getZahl());
                verbleideneZüge--;
                return 0;
            } else {
                return 1;

            }

        }
        return 1;
        * */
    }

    public int getVerbleideneZüge() {
        return this.verbleideneZüge;
    }

    /**
     * Überprüft ob sich die Spielfigur bewegen kann.
     *
     * @param Spielfigur
     * @return
     */
    public boolean SpielfigurZugMöglich(int Spielfigur) {
        /*int SpielfigurIndex = Spielfigur--;
        if (this.verbleideneZüge != 0) {
            Spielfigur AusgewählteSpielfigur = this.getSpielfiguren()[SpielfigurIndex];
            List<Spielfigur> moeglSpielfiguren = this.moeglSpielfiguren(dasSpiel.getWuerfel().getZahl());
            if (moeglSpielfiguren.contains(AusgewählteSpielfigur)) {
                return true;
            }

        }
        return false;*/
        
         List<Spielfigur> moeglSpielfiguren = this.moeglSpielfiguren(this.dasSpiel.getWuerfel().getZahl());
        
        return this.Spielfiguren[Spielfigur].kannSichBewegen(this.dasSpiel.getWuerfel().getZahl()) && moeglSpielfiguren.contains(this.Spielfiguren[Spielfigur]);
    }
    
    
     public Spielfigur spielfigWaehlen() {
        while (true) {
        
       if (this.Spefigur != null){
       return Spefigur;
       }
        
    }
    }


}
