package mainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame {
    private JFrame frame;
    private JPanel panel;
    private JButton button;

    private int width;
    private int height;

    public mainFrame() {
        cleanFrame();
        initializeDimensions();
        initializeComponents();
        setupFrame();
    }

    private void cleanFrame() {
        frame = new JFrame();
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
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
        panel = new JPanel();

        button.addActionListener
        (
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Bouton joué cliqué");
                    frame.dispose();
                    jeuFrame jeu = new jeuFrame(frame, width, height);
                }
            });

        panel.add(button);
    }

    public void setupFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(width / 4, height / 4);
        frame.setSize(width / 2, height / 2);
        frame.setLayout(new BorderLayout());
        
        panel.setLayout(null);
        int widthButton = 150;
        int heightButton = 30;
        button.setBounds(width / 4 - widthButton / 2, height / 4 - heightButton / 2, widthButton, heightButton);

        frame.add(panel);

        frame.setVisible(true);   
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JButton getButton() {
        return this.button;
    }
}
