package kevin;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/**
 * This class is a simple window that pops up to inform the player that
 * the game is over. This happens in the event that the game no longer has any
 * valid moves to be made
 */
public class GameOverScreen extends Frame {
    GameOverScreen() {

        // Label and a button
        Label gameOverText = new Label("Game Over");
        Button gameOverOK = new Button("OK");

        gameOverText.setAlignment(Label.CENTER);

        // Set Layout, title, and size of the window
        setTitle("GAME OVER");
        setLayout(new GridLayout(2,1));
        setSize(300,150);

        // Push the Label and Button into the layout
        add(gameOverText);
        add(gameOverOK);

        setVisible(true);

        // We set the window adapter to close, as well as the button
        // so that the user can close the program with either option
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });


        gameOverOK.setActionCommand("OK");
        gameOverOK.addActionListener(new OkayListener());
    }

    private class OkayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(Objects.equals(e.getActionCommand(), "OK"))
                System.exit(0);

        }
    }


}
