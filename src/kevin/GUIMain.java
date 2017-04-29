package kevin;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/**
 * Main GUI frame for the game
 */

class GUIMain extends Frame {

    private Label[][] labelGrid;
    //private Panel controlPanel;
    private Grid mainMethodGrid;
    private GraphicsTile[][] tileGrid;

    // Getter are setter for the main grids
    // Grid getMainGrid() { return mainMethodGrid; } // sends the modified instance of grid back to main
    void setMainGrid(Grid g) { this.mainMethodGrid = g; } // gets the instance of grid from main


    // prepare the main grid layout for the numbers
    // create all the labels and add them to the GUIMain Frame, they are still empty memory at this stage
    GUIMain() {
        // first we set some simple parameters pertaining to the frame
        setSize(500,500);
        setLayout(new GridLayout(5,4));

        labelGrid = new Label[Grid.SIZE][Grid.SIZE];
        tileGrid = new GraphicsTile[Grid.SIZE][Grid.SIZE];


        for(int i = 0; i < Grid.SIZE; ++i) {
            for(int j= 0; j < Grid.SIZE; ++j) {
                tileGrid[i][j] = new GraphicsTile();
                add(tileGrid[i][j]);// the grid has no values in it at this stage
                //tileGrid[i][j].setAlignment(Label.CENTER);
            }
        }

        setTitle("2048 Game");

        setupGUI();

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });

    }


    // this sets up the buttons, as well as the panel and sets action commands
    // for the buttons
    private void setupGUI() {

        //
        Panel controlPanel = new Panel(new FlowLayout());

        // Define the buttons
        Button rightButton = new Button("Right");
        Button leftButton = new Button("Left");
        Button downButton = new Button("Down");
        Button upButton = new Button("Up");

        // Add them to the control panel
        controlPanel.add(upButton);
        controlPanel.add(downButton);
        controlPanel.add(leftButton);
        controlPanel.add(rightButton);

        // Add the control panel to the super frame
        super.add(controlPanel);

        // Set the action command for pressing a button
        rightButton.setActionCommand("RIGHT");
        leftButton.setActionCommand("LEFT");
        upButton.setActionCommand("UP");
        downButton.setActionCommand("DOWN");

        // Set the Action Listener class for the button
        rightButton.addActionListener(new ButtonClickListener());
        upButton.addActionListener(new ButtonClickListener());
        leftButton.addActionListener(new ButtonClickListener());
        downButton.addActionListener(new ButtonClickListener());


        Button helpButton = new Button("Help");
        helpButton.setActionCommand("HELP");
        helpButton.addActionListener(new HelpWindowListener());
        controlPanel.add(helpButton);

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
     * Implentation of the Action Listener for the game
     */
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Switches on the Action Command String
            switch (e.getActionCommand()) {
                case "LEFT":
                    System.out.print("test");
                    mainMethodGrid.move(Direction.LEFT);
                    mainMethodGrid.generateSquare();
                    mainMethodGrid.gameOver();
                    break;
                case "RIGHT":
                    System.out.print("test");
                    mainMethodGrid.move(Direction.RIGHT);
                    mainMethodGrid.generateSquare();
                    mainMethodGrid.gameOver();
                    break;
                case "UP":
                    System.out.print("test");
                    mainMethodGrid.move(Direction.UP);
                    mainMethodGrid.generateSquare();
                    mainMethodGrid.gameOver();
                    break;
                case "DOWN":
                    System.out.print("test");
                    mainMethodGrid.move(Direction.DOWN);
                    mainMethodGrid.generateSquare();
                    mainMethodGrid.gameOver();
                    break;
            }
        }
    }

    private class HelpWindowListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(Objects.equals(e.getActionCommand(), "HELP"))
                new HelpMenu();
        }
    }
}






