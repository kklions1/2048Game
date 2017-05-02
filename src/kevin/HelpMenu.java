package kevin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This window simply explains the controls with a few simple lines of text
 */
class HelpMenu extends JFrame {

    HelpMenu() {


        JLabel helpTextLine1;
        JLabel helpTextLine3;
        JLabel helpTextLine2;

        setTitle("Help");
        setSize(300,150);


        helpTextLine1 = new JLabel("Controls:");
        helpTextLine2 = new JLabel("W = up, A = left, S = down, D = right");
        helpTextLine3 = new JLabel("Written by Kevin Klions");

        setLayout(new FlowLayout());

        add(helpTextLine1);
        add(helpTextLine2);
        add(helpTextLine3);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { setVisible(false); }
        });




    }

}
