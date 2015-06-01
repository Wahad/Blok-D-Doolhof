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
    private boolean end;

    public Speler(Veld veld) {
        super(veld);
        imgIc = new ImageIcon("src/images/spelerTest.png");
        img = imgIc.getImage();
        end = false;
    }

    public void bewegen(Richting r) {
        Veld buurveld = veld.getBuur(r);
        Item i = (Item) buurveld.getObject();
        
         if (i instanceof Item) {
            i.uitvoeren(this);
        }
         
         SpelObject x = buurveld.getObject();
        if (!(x instanceof Muur)) {
            veld.setObject(null);
            buurveld.setObject(this);
            this.veld = buurveld;
            aantalStappen++;
        }
        
    }
    
     public void setEnd(boolean end) {
        this.end = end;
    }
     
     public boolean getEnd() {
        return end;
    }

  public int getaantalStappen() {
        return aantalStappen;
    }

    public void setaantalStappen(int aantalStappen) {
        this.aantalStappen = aantalStappen;
    }
}
