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

       // Panel gridPanel = new Panel(new GridLayout(4, 4));
        Panel controlPanel = new Panel(new FlowLayout());


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

        rightButton = new Button("Right");
        leftButton = new Button("Left");
        downButton = new Button("Down");
        upButton = new Button("Up");
        controlPanel.add(upButton);
        controlPanel.add(downButton);
        controlPanel.add(leftButton);
        controlPanel.add(rightButton);


        super.add(controlPanel);

        super.setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });

    }

    public void displayGrid(Grid grid) {
        for(int i = 0; i < Grid.SIZE; ++i) {
            for(int j = 0; j < Grid.SIZE; ++j) {
                labelGrid[i][j].setText(grid.mainGrid[i][j].toString());
            }
        }
    }
}
