/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Gebruiker
 */
public class Titlebar extends JPanel {

    protected ImageIcon imgIc = new ImageIcon("src/images/title.png");
    protected Image img = imgIc.getImage();
    private JButton button;

    public Titlebar() {
        
        button = new JButton("Start spel");
        this.add(button);
        GoTo();
    }

    public void GoTo() {
        button.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        SpelFrame SpelFrame = new SpelFrame();
                        SpelFrame.setSize(800, 720);
                        SpelFrame.setVisible(true);
                        DoolhofSpel.centreWindow(SpelFrame);
                        SpelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, 300, 1, null);
        setBackground(Color.ORANGE);
    }
}
