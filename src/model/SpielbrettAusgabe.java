package model;

import java.io.*;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*                      ss    ::sa                  
 *        ca::    ss        ws    ::    ys          
 *        ::  ::we    ss  ::  sz  we        ys      
 *          wscz  ::ws    ws      ::    ys          
 *    cs    ::        ::  ::  sz  ws                
 *            ws  cz    ws        ::                
 *  cs  cs    ::              sz  ws::::ws::ws::::ya
 *              ::    cz                    yz  ::  
 *      ::ws::::ws                  yz  yz  ::we    
 *  ::we                                  ws      ps
 *ba    bz  bz  bz                    ws::    ps    
 *  ::ws                                  ws      ps
 *      ::ws::::ws                  pz  pz  ::ws    
 *              ::    rz                    pz  ::  
 *  bs  bs    ::              gz  ws::::ws::we::::pa
 *            ws  rz    ws        ::                
 *    bs    ::        ::  ::  gz  ws                
 *          werz  ::ws    ws      ::    gs          
 *        ::  ::ws    rs  ::  gz  ws        gs      
 *        ra::    rs        we    ::    gs          
 *                     rs    ::ga           
 *                                                                      @Johanna
 */
/**
 * Klasse SpielbrettAusgabe. Diese Klasse erzeugt eine einfache ANSI-Ausgabe des
 * Spielbrettes im Output. Ausserdem ermoeglicht sie eine Steuerung ueber die
 * Befehle: run, 1, 2 und 3.
 *
 * Was ist ANSI?
 *
 * ANSI steht fuer A merican N national S tandards I nstitute ANSI-Zeichencode
 * und ist die Erweiterung von ASCII (7 bits -> 128 zeichen) auf 8bit (->256
 * Zeichen).
 *
 * (Heutzutage beruft man sich eher auf den ISO Standard 8859-1, wobei dieser
 * nicht deckungsgleich zum urspruenglichen ANSI ist. Darum haelt sich der
 * Begriff ANSI zumindestens bei Windows-usern).
 *
 * Was ist eine ANSI-Escape-Sequenz?
 *
 * Schon im damaligen 7-bit system gab es Steuersequenzen(im Bereich dez(0-31))
 * bekannt als C0-Steuerzeichen. Mit dem 8-bit system kam auch eine Erweiterung
 * dieser Steuerzeichen -die C1-Steuerzeichen- dazu bzw. wurden Befehle über
 * Steuersequenzen hinzugefügt, da der Platz noch immer recht knapp war(sie
 * konnten also aus mehreren Zeichen/bits bestehen). diese waren, jedoch nicht
 * mehr mit den 7-bit system kompatiebel.Darum die ANSI-Escape-Commands. Zu fast
 * jedem C1 befehl gibt es ein ANSI-Escape-Aequivalent. "Escape" heißen diese,
 * da sie mit einem Escapezeichen eingeleitet werden.
 *
 * Wie Verhalten sich die Farben?
 *
 * Sind Hintergrund und schrifftfarbe gleich, so erscheint die Schrift weiss.
 * ...to be continued
 *
 * @author Commander
 */
public class SpielbrettAusgabe {

