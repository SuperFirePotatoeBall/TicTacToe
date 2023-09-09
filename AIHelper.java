public class AIHelper{
    public static int[] winCheck(OneSquare[][] g, Board board){
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
        move[0] = -1;
        move[1] = -1;
        return move;
    }
    public static int[] blockCheck(OneSquare[][] g, Board board){
        int[] move = new int[2];
        OneSquare[][] grid;
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
        move[0] = -1;
        move[1] = -1;
        return move;
    }
    public static int[] randomMove(Board board){
        int[] place = new int[2];
        place[0] = (int) (Math.random() * 3);
        place[1] = (int) (Math.random() * 3);
        if(board.isOpen(place[0], place[1])){
            return place;
        } else {
            return randomMove(board);
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