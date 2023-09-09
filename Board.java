import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Board implements ActionListener{
    OneSquare[][] board = new OneSquare[3][3];
    JFrame window;

    JButton[][] buttonBoard = new JButton[3][3];

    private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private int width = gd.getDisplayMode().getWidth();
    private int height = gd.getDisplayMode().getHeight();
    
    public String turn = "x";
    public boolean victory = false;
    public int turnNum = 0;

    private JLabel turnIndicator = new JLabel("Turn: " + turn.toUpperCase());
    private JButton turnButton = new JButton("Have O go first");

    private String AI = "none";
    /*
     * AI takes:
     * "none"
     * "easy"
     * "med"
     * "hard"
     */
    public Board(JFrame win){
        window = win;
    }
    public void start(){
        for(int r = 0; r < buttonBoard.length; r++){
            for(int c = 0; c < buttonBoard[0].length; c++){
                board[r][c] = new OneSquare();
                buttonBoard[r][c] = new JButton(board[r][c].contents);
                buttonBoard[r][c].setFocusable(false);
                buttonBoard[r][c].setFont(new Font(null, Font.PLAIN, 50));
                int y = height/2;
                int x = width/2;
                if(r == 0){
                    y -= 225;
                } else if(r == 1){
                    y -= 75;
                } else {
                    y += 75;
                }
                if(c == 0){
                    x -= 225;
                } else if(c == 1){
                    x -= 75;
                } else {
                    x += 75;
                }
                buttonBoard[r][c].setBounds(x, y, 150, 150);
                buttonBoard[r][c].addActionListener(this);
                window.add(buttonBoard[r][c]);
            }
        }
        turnIndicator.setFont(new Font(null, Font.PLAIN, 35));
        FontMetrics b = turnIndicator.getFontMetrics(new Font(null, Font.PLAIN, 35));
        int turnIndicatorWidth = b.stringWidth("Turn: O");
        turnIndicator.setBounds(width/2 - turnIndicatorWidth/2, height/2 + 225, 500, 150);
        window.add(turnIndicator);

        turnButton.setFont(new Font(null, Font.PLAIN, 35));
        FontMetrics c = turnIndicator.getFontMetrics(new Font(null, Font.PLAIN, 50));
        int turnButtonWidth = c.stringWidth("Have O go first");
        turnButton.setBounds(width/2 - turnButtonWidth/2, height/2 + 350, turnButtonWidth, 100);
        turnButton.setFocusable(false);
        turnButton.addActionListener(this);
        window.add(turnButton);
    }
    public void setAI(String nAI){
        AI = nAI;
    }
    public boolean isOpen(int r, int c){
        return !board[r][c].filled;
    }
    public void clear(){
        for(int r = 0; r < buttonBoard.length; r++){
            for(int c = 0; c < buttonBoard[0].length; c++){
                window.remove(buttonBoard[r][c]);
            }
        }
        window.remove(turnIndicator);
        if(turnNum == 0){window.remove(turnButton);}
        window.revalidate();
        window.repaint();
    }
    public void update(int r, int c){
        if(turnNum == 0){
            window.remove(turnButton);
            window.revalidate();
            window.repaint();
        }
        if(!board[r][c].filled && !victory){
            if(turn.equals("x")){
                board[r][c].x();
            } else {
                board[r][c].o();
            }
            buttonBoard[r][c].setText(turn);
            if(WinChecker.checkWin(board, turn)){
                victory = true;
                if(turn.equals("x")){
                    if(AI.equals("none")){
                        PVPGrid.x();
                    } else {
                        PVEGrid.x();
                    }
                    turnIndicator.setText("X WINS");
                } else if (turn.equals("o")){
                    if(AI.equals("none")){
                        PVPGrid.o();
                    } else {
                        PVEGrid.o();
                    }
                    turnIndicator.setText("O WINS");
                }
            }
            if(turnNum == 8 && victory != true){
                victory = true;
                if(AI.equals("none")){
                    PVPGrid.draw();
                } else {
                    PVEGrid.draw();
                }
                turnIndicator.setText("DRAW");
            }
            if(!AI.equals("none") && turn.equals("x") && victory != true){
                turnSwitch();
                turnNum++;
                AIMove();
            } else if(victory == false){
                turnSwitch();
                turnNum++;
            }      
        }
    }
    public void AIMove(){
        int[] move = new int[2];
        if(AI.equals("easy")){
            move = Easy.AIPlay(this);
        } else if (AI.equals("med")){
            move = Medium.AIPlay(board, this);
        } else if (AI.equals("hard")){
            move = HardOld.AIPlay(board, this, turnNum);
        }
        update(move[0], move[1]);
    }
    public void turnSwitch(){
        if(turn.equals("x")){
            turn = "o";
        } else {
            turn = "x";
        }
        turnIndicator.setText("Turn: " + turn.toUpperCase());
    }
    public void actionPerformed(ActionEvent e){
        for(int r = 0; r < buttonBoard.length; r++){
            for(int c = 0; c < buttonBoard[0].length; c++){
                if(e.getSource() == buttonBoard[r][c]){
                    update(r, c);
                }
            }
        }
        if(e.getSource() == turnButton){
            turnSwitch();
            if(turn.equals("x")){
                turnButton.setText("Have O go first");
            } else {
                turnButton.setText("Have X go first");
                AIMove();
            }
        }
    }
}