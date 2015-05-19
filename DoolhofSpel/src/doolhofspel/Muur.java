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
public class Muur extends Veld {
    private int sterkte;
    private Veld veld;
    
    
     public Muur(Veld veld) {
         super(veld.getXCo(), veld.getYCo());
        imgIc = new ImageIcon("src/images/bookcase.png");
        img = imgIc.getImage();
    }
    
}
