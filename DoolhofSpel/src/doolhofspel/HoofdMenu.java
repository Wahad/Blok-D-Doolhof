/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Menno
 */
public class HoofdMenu extends JFrame {
    
    private JButton button;
    
    public HoofdMenu()
    {
        setLayout(new FlowLayout());
    button = new JButton("Start spel");
    add(button);
    GoTo();
    }
    
    public void GoTo()
    {
    button.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        SpelFrame SpelFrame = new SpelFrame();
                        SpelFrame.setSize(800,720);
                        SpelFrame.setVisible(true);
                        DoolhofSpel.centreWindow(SpelFrame);
                        SpelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                }
        );
    }
    }


