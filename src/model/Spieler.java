/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.util.Collections.list;
import java.util.List;
/**
 *
 * @author koeppen
 */
public interface Spieler {

    /**
     *
     * @param gezogen
     */
    public void ziehen(int gezogen);

    /**
     *
     * @return
     */
    public int wuerfeln();
    public Feld gibafeld();
    public List<Feld> getFelder();
    public Spiel gibSpiel();
}
