/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Menno
 */
public class Vriend extends Item{
     Level level;
    
     public Vriend(Veld veld) {
        super(veld);
        imgIc = new ImageIcon("src/images/Pierce.png");
        img = imgIc.getImage();
        this.name = "vriend";
        
    }
    
     
    @Override
    public void uitvoeren(Speler speler)
    {
        int plus = level.getNummer();
        
        if (plus <= 3) {
                try {
                    plus++;
                    level.setNummer(plus);
                    level.restart();
                    level.repaint();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Gefeliciteerd! U heeft het spel gewonnen!");
                    System.exit(1);
                }
            }
    }

  
}
