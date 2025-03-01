package map;

import java.math.*;

public class map3D {
    private int[][][] map;

    public map3D(int width, int height, int depth) {
        this.map = new int[width][height][depth];
    }

    public map3D(map3D map) {
        this.map = map.getMap();
    }

    public int[][][] getMap() {
        return this.map;
    }

    public void setMap(int[][][] map) {
        this.map = map;
    }

    public void setBlock(int x, int y, int z, int block) {
        this.map[x][y][z] = block;
    }

    public int getBlock(int x, int y, int z) {
        return this.map[x][y][z];
    }

    public void generateMap() {
        for (int x = 0; x < this.map.length; x++) {
            for (int y = 0; y < this.map[0].length; y++) {
                for (int z = 0; z < this.map[0][0].length; z++) {
                    if (z == 0) {
                        this.map[x][y][z] = 1;
                    } else {
                        this.map[x][y][z] = 0;
                    }
                }
            }
        }
    }

    public map3D getVisibleMap(int x0, int y0, int z0) {
        map3D visibleMap = new map3D(this.map.length, this.map[0].length, this.map[0][0].length);

        for (int x = 0; x < this.map.length; x++) {
            for (int y = 0; y < this.map[0].length; y++) {
                for (int z = 0; z < this.map[0][0].length; z++) {
                    if (isVisible(x0, y0, z0, x, y, z)) {
                        visibleMap.setBlock(x, y, z, this.map[x][y][z]);
                    } else {
                        visibleMap.setBlock(x, y, z, -1);
                    }
                }
            }
        }
        return visibleMap;
    }

    public int[][] fromVisibleMap3DToImage(map3D map) {
        int[][] image = new int[map.getMap().length][map.getMap()[0].length];

        for (int x = map.getMap().length - 1; x >= 0; x--) {
            for (int y = 0; y < map.getMap()[0].length; y++) {
                for (int z = 0; z < map.getMap()[0][0].length; z++) {
                    if (map.getBlock(x, y, z) != -1) {
                        image[x][y] = map.getBlock(x, y, z);
                    }
                }
            }
        }
        return image;
    }

    public Boolean isVisible(int x0, int y0, int z0, int x, int y, int z) {
        if (x < x0){
            return false;
        }
        double R = 1.19 * (x - x0);

        if (Math.abs(z - z0) > R){
            return false;
        }

        int h = y - y0;

        if ((z-z0) * (z-z0) > R * R - h * h){
            return false;
        }
        return true;
    }

    public String toString() {
        String str = "";
        for (int x = 0; x < this.map.length; x++) {
            for (int y = 0; y < this.map[0].length; y++) {
                for (int z = 0; z < this.map[0][0].length; z++) {
                    str += this.map[x][y][z] + " ";
                }
                str += "\n";
            }
            str += "\n" + x + "\n";
        }
        return str;
    }
}
