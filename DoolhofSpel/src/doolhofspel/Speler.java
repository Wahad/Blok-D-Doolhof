/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Menno
 */
public class Speler extends SpelObject {

    public int aantalStappen;
    private Item heeft;

    public Speler(Veld veld) {
        super(veld);
        imgIc = new ImageIcon("src/images/spelerTest.png");
        img = imgIc.getImage();
    }

    public void bewegen(Richting r) {
        Veld buurveld = veld.getBuur(r);
        SpelObject x = buurveld.getObject();



        if (!(x instanceof Muur)) {
            if (x instanceof Item) {
                Item i = (Item) x;
                if (!i.pickup) {
                    i.uitvoeren(this);
                } else {
                    heeft = i;
                }
            }
            veld.setObject(null);
            buurveld.setObject(this);
            this.veld = buurveld;
            aantalStappen++;
        }

    }

    public int getaantalStappen() {
        return aantalStappen;
    }

    public void setaantalStappen(int aantalStappen) {
        this.aantalStappen = aantalStappen;
    }
}
