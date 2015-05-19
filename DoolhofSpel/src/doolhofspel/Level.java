/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JPanel;

/**
 *
 * @author Menno
 */
public class Level extends JPanel {
    private int x;
    private int score;
    private int levelnummer;
    final int pixelsize = 32;
    final int aantalVelden = 0;
    private Scanner level;
    Veld[][] velden = new Pad[aantalVelden][aantalVelden];
    
    
    public Level()
    {
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
}
