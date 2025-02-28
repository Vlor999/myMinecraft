package mainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame {
    private JFrame frame;
    private JButton button;

    private int width;
    private int height;

    public mainFrame() {
        initializeDimensions();
        initializeComponents();
        setupFrame();
    }

    private void initializeDimensions() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        this.width = (int) screenSize.getWidth();
        this.height = (int) screenSize.getHeight();
    }

    private void initializeComponents() {
        frame = new JFrame("MineWillem");
        button = new JButton("Jouer");

        button.addActionListener
        (
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Bouton cliqué");
                    jeuFrame jeu = new jeuFrame(frame);
                }
            });
    }

    public void setupFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(width / 4, height / 4);
        frame.setSize(width / 2, height / 2);
        frame.setLayout(new BorderLayout());

        frame.add(button, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JButton getButton() {
        return this.button;
    }
}
