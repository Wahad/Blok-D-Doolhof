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
        g.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
        g.drawString("Score: " + level.getScore(), 0, 300);
        g.drawString("Level " + level.getNummer(), 0, 280);
        if(!level.s.rugzak.isEmpty())
        {
            g.drawString("Item in hand: " + level.s.inHand.name  , 0, 320);
        }
        if(level.s.rugzak.size() > 1)
        {
            for (int i = 0; i < level.s.rugzak.size(); i++) {
                int y = 340 + (i * 20);
                if(level.s.inHand != level.s.rugzak.get(i))
                {
                    g.drawString("Item in rugzak: " + level.s.rugzak.get(i).name , 0, 340);
                } 
            }
        }
        
        setBackground(Color.ORANGE);
    }
}
