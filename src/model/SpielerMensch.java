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
     * den der Spieler sollte wissen, was er spielt.
     */
    private Spiel dasSpiel;
    /**
     * Eine Liste mit 4 Spielfiguren.
     */
    public Spielfigur[] Spielfiguren = new Spielfigur[4];

    /**
     * Logger zu Diagnosezwecken
     */
    private Logger log;
    private String objektname;

    public SpielerMensch(String oname, Logger logger) {
        objektname = oname;
        log = logger;
    }

    /**
     * Setzt die Spielfigur an die letzte Stelle der Liste Spielfiguren.
     *
     * @param Spielfigur
     */
    public void setzeSpielfigur(Spielfigur dieSpielfigur) {
        log.log(objektname, "Methode setzeSpielfigur() gestartet mit Parameter " + dieSpielfigur + " .");
        int i = 0;
        while (Spielfiguren[i] != null) {
            i++;
        }
        Spielfiguren[i] = dieSpielfigur;
        log.log(objektname, "Methode setzeSpielfigur() beendet.");

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
            if (i.gibAufZielfeld()) {
                log.log(objektname, "Methodenrückgabe: " + false);
                log.log(objektname, "Methode hatGewonnen() beendet.");
                return false;
            }
        }
        log.log(objektname, "Methodenrückgabe: " + true);
        log.log(objektname, "Methode hatGewonnen() beendet.");
        return true;
    }

    @Override
    public void ziehen(int gezogen) {
        log.log(objektname, "Methode ziehen() gestartet.");
        //habe ich gewonnen? Wenn nein, dann mache ich einen normalen Zug
        if(gezogen > 3){
        if (!this.hatGewonnen()){
             //habe ich nur Spielfiguren im Startkreis
            if(this.SpielerImStartkreis()){
              //-> ja, dann bis zu dreimal würfeln und hoffe auf eine 6
                for ( int i = 0; i > 3; i++ ) {
                    // ist es eine 6?
                    if(this.wuerfeln()==6){
                        gezogen++;
                        //schlagen --> geschlagene Figur kommt auf den Startkreis zurück
                        //this.Spielfiguren[0].schlagen(aFeld);
                        //Spielfigur auf das A-Feld setzen
                        this.Spielfiguren[0].herauskommen();
                        //nochmal würfeln
                        this.Spielfiguren[0].laufen(this.wuerfeln());
                        if(this.dasSpiel.gibWuerfel().gibZahl() == 6)
                            {this.ziehen(gezogen++);}
                        return;
                    }
                }
                return;
            }
            //-> nein, einmal würfeln
            else {  //unnoetige zeile aber lieber doppelt als keinmal
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
                }
                if(zugmoeglich){
                    if(moegSpielfig.size()==1){
                        moegSpielfig.get(0).laufen(augen);
                        if(augen == 6){
                            this.ziehen(gezogen++);
                        }
                        return;
                    }
                int x = 1;
///////////////////////////////////////////////////////////////////////////////////        
//Spielfigur wählen (Pflichten beachten!!!!!!)
        // 1. Schlagpflicht (wichtigste Pflicht)
        // 2. Figur von Startfeld auf A-Feld, bei 6
        // 3. Figur von A-Feld wegsetzen, sofern noch Figuren im Startkreis
        // 4. Einruecken in Zielfeld
        //Zug mit doppelter Pflicht vor Zug mit einfacher Pflicht
                 
//Spielfigur vorrücken
            moegSpielfig.get(x).laufen(augen);
            //nochmal würfeln
            }
             if(augen==6){
                 ziehen(gezogen++);
             }
            }
        }
        }
        //ich habe doch schon gewonnen: ich mache nichts
        log.log(objektname, "Methode ziehen() beendet.");

    }

    @Override
    public int wuerfeln() {
        log.log(objektname, "Methode wuerfeln() gestartet.");
        int augenzahl = this.dasSpiel.gibWuerfel().wuerfeln();
        log.log(objektname, "Methodenrückgabe: " + augenzahl);
        log.log(objektname, "Methode wuerfeln() beendet.");
        return augenzahl;
    }

    /**
     * Die Methode gibt an ob sich alle Spielfiguren auf den Startfeldern
     * befinden.
     *
     *
     *
     *
     * @returnSSS
     */
    public boolean SpielerImStartkreis() {
        log.log(objektname, "Methode SpielerImStartkreis() gestartet.");

        for (int i = 0; i < 4; i++) {
            if (this.Spielfiguren[i].isAufstartfeld() == true) {

            } else {
                log.log(objektname, "Methodenrückgabe: " + false);
                log.log(objektname, "Methode SpielerImStartkreis() beendet.");
                return false;

            }

        }
        log.log(objektname, "Methodenrückgabe: " + true);
        log.log(objektname, "Methode SpielerImStartkreis() beendet.");
        return true;

    }
    
    @Override
    public Feld gibafeld(){
    return aFeld;
    }

    @Override
    public Feld[] getFelder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Spiel gibSpiel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
