/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
     * Eine Liste mit 4 Spielfiguren.
     */
    public Spielfigur[] Spielfiguren = new Spielfigur[4];
    
    /**
     * Logger zu Diagnosezwecken
     */
    public Logger log;
    
    public SpielerMensch(Logger logger){
        log = logger;
    }

    /**
     * Setzt die Spielfigur an die letzte Stelle der Liste Spielfiguren.
     *
     * @param Spielfigur
     */
    public void setzeSpielfigur(Spielfigur Spielfigur) {
        int i = 0;
        while (Spielfiguren[i] != null) {
            i++;
        }
        Spielfiguren[i] = Spielfigur;

    }
    /**
     * ueberprueft, ob ein Spieler gewonnen hat (alle Spielfiguren im Zielkreis hat)
     * @return true, wenn der Spieler gewonnen hat, sonst false
     */
    public boolean hatGewonnen(){
        for (Spielfigur i : Spielfiguren){
        if (i.gibAufZielfeld() == false){
        return false;
        }
        }
        return true;
    }

    @Override
    public void ziehen() {
        //habe ich gewonnen? Wenn nein, dann mache ich einen normalen Zug
        
        //habe ich nur Spielfiguren im Startkreis
        //-> ja, dann bis zu dreimal würfeln und hoffe auf eine 6
            // ist es eine 6?
                //Spielfigur auf das A-Feld setzen
                //schlagen --> geschlagene Figur kommt auf den Startkreis zurück
                //nochmal würfeln
            //ist es keine 6 -> möglicherweise verbleibenden Wurf ausführen
        
        
        //-> nein, einmal würfeln
            // ist es eine 6? 
                //kann eine Spielfigur diesen Wurf durchführen?
                    //--> Spielfigur: kannSichBewegen(int felderAnzahl)
                //Spielfigur wählen (Pflichten beachten!!!!!!)
                    // 1. Schlagpflicht (wichtigste Pflicht)
                    // 2. Figur von Startfeld auf A-Feld, bei 6
                    // 3. Figur von A-Feld wegsetzen, sofern noch Figuren im Startkreis
                    // 4. Einruecken in Zielfeld
                    //Zug mit doppelter Pflicht vor Zug mit einfacher Pflicht
                //Spielfigur vorrücken
                //schlagen --> geschlagene Figur kommt auf den Startkreis zurück
                //nochmal würfeln
            //es ist keine 6
                //kann eine Spielfigur diesen Wurf durchführen?
                //Spielfigur wählen (Pflichten beachten!!!!!!)
                //Spielfigur wählen (Pflichten beachten!!!!!!)
                    // 1. Schlagpflicht (wichtigste Pflicht)
                    // 2. Figur von Startfeld auf A-Feld, bei 6
                    // 3. Figur von A-Feld wegsetzen, sofern noch Figuren im Startkreis
                    // 4. Einruecken in Zielfeld
                    //Zug mit doppelter Pflicht vor Zug mit einfacher Pflicht
                //Spielfigur vorrücken
                //schlagen --> geschlagene Figur kommt auf den Startkreis zurück
        
        //ich habe doch schon gewonnen: ich mache nichts
        
    }

    @Override
    public int wuerfeln() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
