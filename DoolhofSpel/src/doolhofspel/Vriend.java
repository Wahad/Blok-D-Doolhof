/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import javax.swing.ImageIcon;

/**
 *
 * @author Menno
 */
public class Vriend extends Item{
    
     public Vriend(Veld veld) {
         super(veld);
        imgIc = new ImageIcon("src/images/Pierce.png");
        img = imgIc.getImage();
    }
      @Override
    public void uitvoeren(Speler speler)
    {
        speler.setEnd(true);
    }

  
}
