package mainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jeuFrame {
    private JFrame frame;

    private int width;
    private int height;

    public jeuFrame(JFrame frame) {
        this.frame = frame;
        cleanFrame();
    }

    private void cleanFrame() {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
    }

}
