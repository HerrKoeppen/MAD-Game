  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 * Die Logger-Klasse erzeugt Ausgaben in eine Textdatei und dient dem
 * Verständnis des Programmablaufs.
 *
 * @author K
 */
public class Logger {

    /**
     * Das Attribut activated stellt Logger-Meldungen allgemein an oder aus.
     */
    private boolean activated;
    /**
     * Das Attribut writer stellt den Dateizugriff dar.
     */
    private FileWriter writer;

    /**
     * Startdardkonstruktor, der in die Datei log.txt schreibt.
     */
    
    private BufferedWriter bufferedWriter;
    public Logger() {
        activated = true;
        try {
            File logDatei = new File("log.txt");
            if (!logDatei.exists()){
                logDatei.createNewFile();
            }
            writer = new FileWriter(logDatei, true);
            bufferedWriter = new BufferedWriter(writer);
                        log("LoggerObjekt", "Log in Datei log.txt gestartet");

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * weiterer Konstruktor, der in eine beliebige Datei schreibt.
     *
     * @param filename Dateiname, als "Datei.txt" angeben!
     */
    public Logger(String filename) {
        activated = true;
        try {
            File logDatei = new File(filename);
            if (!logDatei.exists()){
                logDatei.createNewFile();
            }
            writer = new FileWriter(logDatei, true);
            bufferedWriter = new BufferedWriter(writer);
            log("LoggerObjekt", "Log in Datei "+filename+" gestartet");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Schreibt einen Log in die Logdatei. Ergänzt dazu die Systemzeit.
     *
     * @param objektname Name des Objekts, das die Nachricht auslöst
     * @param nachricht Nachricht, die das Objekt schreibt.
     */
    public void log(String objektname, String nachricht) {
        if (activated) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String uhrzeit = sdf.format(new Date());
            try {
                bufferedWriter.write(uhrzeit + " " + objektname + " : " + nachricht);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Stellt das loggen aus. Die Methode log() bewirkt dann nichts mehr.
     */
    public void deactivate() {
        activated = false;
    }

    /**
     * Stellt das loggen an. Die Methode log() schreibt jetzt wieder Inhalte in
     * die Logdatei.
     */
    public void activate() {
        activated = true;
    }

    /**
     * Schließt den Filewriter. Am Ende des Loggens einmal aufrufen. Weitere
     * Logs verursachen dann aber einen Fehler!
     */
    public void logBeenden() {
        try {
            log("LoggerObjekt","Log wird beendet.");
            bufferedWriter.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
