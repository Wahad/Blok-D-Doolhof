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
public class ValsSpeler extends Item {

    private int waarde;
    
    
    public ValsSpeler(Veld veld, int waarde, boolean pickup) {
        super(veld);
        imgIc = new ImageIcon("src/images/valsspeler.png");
        img = imgIc.getImage();
        this.name = "valsspeler";
        this.waarde = waarde;
        this.setPickup(pickup);
    }

    @Override
    public void uitvoeren(Speler speler) {
        int stappen = speler.getaantalStappen() - waarde;
        speler.setaantalStappen(stappen);
    }
}
