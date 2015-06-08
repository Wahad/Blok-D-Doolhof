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
     Helper helper;
     
    
     public Vriend(Veld veld) {
        super(veld);
        imgIc = new ImageIcon("src/images/vriend.png");
        img = imgIc.getImage();
        this.name = "vriend";
        this.pickup = false;
        helper.setVriendXco(veld.getXCo());
        helper.setVriendYco(veld.getYCo());
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
    public void setHelper(Helper helper)
        {
            this.helper = helper;
        }

  
}
