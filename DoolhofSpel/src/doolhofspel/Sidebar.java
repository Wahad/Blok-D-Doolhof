/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Gebruiker
 */
public class Sidebar extends JPanel{
    
    private Level level;
   
    public void setLevel(Level level){
        this.level = level;
        
    }

    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("TimesNewRoman", Font.PLAIN, 18));
        g.drawString("Score: " + level.getScore(), 5, 300);
        g.drawString("Level " + level.getNummer(), 5, 280);
        setBackground(Color.ORANGE);
    }
}
