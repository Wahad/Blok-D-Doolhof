/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Menno
 */
public class Muur extends SpelObject{
    private int sterkte;
    
    
     public Muur(Veld veld) {
        super(veld);
        imgIc = new ImageIcon("src/images/bookcase.png");
        img = imgIc.getImage();
    }
    
}
