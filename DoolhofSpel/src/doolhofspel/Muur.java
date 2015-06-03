/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Menno
 */
public class Muur extends SpelObject implements Destructable{
    private boolean sterkte;
    
    
     public Muur(Veld veld, boolean sterk) {
        super(veld);
        this.sterkte = sterk;
        imgIc = new ImageIcon("src/images/muur.png");
        img = imgIc.getImage();
    }
     
     @Override
     public void destroy(Veld veld){
         SpelObject x = veld.getObject();
         if(x instanceof Muur && !sterkte){
             veld.setObject(null);
         }
     }
    
}
