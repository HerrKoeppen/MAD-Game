package model;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Beste KLasse der Weld super legitim und so 
 * need more Space.
 * @author Commander
 */
public class SpielbrettAusgabe {
    
    // Fetter ANSI ESCAPE CODE :
    private static final String ANSI_RESET = "\u001B[0m"; //ANSI escape command wie in C ^^
    
    private static final String ANSI_fBlack = "\u001B[30m"; 
    private static final String ANSI_fRed = "\u001B[31m";
    private static final String ANSI_fGreen = "\u001B[32m";
    private static final String ANSI_fYellow = "\u001B[33m";
    private static final String ANSI_fBlue = "\u001B[34m";
    private static final String ANSI_fPurpel = "\u001B[35m";
    private static final String ANSI_fCyan = "\u001B[36m";
    private static final String ANSI_fWhite = "\u001B[37m";
   
    private static final String ANSI_bWhite = "\u001B[40m"; 
    private static final String ANSI_bRed = "\u001B[41m";
    private static final String ANSI_bGreen = "\u001B[42m";
    private static final String ANSI_bYellow = "\u001B[43m";
    private static final String ANSI_bBlue = "\u001B[44m";
    private static final String ANSI_bPurpel = "\u001B[45m";
    private static final String ANSI_bCyan = "\u001B[46m";
    private static final String ANSI_bGrey = "\u001B[47m";
    
    private final String[] fColor = { ANSI_fBlue, ANSI_fRed, ANSI_fCyan, ANSI_fPurpel, ANSI_fYellow, ANSI_fGreen, ANSI_fWhite, ANSI_fBlack };
    
    private static final int groesseX = 21 ; 
    private static final int groesseY = 25 ;
    
    private String[][] AnsiSpielbrett = new String[groesseX][groesseY];
    public boolean Ansiausgabean ;
    Logger log;
    private Spiel dasSpiel;
    private String objektname;
    
            
    
          /**| a| b| c| d| e| f| g| h| i| j| k| l| m| n| o| p| q| r| s| t| u| v| 
     * | 1|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  
     * | 2|  |  |  |  |  |  |  |  |  |  |  |AB|  |  |  |  |  |  |  |  |  |  |  
     * | 3|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  | 
     * | 4|  |  |  |  |  |  |  |  |  |  |SW|  |SW|  |  |  |  |  |  |  |  |  | 
     * | 5|  |  |  |  |  |  |  |  |. |. |. |. |. |. |. |. |. |. |. |. |. |. | 
     * | 6|. |. |AB|. |. |. |. |. |. |SW|. |. |. |SW|. |. |. |..|. |. |AR|. | 
     * | 7|. |. |. |. |SW|. |. |. |. |. |. |. |. |. |. |. |. |. |SW|. |. |. | 
     * | 8|. |. |..|. |..|. |SW|. |. |. |. |. |. |. |. |. |SW|. |. |. |. |. | 
     * | 9|. |. |. |SW|. |. |. |. |. |SW|. |. |..|SW|. |. |. |. |. |SW|. |. | 
     * |10|. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. |. | 
     * |11|. |. |. |. |SW|. |. |. |. |. |. |. |. |. |. |. |. |. |SW|. |. |. | 
     * |12|. |. |. |. |. |. |. |. |. |..| .|. |. |. |. |. |. |. |. |. |. |. | 
     * |13|. |. |. |. |. |. |SW|. |. |. |. |. |. |. |. |. |SW|. |. |. |..|. | 
     * |14|. |. |. |. |SW|. |. |. |. |. |. |. |. | .| .| .| .| .|SW| .| .|. | 
     * |15|. |. |SW|. |. |..|. |. |. | .| .| .|. |. |. |. |. |. |. | .|SW| .| 
     * |16|. |AS|. |. |. |. |. |. |. |. | .| .| .| .| .|. |..| .| .| .|. |AG| 
     * |17|. |. | .| .|. |. | .| .| .| .| .| .| .| .| .| .| .|. | .| .| .|. | 
     * |18|. |. |..|SW|. |SW|. |SW|. | .|. |. |. |. |. |SW|. |SW|. |SW|. |. | 
     * |19|. |. | .| .| .| .| .| .| .| .| .|..|. |. |. |. |. |. |. |. |. |. | 
     * |20|. |. | .| .| .| .| .| .| .| .| .|SW| .| .| .| .| .| .| .| .| .| .|
     * |21|. |. | .| .| .| .|. |SW| .| .| .| .|. |. | .|SW|. | .| .| .| .| .| 
     * |22|. |. | .| .| .| .| .| .| .| .|SW| .|SW| .| .| .| .| .| .| .| .| .| 
     * |23|. |. | .| .|. |..| .|SW| .|. |. |. | .| .| .|SW| .| .|..|. |. |. | 
     * |24|. |. | .| .| .| .| .|. | .|SW| .| .| .|SW| .| .| .| .| .| .| .| .| 
     * |25|. |. | .| .|..| .|. |. |. |. |. |. |. | .|. |. |. |. |. |. |. |. | 
     * |26|. |. | .| .| .| .| .|AP|. |. |. | .| .| .|..|AG| .| .| .| .| .| .| 
     **/

