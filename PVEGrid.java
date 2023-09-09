import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class PVEGrid implements ActionListener{

    public static int xw = 0;
    public static int ow = 0;
    public static int draw = 0;

    public static double xwp = 0;
    public static double owp = 0;
    public static double drawp = 0;


    private JFrame window = Display.window;
    private Board grid = new Board(window);

    private JButton mainMenu = new JButton("Main Menu");
    private JButton newGame = new JButton("New Game");


    private static JLabel xwLable = new JLabel("X wins: " + xw + "| X win percentage: " + (int)xwp);
    private static JLabel owLable = new JLabel("O wins: " + ow + "| O win percentage: " + (int)owp);
    private static JLabel drawLable = new JLabel("Draws: " + draw + "| Draw percentage: " + (int)drawp);
    private JLabel title = new JLabel("Tic Tac Toe");
    

    private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private int width = gd.getDisplayMode().getWidth();
    private int height = gd.getDisplayMode().getHeight();
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    private String AI = "none";





    public PVEGrid(){
    }
    public void start(String nAI){
        mainMenu();
        newGame();
        textBoxs();
        AI = nAI;
        grid.setAI(AI);
        grid.start();
    }
    public void mainMenu(){
        mainMenu.setBounds((width/2- 225 - 400)/2, height/2 - 125, 400, 100);
        mainMenu.setFocusable(false);
        mainMenu.setFont(new Font(null, Font.PLAIN, 50));
        mainMenu.addActionListener(this);
        window.add(mainMenu);
    }
    public void newGame(){
        newGame.setBounds((width/2- 225 - 400)/2, height/2 + 25, 400, 100);
        newGame.setFocusable(false);
        newGame.setFont(new Font(null, Font.PLAIN, 50));
        newGame.addActionListener(this);
        window.add(newGame);
    }
    public void textBoxs(){
        title.setFont(new Font("SERIF", Font.PLAIN, 100));
        xwLable.setFont(new Font(null, Font.PLAIN, 35));
        owLable.setFont(new Font(null, Font.PLAIN, 35));
        drawLable.setFont(new Font(null, Font.PLAIN, 35));
        

        FontMetrics a = title.getFontMetrics(new Font("SERIF", Font.PLAIN, 100));
        int titleWidth = a.stringWidth("Tic Tac Toe");
        

        title.setBounds(width/2 - titleWidth/2, 100, 1000, 150);
        xwLable.setBounds(width/2 + 400, height/2 -225, 1000, 150);
        owLable.setBounds(width/2 + 400, height/2 -75, 1000, 150);
        drawLable.setBounds(width/2 + 400, height/2 +75, 1000, 150);
        

        window.add(title);
        window.add(xwLable);
        window.add(owLable);
        window.add(drawLable);
        
    }






    public static void draw(){
        draw++;
        calculatePercent();
    }
    public static void x(){
        xw++;
        calculatePercent();
    }
    public static void o(){
        ow++;
        calculatePercent();
    }
    public static void calculatePercent(){
        int total = draw + xw + ow;
        if(xw != 0){
            double tempW = xw;
            xwp = Math.round((tempW/total) * 100);
        }
        if(ow != 0){
            double tempW = ow;
            owp = Math.round((tempW/total) * 100);
        }
        if(draw != 0){
            double tempW = draw;
            drawp = Math.round((tempW/total) * 100);
        }
        updateText();
    }
    public static void updateText(){
        xwLable.setText("X wins: " + xw + "| X win percentage: " + (int)xwp);
        owLable.setText("O wins: " + ow + "| O win percentage: " + (int)owp);
        drawLable.setText("Draws: " + draw + "| Draw percentage: " + (int)drawp);
    }







    public void actionPerformed(ActionEvent e){ 
        if(e.getSource() == mainMenu){
            window.remove(mainMenu);
            window.remove(newGame);
            window.remove(title);
            window.remove(xwLable);
            window.remove(owLable);
            window.remove(drawLable);
            grid.clear();
            window.revalidate();
            window.repaint();
            Display.startMainMenu();
        } else if(e.getSource() == newGame){
            grid.clear(); 
            grid = new Board(window);
            grid.setAI(AI);
            grid.start();
        }
    }
}