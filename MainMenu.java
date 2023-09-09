import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class MainMenu implements ActionListener{

    private JFrame window = Display.window;
    private JButton pVPButton = new JButton("Player VS. Player");
    private JButton pVEButton = new JButton("Player VS. Computer");
    private JButton settingsButton = new JButton("Settings");
    private JButton exit = new JButton("Exit");
    private JLabel title = new JLabel("Tic Tac Toe");

    private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private int width = gd.getDisplayMode().getWidth();
    //private int height = gd.getDisplayMode().getHeight();  

    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    public MainMenu(){
    }

    public void start(){

        pVPButtonSetup();
        pVEButtonSetup();
        settingsButtonSetup();
        exitSetup();
        titleSetup();

        window.setVisible(true);
    }

    private void pVPButtonSetup(){

        pVPButton.setBounds(width/2 - 700, 400, 600, 150);
        pVPButton.setFocusable(false);
        pVPButton.setFont(new Font(null, Font.PLAIN, 50));
        pVPButton.addActionListener(this);
        window.add(pVPButton);
    }
    private void pVEButtonSetup(){

        pVEButton.setBounds(width/2 + 100, 400, 600, 150);
        pVEButton.setFocusable(false);
        pVEButton.setFont(new Font(null, Font.PLAIN, 50));
        pVEButton.addActionListener(this);
        window.add(pVEButton);
    }
    private void settingsButtonSetup(){

        settingsButton.setBounds(width/2 - 700, 700, 600, 150);
        settingsButton.setFocusable(false);
        settingsButton.setFont(new Font(null, Font.PLAIN, 50));
        settingsButton.addActionListener(this);
        window.add(settingsButton);
    }
    private void exitSetup(){
        exit.setBounds(width/2 + 100, 700, 600, 150);
        exit.setFocusable(false);
        exit.setFont(new Font(null, Font.PLAIN, 50));
        exit.addActionListener(this);
        window.add(exit);
    }
    private void titleSetup(){
        title.setFont(new Font("SERIF", Font.PLAIN, 100));
        FontMetrics a = title.getFontMetrics(new Font("SERIF", Font.PLAIN, 100));
        int titleWidth = a.stringWidth("Tic Tac Toe");
        title.setBounds(width/2 - titleWidth/2, 200, 1000, 100);
        
        window.add(title);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == pVEButton){
            window.remove(exit);
            window.remove(settingsButton);
            window.remove(title);
            window.remove(pVEButton);
            window.remove(pVPButton);
            window.revalidate();
            window.repaint();
            Display.startPVE();
        } else if(e.getSource() == pVPButton){
            window.remove(exit);
            window.remove(settingsButton);
            window.remove(title);
            window.remove(pVEButton);
            window.remove(pVPButton);
            window.revalidate();
            window.repaint();
            Display.startPVP();
        }else if(e.getSource() == exit){
            window.setVisible(false);
            window.dispose();
        }
    }
}
