


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
public class Hard{
    static int round = -1;
    static int[] move = new int[2];

    static Board[] scenarios = null;
    scenarios[0] = new Board();
    public static int[] AIPlay(OneSquare[][] g, Board board, int turnNum){
        round = turnNum/2;
        return move;
    }


    static public int[] basicChecks(OneSquare[][] g, Board board, int turnNum){
        if(AIHelper.canWin(g, board)){
            move = AIHelper.winCheck(g, board);
        } else if (AIHelper.canBlock(g, board)){
            move = AIHelper.blockCheck(g, board);
        }
        move = new int[] {-1,-1};
        return move;
    }
}