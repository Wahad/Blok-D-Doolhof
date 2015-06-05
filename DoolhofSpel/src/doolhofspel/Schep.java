/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import javax.swing.ImageIcon;

/**
 *
 * @author Menno
 */
public class Schep extends Item {
    public Schep(Veld veld)   {
        super(veld);
        imgIc = new ImageIcon("src/images/schep.png");
        img = imgIc.getImage();
        this.name = "Schep";
        this.setPickup(pickup);
    }
     @Override
    public void uitvoeren(Speler speler) {
        Richting r = speler.r;
        Veld zichzelf = veld.getBuur(r);
        Muur muur = (Muur) zichzelf.getObject();
        muur.destroy(zichzelf);
    }
}