    public SpielbrettAusgabe(Spiel soNSpiel, Logger logger, String oname) {
    /*Char[][] AsciiSpielbrett = {{"..............................................................................."},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}};*/
    //way more elegant:
    this.dasSpiel = soNSpiel;
    this.objektname = oname;
    log = logger;
    for (int i = 0; i < groesseX;i++){
            for (int k = 0; k < groesseY ;k++){
                this.AnsiSpielbrett[i][k]= ANSI_RESET +ANSI_bGrey +ANSI_fWhite +"  " ;   //+ ANSI_fBlue ANSI_RESET
        }
    }
    this.sternZeichnen();
    this.Ansiausgabean = true;
    }
    public void feldeinfuegen(Feld dasFeld){
    log.log(objektname,"Methode feldeinfuegen() gestartet mit parameter "+ dasFeld + ".");
    String farbe = "s";
    switch (dasFeld.getFarbe().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "blau":
            farbe = ANSI_bBlue+"  "  ;    
                break;
            case "rot":
            farbe = ANSI_bRed+"  "  ;  
                break;
            case "cyan":
            farbe = ANSI_bCyan+"  "  ;    
                break;
            case "gelb":
            farbe = ANSI_bYellow+"  "  ;
                break;
            case "pink":
            farbe = ANSI_bPurpel+"  "  ;    
                break;
            case "schwarz":
            farbe = ANSI_bWhite+"§§"  ;    
                break;
            case "orange":
            case "braun":
            farbe = ANSI_bGreen+"  "  ;   
                break;
            case "weiss":
            farbe = ANSI_RESET + "  "  ;    
                break;
            default:
                break;
        }
    String Caption ="w";
    switch (dasFeld.getFeldtyp().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "start":
            case "startfeld":
            case "sfeld":
                Caption = "";
                break;
            case "a":
            case "afeld":
            case "a-feld":
            case "anfangsfeld":
                Caption = "";
                break;
            case "ziel":
            case "zfeld":
            case "zielfeld":
                Caption = "";
                break;
            case "standart":
            case "standartfeld":
            case "standardfeld":
                Caption = "";
                break;
            case "efeld":
            case "zefeld":
                Caption = "";
                break;
            default:
                Caption = "";
                break;
        }
    this.AnsiSpielbrett[dasFeld.getPositionX()][dasFeld.getPositionY()] = ANSI_RESET + farbe + Caption ;  
    log.log(objektname, "Methodenrückgabe: " + ANSI_RESET + farbe + Caption );
        log.log(objektname, "Methode feldeinfuegen() beendet.");
    
    }
    /* X und Y achse vertauscht: (100% gewollt, sieht aber wirklich besser aus)
    * ..............................SA..................
    * ........GA................WS......................
    * ..............WS................WS................
    * ..........WS......WS....WS........................
    * ................................WS................
    * ............WS........WS..........................
    * ................................WS....WS..WS....GA
    * ..................................................
    * ........WS....WS............................WS....
    * ....WS..................................WS........
    * BA..................................WS............
    * ....WS..................................WS........
    * ........WS....WS............................WS....
    * ..................................................
    * ................................WS....WS..WS....PA
    * ............WS........WS..........................
    * ................................WS................
    * ..........WS......WS....WS........................
    * ..............WS................WS................
    * ........RS................WS......................
    * ..............................CA..................*/
    
