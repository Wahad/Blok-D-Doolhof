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
     public ValsSpeler(Veld veld)
    {
        super(veld);
        imgIc = new ImageIcon("src/images/Dean.png");
        img = imgIc.getImage();
    }
    
    public void uitvoeren(Speler speler)
    {
        int stappen = speler.getaantalStappen()/2;
        speler.setaantalStappen(stappen);
    }
    
}
