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
   
    private static final String ANSI_bBlack = "\u001B[40m"; 
    private static final String ANSI_bRed = "\u001B[41m";
    private static final String ANSI_bGreen = "\u001B[42m";
    private static final String ANSI_bYellow = "\u001B[43m";
    private static final String ANSI_bBlue = "\u001B[44m";
    private static final String ANSI_bPurpel = "\u001B[45m";
    private static final String ANSI_bCyan = "\u001B[46m";
    private static final String ANSI_bWhite = "\u001B[47m";
    private String[][] AnsiSpielbrett = new String[25][21];
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
    //way more elegant
    
    for (int i = 0; i < 25;i++){
            for (int k = 0; k < 21;k++){
                this.AnsiSpielbrett[i][k]= ANSI_bWhite +ANSI_fWhite +".." + ANSI_RESET ;   //+ ANSI_fBlue ANSI_RESET
        }
    }
    this.Ansiausgabean = true;
    }
    public void feldeinfuegen(Feld dasFeld){
    String farbe = "s";
    switch (dasFeld.getFarbe().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "blau":
            farbe = ANSI_bBlue+"b"  ;    
                break;
            case "rot":
            farbe = ANSI_bRed+"r"  ;  
                break;
            case "cyan":
            farbe = ANSI_bCyan+"c"  ;    
                break;
            case "gelb":
            farbe = ANSI_bYellow+"g"  ;
                break;
            case "pink":
            farbe = ANSI_bPurpel+"p"  ;    
                break;
            case "schwarz":
            farbe = ANSI_bBlack+"s"  ;    
                break;
            case "orange":
            farbe = ANSI_bGreen+"o"  ;   
                break;
            case "zielfeld":
            farbe = ANSI_RESET  ;    
                break;
            default:
                break;
        }
    String Caption ="w";
    switch (dasFeld.getFeldtyp().toLowerCase()) { // sehr netter Switch der den Typ des Feldes festlegt
            case "start":
            case "startfeld":
            case "Startfeld":
                Caption = "s";
                break;
            case "a":
            case "afeld":
            case "Afeld":
            case "A-Feld":
            case "Anfangsfeld":
            case "anfangsfeld":
                Caption = "a";
                break;
            case "ziel":
            case "Zielfeld":
            case "zielfeld":
                Caption = "z";
                break;
            case "standart":
            case "standartfeld":
            case "Standartfeld":
                Caption = "n";
                break;
            default:
                break;
        }
    this.AnsiSpielbrett[dasFeld.getPositionX()][dasFeld.getPositionY()] = farbe + Caption + ANSI_RESET;  
    
    
    }
    
    public void spielAudgabe(){
       System.out.println("ANSI-Spielbrett steht bereit:");
       if(this.Ansiausgabean){
        for (int i = 0; i<25;i++){
            for (int k = 0; k<21;k++){
            System.out.print(AnsiSpielbrett[i][k]);    
        }
            System.out.println();
        }
    } 
    }
     
     public static void main(String args[]) {
    
     Logger log = new Logger("TestLog.txt");
     Spiel test = new Spiel(log,"testSpiel",0);
     test.output.spielAudgabe();
     }
}
    
