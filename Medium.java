

/*How medium AI works:
 * It looks for wins, looks for blocks, randolmy places
 */
public class Medium {
    public static int[] AIPlay(OneSquare[][] g, Board board){
        int[] move = new int[2];
        move = AIHelper.winCheck(g, board);
            if(move[0] < 0){
                move = AIHelper.blockCheck(g, board);
                if(move[0] < 0){
                    move = AIHelper.randomMove(board);
                }
            }
        return move;
    }
}
