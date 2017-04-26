package kevin;

import java.awt.*;
import java.awt.event.*;

/**
 * Main GUI frame for the game
 */

public class GUIMain extends Frame {

    private Label[][] labelGrid;

    private Panel controlPanel;
    private Button upButton;
    private Button leftButton;
    private Button rightButton;
    private Button downButton;

    // prepare the main grid layout for the numbers
    // and sets all labels in the grid layout to the initial mainGrid values
    // which should be 0
    public GUIMain(Grid grid) {
        super.setSize(500,500);





        super.setLayout(new GridLayout(5,4));

        labelGrid = new Label[Grid.SIZE][Grid.SIZE];

        for(int i = 0; i < Grid.SIZE; ++i) {
            for(int j= 0; j < Grid.SIZE; ++j) {
                labelGrid[i][j] = new Label();
                super.add(labelGrid[i][j]);
                labelGrid[i][j].setText(grid.mainGrid[i][j].toString());
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
        rightButton = new Button("Right");
        leftButton = new Button("Left");
        downButton = new Button("Down");
        upButton = new Button("Up");

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


    }


    // a draw function for the grid class
    // this redraws the number grid being displayed on the GUI
    public void displayGrid(Grid grid) {
        for(int i = 0; i < Grid.SIZE; ++i) {
            for(int j = 0; j < Grid.SIZE; ++j) {
                labelGrid[i][j].setText(grid.mainGrid[i][j].toString());
            }
        }
    }

    // private action listener class for buttons
    private class ButtonClickListener extends Grid implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Switches on the Action Command String
            switch (e.getActionCommand()) {
                case "LEFT":
                    System.out.print("test");
                    move(Direction.LEFT);
                    break;
                case "RIGHT":
                    System.out.print("test");

                    move(Direction.RIGHT);
                    break;
                case "UP":
                    System.out.print("test");

                    move(Direction.UP);
                    break;
                case "DOWN":
                    System.out.print("test");

                    move(Direction.DOWN);
                    break;


            }
        }
    }
}






