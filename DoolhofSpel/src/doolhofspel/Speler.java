/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Menno
 */
public class Speler extends SpelObject {

    private int aantalStappen = 0;
    public ArrayList<Item> rugzak;
    public Item inHand;
    public Richting richt;
    private boolean switched;
    
    public Richting getRicht() {
        return richt;
    }

    public void setRicht(Richting richt) {
        this.richt = richt;
    }

    public Speler(Veld veld) {
        super(veld);
        this.rugzak = new ArrayList<>();
        imgIc = new ImageIcon("src/images/speler.png");
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
                    if(rugzak.isEmpty())
                    {
                        inHand = i;
                    }
                    rugzak.add(i);
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
    
    public Veld getVeld()
    {
        return veld;
    }
    
    public void setVeld(Veld veld)
    {
        this.veld = veld;
    }

    public void selecteerAnderItem() {
        switched = false;
        for (Item i : rugzak) {
           if(!switched)
           {
            if(i != inHand)
            {
                inHand = null;
                inHand = i;
                switched = true;
            }
           }
        }
    }
}
