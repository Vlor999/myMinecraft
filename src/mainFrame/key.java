package mainFrame;

import java.awt.event.KeyEvent;

public enum key {
    FRONT,
    BACK,
    LEFT,
    RIGHT,
    UP,
    DOWN;

    public static key getKey(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_W:
                return FRONT;
            case KeyEvent.VK_S:
                return BACK;
            case KeyEvent.VK_A:
                return LEFT;
            case KeyEvent.VK_D:
                return RIGHT;
            case KeyEvent.VK_SPACE:
                return UP;
            case KeyEvent.VK_SHIFT:
                return DOWN;
            default:
                return null;
        }
    }



}
