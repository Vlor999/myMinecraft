package mainFrame;

import map.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private map3D map;
    private position3D player;


    private static final int CELL_SIZE = 50; // Taille des cellules

    public GamePanel(map3D map, position3D player) {
        this.map = map;
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int[][] grid = map.fromVisibleMap3DToImage(map.getVisibleMap(player.getX(), player.getY(), player.getZ()));
        int[] cellSize = getCellSize();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int value = grid[row][col];

                // Définir la couleur en fonction de la valeur de la cellule
                if (value == 1) {
                    g.setColor(Color.BLUE);
                } else if (value == 2) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(Color.WHITE);
                }

                // Dessiner le rectangle
                int x = col * cellSize[0];
                int y = row * cellSize[1];
                g.fillRect(x, y, cellSize[0], cellSize[1]);
            }
        }

        // Dessiner la position du joueur en rouge
        g.setColor(Color.RED);
        g.fillOval(player.getX() * cellSize[0] + cellSize[0] / 4, 
                   player.getY() * cellSize[1] + cellSize[1] / 4, 
                   cellSize[0] / 2, cellSize[1] / 2);
    }

    private int[] getCellSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int width = (int) screenSize.getWidth()/8;
        int height = (int) screenSize.getHeight()/8;
        return new int[] {width, height};
    }
}
