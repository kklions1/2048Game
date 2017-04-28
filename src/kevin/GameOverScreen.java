package kevin;

import java.awt.*;

/**
 * Created by kevin on 4/28/17.
 */


/* TODO finish implementing this window, and then make a true result from the gameover function
    create an new instance of this class
  */
public class GameOverScreen extends Frame {
    GameOverScreen() {
        Label gameOverText = new Label("Game Over");
        Button gameOverOK = new Button("OK");
        setTitle("GAME OVER");
        setLayout(new FlowLayout());
        setSize(300,150);
        add(gameOverText);
        add(gameOverOK);
    }


}
