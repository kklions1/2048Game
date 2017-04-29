package kevin;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class HelpMenu extends Frame {

    HelpMenu() {


        Label helpTextLine1;
        Label helpTextLine3;
        Label helpTextLine2;

        setTitle("Help");
        setSize(300,150);


        helpTextLine1 = new Label("Controls:");
        helpTextLine2 = new Label("W = up, A = left, S = down, D = right");
        helpTextLine3 = new Label("Written by Kevin Klions");

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
