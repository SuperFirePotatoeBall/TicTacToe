public class WinChecker {
    public static boolean checkWin(OneSquare[][] b, String turn){
        OneSquare[][] board = b;
        if(checkVertical(board, turn) || checkHorizontal(board, turn) || checkDiagonal(board, turn)){
            return true;
        }
        return false;
    }
    public static boolean checkVertical(OneSquare[][] board, String turn){
        for(int c = 0; c < board[0].length; c++){
            int victory = 0;
            for(int r = 0; r < board.length; r++){
                if(board[r][c].contents.equals(turn)){
                    victory++;
                }
            }
            if(victory == 3){
                return true;
            }
        }
        return false;
        
    }
    public static boolean checkHorizontal(OneSquare[][] board, String turn){
        for(int r = 0; r < board.length; r++){
            int victory = 0;
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c].contents.equals(turn)){
                    victory++;
                }
            }
            if(victory == 3){
                return true;
            }
        }
        return false;
    }
    public static boolean checkDiagonal(OneSquare[][] board, String turn){
        int V1 = 0;
        int V2 = 0;
        for(int pos = 0; pos < board.length; pos++){
            if(board[pos][pos].contents.equals(turn)){
                V1++;
            }
            if(board[pos][2-pos].contents.equals(turn)){
                V2++;
            }
        }
        if(V1 == 3 || V2 == 3){
            return true;
        }
        return false;
    }
}
