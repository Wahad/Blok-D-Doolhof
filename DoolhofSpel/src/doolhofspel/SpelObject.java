/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Gebruiker
 */
public class SpelObject extends JComponent{
    
    protected ImageIcon imgIc;
    protected Image img;
    protected Veld veld;
    Level level;
    
    public SpelObject(Veld veld){
        this.veld = veld;
    }
    
    public void drawObject(Graphics g) {
        g.drawImage(this.img, veld.getXCo(), veld.getYCo(), null);
    }
    
}
