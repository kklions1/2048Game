package kevin;

import java.awt.*;
import java.awt.event.*;

/**
 * Main GUI frame for the game
 */

public class GUIMain extends Frame {

    Label[][] labelGrid;

    // prepare the main grid layout for the numbers
    // and sets all labels in the grid layout to the initial mainGrid values
    // which should be 0
    public GUIMain(Grid grid) {
        super.setSize(500,500);

        super.setLayout(new GridLayout(4, 5));

        labelGrid = new Label[Grid.SIZE][Grid.SIZE];

        for(int i = 0; i < Grid.SIZE; ++i) {
            for(int j= 0; j < Grid.SIZE; ++j) {
                labelGrid[i][j] = new Label();
                super.add(labelGrid[i][j]);
                labelGrid[i][j].setText(grid.mainGrid[i][j].toString());
            }
        }
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
