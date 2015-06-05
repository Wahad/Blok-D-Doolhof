/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;


/**
 *
 * @author Gebruiker
 */
public class DoolhofSpel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       HoofdMenu frame = new HoofdMenu();
       frame.setSize(800,720);
       frame.setVisible(true);
       frame.setBackground(Color.ORANGE);
       centreWindow(frame);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
    }
     public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    
}
