/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Gebruiker
 */
public class Titlebar extends JPanel{
    Level level;
    
    public void setLevel(Level level){
        this.level = level;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Level " + level.getNummer(), 300, 20);
        setBackground(Color.ORANGE);
    }
}
