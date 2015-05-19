/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author Menno
 */
public class Pad extends Veld {
    private Veld veld;
    
    public Pad(Veld veld)
    {
        super(veld.getXCo(), veld.getYCo());
        imgIc = new ImageIcon("src/pictures/planks.png");
        img = imgIc.getImage();
    }

    
   
}
