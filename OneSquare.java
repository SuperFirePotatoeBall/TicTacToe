public class OneSquare{
    public boolean filled;
    public String contents;
    public OneSquare(){
        filled = false;
        contents = "";
    }
    public OneSquare(boolean f, String c){
        filled = f;
        contents = c;
    }
    public void x(){
        filled = true;
        contents = "x";
    }
    public void o(){
        filled = true;
        contents = "o";
    }
    public OneSquare copy(){
        OneSquare copy = new OneSquare(filled, contents);
        return copy;
    }
}