    public void spielAusgabe(){
       System.out.println("\u001B[0m\u001B[35mA\u001B[34mN\u001B[36mS\u001B[32mI\u001B[0m-\u001B[33mS\u001B[31mp\u001B[35mi\u001B[34me\u001B[36ml\u001B[32mb\u001B[33mr\u001B[31me\u001B[35mt\u001B[36mt\u001B[0m steht bereit:\u001B[0m");
       if(this.Ansiausgabean){
        for (int i = 0; i<groesseX;i++){
            for (int k = 0; k<groesseY;k++){
            System.out.print(AnsiSpielbrett[i][k]);    
        }
            System.out.println();
        }
    } 
    }
    private void sternZeichnen(){
        String ccaption = "::";
        String farbe =ANSI_RESET + ANSI_bGrey;//ANSI_RESET  +ANSI_fWhite;
        this.AnsiSpielbrett[11][1] = farbe  + ccaption ;
        this.AnsiSpielbrett[12][3] = farbe + ccaption;
        this.AnsiSpielbrett[12][5] = farbe + ccaption ;
        this.AnsiSpielbrett[12][6] = farbe  + ccaption ;
        this.AnsiSpielbrett[13][7] = farbe  + ccaption ;
        this.AnsiSpielbrett[14][6] = farbe  + ccaption ;
        this.AnsiSpielbrett[16][5] = farbe + ccaption ;
        this.AnsiSpielbrett[18][4] = farbe + ccaption ;
        this.AnsiSpielbrett[19][5] = farbe + ccaption ;
        this.AnsiSpielbrett[18][6] = farbe + ccaption ;
        this.AnsiSpielbrett[17][8] = farbe + ccaption ;
        this.AnsiSpielbrett[16][10] = farbe + ccaption ;
        this.AnsiSpielbrett[16][12] = farbe + ccaption ; 
        this.AnsiSpielbrett[18][12] = farbe  + ccaption ;
        this.AnsiSpielbrett[20][14] = farbe + ccaption;
        this.AnsiSpielbrett[19][16] = farbe + ccaption ;
        this.AnsiSpielbrett[17][16] = farbe + ccaption ;
        this.AnsiSpielbrett[15][16] = farbe  + ccaption ;
        this.AnsiSpielbrett[14][17] = farbe  + ccaption ;
        this.AnsiSpielbrett[14][18] = farbe + ccaption ;
        this.AnsiSpielbrett[14][20] = farbe  + ccaption ;
        this.AnsiSpielbrett[14][22] = farbe  + ccaption ;
        this.AnsiSpielbrett[14][23] = farbe + ccaption ;
        this.AnsiSpielbrett[13][23] = farbe + ccaption ;
        this.AnsiSpielbrett[12][21] = farbe + ccaption ;
        this.AnsiSpielbrett[10][19] = farbe  + ccaption ;

        this.AnsiSpielbrett[9][1] = farbe  + ccaption ;
        this.AnsiSpielbrett[8][3] = farbe + ccaption ;
        this.AnsiSpielbrett[8][5] = farbe  + ccaption ;
        this.AnsiSpielbrett[8][6] = farbe  + ccaption ;
        this.AnsiSpielbrett[7][7] = farbe  + ccaption ;
        this.AnsiSpielbrett[6][6] = farbe  + ccaption ;
        this.AnsiSpielbrett[4][5] = farbe  + ccaption ;
        this.AnsiSpielbrett[2][4] = farbe  + ccaption ;
        this.AnsiSpielbrett[1][5] = farbe  + ccaption ;
        this.AnsiSpielbrett[2][6] = farbe  + ccaption ;
        this.AnsiSpielbrett[3][8] = farbe  + ccaption ;
        this.AnsiSpielbrett[4][10] = farbe  + ccaption ;
        this.AnsiSpielbrett[4][12] = farbe  + ccaption ; 
        this.AnsiSpielbrett[0][14] = farbe  + ccaption ;
        this.AnsiSpielbrett[2][12] = farbe  + ccaption ;
        this.AnsiSpielbrett[1][16] = farbe  + ccaption ;
        this.AnsiSpielbrett[3][16] = farbe  + ccaption ;
        this.AnsiSpielbrett[5][16] = farbe  + ccaption ;
        this.AnsiSpielbrett[6][17] = farbe  + ccaption ;
        this.AnsiSpielbrett[6][18] = farbe  + ccaption ;
        this.AnsiSpielbrett[6][20] = farbe  + ccaption ;
        this.AnsiSpielbrett[6][22] = farbe  + ccaption ;
        this.AnsiSpielbrett[6][23] = farbe  + ccaption ;
        this.AnsiSpielbrett[7][23] = farbe  + ccaption ;
        this.AnsiSpielbrett[8][21] = farbe  + ccaption ;
    
    };
    
