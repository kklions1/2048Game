package kevin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/**
 * Main GUI frame for the game
 */

class GUIMain extends JFrame {

    private Grid mainMethodGrid;
    private GraphicsTile[][] tileGrid;
    private int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;


    void setMainGrid(Grid g) { this.mainMethodGrid = g; } // gets the instance of grid from main

    /**
     * Constructs the main frame for the game.  This method sets things like the layout,
     * the size of the window, and initializes graphics of the game.
     */
    GUIMain() {
        // first we set some simple parameters pertaining to the frame
        setSize(500,500);
        setLayout(new GridLayout(5,4));

        tileGrid = new GraphicsTile[Grid.SIZE][Grid.SIZE];


        for(int i = 0; i < Grid.SIZE; ++i) {
            for(int j= 0; j < Grid.SIZE; ++j) {
                tileGrid[i][j] = new GraphicsTile();
                add(tileGrid[i][j]);// the grid has no values in it at this stage
            }
        }

        setTitle("2048 Game");


        JPanel controlPanel = new JPanel(new FlowLayout());

        // Add the control panel to the super frame
        add(controlPanel);

        // Make the help button
        JButton helpButton = new JButton("Help");
        helpButton.setActionCommand("HELP");
        helpButton.addActionListener(new HelpWindowListener());
        controlPanel.add(helpButton);


        setupControls();

        setVisible(true);


        // Make the 'X' button on the window actually close the application
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });

    }


    /**
     * Sets up the the controls of the game
     */
    private void setupControls() {

        Action keyMove = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "w":
                        mainMethodGrid.move(Direction.UP);
                        mainMethodGrid.moveProgression();
                        break;
                    case "a":
                        mainMethodGrid.move(Direction.LEFT);
                        mainMethodGrid.moveProgression();
                        break;
                    case "s":
                        mainMethodGrid.move(Direction.DOWN);
                        mainMethodGrid.moveProgression();
                        break;
                    case "d":
                        mainMethodGrid.move(Direction.RIGHT);
                        mainMethodGrid.moveProgression();
                        break;
                    // Accidentally pressing the CAPSLOCK key would break the controls of the game
                    // So these cases are here to fix that
                    case "W":
                        mainMethodGrid.move(Direction.UP);
                        mainMethodGrid.moveProgression();
                        break;
                    case "A":
                        mainMethodGrid.move(Direction.LEFT);
                        mainMethodGrid.moveProgression();
                        break;
                    case "S":
                        mainMethodGrid.move(Direction.DOWN);
                        mainMethodGrid.moveProgression();

                        break;
                    case "D":
                        mainMethodGrid.move(Direction.RIGHT);
                        mainMethodGrid.moveProgression();
                        break;
                }
            }
        };


        JRootPane rootPane = getRootPane();

        // Bind for W -> up
        rootPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), "UP");
        rootPane.getActionMap().put("UP", keyMove);

        // Bind for A -> left
        rootPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("A"), "LEFT");
        rootPane.getActionMap().put("LEFT", keyMove);

        // Bind for S -> down
        rootPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), "DOWN");
        rootPane.getActionMap().put("DOWN", keyMove);

        // Bind for D -> right
        rootPane.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), "RIGHT");
        rootPane.getActionMap().put("RIGHT", keyMove);


    }


    // a draw function for the grid class
    // this redraws the number grid being displayed on the GUI
    void displayGrid() {
        for(int i = 0; i < Grid.SIZE; ++i) {
            for(int j = 0; j < Grid.SIZE; ++j) {
                tileGrid[i][j].setLabel(mainMethodGrid.mainGrid[i][j].toString());
            }
        }
    }


    /**
     * Listener class for the help button
     */
    private class HelpWindowListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(Objects.equals(e.getActionCommand(), "HELP"))
                new HelpMenu();
        }
    }


}






