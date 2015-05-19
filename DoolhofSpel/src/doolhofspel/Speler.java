/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Menno
 */
public class Speler extends JComponent {

    public int aantalStappen;
    public Veld beginveld;
    protected ImageIcon imgIc;
    protected Image img;

    public Speler(Veld veld) {
        this.beginveld = veld;
        imgIc = new ImageIcon("src/images/spelerTest.png");
        img = imgIc.getImage();
    }

    public void drawObject(Graphics g) {
        g.drawImage(this.img, beginveld.getXCo(), beginveld.getYCo(), null);
    }

    public enum Richting {

        NORTH("north"), EAST("east"), SOUTH("south"), WEST("west");
        private final String richting;

        public String getRichting() {
            return richting;
        }

        Richting(String r) {
            richting = r;
        }
    }

    public void bewegen(Richting r) {
        Veld buurveld = beginveld.getBuur(r);
        if (!(buurveld instanceof Muur)) {
            this.beginveld = buurveld;
            aantalStappen++;
        }
    }
    
//    public class input implements KeyListener{
//
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//            int keycode = e.getKeyCode();
//            if (keycode == KeyEvent.VK_UP) {
//                s.bewegen(Richting.NORTH);
//            }
//            if (keycode == KeyEvent.VK_DOWN) {
//                s.bewegen(Richting.SOUTH);
//            }
//            if (keycode == KeyEvent.VK_RIGHT) {
//                s.bewegen(Richting.EAST);
//            }
//            if (keycode == KeyEvent.VK_LEFT) {
//                s.bewegen(Richting.EAST);
//            }
//        }
//
//        @Override
//        public void keyTyped(KeyEvent e) {
//            
//        }
//        
//        @Override
//        public void keyReleased(KeyEvent e) {
//            
//        }
//    
//    }
}