    public void wuerfelausgeben(int augen)
    {
        for (int i = 9; i < 12 ;i++){
            for (int k = 12; k < 15 ;k++){
                this.AnsiSpielbrett[i][k] = ANSI_RESET  +ANSI_bGrey +"  ";   //+ ANSI_fBlue ANSI_RESET
        }
        String ccaption = "QQ";
         Random rand = new Random();
        int fau = rand.nextInt(6);
        String farbe =ANSI_RESET  +ANSI_bGrey   + this.fColor[fau];
       
        
        switch (augen) { 
            case 1:
            //farbe = farbe + ANSI_fBlue;
            this.AnsiSpielbrett[10][13] =farbe  + ccaption ;
                break;
            case 2:
            //farbe = farbe + ANSI_fRed;
            this.AnsiSpielbrett[9][14] =farbe  + ccaption ;
            this.AnsiSpielbrett[11][12] =farbe  + ccaption ;
                break;
            case 3:
            //farbe = farbe + ANSI_fCyan;
            this.AnsiSpielbrett[9][14] =farbe  + ccaption ;
            this.AnsiSpielbrett[11][12] =farbe  + ccaption ;
            this.AnsiSpielbrett[10][13] =farbe  + ccaption ;
                break;
            case 4:
            //farbe = farbe + ANSI_fPurpel;
            this.AnsiSpielbrett[9][14] =farbe  + ccaption ;
            this.AnsiSpielbrett[11][12] =farbe  + ccaption ;
            this.AnsiSpielbrett[9][12] =farbe  + ccaption ;
            this.AnsiSpielbrett[11][14] =farbe  + ccaption ;
                break;
            case 5:
            //farbe = farbe + ANSI_fYellow;
            this.AnsiSpielbrett[10][13] =farbe  + ccaption ;
            this.AnsiSpielbrett[9][14] =farbe  + ccaption ;
            this.AnsiSpielbrett[11][12] =farbe  + ccaption ;
            this.AnsiSpielbrett[9][12] =farbe  + ccaption ;
            this.AnsiSpielbrett[11][14] =farbe  + ccaption ;
                break;
            case 6:
            //farbe = farbe + ANSI_fGreen;
            this.AnsiSpielbrett[9][14] =farbe  + ccaption ;
            this.AnsiSpielbrett[11][12] =farbe  + ccaption ;
            this.AnsiSpielbrett[9][12] =farbe  + ccaption ;
            this.AnsiSpielbrett[11][14] =farbe  + ccaption ;
            this.AnsiSpielbrett[10][12] =farbe  + ccaption ;
            this.AnsiSpielbrett[10][14] =farbe  + ccaption ;
            
                break;
            default:
                break;
        }
    
    }
    }
    public void SpielerSetzen(Spielfigur diefigur)
    {
        log.log(objektname, "Methode SpielerSetzen() gestartet.");
        if(diefigur != null && diefigur.getAktfeld() != null){
        Feld dasFeld = diefigur.getAktfeld();
        String farbe = ANSI_RESET;
        switch (dasFeld.getFarbe().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "blau":
            farbe = ANSI_bBlue  ;    
                break;
            case "rot":
            farbe = ANSI_bRed  ;  
                break;
            case "cyan":
            farbe = ANSI_bCyan  ;    
                break;
            case "gelb":
            farbe = ANSI_bYellow ;
                break;
            case "pink":
            farbe = ANSI_bPurpel;    
                break;
            case "schwarz":
            farbe = ANSI_bWhite;    
                break;
            case "orange":
            case "braun":
            farbe = ANSI_bGreen ;   
                break;
            case "weiss":
            farbe = ANSI_RESET   ;    
                break;
            default:
                break;
        }
        String Caption = "default";
        int nummer = 0;
        for (int i = 0; i < 3; i++ ){
            if (diefigur.getTeam().getSpielfiguren()[i].equals(diefigur)){
                nummer = i;
                break;
         }
        }
        //System.out.println(nummer);
        switch (diefigur.getFarbe().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "blau":
                farbe = farbe + ANSI_fBlue;
                Caption = "B"  ;    
                break;
            case "rot":
                farbe = farbe + ANSI_fRed;
                Caption = "R" ;  
                break;
            case "cyan":
            case "gruen":
                farbe = farbe + ANSI_fCyan;
                Caption = "C" ;    
                break;
            case "gelb":
                farbe = farbe + ANSI_fYellow;
                Caption = "G" ;
                break;
            case "pink":
                farbe = farbe + ANSI_fPurpel;
                Caption = "P" ;    
                break;
            case "schwarz":
                farbe = farbe + ANSI_fBlack;
                Caption =  "S" ;    
                break;
            case "orange":
            case "braun":
                farbe = farbe + ANSI_fGreen;
                Caption = "O" ;   
                break;
            default:
                break;
        }
         //System.out.println(Caption);
        
        
       
    this.AnsiSpielbrett[dasFeld.getPositionX()][dasFeld.getPositionY()] = ANSI_RESET + farbe + Caption + nummer;  
        log.log(objektname, "Methodenrückgabe: " + ANSI_RESET + farbe + ANSI_fWhite + Caption + nummer );
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
    
     public static void main(String args[]) {
     //System.out.println("\u001B[41m" + "\u001B[37m"  + "Hello World!" + "\u001B[0m");
     Logger log = new Logger("SherLog.txt");
     Spiel test = new Spiel(log,"testSpiel",0);
     test.output.spielAusgabe();
    // die 7 mitspieler
     Spieler tester = new SpielerMensch("Alice",log,test);
     Spieler tester2 = new SpielerMensch("Bob",log,test);
     Spieler tester3 = new SpielerMensch("Charly",log,test);
     Spieler tester4 = new SpielerMensch("Eve",log,test);
     Spieler tester5 = new SpielerMensch("Dave",log,test);
     Spieler tester6 = new SpielerMensch("Fynnia",log,test);
     Spieler tester7 = new SpielerMensch("Gargamel",log,test);
     test.output.SpielerSetzen(tester.getSpielfiguren()[1]);
     test.output.spielAusgabe();
     test.AlleSpielfiguren[0].herauskommen();
     test.output.spielAusgabe();
     test.output.wuerfelausgeben(1);
    
     for( int a = 0; a< 8 ; a++){
        test.getWuerfel().wuerfeln();
        test.AlleSpielfiguren[0].laufen(test.getWuerfel().wuerfeln());
        test.output.spielAusgabe();}
     
    
     /*
     test.AlleSpielfiguren[3].setzten(test.getSpielbrett().getFelder().get(7));
     test.output.spielAusgabe();
     test.AlleSpielfiguren[0].setzten(test.getSpielbrett().getFelder().get(3));
     test.output.spielAusgabe();


     test.AlleSpielfiguren[0].schlagen(test.getSpielbrett().getFelder().get(7));
     test.AlleSpielfiguren[0].setzten(test.getSpielbrett().getFelder().get(7));
     test.output.spielAusgabe();

     */
     
     
     }
}
    
