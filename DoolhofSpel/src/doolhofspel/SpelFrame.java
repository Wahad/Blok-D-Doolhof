/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpelFrame extends JFrame {
    HoofdMenu menu;
    Level level;
    Sidebar side;
    Titlebar title;
    

    public SpelFrame() {

        
        this.setPreferredSize(new Dimension(800, 720));
        title = new Titlebar();
        
        title.setPreferredSize(new Dimension(800, 30));
        title.setBackground(Color.ORANGE);
        add(title, BorderLayout.NORTH);
       
        side = new Sidebar();
        side.setPreferredSize(new Dimension(100, 720));
        add(side, BorderLayout.EAST);
        
        level = new Level();
        level.setPreferredSize(new Dimension(640, 640));
        add(level, BorderLayout.CENTER);
        
        
        
        level.setFrame(this);
        side.setLevel(level);
        this.repaint();
    }
}
