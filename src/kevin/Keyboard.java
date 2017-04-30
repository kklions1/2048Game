package kevin;

import java.awt.event.*;
import java.util.EventListener;

/**
 *  Trying to make a class that reads keyboard inputs
 *
 */
public abstract class Keyboard implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:

                break;
            case KeyEvent.VK_A:

                break;
            case KeyEvent.VK_S:

                break;
            case KeyEvent.VK_D:

                break;
        }
    }

}
