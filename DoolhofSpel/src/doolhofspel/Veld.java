/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Menno
 */
public class Veld extends JComponent {

    protected ImageIcon imgIc = new ImageIcon("src/images/veld.png");
    protected Image img = imgIc.getImage();
    private int yco;
    private int xco;
    private HashMap<Richting, Veld> buurvakjes;
    private SpelObject obg;
    private boolean bekeken = false;
    private int index = 0;

    public Veld(int xcor, int ycor) {
        buurvakjes = new HashMap<>();
        this.xco = xcor;
        this.yco = ycor;
    }

    public Veld getBuur(Richting r) {
        return buurvakjes.get(r);
    }

    public void setBuur(Richting r, Veld neighbour) {
        buurvakjes.put(r, neighbour);
    }

    public void setObject(SpelObject g) {
        this.obg = g;
    }
    
    public SpelObject getObject(){
        return obg;
    }

    public void drawObject(Graphics g) {
        g.drawImage(img, xco, yco, null);
        if (obg != null) {
            obg.drawObject(g);
        }
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

    public boolean isBekeken() {
        return bekeken;
    }

    public void setBekeken(boolean bekeken) {
        this.bekeken = bekeken;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void setImage(ImageIcon image){
        this.img = image.getImage();
    }
    
}
