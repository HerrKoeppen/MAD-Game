/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.ImageIcon;
import model.Feld;
import model.Logger;
import model.Spiel;
import model.Spielfigur;
import model.SpielerMensch;
import javax.xml.stream.XMLEventReader;

/**
 *
 * @author K
 */
public class MADGUI extends javax.swing.JFrame {

    /**
     * Creates new form MADGUI
     */
   

    public MADGUI(Logger logger, Spiel spiel) {
        initComponents();
        log = logger;
        dasSpiel = spiel;
        setzeFelderNachModel();
        this.WuerfelReset();
        this.darstellungAnzeigen();
    }
    
    public void GUIspielen(){
        while (dasSpiel.spieleEinenZug() != 1) {
                    darstellungAnzeigen();

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {

                    }
                }
    }

    public void setzeFelderNachModel() {
        felder = new javax.swing.JLabel[96];
       
        felder[0] = baf;
        
        felder[1] = f2;
        felder[2] = f3;
        felder[3] = f4;
        felder[4] = f5;
        felder[5] = f6;
        felder[6] = f7; 
        
        felder[7] = ref;
        felder[8] = raf;
        
        felder[9] = f10;
        felder[10] = f11;
        felder[11] = f12;
        felder[12] = f13;
        felder[13] = f14;
        felder[14] = f15;
        
        felder[15] = tef;
        felder[16] = taf;
        
        felder[17] = f18;
        felder[18] = f19;
        felder[19] = f20;
        felder[20] = f21;
        felder[21] = f22;
        felder[22] = f23;
        
        felder[23] = pef;
        felder[24] = paf;
        
        felder[25] = f26;
        felder[26] = f27;
        felder[27] = f28;
        felder[28] = f29;
        felder[29] = f30;
        felder[30] = f31;
        
        felder[31] = gef;
        felder[32] = gaf;
        
        felder[33] = f34;
        felder[34] = f35;
        felder[35] = f36;
        felder[36] = f37;
        felder[37] = f38;
        felder[38] = f39;
        
        felder[39] = sef;
        felder[40] = saf;
        
        felder[41] = f42;
        felder[42] = f43;
        felder[43] = f44;
        felder[44] = f45;
        felder[45] = f46;
        felder[46] = f47;
        
        felder[47] = bef;
        // blaue Zielfelder
        felder[48] = bz1;
        felder[49] = bz2;
        felder[50] = bz3;
        felder[51] = bz4;
        // rote Zielfelder
        felder[52] = rz1;
        felder[53] = rz2;
        felder[54] = rz3;
        felder[55] = rz4;
        // gruene Zielfelder
        felder[56] = tz1;
        felder[57] = tz2;
        felder[58] = tz3;
        felder[59] = tz4;
        // pinke Zielfelder
        felder[60] = pz1;
        felder[61] = pz2;
        felder[62] = pz3;
        felder[63] = pz4;
        //gelbe Zielfelder
        felder[64] = gz1;
        felder[65] = gz2;
        felder[66] = gz3;
        felder[67] = gz4;
        // schwarze Zielfelder
        felder[68] = sz1;
        felder[69] = sz2;
        felder[70] = sz3;
        felder[71] = sz4;
        // blaue Startfelder
        felder[72] = bs1;
        felder[73] = bs2;
        felder[74] = bs3;
        felder[75] = bs4;
        // rote Startfelder
        felder[76] = rs1;
        felder[77] = rs2;
        felder[78] = rs3;
        felder[79] = rs4;
        // gruene Startfelder
        felder[80] = ts1;
        felder[81] = ts2;
        felder[82] = ts3;
        felder[83] = ts4;
        // pinke Startfelder
        felder[84] = ps1;
        felder[85] = ps2;
        felder[86] = ps3;
        felder[87] = ps4;
        //gelbe Startfelder
        felder[88] = gs1;
        felder[89] = gs2;
        felder[90] = gs3;
        felder[91] = gs4;
        //schwarze Startfelder
        felder[92] = ss1;
        felder[93] = ss2;
        felder[94] = ss3;
        felder[95] = ss4;
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rot2 = new javax.swing.JLabel();
        rot3 = new javax.swing.JLabel();
        baf = new javax.swing.JLabel();
        f2 = new javax.swing.JLabel();
        f3 = new javax.swing.JLabel();
        f4 = new javax.swing.JLabel();
        f5 = new javax.swing.JLabel();
        f6 = new javax.swing.JLabel();
        f7 = new javax.swing.JLabel();
        ref = new javax.swing.JLabel();
        raf = new javax.swing.JLabel();
        f10 = new javax.swing.JLabel();
        f11 = new javax.swing.JLabel();
        f12 = new javax.swing.JLabel();
        f13 = new javax.swing.JLabel();
        f14 = new javax.swing.JLabel();
        f15 = new javax.swing.JLabel();
        tef = new javax.swing.JLabel();
        taf = new javax.swing.JLabel();
        f18 = new javax.swing.JLabel();
        f19 = new javax.swing.JLabel();
        f20 = new javax.swing.JLabel();
        f21 = new javax.swing.JLabel();
        f22 = new javax.swing.JLabel();
        f23 = new javax.swing.JLabel();
        pef = new javax.swing.JLabel();
        paf = new javax.swing.JLabel();
        f26 = new javax.swing.JLabel();
        f27 = new javax.swing.JLabel();
        f28 = new javax.swing.JLabel();
        f29 = new javax.swing.JLabel();
        f30 = new javax.swing.JLabel();
        f31 = new javax.swing.JLabel();
        gef = new javax.swing.JLabel();
        gaf = new javax.swing.JLabel();
        f34 = new javax.swing.JLabel();
        f35 = new javax.swing.JLabel();
        f36 = new javax.swing.JLabel();
        f37 = new javax.swing.JLabel();
        f38 = new javax.swing.JLabel();
        f39 = new javax.swing.JLabel();
        sef = new javax.swing.JLabel();
        saf = new javax.swing.JLabel();
        f42 = new javax.swing.JLabel();
        f43 = new javax.swing.JLabel();
        f44 = new javax.swing.JLabel();
        f45 = new javax.swing.JLabel();
        f46 = new javax.swing.JLabel();
        f47 = new javax.swing.JLabel();
        bef = new javax.swing.JLabel();
        bz1 = new javax.swing.JLabel();
        bz2 = new javax.swing.JLabel();
        bz3 = new javax.swing.JLabel();
        bz4 = new javax.swing.JLabel();
        rz1 = new javax.swing.JLabel();
        rz2 = new javax.swing.JLabel();
        rz3 = new javax.swing.JLabel();
        rz4 = new javax.swing.JLabel();
        tz1 = new javax.swing.JLabel();
        tz2 = new javax.swing.JLabel();
        tz3 = new javax.swing.JLabel();
        tz4 = new javax.swing.JLabel();
        pz1 = new javax.swing.JLabel();
        pz2 = new javax.swing.JLabel();
        pz3 = new javax.swing.JLabel();
        pz4 = new javax.swing.JLabel();
        gz1 = new javax.swing.JLabel();
        gz2 = new javax.swing.JLabel();
        gz3 = new javax.swing.JLabel();
        gz4 = new javax.swing.JLabel();
        sz1 = new javax.swing.JLabel();
        sz2 = new javax.swing.JLabel();
        sz3 = new javax.swing.JLabel();
        sz4 = new javax.swing.JLabel();
        bs1 = new javax.swing.JLabel();
        bs2 = new javax.swing.JLabel();
        bs3 = new javax.swing.JLabel();
        bs4 = new javax.swing.JLabel();
        rs1 = new javax.swing.JLabel();
        rs2 = new javax.swing.JLabel();
        rs3 = new javax.swing.JLabel();
        rs4 = new javax.swing.JLabel();
        ts1 = new javax.swing.JLabel();
        ts2 = new javax.swing.JLabel();
        ts3 = new javax.swing.JLabel();
        ts4 = new javax.swing.JLabel();
        ps1 = new javax.swing.JLabel();
        ps2 = new javax.swing.JLabel();
        ps3 = new javax.swing.JLabel();
        ps4 = new javax.swing.JLabel();
        gs1 = new javax.swing.JLabel();
        gs2 = new javax.swing.JLabel();
        gs3 = new javax.swing.JLabel();
        gs4 = new javax.swing.JLabel();
        ss1 = new javax.swing.JLabel();
        ss2 = new javax.swing.JLabel();
        ss3 = new javax.swing.JLabel();
        ss4 = new javax.swing.JLabel();
        die1 = new javax.swing.JLabel();
        die2 = new javax.swing.JLabel();
        die3 = new javax.swing.JLabel();
        die4 = new javax.swing.JLabel();
        die5 = new javax.swing.JLabel();
        die6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSpielverlauf = new javax.swing.JTextArea();
        Spielbrett = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(rot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));
        getContentPane().add(rot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, -1, -1));
        getContentPane().add(baf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 50, 90));
        getContentPane().add(f2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 50, 90));
        getContentPane().add(f3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 50, 100));
        getContentPane().add(f4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 50, 100));
        getContentPane().add(f5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 50, 70));
        getContentPane().add(f6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 50, 70));
        getContentPane().add(f7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 40, 80));
        getContentPane().add(ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 50, 70));
        getContentPane().add(raf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 50, 70));
        getContentPane().add(f10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 50, 70));
        getContentPane().add(f11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 50, 70));
        getContentPane().add(f12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 50, 80));
        getContentPane().add(f13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 50, 80));
        getContentPane().add(f14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 50, 80));
        getContentPane().add(f15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 50, 80));
        getContentPane().add(tef, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 50, 90));
        getContentPane().add(taf, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 50, 90));
        getContentPane().add(f18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 50, 90));
        getContentPane().add(f19, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 50, 80));
        getContentPane().add(f20, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 50, 90));
        getContentPane().add(f21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 50, 80));
        getContentPane().add(f22, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 50, 80));
        getContentPane().add(f23, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 50, 90));
        getContentPane().add(pef, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 50, 90));
        getContentPane().add(paf, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, 50, 90));
        getContentPane().add(f26, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 50, 90));
        getContentPane().add(f27, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 50, 80));
        getContentPane().add(f28, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 50, 80));
        getContentPane().add(f29, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 50, 80));
        getContentPane().add(f30, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 50, 70));
        getContentPane().add(f31, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 600, 50, 80));
        getContentPane().add(gef, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 590, 50, 90));
        getContentPane().add(gaf, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 50, 80));
        getContentPane().add(f34, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, 50, 80));
        getContentPane().add(f35, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 50, 80));
        getContentPane().add(f36, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 50, 80));
        getContentPane().add(f37, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 50, 80));
        getContentPane().add(f38, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 50, 90));
        getContentPane().add(f39, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 50, 80));
        getContentPane().add(sef, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 50, 110));
        getContentPane().add(saf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 50, 90));
        getContentPane().add(f42, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 50, 80));
        getContentPane().add(f43, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 50, 80));
        getContentPane().add(f44, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 50, 70));
        getContentPane().add(f45, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 50, 80));
        getContentPane().add(f46, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 50, 80));
        getContentPane().add(f47, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 50, 80));
        getContentPane().add(bef, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 50, 90));
        getContentPane().add(bz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 60, 90));
        getContentPane().add(bz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 50, 80));
        getContentPane().add(bz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 50, 90));
        getContentPane().add(bz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 60, 80));
        getContentPane().add(rz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 50, 80));
        getContentPane().add(rz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 50, 80));
        getContentPane().add(rz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 50, 90));
        getContentPane().add(rz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 50, 80));
        getContentPane().add(tz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 50, 80));
        getContentPane().add(tz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 60, 90));
        getContentPane().add(tz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 50, 80));
        getContentPane().add(tz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 60, 80));
        getContentPane().add(pz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 50, 80));
        getContentPane().add(pz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 60, 90));
        getContentPane().add(pz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 50, 90));
        getContentPane().add(pz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 60, 90));
        getContentPane().add(gz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 50, 80));
        getContentPane().add(gz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 50, 80));
        getContentPane().add(gz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 60, 80));
        getContentPane().add(gz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 50, 80));
        getContentPane().add(sz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 60, 90));
        getContentPane().add(sz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 50, 80));
        getContentPane().add(sz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 50, 90));
        getContentPane().add(sz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 50, 70));
        getContentPane().add(bs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, 70));
        getContentPane().add(bs2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 50, 70));
        getContentPane().add(bs3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 50, 80));
        getContentPane().add(bs4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 50, 70));
        getContentPane().add(rs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 50, 80));
        getContentPane().add(rs2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 50, 80));
        getContentPane().add(rs3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 50, 80));
        getContentPane().add(rs4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 50, 80));
        getContentPane().add(ts1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 50, 70));
        getContentPane().add(ts2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 50, 80));
        getContentPane().add(ts3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 50, 80));
        getContentPane().add(ts4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 50, 80));
        getContentPane().add(ps1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 600, 50, 80));
        getContentPane().add(ps2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, 50, 80));
        getContentPane().add(ps3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 660, 50, 70));
        getContentPane().add(ps4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 670, 50, 60));
        getContentPane().add(gs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 50, 80));
        getContentPane().add(gs2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 50, 80));
        getContentPane().add(gs3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 50, 70));
        getContentPane().add(gs4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 660, 60, 70));
        getContentPane().add(ss1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 50, 60));
        getContentPane().add(ss2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 50, 70));
        getContentPane().add(ss3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 40, 60));
        getContentPane().add(ss4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 50, 70));

        die1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/die1.png"))); // NOI18N
        getContentPane().add(die1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        die2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/die2.png"))); // NOI18N
        getContentPane().add(die2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        die3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/die3.png"))); // NOI18N
        getContentPane().add(die3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        die4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/die4.png"))); // NOI18N
        getContentPane().add(die4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        die5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/die5.png"))); // NOI18N
        getContentPane().add(die5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        die6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/die6.png"))); // NOI18N
        getContentPane().add(die6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        jScrollPane1.setName(""); // NOI18N

        jTextAreaSpielverlauf.setColumns(20);
        jTextAreaSpielverlauf.setRows(5);
        jTextAreaSpielverlauf.setText("Spielverlauf");
        jScrollPane1.setViewportView(jTextAreaSpielverlauf);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 280, 460));

        Spielbrett.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/768px-Dontworry6.svg.png"))); // NOI18N
        getContentPane().add(Spielbrett, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void darstellungAnzeigen() {
        for (int i = 0; i < 90; i++) {
            //if (i != 41 && i != 42 && i != 43 && i != 44 && i != 45 && i != 46 && i != 47 && i != 67 && i != 68 && i != 69 && i != 88 && i != 89 && i != 90) {
                anpassen(dasSpiel.getSpielbrett().getFelder().get(i), i);
            //}
        }
        repaint();
    }

    public void anpassen(Feld f, int index) {
        felder[index].setVisible(true);
        if (!f.getIstBesetzt()) {

            felder[index].setVisible(false);
            return;
            
        }
        if (f.getHausbesetzer().getTeam().getfarbe().equalsIgnoreCase("blau")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/view/Spielfigur_blau.png"));
            felder[index].setIcon(icon);
            return;
        }
        if (f.getHausbesetzer().getTeam().getfarbe().equalsIgnoreCase("rot")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/view/Spielfigur_rot.png"));
            felder[index].setIcon(icon);
            return;
        }
        if (f.getHausbesetzer().getTeam().getfarbe().equalsIgnoreCase("gruen")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/view/Spielfigur_gruen.png"));
            felder[index].setIcon(icon);
            return;
        }
        if (f.getHausbesetzer().getTeam().getfarbe().equalsIgnoreCase("pink")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/view/Spielfigur_lila.png"));
            felder[index].setIcon(icon);
            return;
        }
        if (f.getHausbesetzer().getTeam().getfarbe().equalsIgnoreCase("gelb")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/view/Spielfigur_gelb.png"));
            felder[index].setIcon(icon);
            return;
        }
        if (f.getHausbesetzer().getTeam().getfarbe().equalsIgnoreCase("schwarz")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/view/Spielfigur_schwarz.png"));
            felder[index].setIcon(icon);
            return;
        }
        if (f.getHausbesetzer().getTeam().getfarbe().equalsIgnoreCase("tuerkis")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/view/Spielfigur_schwarz.png"));
            felder[index].setIcon(icon);
            return;
        }
        

    }

  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Spielbrett;
    private javax.swing.JLabel baf;
    private javax.swing.JLabel bef;
    private javax.swing.JLabel bs1;
    private javax.swing.JLabel bs2;
    private javax.swing.JLabel bs3;
    private javax.swing.JLabel bs4;
    private javax.swing.JLabel bz1;
    private javax.swing.JLabel bz2;
    private javax.swing.JLabel bz3;
    private javax.swing.JLabel bz4;
    private javax.swing.JLabel die1;
    private javax.swing.JLabel die2;
    private javax.swing.JLabel die3;
    private javax.swing.JLabel die4;
    private javax.swing.JLabel die5;
    private javax.swing.JLabel die6;
    private javax.swing.JLabel f10;
    private javax.swing.JLabel f11;
    private javax.swing.JLabel f12;
    private javax.swing.JLabel f13;
    private javax.swing.JLabel f14;
    private javax.swing.JLabel f15;
    private javax.swing.JLabel f18;
    private javax.swing.JLabel f19;
    private javax.swing.JLabel f2;
    private javax.swing.JLabel f20;
    private javax.swing.JLabel f21;
    private javax.swing.JLabel f22;
    private javax.swing.JLabel f23;
    private javax.swing.JLabel f26;
    private javax.swing.JLabel f27;
    private javax.swing.JLabel f28;
    private javax.swing.JLabel f29;
    private javax.swing.JLabel f3;
    private javax.swing.JLabel f30;
    private javax.swing.JLabel f31;
    private javax.swing.JLabel f34;
    private javax.swing.JLabel f35;
    private javax.swing.JLabel f36;
    private javax.swing.JLabel f37;
    private javax.swing.JLabel f38;
    private javax.swing.JLabel f39;
    private javax.swing.JLabel f4;
    private javax.swing.JLabel f42;
    private javax.swing.JLabel f43;
    private javax.swing.JLabel f44;
    private javax.swing.JLabel f45;
    private javax.swing.JLabel f46;
    private javax.swing.JLabel f47;
    private javax.swing.JLabel f5;
    private javax.swing.JLabel f6;
    private javax.swing.JLabel f7;
    private javax.swing.JLabel gaf;
    private javax.swing.JLabel gef;
    private javax.swing.JLabel gs1;
    private javax.swing.JLabel gs2;
    private javax.swing.JLabel gs3;
    private javax.swing.JLabel gs4;
    private javax.swing.JLabel gz1;
    private javax.swing.JLabel gz2;
    private javax.swing.JLabel gz3;
    private javax.swing.JLabel gz4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaSpielverlauf;
    private javax.swing.JLabel paf;
    private javax.swing.JLabel pef;
    private javax.swing.JLabel ps1;
    private javax.swing.JLabel ps2;
    private javax.swing.JLabel ps3;
    private javax.swing.JLabel ps4;
    private javax.swing.JLabel pz1;
    private javax.swing.JLabel pz2;
    private javax.swing.JLabel pz3;
    private javax.swing.JLabel pz4;
    private javax.swing.JLabel raf;
    private javax.swing.JLabel ref;
    private javax.swing.JLabel rot2;
    private javax.swing.JLabel rot3;
    private javax.swing.JLabel rs1;
    private javax.swing.JLabel rs2;
    private javax.swing.JLabel rs3;
    private javax.swing.JLabel rs4;
    private javax.swing.JLabel rz1;
    private javax.swing.JLabel rz2;
    private javax.swing.JLabel rz3;
    private javax.swing.JLabel rz4;
    private javax.swing.JLabel saf;
    private javax.swing.JLabel sef;
    private javax.swing.JLabel ss1;
    private javax.swing.JLabel ss2;
    private javax.swing.JLabel ss3;
    private javax.swing.JLabel ss4;
    private javax.swing.JLabel sz1;
    private javax.swing.JLabel sz2;
    private javax.swing.JLabel sz3;
    private javax.swing.JLabel sz4;
    private javax.swing.JLabel taf;
    private javax.swing.JLabel tef;
    private javax.swing.JLabel ts1;
    private javax.swing.JLabel ts2;
    private javax.swing.JLabel ts3;
    private javax.swing.JLabel ts4;
    private javax.swing.JLabel tz1;
    private javax.swing.JLabel tz2;
    private javax.swing.JLabel tz3;
    private javax.swing.JLabel tz4;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel felder[];
    private Spiel dasSpiel;
    private Logger log;

    /**
     * 
     * Setzt alle WuerfelLabels auf unsichtbar.
       */ 
    public void WuerfelReset(){
        die1.setVisible(false);
        die2.setVisible(false);
        die3.setVisible(false);
        die4.setVisible(false);
        die5.setVisible(false);
        die6.setVisible(false);
        
        
    }
    /**
     * Setz alle WuerfelLabels auf unsichtbar und macht das WuerfelLabel mit 
     * der übergebenen Zahl auf sichtbar.
     * 
     * 
     * 
     * 
     * 
     * @param WuerfelZahl 
     */
    
    
    public void WuerfelAusgeben(int WuerfelZahl){
        die1.setVisible(false);
        die2.setVisible(false);
        die3.setVisible(false);
        die4.setVisible(false);
        die5.setVisible(false);
        die6.setVisible(false);
        switch (WuerfelZahl){
            case 1:die1.setVisible(true);break;
            case 2:die2.setVisible(true);break;
            case 3:die3.setVisible(true);break;
            case 4:die4.setVisible(true);break;
            case 5:die5.setVisible(true);break;
            case 6:die6.setVisible(true);break;
            
            
            
        }
                
        
        
        
        
    }
}



