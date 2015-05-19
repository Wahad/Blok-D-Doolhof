/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Roberto & Gert-Jan
 */
public class SpelFrame extends JFrame {
     Level level;
 public SpelFrame() {
        setLayout(new BorderLayout());
        
        level = new Level();
        level.setSize(680, 700);
        add(level);
        this.setSize(680, 700);
        this.repaint();
    }
}
