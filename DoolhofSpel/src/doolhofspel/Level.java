/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Menno
 */
public class Level extends JPanel {

    private int x;
    private int score;
    private int levelnummer = 1;
    final int pixelsize = 32;
    final int aantalVelden = 20;
    private Scanner level;
    Veld[][] velden = new Veld[aantalVelden][aantalVelden];
    private Speler s;
    private Vriend v;
    private Richting richt;
    SpelFrame frame;

    public Level() {
        addKeyListener(new input()); 
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        openLevel();
        leesLevelIn();
        sluitLevel();

    }

    private void openLevel() {

        try {
            level = new Scanner(new File("src/images/testlevel" + levelnummer+ ".txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Geen map gevonden " + e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.ORANGE);
        for (int x = 0; x < aantalVelden; x++) {
            for (int y = 0; y < aantalVelden; y++) {
                velden[x][y].drawObject(g);
            }
        }
    }

    private void leesLevelIn() {
        x = 0;
        while (level.hasNext()) {
            for (int y = 0; y < aantalVelden; y++) {
                velden[x][y] = new Veld((x * pixelsize) + 10, (y * pixelsize) + 10);
                switch (level.next()) {
                    case "A":
                        SpelObject m = new Muur(velden[x][y]);
                        velden[x][y].setObject(m);
                        break;
                    case "S":
                        s = new Speler(velden[x][y]);
                        velden[x][y].setObject(s);
                        break;
                    case "B":
                        v = new Vriend(velden[x][y]);
                        v.level = this;
                        velden[x][y].setObject(v);
                        
                        break;
                        
                     case "V":
                        SpelObject v = new ValsSpeler(velden[x][y]);
                        velden[x][y].setObject(v);
                        break;
                }
            }
            x++;
        }
        
        for (int x = 0; x < aantalVelden; x++) {
            for (int y = 0; y < aantalVelden; y++) {
                if (x > 0) {
                    velden[x][y].setBuur(Richting.WEST, velden[x - 1][y]);
                }
                if (y > 0) {
                    velden[x][y].setBuur(Richting.NORTH, velden[x][y - 1]);
                }
                if (x < aantalVelden - 1) {
                    velden[x][y].setBuur(Richting.EAST, velden[x + 1][y]);
                }
                if (y < aantalVelden - 1) {
                    velden[x][y].setBuur(Richting.SOUTH, velden[x][y + 1]);
                }
            }
        }
    }
    
    private void sluitLevel(){
        level.close();
    }
    
    public void restart(){
        openLevel();
        leesLevelIn();
        sluitLevel();
    }
    
    public int getNummer(){
        return levelnummer;
    }
    public void setNummer(int nummer){
        this.levelnummer = nummer;
    }
    
    public class input implements KeyListener{
        

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            
            if (keycode == KeyEvent.VK_UP) {
                s.bewegen(Richting.NORTH);
                richt = Richting.NORTH;
            }
            if (keycode == KeyEvent.VK_DOWN) {
                s.bewegen(Richting.SOUTH);
                richt = Richting.SOUTH;
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                s.bewegen(Richting.EAST);
                richt = Richting.EAST;
            }
            if (keycode == KeyEvent.VK_LEFT) {
                s.bewegen(Richting.WEST);
                richt = Richting.WEST;
            }
            if (keycode == KeyEvent.VK_R){
                restart();
            }
            
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    
    }
}
