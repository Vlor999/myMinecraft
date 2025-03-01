package map;

import mainFrame.key;

public class position3D {
    private int x;
    private int y;
    private int z;

    public position3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public position3D() {
        this(0, 0, 0);
    }

    public void updatePosition(key currentKey) {
        switch (currentKey) {
            case FRONT:
                this.y++;
                break;
            case BACK:
                this.y--;
                break;
            case LEFT:
                this.x--;
                break;
            case RIGHT:
                this.x++;
                break;
            case UP:
                this.z++;
                break;
            case DOWN:
                this.z--;
                break;
            default:
                break;
        }
        System.out.println("Position: " + this.x + " " + this.y + " " + this.z);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }    
}
