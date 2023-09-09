import javax.swing.JFrame;
import java.awt.*;

public class Display{
    GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    static JFrame window = new JFrame();
    public Display(){
        window.setSize(1960, 1020);
        window.setLayout(null);
        device.setFullScreenWindow(window);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu test = new MainMenu();   
        test.start();
    }
    public static void startPVP(){
        PVPGrid pvpGrid = new PVPGrid();
    }
    public static void startMainMenu(){
        MainMenu menu = new MainMenu();
        menu.start();
    }
    public static void startPVE(){
        AIChoice aiChoice = new AIChoice();
    }
}