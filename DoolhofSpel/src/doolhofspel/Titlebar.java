/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 *
 * @author Gebruiker
 */
public class Titlebar extends JPanel {

    protected ImageIcon imgIc = new ImageIcon("src/images/title.png");
    protected Image img = imgIc.getImage();

 

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, 300, 1, null);
        setBackground(Color.ORANGE);
    }
}
