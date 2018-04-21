package model;

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
    
    private static final int groesseX = 21 ; 
    private static final int groesseY = 25 ;
    
    private String[][] AnsiSpielbrett = new String[groesseX][groesseY];
    public boolean Ansiausgabean ;
    
            
    
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

    public SpielbrettAusgabe() {
    /*Char[][] AsciiSpielbrett = {{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
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
    
    for (int i = 0; i < groesseX;i++){
            for (int k = 0; k < groesseY ;k++){
                this.AnsiSpielbrett[i][k]= ANSI_bGrey +ANSI_fWhite +"  " + ANSI_RESET ;   //+ ANSI_fBlue ANSI_RESET
        }
    }
    this.sternZeichnen();
    this.Ansiausgabean = true;
    }
    public void feldeinfuegen(Feld dasFeld){
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
            case "Startfeld":
                Caption = "";
                break;
            case "a":
            case "afeld":
            case "Afeld":
            case "A-Feld":
            case "Anfangsfeld":
            case "anfangsfeld":
                Caption = "";
                break;
            case "ziel":
            case "Zielfeld":
            case "zielfeld":
                Caption = "";
                break;
            case "standart":
            case "standartfeld":
            case "Standartfeld":
                Caption = "";
                break;
            case "eFeld":
            case "zeFeld":
            case "zefeld":
                Caption = "";
                break;
            default:
                Caption = "";
                break;
        }
    this.AnsiSpielbrett[dasFeld.getPositionX()][dasFeld.getPositionY()] = farbe + Caption + ANSI_RESET;  
    
    
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
       System.out.println("\u001B[35mA\u001B[34mN\u001B[36mS\u001B[32mI\u001B[0m-\u001B[33mS\u001B[31mp\u001B[35mi\u001B[34me\u001B[36ml\u001B[32mb\u001B[33mr\u001B[31me\u001B[35mt\u001B[36mt\u001B[0m steht bereit:\u001B[0m");
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
        this.AnsiSpielbrett[11][1] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[12][3] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[12][5] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[12][6] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[13][7] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[14][6] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[16][5] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[18][4] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[19][5] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[18][6] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[17][8] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[16][10] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[16][12] = ANSI_bGrey  + ccaption + ANSI_RESET; 
        this.AnsiSpielbrett[18][12] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[20][14] = ANSI_bGrey  + ccaption+ ANSI_RESET;
        this.AnsiSpielbrett[19][16] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[17][16] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[15][16] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[14][17] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[14][18] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[14][20] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[14][22] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[14][23] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[13][23] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[12][21] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[10][19] = ANSI_bGrey  + ccaption + ANSI_RESET;

        this.AnsiSpielbrett[9][1] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[8][3] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[8][5] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[8][6] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[7][7] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[6][6] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[4][5] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[2][4] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[1][5] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[2][6] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[3][8] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[4][10] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[4][12] = ANSI_bGrey  + ccaption + ANSI_RESET; 
        this.AnsiSpielbrett[2][12] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[0][14] = ANSI_bGrey  + ccaption+ ANSI_RESET;
        this.AnsiSpielbrett[1][16] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[3][16] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[5][16] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[6][17] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[6][18] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[6][20] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[6][22] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[6][23] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[7][23] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[8][21] = ANSI_bGrey  + ccaption + ANSI_RESET;
        this.AnsiSpielbrett[10][19] = ANSI_bGrey  + ccaption + ANSI_RESET;
    
    };
    
    public void wuerfelausgeben(int augen)
    {
    
    
    }    
    public void SpielerSetzen(Spielfigur diefigur)
    {
    
    
    }    
            
     public static void main(String args[]) {
     //System.out.println("\u001B[41m" + "\u001B[37m"  + "Hello World!" + "\u001B[0m");
     Logger log = new Logger("TestLog.txt");
     Spiel test = new Spiel(log,"testSpiel",0);
     test.output.spielAusgabe();
     }
}
    
