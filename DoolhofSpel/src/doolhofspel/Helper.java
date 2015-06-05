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
public class Helper extends Item {
    
    public Helper(Veld veld)
    {
        super(veld);
        imgIc = new ImageIcon("src/images/helper.png");
        img = imgIc.getImage();
        this.name = "helper";
    }
}
