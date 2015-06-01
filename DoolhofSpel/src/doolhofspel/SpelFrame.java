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
        Dimension dframe = new Dimension();
        dframe.height = 700;
        dframe.width = 900;
        Dimension dtitle = new Dimension();
        dtitle.height = 30;
        dtitle.width = 900;
        
        this.setSize(dframe);
        JPanel title = new JPanel();
        title.setPreferredSize(dtitle);
        title.setBackground(Color.red);
        add(title, BorderLayout.NORTH);
        
        level = new Level();
        Dimension dcenter = new Dimension();
        dcenter.height = 640;
        dcenter.width = 640;
        level.setSize(dcenter);
        add(level, BorderLayout.CENTER);
    }
}
