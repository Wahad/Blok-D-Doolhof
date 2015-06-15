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
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Menno
 */
public class Level extends JPanel {

    private int y;
    private int levelnummer = 1;
    final int pixelsize = 32;
    final int aantalVelden = 20;
    private Scanner level;
    Veld[][] velden = new Veld[aantalVelden][aantalVelden];
    public Speler s;
    private Vriend v;
    private Helper h;
    private Item inHand;
    private List rugzak;
    SpelFrame frame;

    public Level() {

        addKeyListener(new input());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        openLevel();
        leesLevelIn();
        sluitLevel();
    }

    public void setFrame(SpelFrame frame) {
        this.frame = frame;
    }

    private void openLevel() {

        try {
            level = new Scanner(new File("src/images/testlevel" + levelnummer + ".txt"));
        } catch (FileNotFoundException e) {
            
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
        if (h.isGevonden()) {
            h.paintRoute(g);
            s.drawObject(g);
        }

    }

    private void leesLevelIn() {
        y = 0;
        while (level.hasNext()) {
            for (int x = 0; x < aantalVelden; x++) {

                velden[x][y] = new Veld((x * pixelsize), (y * pixelsize));
                switch (level.next()) {
                    case "A":
                        SpelObject m = new Muur(velden[x][y], false);
                        velden[x][y].setObject(m);
                        break;
                    case "W":
                        SpelObject w = new Muur(velden[x][y], true);
                        velden[x][y].setObject(w);
                        break;
                    case "F":
                        v = new Vriend(velden[x][y], false);
                        v.level = this;
                        velden[x][y].setObject(v);
                        break;
                    case "V":
                        Random rand = new Random();
                        int waarde = rand.nextInt(20) + 1;
                        SpelObject vs = new ValsSpeler(velden[x][y], waarde, true);
                        velden[x][y].setObject(vs);
                        break;
                    case "B":
                        SpelObject b = new Schep(velden[x][y], true);
                        velden[x][y].setObject(b);
                        break;
                    case "H":
                        h = new Helper(velden[x][y], false);
                        velden[x][y].setObject((Helper) h);
                        h.setVeldLijst(velden);
                        break;
                    case "T":
                        SpelObject t = new Teleporter(velden[x][y], true);
                        t.level = this;
                        velden[x][y].setObject(t);
                        break;
                    case "S":
                        s = new Speler(velden[x][y]);
                        velden[x][y].setObject(s);
                        break;
                }

            }
            y++;
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

    public int getScore() {
        return s.getaantalStappen();
    }

    private void sluitLevel() {
        level.close();
    }

    public void restart() {
        rugzak = s.getRugzak();
        inHand = null;
        rugzak = null;
        openLevel();
        leesLevelIn();
        sluitLevel();
    }

    public int getNummer() {
        return levelnummer;
    }

    public void setNummer(int nummer) {
        this.levelnummer = nummer;
    }

    public Veld[][] getVeldenLijst() {
        return velden;
    }
    
    

    public class input implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_UP) {
                s.bewegen(Richting.NORTH);
                s.setRicht(Richting.NORTH);
            }
            if (keycode == KeyEvent.VK_DOWN) {
                s.bewegen(Richting.SOUTH);
                s.setRicht(Richting.SOUTH);
                
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                s.bewegen(Richting.EAST);
                s.setRicht(Richting.EAST);
            }
            if (keycode == KeyEvent.VK_LEFT) {
                s.bewegen(Richting.WEST);
                s.setRicht(Richting.WEST);
            }
            if (keycode == KeyEvent.VK_SPACE) {
                inHand = s.getInHand();
                inHand.uitvoeren(s);
            }
            if (keycode == KeyEvent.VK_SHIFT) {
                s.selecteerAnderItem();
            }
            if (keycode == KeyEvent.VK_R) {
                restart();
            }
            repaint();
            frame.repaint();
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
