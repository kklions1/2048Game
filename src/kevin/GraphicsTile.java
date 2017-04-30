package kevin;

import javax.swing.*;
import java.awt.*;

/**
 * Used to help color the grid so that things don't look super ugly
 * and also it increases readability of the actual numbers
 */
public class GraphicsTile extends JPanel {

    private JLabel value;

    GraphicsTile() {

        value = new JLabel();
        value.setAlignmentX(JLabel.CENTER);
        value.setAlignmentY(JLabel.CENTER);
        add(value);
        //setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setVisible(true);


    }

    void setLabel(String text) {
        this.value.setText(text);
        setColor();
    }


    private void setColor() {
        switch(value.getText()) {
            case "0":
                setBackground(Color.WHITE);
                break;
            case "2":
                setBackground(Color.GREEN);
                break;
            case "4":
                setBackground(Color.GRAY);
                break;
            case "8":
                setBackground(Color.LIGHT_GRAY);
                break;
            case "16":
                setBackground(Color.BLUE);
                break;
            case "32":
                setBackground(Color.MAGENTA);
                break;
            case "64":
                setBackground(Color.CYAN);
                break;
            case "128":
                setBackground(Color.RED);
                break;
            case "256":
                setBackground(Color.ORANGE);
                break;
            case "512":
                setBackground(Color.YELLOW);
                break;
            case "1024":
                setBackground(Color.GREEN);
                break;
            case "2048":
                setBackground(Color.BLUE);
                break;
            default:
                setBackground(Color.PINK);
                break;

        }
    }
}
