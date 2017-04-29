package kevin;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/**
 * Main GUI frame for the game
 */

class GUIMain extends Frame {

    private Label[][] labelGrid;

    private Panel controlPanel;

    private Grid mainMethodGrid;

    // Getter are setter for the main grids
    Grid getMainGrid() { return mainMethodGrid; } // sends the modified instance of grid back to main
    void setMainGrid(Grid g) { this.mainMethodGrid = g; } // gets the instance of grid from main


    // prepare the main grid layout for the numbers
    // create all the labels and add them to the GUIMain Frame, they are still empty memory at this stage
    GUIMain() {
        super.setSize(500,500);

        super.setLayout(new GridLayout(5,4));

        labelGrid = new Label[Grid.SIZE][Grid.SIZE];

        for(int i = 0; i < Grid.SIZE; ++i) {
            for(int j= 0; j < Grid.SIZE; ++j) {
                labelGrid[i][j] = new Label();
                super.add(labelGrid[i][j]);
                //labelGrid[i][j].setText(grid.mainGrid[i][j].toString());
            }
        }

        super.setTitle("2048 Game");

        setupGUI();

        super.setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });

    }


    // this sets up the buttons, as well as the panel and sets action commands
    // for the buttons
    private void setupGUI() {

        Panel controlPanel = new Panel(new FlowLayout());

        // Allocate the buttons
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
                labelGrid[i][j].setText(mainMethodGrid.mainGrid[i][j].toString());
            }
        }
    }

    // private action listener class for buttons
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






