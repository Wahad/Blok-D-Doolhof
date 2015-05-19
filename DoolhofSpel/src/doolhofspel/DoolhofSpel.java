/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

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
       JFrame fraam = new SpelFrame();
       fraam.setSize(700,700);
       fraam.setLocationRelativeTo(null);
       fraam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       fraam.setVisible(true);
    }
}
