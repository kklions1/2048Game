package kevin;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class HelpMenu {

    private Frame helpWindow;

    HelpMenu() {


        Label helpTextLine1;
        Label helpTextLine3;
        Label helpTextLine2;

        helpWindow = new Frame("Help");
        helpWindow.setSize(300,150);


        helpTextLine1 = new Label("Controls:");
        helpTextLine2 = new Label("W = up, A = left, S = down, D = right");
        helpTextLine3 = new Label("Written by Kevin Klions");

        helpWindow.setLayout(new FlowLayout());

        helpWindow.add(helpTextLine1);
        helpWindow.add(helpTextLine2);
        helpWindow.add(helpTextLine3);

        helpWindow.setVisible(true);

        helpWindow.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { helpWindow.setVisible(false); }
        });




    }

}
