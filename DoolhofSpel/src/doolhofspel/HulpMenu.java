/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Menno
 */
public class HulpMenu extends JFrame {
      private ImageIcon image1;
    private JLabel besturing;
    private JButton close;

    public HulpMenu() {
        super("Hulpmenu");
        setLayout(new FlowLayout());
        image1 = new ImageIcon("src/images/controls.png");
        besturing = new JLabel(image1);
        add(besturing);
        close = new JButton("Terug");
        add(close);

        close.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        dispose();
                    }
                }
        );
    
}
}
