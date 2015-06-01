/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class SpelFrame extends JFrame {

    Level level;

    public SpelFrame() {

        setLayout(new BorderLayout());
        this.setSize(700, 700);

        level = new Level();
        level.setSize(680, 700);
        add(level, BorderLayout.CENTER);
    }
}
