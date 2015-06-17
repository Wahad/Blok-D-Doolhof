/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Menno
 */
public class HoofdMenu extends JFrame {
    Titlebar title;
    private final JButton start;
    private final JButton instructie;
    
    public HoofdMenu()
    {
    super("Find the Princess|Made by Roy van der Ende and Menno van Hameren");
        setLayout(new FlowLayout());

        start = new JButton("Start Spel");
        add(start);

        instructie = new JButton("Besturing");
        add(instructie);

        start.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        SpelFrame frame = new SpelFrame();
                        frame.setSize(860,700);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                }
        );
        instructie.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        HulpMenu hulp = new HulpMenu();
                        hulp.setSize(820, 800);
                        hulp.setLocationRelativeTo(null);
                        hulp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        hulp.setVisible(true);
                    }
                }
        );
    }

  
    }



