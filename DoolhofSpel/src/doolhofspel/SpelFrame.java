/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpelFrame extends JFrame {

    Level level;

    public SpelFrame() {

        setLayout(new BorderLayout());
        
        this.setPreferredSize(new Dimension(800, 720));
        JPanel title = new JPanel();
        title.setPreferredSize(new Dimension(800, 30));
        title.setBackground(Color.ORANGE);
        JPanel side = new JPanel();
        side.setPreferredSize(new Dimension(100, 720));
        side.setBackground(Color.ORANGE);
        
        level = new Level();
        level.setPreferredSize(new Dimension(640, 640));
        add(level, BorderLayout.CENTER);
        add(title, BorderLayout.NORTH);
        add(side, BorderLayout.EAST);
    }
}
