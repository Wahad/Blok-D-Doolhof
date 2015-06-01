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
        int stappen2 = speler.getaantalStappen();
        speler.setaantalStappen(stappen);
        System.out.println("Aantal stappen na" + stappen);
        System.out.println("Aantal stappen voor" + stappen2);
    }
    
}
