import mainFrame.mainFrame;
public class Main {
    public static void main(String[] args) {
        mainFrame frame = new mainFrame();
        while(true){
            System.out.print("\rCurent Position: " + frame.getFrame().getLocation());
        }
    }
}
