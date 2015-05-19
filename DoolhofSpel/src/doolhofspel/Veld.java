/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Menno
 */
public class Veld extends JComponent {
    private Veld veld;
     protected ImageIcon imgIc;
    protected Image img;
    private int yco;
    private int xco;
    
     public Veld(int xcor, int ycor) {
        this.xco = xcor;
        this.yco = ycor;
    }
    
     public void setObject(Veld veld) {
        this.veld = veld;
    }
    
    public void drawObject(Graphics g) {
        g.drawImage(veld.img, veld.getXCo(), veld.getYCo(), null);
    }
     public void setXCo(int XCo) {
        this.xco = XCo;
    }

    public void setYCo(int YCo) {
        this.yco = YCo;
    }

    public int getXCo() {
        return xco;
    }

    public int getYCo() {
        return yco;
    }
}
