


/*How hard AI works:
 * Uses the algerithim that garuntes a draw or win
 * should be unbeatable
 * 
 * if AI goes first
 * it picks a corner
 * Player goes
 * if palyer went in a non-middle position, it goes in the opposite corner
 * player goes
 * if the player didnt block, win
 * otherwise if they went in a non-corner position, go in the middle
 * if the player went in a corner position, go in the remaigning corner
 * player goes
 * win in the remaigning opening
 * 
 * if the player origonally goes in the middle pos
 * go in the opposite corner from starting
 * block 3 in a rows and check for wins until draw
 * 
 * 
 * if AI goes second
 * it takes the middle
 * blocks and checks for win until draw
 */
public class HardOld {
    public static int[] AIPlay(OneSquare[][] g, Board board, int turnNum){
        int[] move = new int[2];
        if(turnNum % 2 == 0){
            move = AIFirst(g, board, turnNum);
        } else {
            move = AISecond(g, board, turnNum);
        }
        return move;
    }
    public static int[] AIFirst(OneSquare[][] g, Board board, int turnNum){
        int[] move = new int[2];
        if(turnNum == 0){
            move[0] = 0;
            move[1] = 0;
        } else if(turnNum == 2){
            if(board.isOpen(1, 1)){
                if(board.isOpen(2, 2)){
                    if(board.isOpen(0, 1) && board.isOpen(0, 2) && board.isOpen(1, 2)){
                        move[0] = 0; 
                        move[1] = 2;
                        return move;
                    } else {
                        move[0] = 2;
                        move[1] = 0;
                        return move;
                    }
                } else {
                    move[0] = 2; 
                    move[1] = 0;
                    return move;
                }
            } else {
                move[0] = 2;
                move[1] = 2;
            }
        } else {
            move = smartPlay(g, board);
            return move;
        }
        return move;
    }
    public static int[] AISecond(OneSquare[][] g, Board board, int turnNum){
        int[] move = new int[2];
        if(board.isOpen(1, 1)){
            move[0] = 1;
            move[1] = 1;
        } else {
            move = smartPlay(g, board);
        }
        return move;
    }
    public static int[] smartPlay(OneSquare[][] g, Board board){
        int[] move = new int[2];
        OneSquare[][] grid;
        for(int r = 0; r <= 2; r ++){
            for(int c = 0; c <= 2; c++){
                grid = copyArray(g);
                if(board.isOpen(r, c)){
                    grid[r][c].o();
                    if(WinChecker.checkWin(grid, "o")){
                        move[0] = r;
                        move[1] = c;
                        return move;
                    }
                }
            }
        }
        for(int r = 0; r <= 2; r ++){
            for(int c = 0; c <= 2; c++){
                grid = copyArray(g);
                if(board.isOpen(r, c)){
                    grid[r][c].x();
                    if(WinChecker.checkWin(grid, "x")){
                        move[0] = r;
                        move[1] = c;
                        return move;
                    }
                }
            }
        }
        return RandomPlay(board);
    }
    public static int[] RandomPlay(Board board){
        int[] place = new int[2];
        place[0] = (int) (Math.random() * 3);
        place[1] = (int) (Math.random() * 3);
        if(board.isOpen(place[0], place[1])){
            return place;
        } else {
            return RandomPlay(board);
        }
    }
    public static OneSquare[][] copyArray(OneSquare[][] grid){
        OneSquare[][] copy = new OneSquare[3][3];
        for(int r = 0; r <= 2; r++){
            for(int c = 0; c <= 2; c++){
                copy[r][c] = grid[r][c].copy();
            }
        }
        return copy;
    }
}
