package kevin;

import java.awt.*;

/**
 * Used to help color the grid so that things don't look super ugly
 * and also it increases readability of the actual numbers
 */
public class GraphicsTile extends Panel {

    private Label value;

    GraphicsTile() {

        value = new Label();
        value.setAlignment(Label.CENTER);
        add(value);
        setVisible(true);
    }

    void setLabel(String text) { this.value.setText(text); }
}
