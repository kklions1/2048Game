package kevin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * window is displayed when the game is won (that is, a square has the value '2048')
 */
public class VictoryScreen extends JFrame {

    VictoryScreen() {
        JLabel victoryScreenText = new JLabel("You Won!");
        JButton victoryContinue = new JButton("Continue");
        JButton victoryExit = new JButton("Exit");

        setTitle("Congratulations");

        victoryScreenText.setAlignmentX(JLabel.CENTER);
        victoryScreenText.setAlignmentY(JLabel.CENTER);

        setLayout(new GridLayout(3,1));

        add(victoryScreenText);
        add(victoryContinue);
        add(victoryExit);

        setSize(300, 150);

        setVisible(true);
        setAlwaysOnTop(true);

        victoryContinue.setActionCommand("CONTINUE");
        victoryContinue.addActionListener(new VictoryListener());
        victoryExit.setActionCommand("EXIT");
        victoryExit.addActionListener(new VictoryListener());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });

    }


    /**
     * Listener class for the victory screen buttons
     */
    private class VictoryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()) {
                case "CONTINUE":
                    setVisible(false);
                    break;
                case "EXIT":
                    System.exit(0);
                    break;
            }
        }
    }
}