    /**
     * Statische Konstante: ANSI-Escapesequenz, welche alle Texteinstellungen in
     * der Konsole auf die Defaultwerte zuruecksetzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_RESET = "\u001B[0m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Schwarz setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fBlack = "\u001B[30m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Rot setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fRed = "\u001B[31m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Gruen setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fGreen = "\u001B[32m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Gelb setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fYellow = "\u001B[33m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Blau setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fBlue = "\u001B[34m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Magenta setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fPurpel = "\u001B[35m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Cyan setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fCyan = "\u001B[36m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Hellgrau/weiss setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fWhite = "\u001B[37m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Dunkelgrau setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fbBlack = "\u001B[30;1m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Hellrot setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fbRed = "\u001B[31;1m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Hellgruen setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fbGreen = "\u001B[32;1m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf ein helles Gelb setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fbYellow = "\u001B[33;1m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fbBlue = "\u001B[34;1m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Rosa setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fbPurpel = "\u001B[35;1m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Hellcyan setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fbCyan = "\u001B[36;1m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche die Schrifftfarbe der
     * Textausgabe auf Weiss setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_fbWhite = "\u001B[37;1m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche den Schriffthintergrund
     * der Textausgabe auf Weiss setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_bWhite = "\u001B[40m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche den Schriffthintergrund
     * der Textausgabe auf Rot setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_bRed = "\u001B[41m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche den Schriffthintergrund
     * der Textausgabe auf Gruen setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_bGreen = "\u001B[42m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche den Schriffthintergrund
     * der Textausgabe auf Gelb setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_bYellow = "\u001B[43m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche den Schriffthintergrund
     * der Textausgabe auf Blau setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_bBlue = "\u001B[44m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche den Schriffthintergrund
     * der Textausgabe auf Magenta setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_bPurpel = "\u001B[45m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche den Schriffthintergrund
     * der Textausgabe auf Cyan setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_bCyan = "\u001B[46m";
    /**
     * Statische Konstante: ANSI-Escapesequenz, welche den Schriffthintergrund
     * der Textausgabe auf Grau setzt.
     *
     * @see SpielbrettAusgabe
     */
    private static final String ANSI_bGrey = "\u001B[47m";
    /**
     * 
     */
    private final String[] fColor = {ANSI_fBlue, ANSI_fRed, ANSI_fCyan, ANSI_fPurpel, ANSI_fYellow, ANSI_fGreen, ANSI_fbBlue, ANSI_fbRed, ANSI_fbCyan, ANSI_fbPurpel, ANSI_fbYellow, ANSI_fbGreen, ANSI_fbWhite, ANSI_fbBlack};
    /**
     * groesseX ist eine Konstante (darum final) die die Elementanzahl der Array
     * AnsiSpielbrett[] und somit die Zeilen des Spielbrett bzw. die höhe
     * bestimmt.
     */
    private final int groesseX = 21;
    /**
     * groesseX ist eine Konstante (darum final) die die Elementanzahl der Array
     * AnsiSpielbrett[] und somit die Zeilen des Spielbrett bzw. die höhe
     * bestimmt.
     *
     * @see AnsiSpielbrett
     */
    private final int groesseY = 25;
    /**
     * hallo
     */
    private String[][] AnsiSpielbrett = new String[groesseX][groesseY];
    /**
     * 
     */
    public boolean Ansiausgabean;
    /**
     * 
     */
    Logger log;
    /**
     * 
     */
    private Spiel dasSpiel;
    /**
     * 
     */
    private String objektname;
    /**
     * 
     * @param soNSpiel
     * @param logger
     * @param oname 
     */
    public SpielbrettAusgabe(Spiel soNSpiel, Logger logger, String oname) {

        this.dasSpiel = soNSpiel;
        this.objektname = oname;
        log = logger;
        for (int i = 0; i < groesseX; i++) {
            for (int k = 0; k < groesseY; k++) {
                this.AnsiSpielbrett[i][k] = ANSI_RESET + ANSI_bGrey + ANSI_fWhite + "  ";   //+ ANSI_fBlue ANSI_RESET
            }
        }
        this.sternZeichnen();
        this.Ansiausgabean = true;
    }
    /**
     * 
     * @param dasFeld 
     */
    public void feldeinfuegen(Feld dasFeld) {
        log.log(objektname, "Methode feldeinfuegen() gestartet mit parameter " + dasFeld + ".");
        String farbe = "s";
        switch (dasFeld.getFarbe().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "blau":
                farbe = ANSI_bBlue + ANSI_fbBlue + "b";
                break;
            case "rot":
                farbe = ANSI_bRed + ANSI_fbRed + "r";
                break;
            case "gruen":
                farbe = ANSI_bGreen + ANSI_fbGreen + "g";
                break;
            case "gelb":
                farbe = ANSI_bYellow + ANSI_fbYellow + "y";
                break;
            case "pink":
                farbe = ANSI_bPurpel + "p";
                break;
            case "schwarz":
                farbe = ANSI_bWhite + "s";
                break;
            case "orange":
            case "tuerkis":
                farbe = ANSI_bCyan + ANSI_fbCyan + "c";
                break;
            case "weiss":
                farbe = ANSI_RESET + ANSI_fWhite + "w";
                break;
            default:
                break;
        }
        String Caption = "w";
        switch (dasFeld.getFeldtyp().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "start":
            case "startfeld":
            case "sfeld":
                Caption = "s";
                break;
            case "a":
            case "afeld":
            case "a-feld":
            case "anfangsfeld":
                Caption = "a";
                break;
            case "ziel":
            case "zfeld":
            case "zielfeld":
                Caption = "z";
                break;
            case "standard":
            case "standardfeld":
                Caption = "s";
                break;
            case "efeld":
            case "zefeld":
                Caption = "e";
                break;
            default:
                Caption = "";
                break;
        }
        this.AnsiSpielbrett[dasFeld.getPositionX()][dasFeld.getPositionY()] = ANSI_RESET + farbe + Caption;
        log.log(objektname, "Methodenrückgabe: " + ANSI_RESET + farbe + Caption);
        log.log(objektname, "Methode feldeinfuegen() beendet.");

    }
    /**
     * 
     */
    public void spielAusgabe() {
        System.out.println("\u001B[0m\u001B[35mA\u001B[34mN\u001B[36mS\u001B[32mI\u001B[0m-\u001B[33mS\u001B[31mp\u001B[35mi\u001B[34me\u001B[36ml\u001B[32mb\u001B[33mr\u001B[31me\u001B[35mt\u001B[36mt\u001B[0m steht bereit:\u001B[0m");
        if (this.Ansiausgabean) {
            for (int i = 0; i < groesseX; i++) {
                for (int k = 0; k < groesseY; k++) {
                    System.out.print(AnsiSpielbrett[i][k]);
                }
                System.out.println();
            }
        }
    }
    /**
     * 
     */
    private void sternZeichnen() {
        String ccaption = "::";
        String farbe = ANSI_RESET + ANSI_bGrey;//ANSI_RESET  +ANSI_fWhite;
        this.AnsiSpielbrett[11][1] = farbe + ccaption;
        this.AnsiSpielbrett[12][3] = farbe + ccaption;
        this.AnsiSpielbrett[12][5] = farbe + ccaption;
        this.AnsiSpielbrett[12][6] = farbe + ccaption;
        this.AnsiSpielbrett[13][7] = farbe + ccaption;
        this.AnsiSpielbrett[14][6] = farbe + ccaption;
        this.AnsiSpielbrett[16][5] = farbe + ccaption;
        this.AnsiSpielbrett[18][4] = farbe + ccaption;
        this.AnsiSpielbrett[19][5] = farbe + ccaption;
        this.AnsiSpielbrett[18][6] = farbe + ccaption;
        this.AnsiSpielbrett[17][8] = farbe + ccaption;
        this.AnsiSpielbrett[16][10] = farbe + ccaption;
        this.AnsiSpielbrett[16][12] = farbe + ccaption;
        this.AnsiSpielbrett[18][12] = farbe + ccaption;
        this.AnsiSpielbrett[20][14] = farbe + ccaption;
        this.AnsiSpielbrett[19][16] = farbe + ccaption;
        this.AnsiSpielbrett[17][16] = farbe + ccaption;
        this.AnsiSpielbrett[15][16] = farbe + ccaption;
        this.AnsiSpielbrett[14][17] = farbe + ccaption;
        this.AnsiSpielbrett[14][18] = farbe + ccaption;
        this.AnsiSpielbrett[14][20] = farbe + ccaption;
        this.AnsiSpielbrett[14][22] = farbe + ccaption;
        this.AnsiSpielbrett[14][23] = farbe + ccaption;
        this.AnsiSpielbrett[13][23] = farbe + ccaption;
        this.AnsiSpielbrett[12][21] = farbe + ccaption;
        this.AnsiSpielbrett[10][19] = farbe + ccaption;
        this.AnsiSpielbrett[9][1] = farbe + ccaption;
        this.AnsiSpielbrett[8][3] = farbe + ccaption;
        this.AnsiSpielbrett[8][5] = farbe + ccaption;
        this.AnsiSpielbrett[8][6] = farbe + ccaption;
        this.AnsiSpielbrett[7][7] = farbe + ccaption;
        this.AnsiSpielbrett[6][6] = farbe + ccaption;
        this.AnsiSpielbrett[4][5] = farbe + ccaption;
        this.AnsiSpielbrett[2][4] = farbe + ccaption;
        this.AnsiSpielbrett[1][5] = farbe + ccaption;
        this.AnsiSpielbrett[2][6] = farbe + ccaption;
        this.AnsiSpielbrett[3][8] = farbe + ccaption;
        this.AnsiSpielbrett[4][10] = farbe + ccaption;
        this.AnsiSpielbrett[4][12] = farbe + ccaption;
        this.AnsiSpielbrett[0][14] = farbe + ccaption;
        this.AnsiSpielbrett[2][12] = farbe + ccaption;
        this.AnsiSpielbrett[1][16] = farbe + ccaption;
        this.AnsiSpielbrett[3][16] = farbe + ccaption;
        this.AnsiSpielbrett[5][16] = farbe + ccaption;
        this.AnsiSpielbrett[6][17] = farbe + ccaption;
        this.AnsiSpielbrett[6][18] = farbe + ccaption;
        this.AnsiSpielbrett[6][20] = farbe + ccaption;
        this.AnsiSpielbrett[6][22] = farbe + ccaption;
        this.AnsiSpielbrett[6][23] = farbe + ccaption;
        this.AnsiSpielbrett[7][23] = farbe + ccaption;
        this.AnsiSpielbrett[8][21] = farbe + ccaption;

    }

    
    /**
     * 
     */
    public void MADsh() {
        String echo = "error";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println("echo>>");
            try {
                echo = br.readLine();
            } catch (IOException ex) {
                return;
            }
            if (echo.equals("esc")) {
                return;
            }
            System.out.println(echo);
        }
    }
    /**
     * 
     */
    public void echo() {
        String echo = "error";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("echo>>");
        try {
            echo = br.readLine();
        } catch (IOException ex) {

        }
        System.out.println(echo);
    }
    /**
     * 
     * @return 
     */
    public boolean wuerfeln() {
        String echo = "error";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println(">>Wuerfeln:");
            try {
                echo = br.readLine();
            } catch (IOException ex) {
                return false;
            }
            if (echo.equals("run")) {
                return true;
            }
            if (echo.equals("")) {
                return true;
            }
            if (echo.equals("esc")) {
                return false;
            }
            System.out.println("what's this?");
        }

    }

    public int Spielerwaehlen(List<Spielfigur> moegSpielfig) {
        String echo = "error";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);


        while (true) {
            System.out.print(">>Waehle einen Spielefiguren ");
            for(Spielfigur i: moegSpielfig){
            if ( i != null){
            System.out.print(i.getobjektname() + " ");
            }
            }
            System.out.println();
            try {
                echo = br.readLine();
            } catch (IOException ex) {
                return -1;
            }
            if (echo.equals("")) {
                return 0;}
            if (echo.equals("0")) {
                return 0;
            }
            if (echo.equals("1") && moegSpielfig.size() > 1) {
                return 1;
            }
            if (echo.equals("2") && moegSpielfig.size() > 2) {
                return 2;
            }
            if (echo.equals("esc")) {
                return -1;
            }
            System.out.println("what's this?");
        }

    }
    /**
     * 
     * @param augen 
     */
    public void wuerfelausgeben(int augen) {
        for (int i = 9; i < 12; i++) {
            for (int k = 12; k < 15; k++) {
                this.AnsiSpielbrett[i][k] = ANSI_RESET + ANSI_bGrey + "  ";   //+ ANSI_fBlue ANSI_RESET
            }
            String ccaption = "QQ";
            Random rand = new Random();
            int fau = rand.nextInt(11);
            String farbe = ANSI_RESET + ANSI_bGrey + this.fColor[fau];

            switch (augen) {
                case 1:
                    //farbe = farbe + ANSI_fBlue;
                    this.AnsiSpielbrett[10][13] = farbe + ccaption;
                    break;
                case 2:
                    //farbe = farbe + ANSI_fRed;
                    this.AnsiSpielbrett[9][14] = farbe + ccaption;
                    this.AnsiSpielbrett[11][12] = farbe + ccaption;
                    break;
                case 3:
                    //farbe = farbe + ANSI_fCyan;
                    this.AnsiSpielbrett[9][14] = farbe + ccaption;
                    this.AnsiSpielbrett[11][12] = farbe + ccaption;
                    this.AnsiSpielbrett[10][13] = farbe + ccaption;
                    break;
                case 4:
                    //farbe = farbe + ANSI_fPurpel;
                    this.AnsiSpielbrett[9][14] = farbe + ccaption;
                    this.AnsiSpielbrett[11][12] = farbe + ccaption;
                    this.AnsiSpielbrett[9][12] = farbe + ccaption;
                    this.AnsiSpielbrett[11][14] = farbe + ccaption;
                    break;
                case 5:
                    //farbe = farbe + ANSI_fYellow;
                    this.AnsiSpielbrett[10][13] = farbe + ccaption;
                    this.AnsiSpielbrett[9][14] = farbe + ccaption;
                    this.AnsiSpielbrett[11][12] = farbe + ccaption;
                    this.AnsiSpielbrett[9][12] = farbe + ccaption;
                    this.AnsiSpielbrett[11][14] = farbe + ccaption;
                    break;
                case 6:
                    //farbe = farbe + ANSI_fGreen;
                    this.AnsiSpielbrett[9][14] = farbe + ccaption;
                    this.AnsiSpielbrett[11][12] = farbe + ccaption;
                    this.AnsiSpielbrett[9][12] = farbe + ccaption;
                    this.AnsiSpielbrett[11][14] = farbe + ccaption;
                    this.AnsiSpielbrett[10][12] = farbe + ccaption;
                    this.AnsiSpielbrett[10][14] = farbe + ccaption;

                    break;
                default:
                    break;
            }

        }
    }
    /**
     * 
     * @param diefigur 
     */
    public void SpielerSetzen(Spielfigur diefigur) {
        log.log(objektname, "Methode SpielerSetzen() gestartet.");
        if (diefigur != null && diefigur.getAktfeld() != null) {
            Feld dasFeld = diefigur.getAktfeld();
            String farbe = ANSI_RESET;
            switch (dasFeld.getFarbe().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
                case "blau":
                    farbe = ANSI_bBlue;
                    break;
                case "rot":
                    farbe = ANSI_bRed;
                    break;
                case "gruen":
                    farbe = ANSI_bGreen;
                    break;
                case "gelb":
                    farbe = ANSI_bYellow;
                    break;
                case "pink":
                    farbe = ANSI_bPurpel;
                    break;
                case "schwarz":
                    farbe = ANSI_bWhite;
                    break;
                case "orange":
                case "tuerkis":
                    farbe = ANSI_bCyan;
                    break;
                case "weiss":
                    farbe = ANSI_RESET;
                    break;
                default:
                    break;
            }
            String Caption = "default";
            int nummer = 0;
            for (int i = 0; i < 3; i++) {
                if (diefigur.getTeam().getSpielfiguren()[i].equals(diefigur)) {
                    nummer = i;
                    break;
                }
            }
            //System.out.println(nummer);
            switch (diefigur.getFarbe().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
                case "blau":
                    farbe = farbe + ANSI_fBlue;
                    Caption = "B";
                    break;
                case "rot":
                    farbe = farbe + ANSI_fRed;
                    Caption = "R";
                    break;
                case "gruen":
                    farbe = farbe + ANSI_fGreen;
                    Caption = "C";
                    break;
                case "gelb":
                    farbe = farbe + ANSI_fYellow;
                    Caption = "G";
                    break;
                case "pink":
                    farbe = farbe + ANSI_fPurpel;
                    Caption = "P";
                    break;
                case "schwarz":
                    farbe = farbe + ANSI_fBlack;
                    Caption = "S";
                    break;
                case "cyan":
                case "tuerkis":
                    farbe = farbe + ANSI_fCyan;
                    Caption = "O";
                    break;
                default:
                    break;
            }
            //System.out.println(Caption);

            this.AnsiSpielbrett[dasFeld.getPositionX()][dasFeld.getPositionY()] = ANSI_RESET + farbe + Caption + nummer;
            log.log(objektname, "Methodenrückgabe: " + ANSI_RESET + farbe + ANSI_fWhite + Caption + nummer);
            log.log(objektname, "Methode SpielerSetzen() erfolgreich beendet.");
            return;
        }
        log.log(objektname, "Methodenrückgabe: " + false);
        log.log(objektname, "Methode SpielerSetzen() beendet.");
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
    /**
     * Test-methode
     * @param args 
     */
    public static void main(String args[]) {

        //der Schreiberling
        Logger log = new Logger("SherLog.txt");
        //das Spiel
        Spiel test = new Spiel(log, "testSpiel", 0);
        // die 7 mitspieler
        Spieler tester = new SpielerMensch("Azrael", log, test);
        Spieler tester2 = new SpielerMensch("Barbarianna", log, test);
        Spieler tester3 = new SpielerMensch("Charles der II", log, test);
        Spieler tester4 = new SpielerMensch("Dave", log, test);
        Spieler tester5 = new SpielerMensch("Eve", log, test);
        Spieler tester6 = new SpielerMensch("Fynnia", log, test);
        Spieler tester7 = new SpielerMensch("Gargamel", log, test);
        //eine Proto-Spielschleife
        for (int a = 0; a < 100; a++) {
            tester.ziehen2();
            /*tester2.ziehen2();
            tester3.ziehen2();
            tester4.ziehen2(); 
            tester5.ziehen2();
            tester6.ziehen2();
            tester7.ziehen2();
          &*/
              
        }
        test.output.spielAusgabe();

    }

}
