/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Gebruiker
 */
public class Sidebar extends JPanel{
    
    private Level level;
    private List rugzak;
    private Item inHand;
   
    public void setLevel(Level level){
        this.level = level;
        
    }
    

            
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
        g.drawString("Score: " + level.getScore(), 0, 300);
        g.drawString("Level " + level.getNummer(), 0, 280);
        rugzak = level.s.getRugzak();
        inHand = level.s.getInHand();
        
        if(!rugzak.isEmpty())
        {
            g.drawString("Item in hand: " + inHand.name  , 0, 320);
        }
        if(rugzak.size() > 1)
        {
            for (int i = 0; i < rugzak.size(); i++) {
                int y = 320 + (i * 20);
                if(inHand != rugzak.get(i))
                {
                    Item item = (Item) rugzak.get(i);
                    String naam = item.name;
                    g.drawString("Item in rugzak: " + naam, 0, y);
                } 
            }
        }
        
        setBackground(Color.ORANGE);
    }
}
