/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import doolhofspel.Speler.Richting;

/**
 *
 * @author Menno
 */
public class Level extends JPanel {

    private int x;
    private int score;
    private int levelnummer;
    final int pixelsize = 32;
    final int aantalVelden = 20;
    private Scanner level;
    Veld[][] velden = new Veld[aantalVelden][aantalVelden];
    private Speler s;

    public Level() {
        addKeyListener(new input()); 
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        openLevel();
        leesLevelIn();

    }

    private void openLevel() {

        try {
            level = new Scanner(new File("src/images/testlevel.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Geen map gevonden " + e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < aantalVelden; x++) {
            for (int y = 0; y < aantalVelden; y++) {
                velden[x][y].drawObject(g);
            }
        }
        s = new Speler(velden[18][18]);
        s.drawObject(g);
    }

    private void leesLevelIn() {
        x = 0;
        while (level.hasNext()) {
            for (int y = 0; y < aantalVelden; y++) {
                velden[x][y] = new Veld((x * pixelsize) + 10, (y * pixelsize) + 10);
                switch (level.next()) {
                    case "P":
                        Veld pad = new Pad(velden[x][y]);
                        velden[x][y].setObject(pad);
                        break;
                    case "A":
                        Veld muur = new Muur(velden[x][y]);
                        velden[x][y].setObject(muur);
                        break;
                }
            }
            x++;
        }
    }
    
    public class input implements KeyListener{
        

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            
            if (keycode == KeyEvent.VK_UP) {
                s.bewegen(Richting.NORTH);
            }
            if (keycode == KeyEvent.VK_DOWN) {
                s.bewegen(Richting.SOUTH);
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                s.bewegen(Richting.EAST);
            }
            if (keycode == KeyEvent.VK_LEFT) {
                s.bewegen(Richting.EAST);
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    
    }
}
