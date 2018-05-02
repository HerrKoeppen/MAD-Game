/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

/**
 * Die Klasse SpielerMensch beinhaltet zum einen, den Namen der Spieler, die
 * Farbe, die den Spielern momentan zu geordnet ist und ordnet die Spielfiguren
 * (jeder besitzt 4 Spielfiguren) den Spielern zu.
 *
 * @author Commander
 */
public class SpielerComputer implements Spieler {

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

    /**
     * Logger zu Diagnosezwecken
     */
    private Logger log;
    private String objektname;

    public SpielerComputer(String oname, Logger logger, Spiel dasspiel) {
        objektname = oname;
        log = logger;
        log.log(objektname, "konstrucktor SpielerMensch() gestartet.");
        this.dasSpiel = dasspiel;
        this.id = this.dasSpiel.setSpieler(this);
        this.Farbe = this.dasSpiel.Farben[id];
        log.log(objektname, "Spieler hat die Farbe: " + Farbe);

        switch (Farbe.toLowerCase()) { // sehr uneleganter Switch: nochmal überarbeiten!!!!!!!
            case "blau":
                this.aFeld = this.dasSpiel.getSpielbrett().getFelder().get(0);
                this.zeFeld = this.dasSpiel.getSpielbrett().getFelder().get(41);
                this.zielfeld = this.dasSpiel.getSpielbrett().getFelder().get(42);
                break;
            case "rot":
                this.aFeld = this.dasSpiel.getSpielbrett().getFelder().get(6);
                this.zeFeld = this.dasSpiel.getSpielbrett().getFelder().get(5);
                this.zielfeld = this.dasSpiel.getSpielbrett().getFelder().get(45);
                break;
            case "gruen":
                this.aFeld = this.dasSpiel.getSpielbrett().getFelder().get(12);
                this.zeFeld = this.dasSpiel.getSpielbrett().getFelder().get(11);
                this.zielfeld = this.dasSpiel.getSpielbrett().getFelder().get(48);
                break;
            case "pink":
                this.aFeld = this.dasSpiel.getSpielbrett().getFelder().get(18);
                this.zeFeld = this.dasSpiel.getSpielbrett().getFelder().get(17);
                this.zielfeld = this.dasSpiel.getSpielbrett().getFelder().get(51);
                break;
            case "gelb":
                this.aFeld = this.dasSpiel.getSpielbrett().getFelder().get(24);
                this.zeFeld = this.dasSpiel.getSpielbrett().getFelder().get(23);
                this.zielfeld = this.dasSpiel.getSpielbrett().getFelder().get(54);
                break;
            case "schwarz":
                this.aFeld = this.dasSpiel.getSpielbrett().getFelder().get(30);
                this.zeFeld = this.dasSpiel.getSpielbrett().getFelder().get(29);
                this.zielfeld = this.dasSpiel.getSpielbrett().getFelder().get(57);
                break;
            case "tuerkis":
                this.aFeld = this.dasSpiel.getSpielbrett().getFelder().get(36);
                this.zeFeld = this.dasSpiel.getSpielbrett().getFelder().get(35);
                this.zielfeld = this.dasSpiel.getSpielbrett().getFelder().get(60);
                break;

            default:
                break;
        }
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

    public void ziehen2(int gezogen) {
        log.log(objektname, "Methode ziehen() gestartet.");
        //habe ich gewonnen? Wenn nein, dann mache ich einen normalen Zug
        if (gezogen < 3) {
            if (!this.hatGewonnen()) {
                System.out.println(this.objektname + " ist am Zug");
                //habe ich nur Spielfiguren im Startkreis
                if (this.SpielerImStartkreis()) {
                    System.out.println(this.objektname + " darf 3mal wuerfeln");
                    //-> ja, dann bis zu dreimal würfeln und hoffe auf eine 6
                    for (int i = 0; i < 3; i++) {

                        // ist es eine 6?
                        if (this.wuerfeln() == 6) {
                            //schlagen --> geschlagene Figur kommt auf den Startkreis zurück
                            //this.Spielfiguren[0].schlagen(aFeld);
                            //Spielfigur auf das A-Feld setzen
                            this.Spielfiguren[0].herauskommen();
                            System.out.println(this.objektname + " kommt raus.");
                            //nochmal würfeln
                            this.Spielfiguren[0].laufen(this.wuerfeln());

                            if (this.dasSpiel.getWuerfel().getZahl() == 6) {
                                System.out.println(this.Name + " ist nochmal am Zug.");
                                this.ziehen(gezogen++);

                            }

                            return;

                        }
                    }
                    return;
                } //-> nein, einmal würfeln
             else {  //unnoetige zeile aber lieber doppelt als keinmal
               
                int Random = this.wuerfeln();
        
                
                List<Spielfigur> moeglSpielfiguren = this.moeglSpielfgiguren(Random);
                if(moeglSpielfiguren.isEmpty()) {
                    System.out.println(this.objektname +" kann nicht ziehen.Muhahaha(böses Lachen)");
                    return;
                       
                  }else{
                  
                    moeglSpielfiguren.get(0).laufen(Random);
                    if (Random == 6) {
                    this.ziehen(gezogen++);
                    }
                }
              
                
                
                }           
    }
        }
    }
    
            

    public List<Spielfigur> moeglSpielfgiguren(int ZuLaufendeFeldanzahl) {
        List<Spielfigur> moeglSpielfiguren = new LinkedList<Spielfigur>();
        List<Spielfigur> DPflichtSpielfiguren = new LinkedList<Spielfigur>();
        for (int i = 0; i < this.Spielfiguren.length; i++) {
            //Wenn die Spielfigur ziehen kann.
            if (Spielfiguren[i].getPrioritaet(ZuLaufendeFeldanzahl) == 1) {
                moeglSpielfiguren.add(Spielfiguren[i]);

                //Wenn die Spielfigur ziehen muss    
            } else if (Spielfiguren[i].getPrioritaet(ZuLaufendeFeldanzahl) == 2) {
                DPflichtSpielfiguren.add(Spielfiguren[i]);

                //Wenn die Spielfigur doppelt ziehen muss.    
            } else if (Spielfiguren[i].getPrioritaet(ZuLaufendeFeldanzahl) == 3) {
                List<Spielfigur> DDPflichtSpielfiguren = new LinkedList<Spielfigur>();
                DDPflichtSpielfiguren.add(Spielfiguren[i]);
                return DDPflichtSpielfiguren;

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
    public void ziehen(int gezogen) {
        log.log(objektname, "Methode ziehen() gestartet.");
        //habe ich gewonnen? Wenn nein, dann mache ich einen normalen Zug
        if (gezogen < 3) {
            if (!this.hatGewonnen()) {
                System.out.println(this.objektname + " ist am Zug");
                //habe ich nur Spielfiguren im Startkreis
                if (this.SpielerImStartkreis()) {
                    System.out.println(this.objektname + " darf 3mal wuerfeln");
                    //-> ja, dann bis zu dreimal würfeln und hoffe auf eine 6
                    for (int i = 0; i < 3; i++) {

                        // ist es eine 6?
                        if (this.wuerfeln() == 6) {
                            //schlagen --> geschlagene Figur kommt auf den Startkreis zurück
                            //this.Spielfiguren[0].schlagen(aFeld);
                            //Spielfigur auf das A-Feld setzen
                            this.Spielfiguren[0].herauskommen();
                            System.out.println(this.objektname + " kommt raus.");
                            //nochmal würfeln
                            this.Spielfiguren[0].laufen(this.wuerfeln());

                            if (this.dasSpiel.getWuerfel().getZahl() == 6) {
                                System.out.println(this.Name + " ist nochmal am Zug.");
                                this.ziehen(gezogen++);

                            }

                            return;

                        }
                    }
                    return;
                } //-> nein, einmal würfeln
                else {

                    int augen = this.wuerfeln();
                    //kann eine Spielfigur diesen Wurf durchführen?
                    List<Spielfigur> moegSpielfig = new LinkedList<Spielfigur>();
                    boolean zugmoeglich = false;
                    for (Spielfigur fig : Spielfiguren) {
                        //--> Spielfigur: kannSichBewegen(int felderAnzahl)
                        if (fig.kannSichBewegen(augen)) {
                            moegSpielfig.add(fig);
                            zugmoeglich = true;

                        }
                        if (zugmoeglich) {

                            moegSpielfig.get(0).laufen(augen);
                            if (augen == 6) {
                                this.ziehen(gezogen++);
                            }
                            return;

                            //int x = 1;
///////////////////////////////////////////////////////////////////////////////////        
//Spielfigur wählen (Pflichten beachten!!!!!!)
                            // 1. Schlagpflicht (wichtigste Pflicht)
                            // 2. Figur von Startfeld auf A-Feld, bei 6
                            // 3. Figur von A-Feld wegsetzen, sofern noch Figuren im Startkreis
                            // 4. Einruecken in Zielfeld
                            //Zug mit doppelter Pflicht vor Zug mit einfacher Pflicht
//Spielfigur vorrücken
                            //moegSpielfig.get(x).laufen(augen);
                            //nochmal würfeln
                        }
                        if (augen == 6) {
                            ziehen(gezogen++);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
        //ich habe doch schon gewonnen: ich mache nichts
        log.log(objektname, "Methode ziehen() beendet.");

    }

    @Override
    /**
     * Methode, um zu wuerfeln
     *
     * @return augenzahl
     */
    public int wuerfeln() {
        log.log(objektname, "Methode wuerfeln() gestartet.");
        int augenzahl = this.dasSpiel.getWuerfel().wuerfeln();
        log.log(objektname, "Methodenrückgabe: " + augenzahl);
        log.log(objektname, "Methode wuerfeln() beendet.");
        return augenzahl;
    }

    /**
     * Die Methode gibt an, ob sich alle Spielfiguren auf den Startfeldern
     * befinden.
     *
     * @return Boolean
     */
    public boolean SpielerImStartkreis() {
        log.log(objektname, "Methode hatGewonnen() gestartet.");
        for (Spielfigur i : Spielfiguren) {
            if (!i.isAufstartfeld()) {
                log.log(objektname, "Methodenrückgabe: " + false);
                log.log(objektname, "Methode SpielerImStartkreis() beendet.");

                return false;
            }
        }
        log.log(objektname, "Methodenrückgabe: " + true);
        log.log(objektname, "Methode hatGewonnen() beendet.");
        return true;

    }

    @Override
    /**
     * Getter-Methode fuer aFeld, also Anfangsfeld
     *
     * @return aFeld
     */
    public Feld getafeld() {
        return aFeld;
    }

    @Override
    /**
     * Getter-Methode fuer ArrayList Felder
     *
     * @return null
     */
    public List<Feld> getFelder() {
        return null;
    }

    @Override
    /**
     * Getter-Methode fuer Spiel
     *
     * @return dasSpiel
     */
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
    public String getobjektname() {
        log.log(objektname, "Methode getobjektname() gestartet.");
        log.log(objektname, "Methodenrückgabe: " + objektname);
        log.log(objektname, "Methode getobjektname() beendet.");
        return objektname;
    }

}
