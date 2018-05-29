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

/**
 *
 * @author K
 */
public class MADGUI extends javax.swing.JFrame {

    /**
     * Creates new form MADGUI
     */
    public MADGUI() {
        initComponents();
        log = new Logger();
        dasSpiel = new Spiel(log, "das Spiel", 6);
        setzeFelderNachModel();

        this.darstellungAnzeigen();

    }

    public MADGUI(Logger logger, Spiel spiel) {
        initComponents();
        log = logger;
        dasSpiel = spiel;
        setzeFelderNachModel();
        this.darstellungAnzeigen();
    }

    public void GUIspielen() {
        while (dasSpiel.spieleEinenZug() != 1) {
            darstellungAnzeigen();

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {

            }
        }
    }

    public void setzeFelderNachModel() {
        //felder = new javax.swing.JLabel[119]; korrekte größe! Etliche Felder gibt es im SPielbrett nicht!
        felder = new javax.swing.JLabel[91];
        felder[0] = baf;
        felder[1] = f2;
        felder[2] = f3;
        felder[3] = f4;
        felder[4] = f5;
        felder[5] = f6;
        //Hier fehlt noch ein Feld, da das Spielbrett aus weniger Feldern besteht.
        felder[6] = ref;
        felder[7] = raf;
        felder[8] = f10;
        felder[9] = f11;
        felder[10] = f12;
        felder[11] = f13;
        felder[12] = f14;
        //Hier fehlt noch ein Feld, da das Spielbrett aus weniger Feldern besteht.
        felder[13] = tef;
        felder[14] = taf;
        felder[15] = f18;
        felder[16] = f19;
        felder[17] = f20;
        felder[18] = f21;
        felder[19] = f22;
        //Hier fehlt noch ein Feld, da das Spielbrett aus weniger Feldern besteht.
        felder[20] = pef;
        felder[21] = paf;
        felder[22] = f26;
        felder[23] = f27;
        felder[24] = f28;
        felder[25] = f29;
        felder[26] = f30;
        //Hier fehlt noch ein Feld, da das Spielbrett aus weniger Feldern besteht.
        felder[27] = gef;
        felder[28] = gaf;
        felder[29] = f34;
        felder[30] = f35;
        felder[31] = f36;
        felder[32] = f37;
        felder[33] = f38;
        //Hier fehlt noch ein Feld, da das Spielbrett aus weniger Feldern besteht.
        felder[34] = sef;
        felder[35] = saf;
        felder[36] = f42;
        felder[37] = f43;
        felder[38] = f44;
        felder[39] = f45;
        felder[40] = f46;
        //Im Spielbrett folgen hier die Felder für Türkis! Im Feldabgleich die Zahlen 41 bis 47 ignorieren!
        felder[41] = null;
        felder[42] = null;
        felder[43] = null;
        felder[44] = null;
        felder[45] = null;
        felder[46] = null;
        //Hier fehlt noch ein Feld, da das Spielbrett aus weniger Feldern besteht.
        felder[47] = null;
        felder[48] = bef;
        felder[49] = bz1;
        felder[50] = bz2;
        felder[51] = bz3;
        //Hier fehlt noch ein Endfeld!
        felder[52] = rz1;
        felder[53] = rz2;
        felder[54] = rz3;
        //Hier fehlt noch ein Endfeld!
        felder[55] = tz1;
        felder[56] = tz2;
        felder[57] = tz3;
        //Hier fehlt noch ein Endfeld!
        felder[58] = pz1;
        felder[59] = pz2;
        felder[60] = pz3;
        //Hier fehlt noch ein Endfeld!
        felder[61] = gz1;
        felder[62] = gz2;
        felder[63] = gz3;
        //Hier fehlt noch ein Endfeld!
        felder[64] = sz1;
        felder[65] = sz2;
        felder[66] = sz3;
        //Hier fehlt noch ein Endfeld!
        //Türkise Endfelder. Die Werte 67 bis 69 ignorieren
        felder[67] = null;
        felder[68] = null;
        felder[69] = null;
        //Hier fehlt noch ein Endfeld!
        felder[70] = bs1;
        felder[71] = bs2;
        felder[72] = bs3;
        //Hier fehlt noch ein Startfeld!
        felder[73] = rs1;
        felder[74] = rs2;
        felder[75] = rs3;
        //Hier fehlt noch ein Startfeld!
        felder[76] = gs1;
        felder[77] = gs2;
        felder[78] = gs3;
        //Hier fehlt noch ein Startfeld!
        felder[79] = ps1;
        felder[80] = ps2;
        felder[81] = ps3;
        //Hier fehlt noch ein Startfeld!
        felder[82] = gs1;
        felder[83] = gs2;
        felder[84] = gs3;
        //Hier fehlt noch ein Startfeld!
        felder[85] = ss1;
        felder[86] = ss2;
        felder[87] = ss3;
        //Hier fehlt noch ein Startfeld!
        //Türkise Strtfelder. Werte von 88 bis 90 ignorieren
        felder[88] = null;
        felder[89] = null;
        felder[90] = null;
        //Hier fehlt noch ein Startfeld!
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        wuerfel = new javax.swing.JLabel();
        Spielbrett = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(baf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 50, 50));
        getContentPane().add(f2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 50, 50));
        getContentPane().add(f3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 50, 50));
        getContentPane().add(f4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 50, 50));
        getContentPane().add(f5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 50, 50));
        getContentPane().add(f6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 50, 50));
        getContentPane().add(f7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 50, 50));
        getContentPane().add(ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 50, 50));
        getContentPane().add(raf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 50, 50));
        getContentPane().add(f10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 50, 50));
        getContentPane().add(f11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 50, 50));
        getContentPane().add(f12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 50, 50));
        getContentPane().add(f13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 50, 50));
        getContentPane().add(f14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 50, 50));
        getContentPane().add(f15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 50, 50));
        getContentPane().add(tef, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 50, 50));
        getContentPane().add(taf, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 50, 50));
        getContentPane().add(f18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 50, 50));
        getContentPane().add(f19, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 50, 50));
        getContentPane().add(f20, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 50, 50));
        getContentPane().add(f21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 50, 50));
        getContentPane().add(f22, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 50, 50));
        getContentPane().add(f23, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, 50, 50));
        getContentPane().add(pef, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 40, 40));
        getContentPane().add(paf, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, 40, 40));
        getContentPane().add(f26, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, 40, 40));
        getContentPane().add(f27, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 40, 40));
        getContentPane().add(f28, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, 40, 40));
        getContentPane().add(f29, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 40, 40));
        getContentPane().add(f30, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 590, 40, 40));
        getContentPane().add(f31, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 640, 40, 40));
        getContentPane().add(gef, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 630, 40, 40));
        getContentPane().add(gaf, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 630, 40, 40));
        getContentPane().add(f34, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 590, 40, 40));
        getContentPane().add(f35, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 40, 40));
        getContentPane().add(f36, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 40, 40));
        getContentPane().add(f37, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 40, 40));
        getContentPane().add(f38, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 40, 40));
        getContentPane().add(f39, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, 40, 40));
        getContentPane().add(sef, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 40, 40));
        getContentPane().add(saf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 40, 40));
        getContentPane().add(f42, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 40, 40));
        getContentPane().add(f43, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 40, 40));
        getContentPane().add(f44, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 40, 40));
        getContentPane().add(f45, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 40, 40));
        getContentPane().add(f46, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 40, 40));
        getContentPane().add(f47, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 40, 40));
        getContentPane().add(bef, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 40, 40));
        getContentPane().add(bz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 40, 40));
        getContentPane().add(bz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 40, 40));
        getContentPane().add(bz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 40, 40));
        getContentPane().add(bz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 40, 40));
        getContentPane().add(rz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 40, 40));
        getContentPane().add(rz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 40, 40));
        getContentPane().add(rz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 40, 40));
        getContentPane().add(rz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 40, 40));
        getContentPane().add(tz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 40, 40));
        getContentPane().add(tz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 40, 40));
        getContentPane().add(tz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 40, 40));
        getContentPane().add(tz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 40, 40));
        getContentPane().add(pz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 40, 40));
        getContentPane().add(pz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 40, 40));
        getContentPane().add(pz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 40, 40));
        getContentPane().add(pz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 40, 40));
        getContentPane().add(gz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 590, 40, 40));
        getContentPane().add(gz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 40, 40));
        getContentPane().add(gz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 40, 40));
        getContentPane().add(gz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 40, 40));
        getContentPane().add(sz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 40, 40));
        getContentPane().add(sz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 40, 40));
        getContentPane().add(sz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 40, 40));
        getContentPane().add(sz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 40, 40));
        getContentPane().add(bs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 40, 40));
        getContentPane().add(bs2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 40, 40));
        getContentPane().add(bs3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 40, 40));
        getContentPane().add(bs4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 40, 40));
        getContentPane().add(rs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 40, 40));
        getContentPane().add(rs2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 40, 40));
        getContentPane().add(rs3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 40, 40));
        getContentPane().add(rs4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 40, 40));
        getContentPane().add(ts1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, 40, 40));
        getContentPane().add(ts2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, 40, 40));
        getContentPane().add(ts3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 40, 40));
        getContentPane().add(ts4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 40, 40));
        getContentPane().add(ps1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 640, 40, 40));
        getContentPane().add(ps2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 640, 40, 40));
        getContentPane().add(ps3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 690, 40, 40));
        getContentPane().add(ps4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 690, 40, 40));
        getContentPane().add(gs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 40, 40));
        getContentPane().add(gs2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, 40, 40));
        getContentPane().add(gs3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, 40, 40));
        getContentPane().add(gs4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 690, 40, 40));
        getContentPane().add(ss1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 40, 40));
        getContentPane().add(ss2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 40, 40));
        getContentPane().add(ss3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 40, 40));
        getContentPane().add(ss4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 40, 40));

        wuerfel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wuerfel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/die1.png"))); // NOI18N
        getContentPane().add(wuerfel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 40, 40));
        wuerfel.getAccessibleContext().setAccessibleName("wuerfel");

        Spielbrett.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/768px-Dontworry6.svg.png"))); // NOI18N
        getContentPane().add(Spielbrett, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void darstellungAnzeigen() {
        for (int i = 0; i < felder.length; i++) {
            if (i != 41 && i != 42 && i != 43 && i != 44 && i != 45 && i != 46 && i != 47 && i != 67 && i != 68 && i != 69 && i != 88 && i != 89 && i != 90) {
                anpassen(dasSpiel.getSpielbrett().getFelder().get(i), i);
            }
        }
        ImageIcon icon = null;
        switch (dasSpiel.getWuerfel().getZahl()) {
            case 1:
                icon = new ImageIcon(getClass().getResource("/view/die1.png"));
                break;
            case 2:
                icon = new ImageIcon(getClass().getResource("/view/die2.png"));
                break;
            case 3:
                icon = new ImageIcon(getClass().getResource("/view/die3.png"));
                break;
            case 4:
                icon = new ImageIcon(getClass().getResource("/view/die4.png"));
                break;
            case 5:
                icon = new ImageIcon(getClass().getResource("/view/die5.png"));
                break;
            case 6:
                icon = new ImageIcon(getClass().getResource("/view/die6.png"));
                break;
        }
        wuerfel.setIcon(icon);

        repaint();
    }

    public void anpassen(Feld f, int index) {
        //System.out.println("Start der Methode anpassen mit den Parametern: ");
        //System.out.println(index);
        felder[index].setVisible(true);
        if (f.getHausbesetzer() == null) {
            //  System.out.println("Leeres Feld");
            felder[index].setVisible(false);
            return;
        }
        //System.out.println(f.getHausbesetzer().getTeam().getfarbe());
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MADGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MADGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MADGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MADGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MADGUI mg = new MADGUI();
                mg.setVisible(true);
                //mg.GUIspielen();

            }
        });
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
    private javax.swing.JLabel wuerfel;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel felder[];
    private Spiel dasSpiel;
    private Logger log;

}
