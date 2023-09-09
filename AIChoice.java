import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
public class AIChoice implements ActionListener{
    private JFrame window = Display.window;
    
    private JButton easy = new JButton("Easy AI");
    private JButton med = new JButton("Med AI");
    private JButton hard = new JButton("Hard AI");
    private JButton back = new JButton("Back to main menu");
    private JLabel title = new JLabel("Tic Tac Toe");

    private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private int width = gd.getDisplayMode().getWidth();
    //private int height = gd.getDisplayMode().getHeight();

    private PVEGrid pveGrid = new PVEGrid();

    public AIChoice(){
        initButtons();
    }
    public void initButtons(){
        easy.setBounds(width/2 - 700, 400, 400, 150);
        med.setBounds(width/2 - 200, 400, 400, 150);
        hard.setBounds(width/2 + 300, 400, 400, 150);
        back.setBounds(width/2 - 300, 700, 600, 150);

        easy.setFocusable(false);
        med.setFocusable(false);
        hard.setFocusable(false);
        back.setFocusable(false);

        easy.setFont(new Font(null, Font.PLAIN, 50));
        med.setFont(new Font(null, Font.PLAIN, 50));
        hard.setFont(new Font(null, Font.PLAIN, 50));
        back.setFont(new Font(null, Font.PLAIN, 50));

        easy.addActionListener(this);
        med.addActionListener(this);
        hard.addActionListener(this);
        back.addActionListener(this);

        window.add(easy);
        window.add(med);
        window.add(hard);
        window.add(back);

        title.setFont(new Font("SERIF", Font.PLAIN, 100));
        FontMetrics a = title.getFontMetrics(new Font("SERIF", Font.PLAIN, 100));
        int titleWidth = a.stringWidth("Tic Tac Toe");
        title.setBounds(width/2 - titleWidth/2, 200, 1000, 100);
        window.add(title);
    }
    public void actionPerformed(ActionEvent e){
        window.remove(easy);
        window.remove(med);
        window.remove(hard);
        window.remove(back);
        window.remove(title);
        window.revalidate();
        window.repaint();
        if(e.getSource() == back){
            Display.startMainMenu();
        } else if(e.getSource() == easy){
            pveGrid.start("easy");
        } else if(e.getSource() == hard){
            pveGrid.start("hard");
        } else if(e.getSource() == med){
            pveGrid.start("med");
        }
    }
}
