package kevin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/**
 * Main GUI frame for the game
 */

class GUIMain extends Frame implements KeyListener {

   // private Label[][] labelGrid;;
    private Grid mainMethodGrid;
    private GraphicsTile[][] tileGrid;

    // Getter are setter for the main grids
    // Grid getMainGrid() { return mainMethodGrid; } // sends the modified instance of grid back to main
    void setMainGrid(Grid g) { this.mainMethodGrid = g; } // gets the instance of grid from main

    /**
     * Constructs the main frame for the game.  This method sets things like the layout,
     * the size of the window, and initializes graphics of the game.
     */
    GUIMain() {
        // first we set some simple parameters pertaining to the frame
        setSize(500,500);
        setLayout(new GridLayout(5,4));

       // labelGrid = new Label[Grid.SIZE][Grid.SIZE];
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

        // FIXME this returns false, meaning that the window does not have focus
        // FIXME use keybinding in swing to fix this problem
        System.out.println(Boolean.toString(hasFocus()));

        //FIXME WHY YOU NO WORK
        addKeyListener(this);

        // Make the 'X' button on the window actually close the application
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });

    }


    /**
     * Sets up the the
     */
    private void setupGUI() {

        //
        Panel controlPanel = new Panel(new FlowLayout());

        // Define the buttons
        JButton rightButton = new JButton("Right");
        JButton leftButton = new JButton("Left");
        JButton downButton = new JButton("Down");
        JButton upButton = new JButton("Up");

        // Add them to the control panel
        controlPanel.add(upButton);
        controlPanel.add(downButton);
        controlPanel.add(leftButton);
        controlPanel.add(rightButton);

        // Add the control panel to the super frame
        add(controlPanel);

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


        JButton helpButton = new JButton("Help");
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

    /**
     * When the Help button is pressed, this class creates a new help window
     */
    private class HelpWindowListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(Objects.equals(e.getActionCommand(), "HELP"))
                new HelpMenu();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KEYPRESS REGISTERED"); // FIXME never gets called
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                System.out.println("UP");
                mainMethodGrid.move(Direction.UP);
                mainMethodGrid.generateSquare();
                mainMethodGrid.gameOver();
                break;
            case KeyEvent.VK_A:
                mainMethodGrid.move(Direction.LEFT);
                mainMethodGrid.generateSquare();
                mainMethodGrid.gameOver();
                break;
            case KeyEvent.VK_S:
                mainMethodGrid.move(Direction.DOWN);
                mainMethodGrid.generateSquare();
                mainMethodGrid.gameOver();
                break;
            case KeyEvent.VK_D:
                mainMethodGrid.move(Direction.RIGHT);
                mainMethodGrid.generateSquare();
                mainMethodGrid.gameOver();
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // FIXME this never gets called either
        System.out.println("KEYRELEASE REGISTERED");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // FIXME same problem here. This cannot be called
        System.out.println("KEYTYPED REGISTERED");
    }

    /**
     * Keyboard Listener class
     */
    private class KeyboardListener implements KeyListener {
        //FIXME WHY DON'T I WORK RIGHT
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("KEYPRESS REGISTERED"); // FIXME never gets called
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    System.out.println("UP");
                    mainMethodGrid.move(Direction.UP);
                    mainMethodGrid.generateSquare();
                    mainMethodGrid.gameOver();
                    break;
                case KeyEvent.VK_A:
                    mainMethodGrid.move(Direction.LEFT);
                    mainMethodGrid.generateSquare();
                    mainMethodGrid.gameOver();
                    break;
                case KeyEvent.VK_S:
                    mainMethodGrid.move(Direction.DOWN);
                    mainMethodGrid.generateSquare();
                    mainMethodGrid.gameOver();
                    break;
                case KeyEvent.VK_D:
                    mainMethodGrid.move(Direction.RIGHT);
                    mainMethodGrid.generateSquare();
                    mainMethodGrid.gameOver();
                    break;
            }
        }


        @Override
        public void keyReleased(KeyEvent e) {
            // FIXME this never gets called either
            System.out.println("KEYRELEASE REGISTERED");
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // FIXME same problem here. This cannot be called
            System.out.println("KEYTYPED REGISTERED");
        }
    }
}






