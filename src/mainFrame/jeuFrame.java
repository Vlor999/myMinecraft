package mainFrame;

import map.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class jeuFrame {
    private JFrame frame;
    private GamePanel panel;

    private int width;
    private int height;

    private map3D map3d;
    private position3D player;

    public jeuFrame(JFrame frame, int width, int height) {
        this.frame = frame;
        this.width = width;
        this.height = height;
        cleanFrame();
        initializeComponents();
        setupFrame();
        launchGame();
    }

    private void initializeComponents() {
        frame = new JFrame("MineWillem - Jeu");
        player = new position3D();
        map3d = new map3D(8, 8, 8);
        map3d.generateMap();

        panel = new GamePanel(map3d, player);
    }

    private void cleanFrame() {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
    }

    public void setupFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(width / 4, height / 4);
        frame.setSize(width / 2, height / 2);
        frame.setLayout(new BorderLayout());

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public void launchGame() {
        panel.setFocusable(true);
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                
                if (keyCode == KeyEvent.VK_ESCAPE) {
                    System.out.println("Quitter le jeu...");
                    mainFrame mainFrame = new mainFrame();
                    frame.dispose();
                }
                else if (keyCode == KeyEvent.VK_ENTER) {
                    frame.dispose();
                }
                if (key.getKey(keyCode) != null) {
                    gereKeyCode(keyCode);
                }
            }
        });

        panel.requestFocusInWindow();
    }

    private void gereKeyCode(int keyCode) {
        player.updatePosition(key.getKey(keyCode));
        System.out.println(map3d.getVisibleMap(player.getX(), player.getY(), player.getZ()));
        panel.repaint();
    }
}
